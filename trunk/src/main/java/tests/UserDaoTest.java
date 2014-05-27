package tests;

import dao.UserDao;
import model.User;

/**
 * Created by Avega on 26.05.14.
 */
public class UserDaoTest
{
    public static void main (String[] args)
    {
        UserDao dao = new UserDao();
        User user = new User("pupkin", "pupkin","pupk45", 2);
        if (dao.saveUser(user))
        {
            System.out.println("SUCCESS");
        }
        else
        {
            System.out.println("Error");
        }

    }
}
