package com.david.gamestore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interface para definir os end-point padrão.
 * @author david
 *
 * @param <T>
 */
public interface Controller<T> {

	/**
	 * End-point para criar um novo registro na base de dados.
	 * @param object
	 * @return ResponseEntity<T>
	 * @throws Exception
	 */
	@PostMapping
	ResponseEntity<T> create(@RequestBody T object) throws Exception;

	/**
	 * End-point para retornar todos os dados referente a uma entidade na base de dados.
	 * @return ResponseEntity<List<T>>
	 * @throws Exception
	 */
	@GetMapping
	ResponseEntity<List<T>> findAll() throws Exception;

	/**
	 * End-point para retornar um registro especifico de uma entidade apartir de seu id (identificador).
	 * @param id
	 * @return ResponseEntity<T>
	 * @throws Exception
	 */
	@GetMapping(path = { "/{id}" })
	ResponseEntity<T> findById(@PathVariable long id) throws Exception;

	/**
	 * End-point para atualizar um registro de uma determinada entidade apartir de seu id (identificador).
	 * @param id
	 * @param object(Enviado no corpo da request)
	 * @return
	 * @throws Exception
	 */
	@PutMapping(value = "/{id}")
	ResponseEntity<T> update(@PathVariable("id") long id, @RequestBody T object) throws Exception;
	
	/**
	 * End-point para deletar um registro de uma determinada entidade apartir de seu id (identificador).
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<T> delete(@PathVariable long id) throws Exception;

}
