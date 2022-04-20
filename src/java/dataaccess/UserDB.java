package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.*;

public class UserDB{

    public List<User> getAll() throws Exception {
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    
        try{
            List<User> users = em.createNameQuery("User.findAll", User.class).getResultList();
            return users;
        } 

        finally {
            em.close();
        }
    
    }
    
    public User get(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            user user = em.find(User.class, email);
            return user;
        }
        finally {
            em.close();
        }
    }
    
    public void insert(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try {
            transaction.begin();
            user.getRole().getUserLost().add(user);
            em.persist(user);
            em.merge(user);
            transaction.commit();
            
        } catch(Exception e){
            transaction.rollback();
        } 
        finally {
            em.close();
        }
    }
    
    public void update(User user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try{
            transaction.begin();
            em.merge(user);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
    
    public void delete(User user) throw Exception {
        EntityMsnsger em = DBUtil.getemFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        
        try{
            Role role = user.getRole();
            role.getUserList().remove(user);
            transaction.begin();
            em.remove(em.merge(user));
            em.merge(role);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
        } finally {
            em.close();
        }
    }
}