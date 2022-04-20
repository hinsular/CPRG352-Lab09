package services;

import dataaccess.RoleDB;
import java.util.ArrayList;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;

public class UserService {
    
    public User get(String email) throws Exception {
        UserDB userDb = new UserDB();
        User user = userDB.get(email);
        return user;
    
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> user = userDB.getAll();
        return user;
    }
    
    public void insert(String email, boolean active, String firstName, String lastName, String password, int roleID) throws Exception {
        User user = new User(email, active, firstName, lastName, password);
        Role role = null;
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        for(Role r: roles){
            if(r.getRoleId() == roleID){
                role = new Role(r.getRoleId(), r.getRoleName());
            }
        }
        user.setRole(role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password, int roleID) throws Exception {
        User user = new User(email, active, firstName, lastName, password);
        Role role = new Role();
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        for(Role r: roles){
            if(r.getRoleId() == roleID){
                role = new Role(r.getRoleId(), r.getRoleName());
            }
        }
        user.setRole(role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}