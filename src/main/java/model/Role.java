package model;

/**
 * Created by Avega on 02.06.14.
 */
public class Role
{
    private int roleId;
    private String nameRole;

    public Role(int roleId, String nameRole)
    {
        this.roleId = roleId;
        this.nameRole = nameRole;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
