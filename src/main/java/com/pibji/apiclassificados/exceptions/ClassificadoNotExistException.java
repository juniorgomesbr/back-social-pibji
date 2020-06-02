package com.pibji.apiclassificados.exceptions;

public class ClassificadoNotExistException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClassificadoNotExistException(Long id) {
		super("Classificado não encontrado:" + id);
	};

}
