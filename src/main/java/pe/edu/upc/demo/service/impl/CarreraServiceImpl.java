package pe.edu.upc.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.demo.model.Carrera;
import pe.edu.upc.demo.repository.CarreraRepository;
import pe.edu.upc.demo.repository.EstudianteRepository;
import pe.edu.upc.demo.service.CarreraService;

@Service
public class CarreraServiceImpl implements CarreraService{

	@Autowired
	private CarreraRepository carreraRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Carrera> findAll() throws Exception {
		// TODO Auto-generated method stub		
		return carreraRepository.findAll();
		
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Carrera> findById(Integer id) throws Exception {
		return carreraRepository.findById(id);
	}
	@Transactional
	@Override
	public Carrera save(Carrera t) throws Exception {
		return carreraRepository.save(t);
	}
	@Transactional
	@Override
	public Carrera update(Carrera t) throws Exception {
		return carreraRepository.save(t);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) throws Exception {
		carreraRepository.deleteById(id);		
	}

	@Override
	@Transactional
	public void deleteAll() throws Exception {
		carreraRepository.deleteAll();
		
	}

}
