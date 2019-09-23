package pe.edu.upc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.demo.model.Authority;

public interface AuthorityRepository 
	extends JpaRepository<Authority, Long>{

}
