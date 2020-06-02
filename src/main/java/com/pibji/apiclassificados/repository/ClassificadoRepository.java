package com.pibji.apiclassificados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pibji.apiclassificados.models.Classificado;

public interface ClassificadoRepository extends CrudRepository<Classificado, Long>{
	
	@Query("select c from Classificado c where c.status = true")
	List<Classificado> queryAtivos();
	

}
