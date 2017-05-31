package bd2.Muber.model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.Session;
public class HibernateUtil
{  
	private static SessionFactory sessionFactory;
	private static  Configuration conf;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
        	
            conf = new Configuration().configure("hibernate.cfg.xml");
            
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();
            // builds a session factory from the service registry
            sessionFactory = conf.buildSessionFactory(serviceRegistry);   
           
        }
         
        return sessionFactory;
    }
   public static void  crearSchema(){
	 //borra si existe el esquema en la base de datos asi no hay conflictos y deja libre para cargar la nueva version de las tablas
		System.out.println("DROPPING SCHEMA");
		new SchemaExport(conf).drop(true, true);
		
		//genera las tablas
		System.out.println("CREANDO SCHEMA");
		new SchemaExport(conf).create(true, true);
	   
	   
	 } 
   public static void cerrar(Session session ){
	   System.out.println("EMPEZANDO A CERRAR...");
	    session.getTransaction().commit();
		session.flush();
		session.close();
		sessionFactory.close(); 
		System.out.println("SESION CERRADA");
	   
	   
   }
}