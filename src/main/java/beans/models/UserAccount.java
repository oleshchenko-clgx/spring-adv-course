package beans.models;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created with IntelliJ IDEA.
 * User: Oleksii Leshchenko
 * Date: 2/1/2019
 * Time: 7:35 PM
 */
public class UserAccount {

    private long id;
    private Double amount;
    private User user;

    public UserAccount() {
    }

    public UserAccount(long id, Double amount, User user) {
        this.id = id;
        this.amount = amount;
        this.user = user;
    }

    public UserAccount withId(long id) {
        return new UserAccount(id, amount, user);
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return id == that.id &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, user);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserAccount.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("amount=" + amount)
                .add("user=" + user)
                .toString();
    }
}
