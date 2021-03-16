package com.david.gamestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.gamestore.model.Sale;
import com.david.gamestore.service.SalesService;

@RestController
@RequestMapping(path = { "/sales" })
public class SaleController {
	
	@Autowired
	public SaleController(SalesService salesService) {
		this.salesService = salesService;
	}

	@Autowired
	private final SalesService salesService;
	
	/*
	@PostMapping
	public ResponseEntity<Sale> save(@RequestBody Sale sale) {
		repository.save(sale);
		return new ResponseEntity<Sale>(sale, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		return new ResponseEntity<List<Sale>>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Sale> findById(@PathVariable String id) {
		return repository.findById(Long.parseLong(id)).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	*/
	
	@PatchMapping(value = "/add-items/{id}")
	public ResponseEntity<Sale> addItem(@PathVariable("id") long id, @RequestBody Sale sale) throws Exception {
		return ResponseEntity.ok().body(salesService.addItem(sale, id));
	}

	/*
	@GetMapping(value = "/remove-items/{id}")
	public ResponseEntity<Sale> removeItem(@PathVariable("id") long id, @RequestBody Sale sale) throws Exception {
		salesService.removeItem(sale, id);
		return ResponseEntity.ok().body(sale);
	}

	@GetMapping(path = { "/checkout" })
	public ResponseEntity<List<BigDecimal>> getCheckout(@RequestBody Sale sale) throws Exception {
		return new ResponseEntity<List<BigDecimal>>(salesService.getCheckOut(sale), HttpStatus.OK);
	}


	/*
	 * @PutMapping(value = "/{id}") public ResponseEntity<Sale>
	 * update(@PathVariable("id") long id, @RequestBody Sale Sale) { return
	 * repository.findById(id).map(record -> { record.setLogin(Sale.getLogin());
	 * record.setName(Sale.getName()); record.setPassword(Sale.getPassword()); Sale
	 * updated = repository.save(record); return ResponseEntity.ok().body(updated);
	 * }).orElse(ResponseEntity.notFound().build()); }
	 */

	/*
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	*/

}
