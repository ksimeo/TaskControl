package tests;

import dao.RoleDao;

/**
 * Created by Avega on 26.05.14.
 */
public class UserDaoTest
{
    public static void main (String[] args)
    {
        RoleDao role = new RoleDao();
        System.out.println(role.getAllRole());

       /*UserDao dao = new UserDao();
        User user = new User("sidorov", "sidorov","si78554", 1);
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
       /* User tmp = null;
        try {
           tmp = dao.getUserByLoginPassword("petrov", "pe78554");
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }*/

       /* User searchName = dao.searchUserByFullName("pupkin");*/
    }
}
