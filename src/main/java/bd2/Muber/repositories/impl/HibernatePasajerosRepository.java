package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.*;
public class HibernatePasajerosRepository extends BaseHibernateRepository{
	
	
	
	public List<Pasajero> getPasajeros(){
		Session session = this.getSession();
		List<Pasajero> pasajeros= session.createQuery("from Pasajero").list();
		return pasajeros;
	}
	
	
	
	
	
}