package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.*;
public class HibernateViajesRepository extends BaseHibernateRepository{
	
	
	
	public List<Viaje> getConductores(){
		Session session = this.getSession();
		List<Viaje> viajes= session.createQuery("from Viaje").list();
		return viajes;
	}
	
	
	
	
	
}