package VTI.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static SessionFactory factory;

    public static Session openSeesion(){
        if (factory == null || factory.isClosed()){
            factory = new Configuration().configure().buildSessionFactory();
        }
        return factory.openSession();
    }

    public static void closeSeesion(){
        if ( factory != null) {
            factory.close();
        }
    }
}
