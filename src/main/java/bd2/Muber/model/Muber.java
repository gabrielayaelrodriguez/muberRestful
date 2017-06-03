package bd2.Muber.model;

import java.util.HashSet;
import java.util.Set;

public class Muber {
	
	private Set<Conductor> conductores;
    private Set<Pasajero> pasajeros;
	private long id_muber;

	public Muber(){
		
		this.conductores=new HashSet<Conductor>();
		this.pasajeros=new HashSet<Pasajero>();
		


	}
	
	public void listarConductores(){
		for (Conductor c: this.getConductores()){
 		    System.out.println("NOMBRE:"+c.getNombre()+"; FECHA LICENCIA:"+c.getF_licencia()+"; FECHA INGRESO:"+c.getF_ingreso());
    	}	
		
	}
	
    public void listarPasajeros(){
    	for (Pasajero c: this.getPasajeros()){
 		    System.out.println("NOMBRE:"+c.getNombre()+"; FECHA INGRESO:"+c.getF_ingreso()+"; CREDITO:"+c.getCredito());
    	}	
	}
	
	

    public void listarViajesAbiertos(){
       for(Conductor c: this.getConductores()){	
			for (Viaje v: c.getViajes()){
				 if(v.getFinalizado()==false){	
		 		    System.out.println("ORIGEN:"+v.getOrigen()+"; DESTINO:"+v.getDestino()+"; COSTO:"+v.getCosto());
				    }
		    }	
       }	
    }

    
	
	
	//getters y setters
	
	public Set<Conductor> getConductores() {
		return conductores;
	}

	public void setConductores(Set<Conductor> conductores) {
		this.conductores = conductores;
	}

	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	

	public long getId_muber() {
		return id_muber;
	}

	public void setId_muber(long id_muber) {
		this.id_muber = id_muber;
	}



}
