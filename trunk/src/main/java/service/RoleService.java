package service;

import dao.RoleDao;
import model.Role;

import java.util.List;

/**
 * Created by Avega on 09.06.14.
 */
public enum RoleService implements IRoleService
{     INSTANCE;
    private RoleDao rDao;

    private RoleService()
    {
        rDao = new RoleDao();
    }
    public List<Role> getAllRole()
    {
        return rDao.getAllRole();
    }
}
