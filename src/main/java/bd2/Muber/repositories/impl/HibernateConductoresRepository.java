package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.*;
public class HibernateConductoresRepository extends BaseHibernateRepository{
	
	
	
	public List<Conductor> getConductores(){
		Session session = this.getSession();
		List<Conductor> conductores= session.createQuery("from Conductor").list();
		return conductores;
	}
	
	
	
	
	
}