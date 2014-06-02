package dao;

import model.User;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * Created by Avega on 01.06.14.
 */
public interface IUserDao
{
    boolean saveUser(User user);
    User getUserByLoginPassword(String login, String password) throws NoSuchProviderException, NoSuchAlgorithmException;
    User  searchUserByFullName(String fullName);

}
