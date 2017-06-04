package bd2.Muber.dto;


import java.util.Set;
import java.util.HashSet;


public class PasajeroDTO extends UsuarioDTO {
	private float credito;
	private Set<ViajeDTO> viajes;
	private Set<CalificacionDTO> calificaciones;
	

	public PasajeroDTO(){
	
	}

	public PasajeroDTO(String nombre, String contrasenia, float credito){
		
		super(nombre, contrasenia);
		this.credito=credito;
		this.viajes = new HashSet<ViajeDTO>();
		this.calificaciones = new HashSet<CalificacionDTO>();
	
		

		
	}

	
	
	public Set<CalificacionDTO> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<CalificacionDTO> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public float getCredito() {
		return credito;
	}


	public void setCredito(float credito) {
		this.credito = credito;
	}
	public Set<ViajeDTO> getViajes() {
		return viajes;
	}

	public void setViajes(Set<ViajeDTO> viajes) {
		this.viajes = viajes;
	}



}
