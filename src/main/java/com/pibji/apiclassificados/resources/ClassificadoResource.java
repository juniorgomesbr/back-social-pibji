package com.pibji.apiclassificados.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pibji.apiclassificados.models.Classificado;
import com.pibji.apiclassificados.repository.ClassificadoRepository;

@RestController
@RequestMapping(value="/api")
public class ClassificadoResource {
	
	@Autowired
	ClassificadoRepository classificadoRepository;
	
	@GetMapping("/classificados")
	public List<Classificado> listaClassificados(){
		return classificadoRepository.findAll();
	}
	
	@PostMapping("/classificados")
	public Classificado createClassificado(@RequestBody Classificado classificado){
		return classificadoRepository.save(classificado);
	}
		

}
