package service;

import dao.UserDao;
import model.User;

import java.util.List;

/**
 * Created by Avega on 28.05.14.
 */
public enum  UserService implements IUserService
{
    INSTANCE;
    private UserDao usDao;

    private UserService()
    {
        usDao = new UserDao();
    }
    @Override
    public User saveUser(String name, String login, String password, int role)
    {
        User user = new User (name, login, password, role);

        return usDao.saveUser(user) ? user : null;
    }
    @Override
    public User searchUser(String name)
    {
        return usDao.searchUserByFullName(name);
    }
    @Override
    public User checkLogin (String login, String password)
    {
        try
        {
            return usDao.getUserByLoginPassword(login, password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return  null;
    }
    @Override
    public List<String> getAllUsarsNames()
    {
        return usDao.getAllUsarsNames();
    }

}
