package beans.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:35 PM
 */
public class User {

    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";

    private long      id;
    private String    email;
    private String    name;
    @DateTimeFormat(pattern = DATE_TIME_PATTERN)
    private LocalDate birthday;

    private String password;
    private String roles;

    public User() {
    }

    public User(long id, String email, String name, LocalDate birthday) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
    }

    public User(String email, String name, LocalDate birthday) {
        this(-1, email, name, birthday);
    }

    public User withId(long id) {
        return new User(id, email, name, birthday);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        if (id != user.id)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null)
            return false;
        if (name != null ? !name.equals(user.name) : user.name != null)
            return false;
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", name='" + name + '\'' +
               ", birthday=" + birthday +
               '}';
    }
}
