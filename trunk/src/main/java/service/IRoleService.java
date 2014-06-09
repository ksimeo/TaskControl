package service;

import model.Role;

import java.util.List;

/**
 * Created by Avega on 09.06.14.
 */
public interface IRoleService
{
    public List<Role> getAllRole(int roleId, String nameRole);
}
