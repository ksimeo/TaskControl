package model;

/**
 * Created by user on 25.05.14.
 */
public class User {
    private int userId;
    private String name;
    private String login;
    private String password;
    private String access;

    public User(int userId, String name, String login, String password, String access) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.access = access;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAccess() {
        return access;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
