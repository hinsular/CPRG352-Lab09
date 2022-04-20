package services;

import dataaccess.RoleDB;
import java.util.List;
import models.Role;

public class RoleService{

    public List<Role> getAll() throws Exception{
        RoleDB noteDB = new RoleDB();
        List<Role> roles = noteDB.getAll();
        return roles;
    }
}