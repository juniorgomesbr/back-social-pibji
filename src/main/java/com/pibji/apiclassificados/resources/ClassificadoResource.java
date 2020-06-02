package com.pibji.apiclassificados.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibji.apiclassificados.exceptions.ClassificadoNotExistException;
import com.pibji.apiclassificados.models.Classificado;
import com.pibji.apiclassificados.repository.ClassificadoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="Classificados API REST")
@CrossOrigin(origins="*")
public class ClassificadoResource {
	
	@Autowired
	ClassificadoRepository classificadoRepository;
	
	@GetMapping("/classificados")
	@ApiOperation(value="Retorna uma lista de Classificados Ativos")
	public List<Classificado> listaClassificados(){
		return classificadoRepository.queryAtivos();
		}
	
	@PostMapping("/classificados")
	public Classificado createClassificado(@RequestBody Classificado classificado){
		return classificadoRepository.save(classificado);
	}
	
	@DeleteMapping("/classificados/{id}")
	public void deleteClassificado(@PathVariable(value="id") long id) {
		Optional<Classificado> classificadoDel = classificadoRepository.findById(id);
		if (classificadoDel.isPresent()) {
			Classificado classificadoPersisted = classificadoDel.get();
			classificadoPersisted.setStatus(false);
			classificadoRepository.save(classificadoPersisted);
		} else {
			throw new ClassificadoNotExistException(id);
		}		
		
	}
		

}
