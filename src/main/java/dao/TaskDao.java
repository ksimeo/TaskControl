package dao;

/**
 * Created by Ksimeo on 25.05.14.
 */
        import model.Task;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.LinkedList;
        import java.util.List;
/**
 *
 * @author Ksimeo
 */
public class TaskDao {

    private static String dbConnName = "root";
    private static String dbConnPass = "root";

    public static List<Task> getAllTasks() {
        List<Task> toReturn = new LinkedList<Task>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskcontrol", dbConnName, dbConnPass);
                ps=conn.prepareStatement("SELECT * FROM taskcontrol.task");
                rs=ps.executeQuery();
                Task t = null;
                while(rs.next()){
                    t = new Task(rs.getInt("id"), rs.getString("title"), rs.getString("description"), rs.getString("priority"));
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

    public boolean addTask (Task task){
        boolean f = false;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskcontrol", dbConnName, dbConnPass);
                ps = conn.prepareStatement("INSERT INTO taskcontrol.task"
                        +"(id, title, description, priority)"
                        +" VALUES(?,?,?,?)"
                );
                ps.setInt(1, task.getId());
                ps.setString(2, task.getTaskTitle());
                ps.setString(3, task.getDescription());
                ps.setString(4, task.getPriority());
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
}