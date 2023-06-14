package co.com.popstyle.servicios.dto.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioResponseDto {

	private Integer idServicio;
	private String nombreServicio;
	private boolean estado;

}
