package co.com.popstyle.servicios.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDto {

	private Integer idServicio; 
	private String nombreServicio;
	private boolean estado;

}