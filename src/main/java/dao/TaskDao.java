package dao;

/**Класс определяющий Dao к Task
 * Created by Ksimeo on 25.05.14.
 */
        import model.Task;
        import model.User;

        import java.sql.*;
        import java.util.ArrayList;
        import java.util.LinkedList;
        import java.util.List;
/**
 *
 * @author Ksimeo
 */
public class TaskDao implements ITaskDao {

    private static String mConnString = ConnectionConfig.mConnString;
    private static String dbConnName = ConnectionConfig.dbConnName;
    private static String dbConnPass = ConnectionConfig.dbConnPass;

    @Override
    public List<Task> getAllTasks() {
        List<Task> toReturn = new LinkedList<>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps=conn.prepareStatement("SELECT * FROM taskcontrol.task");
                rs=ps.executeQuery();
                Task t = null;
                while(rs.next()){
                    t = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("discription"));
                    toReturn.add(t);
                }
            }
            finally {
                if (conn != null){
                    conn.close();
                    conn = null;
                }
                if (ps != null){
                    ps.close();
                    ps = null;
                }
                if (rs != null){
                    rs.close();
                    rs = null;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return toReturn;
    }

    @Override
    public boolean addTask (Task task){
        boolean f = false;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("INSERT IGNORE INTO taskcontrol.task"
                        +"(id, title, discription)"
                        +" VALUES(?,?,?)"
                );
                ps.setInt(1, task.getId());
                ps.setBytes(2, task.getTaskTitle().getBytes());
                ps.setBytes(3, task.getDescription().getBytes());
                int res = ps.executeUpdate();
                f = res > 0;
            }
            finally {
                if (conn != null){
                    conn.close();
                    conn = null;
                }
                if (ps != null){
                    ps.close();
                    ps = null;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<String> getAllTasksTitles() {
        List<String> res = new ArrayList<>();
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT title FROM taskcontrol.task");
                rs = ps.executeQuery();

                while (rs.next())
                {
                    res.add(rs.getString("title"));

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

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Task getTaskByTitle(String title) {
        Task res = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.task WHERE(title = "+"'"+ title +"'"+ ")");
                rs = ps.executeQuery();
                rs.next();

                res = new Task(rs.getInt("id"),rs.getString("title"), rs.getString("discription"));

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

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public Task  getTaskById(int id)
    {
        Task res = null;
        try
        {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(mConnString, dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.task WHERE(id = " + id + ")");
                rs = ps.executeQuery();
                rs.next();

                res = new Task(rs.getInt("id"),rs.getString("title"), rs.getString("discription"));

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

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public boolean setDescription(String title, String description)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE taskcontrol.task SET discription = ? where(title = ?)"
                );
                ps.setString(1, description);
                ps.setString(2, title);
                int res = ps.executeUpdate();

                if (res != 0) {
                    flag = true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }

        }
        return flag;
    }

    public int getLastId()
    {
        int lastId = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT MAX(id) AS m FROM taskcontrol.task");
                rs = ps.executeQuery();

                if (rs.next())
                    lastId = rs.getInt("m");
                else
                    lastId = 0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return lastId;
    }
}