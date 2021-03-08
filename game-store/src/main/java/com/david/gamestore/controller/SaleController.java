package com.david.gamestore.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.gamestore.model.Product;
import com.david.gamestore.model.Sale;
import com.david.gamestore.model.SaleItem;
import com.david.gamestore.repository.SaleRepository;
import com.david.gamestore.service.SalesService;

@RestController
@RequestMapping(path = { "/sales" })
public class SaleController {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SalesService salesService;
	
	@PostMapping
	public ResponseEntity<Sale> save(@RequestBody Sale sale) {
		repository.save(sale);
		return new ResponseEntity<Sale>(sale, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		return new ResponseEntity<List<Sale>>(repository.findAll(), HttpStatus.ACCEPTED);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Sale> findById(@PathVariable Long id) {
		return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "/remove-itens"})
	public ResponseEntity<Sale> removeItem(@RequestBody Sale sale, @PathVariable SaleItem saleItem) throws Exception {
		salesService.removeItem(sale, saleItem);
		return new ResponseEntity<Sale>(sale, HttpStatus.OK);
	}
	
	@GetMapping(path = { "/remove-itens"})
	public ResponseEntity<Sale> addItem(@RequestBody Sale sale, @PathVariable SaleItem saleItem) throws Exception {
		salesService.addItem(sale, saleItem);
		return new ResponseEntity<Sale>(sale, HttpStatus.OK);
	}
	
	@GetMapping(path = { "/checkout"})
	public ResponseEntity<List<BigDecimal>> getCheckout(@RequestBody Sale sale ) throws Exception {
		return new ResponseEntity<List<BigDecimal>>(salesService.getCheckOut(sale), HttpStatus.OK);
	}
	
	@GetMapping(path = {"/sort","/{criteria}"})
	public ResponseEntity<Sale> orderByListProduct(@RequestBody Sale sale, @PathVariable String criteria) {
		List<Product> products = new ArrayList<>();
		
		for (SaleItem iterable_element : sale.getItems()) {
			products.add(iterable_element.getProduct());
		}
		
		Collections.sort(products);
		
		return null;
	}

	/*
	@PutMapping(value = "/{id}")
	public ResponseEntity<Sale> update(@PathVariable("id") long id, @RequestBody Sale Sale) {
		return repository.findById(id).map(record -> {
			record.setLogin(Sale.getLogin());
			record.setName(Sale.getName());
			record.setPassword(Sale.getPassword());
			Sale updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}*/

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
