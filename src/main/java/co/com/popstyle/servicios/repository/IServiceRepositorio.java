package co.com.popstyle.servicios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.popstyle.servicios.entity.ServicioEntity;

@Repository
public interface IServiceRepositorio<T> extends JpaRepository<ServicioEntity, Integer> {

}
