package pe.edu.upc.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sedes")
public class Sede {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	
	@ManyToMany
	@JoinTable(name = "sede_carrera", 
		joinColumns = {@JoinColumn(name = "sede_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "carrera_id")})
	private List<Carrera> carreras;
	
}
