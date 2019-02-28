package beans.controllers;

import beans.models.Auditorium;
import beans.models.Event;
import beans.models.Ticket;
import beans.models.User;
import beans.services.AuditoriumService;
import beans.services.BookingService;
import beans.services.EventService;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private BookingService bookingService;
    private UserService userService;
    private EventService eventService;
    private AuditoriumService auditoriumService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, EventService eventService, AuditoriumService auditoriumService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.eventService = eventService;
        this.auditoriumService = auditoriumService;
    }


    @RequestMapping(value = "/ticketprice", method = RequestMethod.GET)
    public ModelAndView getTicketPrice(
            @RequestParam String eventName,
            @RequestParam String auditoriumName,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam String seats,
            @RequestParam Long userId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ticketprice");
        List<Integer> seatsList = Arrays.stream(seats.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        User user = userService.getById(userId);
        Double price = bookingService.getTicketPrice(eventName, auditoriumName, date, seatsList, user);
        mav.addObject("price", price);

        return mav;
    }

    @RequestMapping(value = "/bookticket", method = RequestMethod.POST)
    public ModelAndView bookTicket(
            @RequestParam long userId,
            @RequestParam String eventName,
            @RequestParam String auditoriumName,
            @RequestParam String seats,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @RequestParam Double price) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ticket");

        User user = userService.getById(userId);
        Auditorium auditorium = auditoriumService.getByName(auditoriumName);
        Event event = eventService.getEvent(eventName, auditorium, date);
        List<Integer> seatsList = Arrays.stream(seats.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        Ticket ticket = new Ticket(event, LocalDateTime.now(), seatsList, user, price);

        Ticket bookedTicket = bookingService.bookTicket(user, ticket);
        mav.addObject("ticket", bookedTicket);

        return mav;
    }

    @RequestMapping(value = "/purchasedtickets", params = {"event", "auditorium", "date"}, method = RequestMethod.GET)
    public ModelAndView getTicketsForEvent(@RequestParam String event,
                                           @RequestParam String auditorium,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("purchasedtickets");
        List<Ticket> ticketsForEvent = bookingService.getTicketsForEvent(event, auditorium, date);
        mav.addObject("tickets", ticketsForEvent);

        return mav;
    }

}

