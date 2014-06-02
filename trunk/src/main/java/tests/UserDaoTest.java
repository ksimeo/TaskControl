package tests;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import dao.UserDao;
import helpers.AuthHelper;
import model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * Created by Avega on 26.05.14.
 */
public class UserDaoTest
{
    public static void main (String[] args)
    {
       UserDao dao = new UserDao();
       /* User user = new User("petrov", "petrov","pe78554", 2);
        if (dao.saveUser(user))
        {
            System.out.println("SUCCESS");
        }
        else
        {
            System.out.println("Error");
        }*/

        /*try {
            System.out.println(AuthHelper.String2Hash("spring"));

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
*/
        User tmp = null;
        try {
           tmp = dao.getUserByLoginPassword("petrov", "pe78554");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

       /* User searchName = dao.searchUserByFullName("pupkin");*/
    }
}
