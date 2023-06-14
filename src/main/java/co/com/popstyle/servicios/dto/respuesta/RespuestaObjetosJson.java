package co.com.popstyle.servicios.dto.respuesta;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class RespuestaObjetosJson<T> {

	
	private RespuestaDto respuesta;
	private List<T> datos;

	public RespuestaObjetosJson() {

		this.respuesta = new RespuestaDto();
		this.datos = new ArrayList<T>();
	}

	public RespuestaObjetosJson(RespuestaDto respuesta, List<T> objetos) {
		this.respuesta = respuesta;
		this.datos = objetos;
	}
}
