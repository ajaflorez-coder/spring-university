package pe.edu.upc.demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upc.demo.model.Carrera;
import pe.edu.upc.demo.repository.CarreraRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Test
	public void contextLoads() {
		
		Carrera carrera = new Carrera();
		carrera.setNombre("Ing. de Software");
		
		Carrera carrera1 = new Carrera();
		carrera1.setNombre("Ing. de Sis Inf");
		
		Carrera carrera2 = new Carrera();
		carrera2.setNombre("Ing. Industrial");
		
		Carrera carrera3 = new Carrera();
		carrera3.setNombre("Ing. Mecanica");
		
		Carrera guardado = carreraRepository.save(carrera);
		carreraRepository.save(carrera1);
		carreraRepository.save(carrera2);
		carreraRepository.save(carrera3);

		assertTrue(guardado.getId().equals(1));
	}

}
