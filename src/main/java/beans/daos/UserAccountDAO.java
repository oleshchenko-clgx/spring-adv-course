package beans.daos;

import beans.models.User;
import beans.models.UserAccount;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/2/2016
 * Time: 12:35 PM
 */
public interface UserAccountDAO {

    UserAccount create(UserAccount userAccount);

    UserAccount update(UserAccount userAccount);

    UserAccount get(User user);

    void delete(UserAccount userAccount);

    static void validateEvent(UserAccount userAccount) {
        if (Objects.isNull(userAccount)) {
            throw new NullPointerException("UserAccount is [null]");
        }
        if (Objects.isNull(userAccount.getUser())) {
            throw new NullPointerException("UserAccount's user is [null]. UserAccount: [" + userAccount + "]");
        }
    }
}
