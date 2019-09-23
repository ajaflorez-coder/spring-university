package pe.edu.upc.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 50, nullable = false)
	private String nombre;
	private Integer semestre;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY)
	private List<EstudianteCurso> estudianteCursos;
	
	@ManyToMany(mappedBy = "cursos")
	private List<Docente> docentes;
	
	public Curso() {
		this.docentes  = new ArrayList<>();
		this.estudianteCursos = new ArrayList<>();
	}
}
