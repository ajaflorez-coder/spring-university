package pe.edu.upc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante_curso")
public class EstudianteCurso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	private float nota; 
	
	@Column(name = "seccion", length = 4, nullable = false)
	private String seccion;
}
