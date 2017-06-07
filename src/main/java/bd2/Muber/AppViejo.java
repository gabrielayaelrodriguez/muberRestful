package bd2.Muber;

import bd2.Muber.model.*;


import java.util.GregorianCalendar;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AppViejo 
{
    public static void main( String[] args )
    {   
    	
         //solo se descomenta la carga() si no se posee la base de datos de la etapa 1, este metodo se encarga de que si no existe 
    	 //la crea y carga pero si ya existe carga los datos solamente 
    
    	//post urlencoded
    	//put raw y en tipo json
    	
        //carga();
         escenariotp2();
    			
    }
    
    
    
    public static void  escenariotp2()
    {  
	   
    	
	    //PUNTO A
	    
    	Long id_viaje = solicitarALtaDeViaje("Mar del Plata","Cordoba","Roberto",3500,2);	
	    	
	   //PUNTO B
	 
	     Long id_margarita= buscarPasajero("Margarita",solicitarListaDePasajeros()); 
	     agregarSaldo(id_margarita,4000);
	     Long id_hugo = cargarPasajero("Hugo", 2300);
	     agregarPasajeroAViaje(id_margarita,id_viaje);
    	
    	 agregarPasajeroAViaje(id_hugo,id_viaje);
       
	    //PUNTO C
	      calificarViaje(id_hugo, id_viaje,"bien", 5 );
	      calificarViaje(id_margarita, id_viaje,"bien", 4 );
    	//PUNTO D
    	  finalizarViaje(id_viaje);
    	  
    }
    
    
    
    //finalizar el viaje
    public static void finalizarViaje(Long id_viaje) {
    	String url="http://localhost:8080/MuberRESTful/rest/services/viajes/finalizar";
		RestTemplate restTemplate = new RestTemplate();
		String input = String.format("idViaje=%1$d", id_viaje);
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/x-www-form-urlencoded");
		HttpEntity<String> entity = new HttpEntity<String>(input, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		System.out.println(response.getBody());
		
	}
    //agregar calificacion a viaje
    public static void calificarViaje(Long id_pasajero,Long id_viaje,String comentario, int puntaje ) {
    	String url="http://localhost:8080/MuberRESTful/rest/services/viajes/calificar";
		RestTemplate restTemplate = new RestTemplate();
		String input = String.format("idViaje=%1$d&idPasajero=%2$d&comentario=%3$s&puntaje=%4$d", id_viaje,id_pasajero, comentario, puntaje);
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/x-www-form-urlencoded");
		HttpEntity<String> entity = new HttpEntity<String>(input, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		System.out.println(response.getBody());
		
	}
    
    //agregar pasajero a viaje
    public static void agregarPasajeroAViaje(Long id_pasajero,Long id_viaje ) {
    	String url="http://localhost:8080/MuberRESTful/rest/services/viajes/agregarPasajero";
		RestTemplate restTemplate = new RestTemplate();
		String input = String.format("idViaje=%1$d&idPasajero=%2$d", id_viaje,id_pasajero);
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/x-www-form-urlencoded");
		HttpEntity<String> entity = new HttpEntity<String>(input, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		System.out.println(response.getBody());
		
	}
   //agrega saldo al pasajero
    public static void agregarSaldo(Long id_margarita, float monto) {
    	String url="http://localhost:8080/MuberRESTful/rest/services/pasajeros/cargarCredito";
		RestTemplate restTemplate = new RestTemplate();
		String input = String.format("idPasajero=%1$d&monto=%2$.0f", id_margarita,monto);
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/x-www-form-urlencoded");
		HttpEntity<String> entity = new HttpEntity<String>(input, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		System.out.println(response.getBody());
		
	}


	//hace la solicitud para el alta de un viaje
    public static Long  solicitarALtaDeViaje(String origen,String destino,String nombreConductor, float costo,int max_pasajero){
    	String url="http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo";
    	RestTemplate restTemplate = new RestTemplate();
    	long id_conductor= buscarConductor(nombreConductor,solicitarListaDeConductores());
    	String input = String.format("origen=%1$s&destino=%2$s&costoTotal=%3$.0f&cantidadPasajeros=%4$d&conductorId= %5$d",
    			origen,destino,costo, max_pasajero, id_conductor);
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("content-type", "application/x-www-form-urlencoded");
		HttpEntity<String> entity = new HttpEntity<String>(input, headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println("Se ha creado el viaje correctamente");
		return new Long(response.getBody());
    }
    
    
    
    
    
    
    // se solicita a la aplicacion por medio de una peticion http el listado de conductores
    
    public static JSONObject solicitarListaDeConductores(){
 
		String url="http://localhost:8080/MuberRESTful/rest/services/conductores";
		RestTemplate restTemplate = new RestTemplate();
		//http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/package-summary.html
		HttpHeaders headers = new HttpHeaders();
		// mando el post y obtengo el listado en formato json 
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		//pasa de ser string a json
	    return new JSONObject(response.getBody());
	   
    }
    

    // se solicita a la aplicacion por medio de una peticion http el listado de conductores
    
    public static JSONObject solicitarListaDePasajeros(){
 
		String url="http://localhost:8080/MuberRESTful/rest/services/pasajeros";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		//pasa de ser string a json
	    return new JSONObject(response.getBody());
	   
    }
    
    
  //buca por nombre un pasajero
    private static long buscarPasajero(String name, JSONObject pasajeros) {
    	Iterator<?> p = pasajeros.keys();
    	while( p.hasNext() ) {
		    String key = (String) p.next();
		    if(pasajeros.get(key).equals(name)){
		    	return Long.parseLong(key, 10);
		    }
    	}
		return (Long) null;
	}
    
    
    
    
    
    //buca por nombre un conductor
    private static long buscarConductor(String name, JSONObject conductores) {
    	Iterator<?> c = conductores.keys();
    	while( c.hasNext() ) {
		    String key = (String) c.next();
		    if(conductores.get(key).equals(name)){
		    	return Long.parseLong(key, 10);
		    }
    	}
		return (Long) null;
	}
    
    public static Long cargarPasajero(String name, float monto){
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Muber muber= new Muber();
		Pasajero hugo = new Pasajero(name, "", monto, muber);
		session.save(muber);
		HibernateUtil.cerrar(session);
		return hugo.getId_usuario();
    }

    //realiza la carga de la base de la etapa 1
	public static void carga()
    {
    	
    	Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Muber muber= new Muber();
		Conductor roberto = new Conductor("Roberto","1234",new GregorianCalendar(2020, 2, 20).getTime(), muber);
		Viaje viaje = roberto.registrarViaje("La Plata","Tres Arroyos", 4, 900);

		roberto.registrarViaje("La Plata","Buenos Aires", 4,500);
		roberto.registrarViaje("Moron","La Plata", 1, 12900);
	
		Pasajero german = new Pasajero("German", "g", 1500, muber);
		Pasajero alicia = new Pasajero("Alicia", "a", 1500, muber );
		Pasajero margarita = new Pasajero("Margarita", "m", 1500, muber);
		
		german.agregarse(viaje);
		alicia.agregarse(viaje);
		margarita.agregarse(viaje);
		
		german.calificar(5, "excelente viaje", viaje);
		alicia.calificar(4, "buen viaje", viaje);
		margarita.calificar(4, "bien", viaje);
		
		roberto.finalizar(viaje);
	
		session.save(muber);
		HibernateUtil.cerrar(session);
		
    }
  
}
