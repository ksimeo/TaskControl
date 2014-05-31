package dao;

/**Класс определяющий Dao к Task
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
        List<Task> toReturn = new LinkedList<>();
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

    public static boolean addTask (Task task){
        boolean f = false;
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taskcontrol", dbConnName, dbConnPass);
                ps = conn.prepareStatement("INSERT IGNORE INTO taskcontrol.task"
                        +"(id, title, discription)"
                        +" VALUES(?,?,?)"
                );
                ps.setInt(1, task.getId());
                ps.setString(2, task.getTaskTitle());
                ps.setString(3, task.getDescription());
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