package bd2.Muber.dto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ViajeDTO {
	private long id_viaje;
	private int max_pasajeros;
	private boolean finalizado;
	private String destino;
	private String origen;
	private float costo;
	private Date fecha;
	private Set<CalificacionDTO> calificaciones;
	private Set<PasajeroDTO> pasajeros;
	private ConductorDTO conducido_por;
	
	public ViajeDTO(){
		
	}
	
	
	public ViajeDTO(String origen, String destino, int maxpasajeros, float costo, ConductorDTO conducido_por) {
		
		this.finalizado=false;
		this.destino=destino;
		this.origen=origen;
		this.costo=costo;
		this.fecha=new Date();
		this.max_pasajeros=maxpasajeros;
		this.pasajeros = new HashSet<PasajeroDTO>();
		this.conducido_por = conducido_por;
		this.calificaciones = new HashSet<CalificacionDTO>();
		
	}
	
	

	
	//setters y getters
	
	public Set<PasajeroDTO> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(Set<PasajeroDTO> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	
	public long getId_viaje() {
		return id_viaje;
	}
	public void setId_viaje(long id_viaje) {
		this.id_viaje = id_viaje;
	}
	public boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMax_pasajeros() {
		return max_pasajeros;
	}
	public void setMax_pasajeros(int max_pasajeros) {
		this.max_pasajeros = max_pasajeros;
	}
	public Set<CalificacionDTO> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<CalificacionDTO> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public ConductorDTO getConducido_por() {
		return conducido_por;
	}
	public void setConducido_por(ConductorDTO conducido_por) {
		this.conducido_por = conducido_por;
	}


	

	

}
