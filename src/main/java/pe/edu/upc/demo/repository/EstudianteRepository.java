package pe.edu.upc.demo.repository;

import java.util.List;

import org.hibernate.jdbc.Expectations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.model.Estudiante;

@Repository
public interface EstudianteRepository 
	extends JpaRepository<Estudiante, Integer>{
	
	// 1. Utilizar la convencion findBy____
	List<Estudiante> findByApellidos(String apellidos) throws Exception;
	List<Estudiante> findByNombres(String nombres) throws Exception;
	
	// 2. Utlizar la Anotacion @Query
	@Query("Select es from Estudiante es where es.apellidos = :apellidos and es.nombres = :nombres")
	List<Estudiante> fetchByApellidosNombres(String apellidos, String nombres)
		throws Exception;
	
}













