package pe.edu.upc.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.demo.model.Carrera;
import pe.edu.upc.demo.service.CarreraService;

@Controller
@RequestMapping("/carrera")
@SessionAttributes("carrera")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;	
	
	@GetMapping("inicio")
	public String inicio(Model model) {
		String nombre = "Jose Carlos";
		model.addAttribute("nombre2", nombre);
		return "carrera/inicio";
	}
	
	@GetMapping("listado")
	public String listar(Model model) {
		try {
			List<Carrera> carreras = carreraService.findAll();
			model.addAttribute("carreras", carreras);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "carrera/listado";
	}
	
	@GetMapping("datos")
	public String datos() {
		return "carrera/datos";
	}
	
	@GetMapping("edit/{id}")
	public String edicion( @PathVariable("id") Integer id, Model model  ) {
		try {
			Optional<Carrera> carrera = carreraService.findById(id);
			// Se verifica que el Optional contiene el objeto
			if( carrera.isPresent() ) {
				model.addAttribute("carrera", carrera.get());
			} else {
				model.addAttribute("error", "No existe el Id");
				return "redirect:/carrera/listado";
			}
			
		} catch (Exception e) {
			model.addAttribute("error", "Error 500");
			return "redirect:/carrera/listado";
		}		
		return "carrera/editar";	// Archivo html
	}
	@PostMapping("grabar")
	public String grabar(@ModelAttribute("carrera") Carrera carrera, Model model, 
			SessionStatus status) {
		try {
			carreraService.save(carrera);
			status.setComplete();
		} catch (Exception e) {
			model.addAttribute("error", "No se guardo la carrera");
		}		
		
		return "redirect:/carrera/listado";
	}
	
	@GetMapping("nuevo")
	public String nuevo(Model model) {
		Carrera carrera = new Carrera();
		model.addAttribute("carrera", carrera);
		return "/carrera/nuevo";
	}
	
	@GetMapping("delete/{id}")
	public String remover( @PathVariable("id") Integer id, Model model  ) {
		try {
			Optional<Carrera> carrera = carreraService.findById(id);
			// Se verifica que el Optional contiene el objeto
			if( carrera.isPresent() ) {
				carreraService.deleteById(id);
			} else {
				model.addAttribute("error", "No existe el Id");				
			}
			
		} catch (Exception e) {
			model.addAttribute("error", "Error 500");
		}		
		return "redirect:/carrera/listado";
	}
	
}












