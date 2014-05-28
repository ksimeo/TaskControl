/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.CurrentTask;
import model.Task;
import model.User;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author VLAD
 */
public class CurrentTaskDao {

    private String dbConnName = "root";
    private String dbConnPass = "root";

    public boolean saveCurrentTask(CurrentTask ct) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean flag = false;
        try {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/taskcontrol",
                        dbConnName, dbConnPass);
                ps = conn.prepareStatement(
                        "INSERT IGNORE INTO taskcontrol.currenttask"
                                + "(id, task_id, creator_id, recipient_id, state,  create_date, start_date, end_date)"
                                + "VALUES(?,?,?,?,?,?,?,?)"
                );

                ps.setInt(1, ct.getId());
                ps.setInt(2, ct.getTaskId());
                ps.setInt(3, ct.getCreatorId());
                ps.setInt(4, ct.getRecepientId());
                ps.setString(5, ct.getState());
                ps.setTimestamp(6, new Timestamp(ct.getCreateDate().getTime()));
                ps.setTimestamp(7, new Timestamp(ct.getStartDate().getTime()));
                ps.setTimestamp(8, new Timestamp(ct.getEndDate().getTime()));
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

    public List<CurrentTask> getAllCurrentTasks() {
        ArrayList<CurrentTask> tasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;
        try {

            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/taskcontrol",
                        dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask;");
                rs = ps.executeQuery();

                while (rs.next()) {
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            new java.util.Date(rs.getTimestamp("start_date").getTime()),
                            new java.util.Date(rs.getTimestamp("end_date").getTime()));
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

    public List<CurrentTask> getAllByUserId(User user) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/taskcontrol",
                        dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(recipient_id = " + user.getUserId() + ")");
                rs = ps.executeQuery();

                while (rs.next()) {
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            new java.util.Date(rs.getTimestamp("start_date").getTime()),
                            new java.util.Date(rs.getTimestamp("end_date").getTime()));
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

    public List<CurrentTask> getAllByCreatorId(User user) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/taskcontrol",
                        dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(creator_id = " + user.getUserId() + ")");
                rs = ps.executeQuery();

                while (rs.next()) {
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            new java.util.Date(rs.getTimestamp("start_date").getTime()),
                            new java.util.Date(rs.getTimestamp("end_date").getTime()));
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

    public List<CurrentTask> getAllByTaskId(Task task) {

        ArrayList<CurrentTask> ctasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/taskcontrol",
                        dbConnName, dbConnPass);
                ps = conn.prepareStatement("SELECT * FROM taskcontrol.currenttask WHERE(task_id = " + task.getId() + ")");
                rs = ps.executeQuery();

                while (rs.next()) {
                    CurrentTask ct = new CurrentTask(rs.getInt("id"),
                            rs.getInt("task_id"),
                            rs.getInt("creator_id"),
                            rs.getInt("recipient_id"),
                            rs.getString("state"),
                            new java.util.Date(rs.getTimestamp("create_date").getTime()),
                            new java.util.Date(rs.getTimestamp("start_date").getTime()),
                            new java.util.Date(rs.getTimestamp("end_date").getTime()));
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

    //    public int getLastId() {
//        int lastId = 0;
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs;
//        try {
//
//            try {
//                conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/taskcontrol",
//                        dbConnName, dbConnPass);
//                ps = conn.prepareStatement(
//                        "SELECT MAX(id) AS m FROM taskcontrol.currenttask");
//
//                rs = ps.executeQuery();
//                lastId = rs.getInt("m");
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } finally {
//            if (conn != null) {
//                conn = null;
//            }
//            if (ps != null) {
//                ps = null;
//            }
//        }
//        return lastId;
//    }

}

