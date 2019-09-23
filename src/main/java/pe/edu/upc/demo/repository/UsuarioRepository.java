package pe.edu.upc.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.demo.model.Usuario;

public interface UsuarioRepository 
	extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByUsername(String username);
}
