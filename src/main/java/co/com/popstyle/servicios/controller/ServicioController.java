package co.com.popstyle.servicios.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.popstyle.servicios.dto.respuesta.RespuestaDto;
import co.com.popstyle.servicios.dto.respuesta.RespuestaObjetosJson;
import co.com.popstyle.servicios.dto.respuesta.ServicioResponseDto;
import co.com.popstyle.servicios.request.dto.ServicioDto;
import co.com.popstyle.servicios.services.IServicioService;

@RestController
public class ServicioController<T> {

	@Autowired
	private IServicioService<T> service;

	@GetMapping(value = "/obtenerServicios")
	public RespuestaObjetosJson<T> obtenerServicios() {

		List<T> misServicios = service.obtenerServicios();

		if (misServicios != null && !misServicios.isEmpty())
			return new RespuestaObjetosJson<T>(
					new RespuestaDto(true, "Si existen Servicios en la Base de Datos !!!", "N/A"), misServicios);

		return new RespuestaObjetosJson<T>(
				new RespuestaDto(false, "No existen Servicios en la Base de Datos !!!", "01"), null);
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/obtenerServicio/{servicio}")
	public RespuestaObjetosJson<T> obtenerEmpresa(@PathVariable Integer servicio) {

		List<ServicioResponseDto> listaServicios = new ArrayList<ServicioResponseDto>();
		ServicioResponseDto servicioDto = service.obtenerServicio(servicio);

		if (servicioDto != null) {
			listaServicios.add(servicioDto);
			return new RespuestaObjetosJson<T>(new RespuestaDto(), (List<T>) listaServicios);
		}
		return new RespuestaObjetosJson<T>(new RespuestaDto(false,
				"No existe el codigo: " + servicio + " del Servicio en la Base de Datos", "N/A"), null);

	}

	@PostMapping(value = "/guardarServicios")
	public RespuestaObjetosJson<T> guardarServicios(@RequestBody @Valid ServicioDto servicioDto) {

		if (service.guardarServicio(servicioDto)) {
			return (new RespuestaObjetosJson<T>(
					new RespuestaDto(true, "Se creó el Servicio: " + servicioDto.getNombreServicio() + " correctamente", "N/A"),
					null));
		}
		return new RespuestaObjetosJson<T>(
				new RespuestaDto(false,
						"No se pudo crear el Servicio" + servicioDto.getNombreServicio() + " en la Base de Datos.", "N/A"),
				null);

	}

	@PutMapping(value = "/actualizarServicio")
	public RespuestaObjetosJson<T> actualizarServicio(@RequestBody @Valid ServicioDto servicioDto) {

		ServicioResponseDto respuestaServicioDto = service.obtenerServicio(servicioDto.getIdServicio());

		if (respuestaServicioDto != null) {
			if (service.actualizarServicio(servicioDto)) {
				return new RespuestaObjetosJson<T>(
						new RespuestaDto(true, "Se actualizó correctamente el Servicio con codigo "
								+ servicioDto.getIdServicio() + " en la Base de Datos", ""),
						null);
			} else {
				return new RespuestaObjetosJson<T>(
						new RespuestaDto(false, "No se pudo actualizar el Servicio con codigo: "
								+ servicioDto.getIdServicio() + " en la Base de Datos", "N/A"),
						null);
			}
		}
		return new RespuestaObjetosJson<T>(new RespuestaDto(false,
				"No existe el Servicio con codigo: " + servicioDto.getIdServicio() + " en la Base de Datos", "N/A"),
				null);
	}

}
