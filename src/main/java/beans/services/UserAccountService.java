package beans.services;

import beans.models.User;
import beans.models.UserAccount;


/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/3/2016
 * Time: 11:02 AM
 */
public interface UserAccountService {

    public UserAccount create(UserAccount userAccount);

    public void remove(UserAccount userAccount);

    UserAccount getUserAccount(User user);

}
