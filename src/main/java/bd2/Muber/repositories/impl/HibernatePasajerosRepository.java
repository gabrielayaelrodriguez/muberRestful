package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import bd2.Muber.dto.*;
public class HibernatePasajerosRepository extends BaseHibernateRepository{
	
	
	
	public List<PasajeroDTO> getPasajeros(){
		Session session = this.getSession();
		List<PasajeroDTO> pasajeros= session.createQuery("from PasajeroDTO").list();
		return pasajeros;
	}
	
	
	
	
	
}