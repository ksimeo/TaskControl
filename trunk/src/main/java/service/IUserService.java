package service;

import model.User;

/**
 * Created by Avega on 01.06.14.
 */
public interface IUserService
{
    User saveUser(String name, String login, String password, int role);
    User searchUser(String name);
    boolean checkLogin (String login, String password);
}
