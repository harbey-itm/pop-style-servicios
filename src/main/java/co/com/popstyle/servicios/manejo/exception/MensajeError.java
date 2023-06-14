package co.com.popstyle.servicios.manejo.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MensajeError {
	
	private String excepcion;
	private String mensaje;
	private String ruta;
	
	
	public MensajeError(Exception excepcion, String ruta) {
		this.excepcion = excepcion.getClass().getSimpleName();
		this.mensaje = excepcion.getMessage();
		this.ruta = ruta;
	}
}
