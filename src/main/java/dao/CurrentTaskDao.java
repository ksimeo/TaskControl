/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.CurrentTask;
import model.Parcel;
import model.Task;
import model.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author VLAD
 */
public class CurrentTaskDao implements ICurrentTaskDao {

    /*private String dbConnName = ConnectionConfig.dbConnName;
    private String dbConnPass = ConnectionConfig.dbConnPass;*/

    @Override
    public boolean saveCurrentTask(CurrentTask ct) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "INSERT IGNORE INTO taskcontrol.currenttask"
                                + "(id, task_id, creator_id, recipient_id, state, priority,  create_date)"
                                + "VALUES(?,?,?,?,?,?,?)"
                );

                ps.setInt(1, ct.getId());
                ps.setInt(2, ct.getTaskId());
                ps.setInt(3, ct.getCreatorId());
                ps.setInt(4, ct.getRecepientId());
                ps.setString(5, ct.getState());
                ps.setString(6, ct.getPriority());
                ps.setTimestamp(7, new Timestamp(ct.getCreateDate().getTime()));

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

    @Override
    public List<CurrentTask> getAllCurrentTasks() {
        ArrayList<CurrentTask> tasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask;");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }

                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    tasks.add(ct);

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
        return tasks;
    }

    @Override
    public List<CurrentTask> getAllByUserId(User user) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(recipient_id = " + user.getUserId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    ctasks.add(ct);

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


        return ctasks;
    }

    @Override
    public List<CurrentTask> getAllByCreatorId(User user) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(creator_id = " + user.getUserId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    ctasks.add(ct);

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
        return ctasks;
    }

    @Override
    public List<CurrentTask> getAllByTaskId(Task task) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(task_id = " + task.getId() + ")");
                rs = ps.executeQuery();

                Date sd;
                Date ed;
                while (rs.next()) {
                    try
                    {
                        sd = new Date(rs.getTimestamp("start_date").getTime());
                    } catch (NullPointerException e)
                    {
                        sd = null;
                    }
                    try
                    {
                        ed = new Date(rs.getTimestamp("end_date").getTime());
                    } catch (NullPointerException e)
                    {
                        ed = null;
                    }
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            rs.getString("priority"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            sd,
                            ed);
                    ctasks.add(ct);

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
        return ctasks;
    }

    @Override
    public Parcel<CurrentTask> getCurrentTaskPage(User user, int from, int to) {
        ArrayList<CurrentTask> page = new ArrayList<>();
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT COUNT(id) AS m FROM taskcontrol.currenttask");
                rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("m");
                }

                if (from < count) {
                    ps = conn.prepareStatement(
                            "SELECT * FROM taskcontrol.currenttask WHERE recipient_id = ? ORDER BY id DESC LIMIT ?, ?");
                    ps.setInt(1, user.getUserId());
                    ps.setInt(2,  from);
                    ps.setInt(3, to-from);
                    rs = ps.executeQuery();
                    Date sd;
                    Date ed;
                    while (rs.next()) {
                        try
                        {
                            sd = new Date(rs.getTimestamp("start_date").getTime());
                        } catch (NullPointerException e)
                        {
                            sd = null;
                        }
                        try
                        {
                            ed = new Date(rs.getTimestamp("end_date").getTime());
                        } catch (NullPointerException e)
                        {
                            ed = null;
                        }

                        CurrentTask ct = new CurrentTask(rs.getInt("id"),
                                rs.getInt("task_id"),
                                rs.getInt("creator_id"),
                                rs.getInt("recipient_id"),
                                rs.getString("state"),
                                rs.getString("priority"),
                                new java.util.Date(rs.getTimestamp("create_date").getTime()),
                                sd,
                                ed);
                        page.add(ct);

                    }

                } else {
                    page = new ArrayList<>();
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
        return new Parcel<CurrentTask>(count, page);
    }
    public Parcel<CurrentTask> getCurrentTaskPageAll(int from, int to) {
        ArrayList<CurrentTask> page = new ArrayList<>();
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT COUNT(id) AS m FROM taskcontrol.currenttask");
                rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("m");
                }

                if (from <= count) {
                    ps = conn.prepareStatement(
                            "SELECT * FROM taskcontrol.currenttask ORDER BY id DESC LIMIT ?, ?");
                    ps.setInt(1,  from);
                    ps.setInt(2, to-from);
                    rs = ps.executeQuery();
                    Date sd;
                    Date ed;
                    while (rs.next()) {
                        try
                        {
                            sd = new Date(rs.getTimestamp("start_date").getTime());
                        } catch (NullPointerException e)
                        {
                            sd = null;
                        }
                        try
                        {
                            ed = new Date(rs.getTimestamp("end_date").getTime());
                        } catch (NullPointerException e)
                        {
                            ed = null;
                        }

                        CurrentTask ct = new CurrentTask(rs.getInt("id"),
                                rs.getInt("task_id"),
                                rs.getInt("creator_id"),
                                rs.getInt("recipient_id"),
                                rs.getString("state"),
                                rs.getString("priority"),
                                new java.util.Date(rs.getTimestamp("create_date").getTime()),
                                sd,
                                ed);
                        page.add(ct);

                    }

                } else {
                    page = new ArrayList<>();
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
        return new Parcel<CurrentTask>(count, page);
    }

    @Override
    public boolean setStartDate(CurrentTask ct, Date d)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        Timestamp time =  new Timestamp(d.getTime());
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE taskcontrol.currenttask SET start_date = ? where(id = " + ct.getId() + ")"
                );
                ps.setTimestamp(1, time);
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

    @Override
    public boolean setEndDate(CurrentTask ct, Date d)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        Timestamp time =  new Timestamp(d.getTime());
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE taskcontrol.currenttask SET end_date = ?  WHERE(id = " + ct.getId() + ")"

                );
                ps.setTimestamp(1, time);
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

    @Override
    public boolean setPriority(CurrentTask ct, String priority) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE taskcontrol.currenttask SET priority = ?  WHERE(id = " + ct.getId() + ")"

                );
                ps.setString(1, priority);
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

    @Override
    public boolean setState(CurrentTask ct, String state) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "UPDATE taskcontrol.currenttask SET state = ?  WHERE(id = " + ct.getId() + ")"

                );
                ps.setString(1, state);
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

    @Override
    public int getLastId() {
        int lastId = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT MAX(id) AS m FROM taskcontrol.currenttask");
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

