package pe.edu.upc.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estudiantes", 
	indexes = {@Index(name = "estudaintes_index1", columnList = "apellidos"), 
			@Index(name = "estudiante_nombres", columnList = "nombres")})
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "nombres", length = 35, nullable = false)
	private String nombres;
	
	@Column(name = "apellidos", length = 40, nullable = false)
	private String apellidos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nac")
	private Date fechaNac;
	
	@Column(name = "edad", columnDefinition = "tinyint")
	private Integer edad;
	
	private float peso;
	
	@ManyToOne
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	@OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
	private List<EstudianteCurso> estudianteCursos;
}





