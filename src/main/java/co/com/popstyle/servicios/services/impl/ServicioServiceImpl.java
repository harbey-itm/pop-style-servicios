package co.com.popstyle.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.popstyle.servicios.dto.respuesta.ServicioResponseDto;
import co.com.popstyle.servicios.entity.ServicioEntity;
import co.com.popstyle.servicios.repository.IServiceRepositorio;
import co.com.popstyle.servicios.request.dto.ServicioDto;
import co.com.popstyle.servicios.services.IServicioService;

@Service
public class ServicioServiceImpl<T> implements IServicioService<T> {

	@Autowired
	private IServiceRepositorio<T> serviceRepositorio;

	@Override
	public List<T> obtenerServicios() {

		@SuppressWarnings("unchecked")
		List<T> listaServicios = (List<T>) serviceRepositorio.findAll();

		if (listaServicios != null)
			return listaServicios;

		return null;
	}

	@Override
	public boolean guardarServicio(ServicioDto servicioDto) {

		ServicioEntity empresaEntity = new ServicioEntity();
		empresaEntity.setIdServicio(0);
		empresaEntity.setNombreServicio(servicioDto.getNombreServicio().toUpperCase());
		empresaEntity.setEstado(true);

		if (serviceRepositorio.save(empresaEntity) != null)
			return true;

		return false;
	}

	@Override
	public ServicioResponseDto obtenerServicio(Integer servicio) {
		ServicioEntity serviceEntity = serviceRepositorio.findById(servicio).orElse(null);

		if (serviceEntity != null) {

			ServicioResponseDto respuesta = new ServicioResponseDto();
			respuesta.setIdServicio(serviceEntity.getIdServicio());
			respuesta.setNombreServicio(serviceEntity.getNombreServicio());
			respuesta.setEstado(serviceEntity.isEstado());
			
			return respuesta;
		}
		return null;
	}

	@Override
	public boolean actualizarServicio(ServicioDto servicioDto) {
		
		ServicioEntity servicioEntity = new ServicioEntity();
		servicioEntity.setIdServicio(servicioDto.getIdServicio());
		servicioEntity.setNombreServicio(servicioDto.getNombreServicio().toUpperCase());
		servicioEntity.setEstado(servicioDto.isEstado());
		
		if(serviceRepositorio.save(servicioEntity) != null)
			return true;
		
		return false;
	}

}
