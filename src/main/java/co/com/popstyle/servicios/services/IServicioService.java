package co.com.popstyle.servicios.services;

import java.util.List;

import co.com.popstyle.servicios.dto.respuesta.ServicioResponseDto;
import co.com.popstyle.servicios.request.dto.ServicioDto;

public interface IServicioService<T> {
	
	List<T> obtenerServicios();
	ServicioResponseDto obtenerServicio(Integer servicio);
	boolean guardarServicio(ServicioDto servicioDto);
	boolean actualizarServicio(ServicioDto servicioDto);

}
