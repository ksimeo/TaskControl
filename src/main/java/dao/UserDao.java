package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by user on 25.05.14.
 */
public class UserDao
{
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
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskcontrol", "root", "Monkey2003");
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
}
