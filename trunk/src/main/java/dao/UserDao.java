package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by user on 25.05.14.
 */
public class UserDao implements IUserDao
{
    private static String mConnString = "jdbc:mysql://localhost:3306/taskcontrol";
    private static String mUserName = "root";
    private static String mPassword = "Monkey2003";
    @Override
    public boolean saveUser(User user)
    {
        boolean returnValue = false;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, mUserName, mPassword);
                ps = conn.prepareStatement("Insert into taskcontrol.user" + "(user_full_name, login, password, role)" +
                        " VALUES" + "(?, ?, ?, ?)");

                ps.setString(1, user.getName());
                ps.setString(2, user.getLogin());
                ps.setString(3, user.getPassword());
                ps.setInt(4, user.getRole());
                int res = ps.executeUpdate();

                ResultSet lastid = ps.getGeneratedKeys();
                if (lastid.next()){
                    user.setUserId(lastid.getInt(1));
                }
                returnValue = res > 0;
            }
            finally
            {
                if (conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if (ps != null)
                {
                    ps.close();
                    ps = null;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }
    @Override
    public User getUserByLoginPassword(String login, String password)
    {
        String query = "Select * from taskcontrol.user where "
                + " login = '" + login
                + "' and password= '" + password + "'";

        User retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, mUserName, mPassword);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();

                while (res.next())
                {
                    retValue = new User(res.getInt("id"),res.getString("user_full_name"), res.getString("login"),
                            res.getString("password"), res.getInt("role"));
                    break;
                }
            }
            finally
            {
                if(conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if(ps != null)
                {
                    ps.close();
                    ps = null;
                }
                if(res != null)
                {
                    res.close();
                    res = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retValue;
    }
    @Override
    public User  searchUserByFullName(String fullName)
    {
        String query = "Select * from taskcontrol.user where "
                + " user_full_name = '" + fullName + "'";

        User retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, mUserName, mPassword);
                ps = conn.prepareStatement(query);
                res = ps.executeQuery();

                while (res.next())
                {
                    retValue = new User(res.getInt("id"),res.getString("user_full_name"), res.getString("login"),
                            res.getString("password"), res.getInt("role"));
                    break;
                }
            }
            finally
            {
                if(conn != null)
                {
                    conn.close();
                    conn = null;
                }
                if(ps != null)
                {
                    ps.close();
                    ps = null;
                }
                if(res != null)
                {
                    res.close();
                    res = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return retValue;
    }
}
