package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import bd2.Muber.model.*;
public class HibernateCalificacionesRepository extends BaseHibernateRepository{
	
	
	
	public List<Calificacion> getCalificaciones(){
		Session session = this.getSession();
		List<Calificacion> calificaciones= session.createQuery("from Calificacion").list();
		return calificaciones;
	}
	
	
	
	
	
}