package pe.edu.upc.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "docentes", 
		indexes = {@Index(name = "docente_apellidos_nombres", 
		columnList = "nombres, apellidos") } )
public class Docente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "nombres", length = 35, nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@ManyToMany
	@JoinTable(name = "docente_cuso", 
			joinColumns = {@JoinColumn(name = "docente_id")}, 
			inverseJoinColumns = {@JoinColumn(name = "curso_id")})
	private List<Curso> cursos;
	
	public Docente() {
		this.cursos = new ArrayList<>();
	}
}
