package dao;

import helpers.AuthHelper;
import model.User;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 25.05.14.
 */
public class UserDao implements IUserDao
{

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
                user.setPassword(AuthHelper.String2Hash(user.getPassword()));

                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
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
    public User getUserByLoginPassword(String login, String password) throws NoSuchProviderException, NoSuchAlgorithmException {


        String query = "Select * from taskcontrol.user where "
                + " login = '" + login
                + "' and password= '" + AuthHelper.String2Hash(password) + "'";

        User retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
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
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
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
    public List<String> getAllEmployeesNames()
    {

        List<String> res = new ArrayList<>();
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT user_full_name FROM taskcontrol.user WHERE (role = 2)");
                rs = ps.executeQuery();

                while (rs.next())
                {
                    res.add(rs.getString("user_full_name"));

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
                    rs.close();
                    rs = null;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }
    public User getUserById(int id)
    {
        String query = "Select * from taskcontrol.user where "
                + " id = " + id;

        User retValue = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
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
