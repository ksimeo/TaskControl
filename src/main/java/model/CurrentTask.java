package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by user on 25.05.14.
 */
public class CurrentTask {
    private int id;
    private int taskId;
    private int creatorId;
    private String state;
    private int recipientId;
    private Date createDate;
    private Date startDate;
    private Date endDate;

    public CurrentTask(int id, int taskId, int creatorId, String state, int recipientId, Date createDate, Date startDate, Date endDate) {
        this.id = id;
        this.taskId = taskId;
        this.creatorId = creatorId;
        this.state = state;
        this.recipientId = recipientId;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getCreateDate() {
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

    @Override
    public String toString() {
        return "CurrentTask{" +
                "id=" + id +
                ", taskId=" + taskId +
                ", creatorId=" + creatorId +
                ", state='" + state + '\'' +
                ", recipientId=" + recipientId +
                ", createDate=" + createDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
