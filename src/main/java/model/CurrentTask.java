package model;

import java.util.Date;

/**
 * Created by user on 25.05.14.
 */
public class CurrentTask {
    private int id;
    private int taskId;
    private int creatorId;
    private int recipientId;
    private String state;
    private String priority;
    private Date createDate;
    private Date startDate;
    private Date endDate;
    public  static String STATUS_FINISH = "finished";
    public  static String STATUS_IN_PROCESS = "in process";
    public  static String STATUS_START = "started";
    public static String PRIORITY_LOW = "low";
    public static String PRIORITY_MIDDLE = "middle";
    public static String PRIORITY_HEIGHT = "height";

    public CurrentTask(int id)
    {
        this.id = id;
    }

    public CurrentTask(int id, int taskId, int creatorId, int recipientId, String state, String priority, Date createDate, Date startDate, Date endDate) {
        this.id = id;
        this.taskId = taskId;
        this.creatorId = creatorId;
        this.recipientId = recipientId;
        this.state = state;
        this.priority = priority;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CurrentTask(int id, int taskId, int creatorId, int recipientId, String state, String priority, Date createDate) {
        this.id = id;
        this.taskId = taskId;
        this.creatorId = creatorId;
        this.recipientId = recipientId;
        this.state = state;
        this.priority = priority;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRecepientId() {
        return recipientId;
    }

    public void setRecepientId(int recepientId) {
        this.recipientId = recepientId;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "CurrentTask{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", creatorId=" + creatorId +
                ", recipientId=" + recipientId +
                ", state='" + state + '\'' +
                ", priority='" + priority + '\'' +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
