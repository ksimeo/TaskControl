package service;

import dao.UserDao;
import model.User;

/**
 * Created by Avega on 28.05.14.
 */
public class UserService implements IUserService
{
    private UserDao usDao;

    public UserService()
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
    public boolean checkLogin (String login, String password)
    {
        return null != usDao.getUserByLoginPassword(login, password);
    }

}
