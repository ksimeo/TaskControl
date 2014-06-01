package dao;

import model.User;

/**
 * Created by Avega on 01.06.14.
 */
public interface IUserDao
{
    boolean saveUser(User user);
    User getUserByLoginPassword(String login, String password);
    User  searchUserByFullName(String fullName);

}
