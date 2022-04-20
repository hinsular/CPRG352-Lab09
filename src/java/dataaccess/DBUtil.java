package dataaccess;

import javax.accessibility.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil{
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
    
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
}