package beans.services;

import beans.daos.UserAccountDAO;
import beans.models.User;
import beans.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/2/2016
 * Time: 12:29 PM
 */
@Service("userAccountServiceImpl")
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountDAO userAccountDAO;

    @Autowired
    public UserAccountServiceImpl(@Qualifier("userAccountDAO") UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    public UserAccount create(UserAccount userAccount) {
        return userAccountDAO.create(userAccount);
    }

    public void remove(UserAccount userAccount) {
        userAccountDAO.delete(userAccount);
    }

    @Override
    public UserAccount getUserAccount(User user) {
        return userAccountDAO.get(user);
    }
}
