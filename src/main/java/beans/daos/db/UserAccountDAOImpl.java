package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.models.User;
import beans.models.UserAccount;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 20/2/16
 * Time: 7:07 PM
 */
@Repository(value = "userAccountDAO")
public class UserAccountDAOImpl extends AbstractDAO implements UserAccountDAO {

    @Override
    public UserAccount create(UserAccount userAccount) {
        System.out.println("Creating " + userAccount);
        UserAccountDAO.validateEvent(userAccount);

        Long eventId = (Long) getCurrentSession().save(userAccount);
        return userAccount.withId(eventId);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return ((UserAccount) getCurrentSession().merge(userAccount));
    }

    @Override
    public UserAccount get(User user) {
        SimpleExpression expr = Restrictions.eq("user", user);
        return ((UserAccount) createBlankCriteria(UserAccount.class).add(expr).uniqueResult());
    }

    @Override
    public void delete(UserAccount userAccount) {
        getCurrentSession().delete(userAccount);
    }

}
