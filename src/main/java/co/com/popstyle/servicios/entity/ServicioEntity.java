package co.com.popstyle.servicios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="servicios")
public class ServicioEntity implements Serializable{

	private static final long serialVersionUID = -3633115895325352934L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServicio;
	
	@Column(name="nombre_servicio")
	private String nombreServicio;
	
	@Column(name="estado")
	private boolean estado;

}
