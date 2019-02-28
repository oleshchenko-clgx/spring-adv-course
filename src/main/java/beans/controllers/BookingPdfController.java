package beans.controllers;

import beans.models.Ticket;
import beans.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(value = "/booking-pdf", headers = "Accept=application/pdf")
public class BookingPdfController {

    private BookingService bookingService;

    @Autowired
    public BookingPdfController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @RequestMapping(value = "/purchasedtickets", method = RequestMethod.GET)
    public ModelAndView getTicketsForEvent(@RequestParam String event,
                                           @RequestParam String auditorium,
                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ticketsPdf");
        List<Ticket> ticketsForEvent = bookingService.getTicketsForEvent(event, auditorium, date);
        mav.addObject("tickets", ticketsForEvent);

        return mav;
    }

}

