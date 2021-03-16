package com.david.gamestore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.gamestore.model.Product;
import com.david.gamestore.repository.ProductRepository;

@RestController
@RequestMapping(path = "/products")
public class ProductController implements Controller<Product> {

	private final ProductRepository productRepository;

	public ProductController(@Autowired ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ResponseEntity<Product> create(Product object) throws Exception {
		productRepository.save(object);
		return new ResponseEntity<Product>(object, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<Product>> findAll() throws Exception {
		return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Product> findById(long id) throws Exception {
		return productRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@Override
	public ResponseEntity<Product> update(long id, Product object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Product> delete(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@GetMapping(path = "/sorts/{criteria}")
	public ResponseEntity<List<Product>> findAllSort(@PathVariable String criteria) throws Exception {
		return new ResponseEntity<List<Product>>(productRepository.findAll(Sort.by(Sort.Direction.ASC, criteria)), HttpStatus.ACCEPTED);
	}

}
