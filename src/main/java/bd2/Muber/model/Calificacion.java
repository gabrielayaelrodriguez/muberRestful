package bd2.Muber.model;

import java.util.ArrayList;
import java.util.List;

import bd2.Muber.dto.CalificacionDTO;

public class Calificacion {
	
	//list is working as a database
	List<CalificacionDTO> calificaciones;
		
	public Calificacion(){
		calificaciones = new ArrayList<CalificacionDTO>();
		
		/*
		students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO("Robert",0);
		StudentVO student2 = new StudentVO("John",1);
		students.add(student1);
		students.add(student2);
		
		*/
	}
	
	//retrive list of students from the database
   public List<CalificacionDTO> getAllCalificaciones() {
      return calificaciones;
   }
   
   public CalificacionDTO getStudent(int id) {
	   return calificaciones.get(id);
   }

}
