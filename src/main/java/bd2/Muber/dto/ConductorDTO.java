package bd2.Muber.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ConductorDTO extends UsuarioDTO {
	private Set<ViajeDTO> viajes;
	private Date f_licencia;
	

    public ConductorDTO(){

    }
    
    public ConductorDTO(String nombre, String contrasenia , Date f_licencia){
		
		super(nombre, contrasenia);
		this.viajes = new HashSet<ViajeDTO>();
		this.f_licencia=f_licencia;
			
	}
    

    //getters y setters
    
	public Set<ViajeDTO> getViajes() {
		return viajes;
	}

	public void setViajes(Set<ViajeDTO> viajes) {
		this.viajes = viajes;
	}

	public Date getF_licencia() {
		return f_licencia;
	}

	public void setF_licencia(Date f_licencia) {
		this.f_licencia = f_licencia;
	}

	

	

}
