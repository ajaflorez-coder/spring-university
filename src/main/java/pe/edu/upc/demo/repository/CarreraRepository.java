package pe.edu.upc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.demo.model.Carrera;

@Repository
public interface CarreraRepository 
	extends JpaRepository<Carrera, Integer>{

}
