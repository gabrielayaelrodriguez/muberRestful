package bd2.Muber.model;


import java.util.Set;
import java.util.HashSet;


public class Pasajero extends Usuario {
	private float credito;
	private Set<Viaje> viajes;
	private Set<Calificacion> calificaciones;
	private Muber muber;

	public Pasajero(){
	
	}

	public Pasajero(String nombre, String contrasenia, float credito, Muber muber){
		
		super(nombre, contrasenia);
		this.credito=credito;
		this.viajes = new HashSet<Viaje>();
		this.calificaciones = new HashSet<Calificacion>();
		this.muber=muber;
		muber.getPasajeros().add(this);
		

		
	}
	
	public void agregarse(Viaje viaje) {
		if(!viaje.getFinalizado()){
		    viaje.agregarPasajero(this);
			this.viajes.add(viaje);
		}else{
			System.out.println("viaje finalizado");
		}
	}
	
	public Calificacion calificar(int puntaje, String comentario, Viaje viaje) {
		
		Calificacion calif= new Calificacion(puntaje, comentario, this, viaje);
		
		viaje.agregarCalificacion(calif);
		return calif;
	}
	public void cobrar(float acobrar) {
		this.credito=this.credito - acobrar;
		
	}
	
	public void cargarCredito(float monto){
		this.credito = this.credito + monto;
	}
	
	
	//geters y setters
	
	
	
	public Set<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public float getCredito() {
		return credito;
	}


	public void setCredito(float credito) {
		this.credito = credito;
	}
	public Set<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}


	public Muber getMuber() {
		return muber;
	}

	public void setMuber(Muber muber) {
		this.muber = muber;
	}


}
