package bd2.Muber.model;

import java.util.GregorianCalendar;
import org.hibernate.Session;


public class Main {
	
	
	public static void main(String[] args) {
		
		
		//abrimos la sesión
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		//empezamos a instanciar y hacer lo pedido en el enunciado
		
		Muber muber= new Muber();
		
       
		Conductor roberto = new Conductor("Roberto","1234",new GregorianCalendar(2020, 2, 20).getTime(), muber);
		Viaje viaje = roberto.registrarViaje("La Plata","Tres Arroyos", 4, 10000);
				
		
		Pasajero german = new Pasajero("German", "g", 1500, muber);
		Pasajero alicia = new Pasajero("Alicia", "a", 1500, muber );
		Pasajero margarita = new Pasajero("Margarita", "m", 1500, muber);
		
		
		german.agregarse(viaje);
		alicia.agregarse(viaje);
		margarita.agregarse(viaje);
		
		
	
		session.save(muber);
		
		margarita.agregarse(viaje);
		
		
		roberto.finalizar(viaje);
		
		
		
		
		
		
		
		session.save(muber);
		
		
		
	
		
		
		
		
		
		
		
		
		
		HibernateUtil.cerrar(session);
		
	}
}
