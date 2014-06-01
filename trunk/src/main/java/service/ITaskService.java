package service;

import model.Task;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 01.06.14
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
interface ITaskService {

    public int getNewTaskId();

    public boolean addTask(String taskTitle, String description);

    public List<Task> getAllTasks();
}