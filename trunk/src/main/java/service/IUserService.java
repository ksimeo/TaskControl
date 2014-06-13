package service;

import model.User;

import java.util.List;

/**
 * Created by Avega on 01.06.14.
 */
public interface IUserService
{
    User saveUser(String name, String login, String password, int role);
    User searchUser(String name);
    User checkLogin (String login, String password);
    public List<String> getAllEmployeesNames();
    public User getUserById(int id);
}
