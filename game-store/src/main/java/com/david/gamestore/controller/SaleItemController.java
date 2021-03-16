package com.david.gamestore.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.david.gamestore.model.Sale;
import com.david.gamestore.model.SaleItem;

public class SaleItemController implements Controller<SaleItem>{
	
	@PutMapping(value = "/add-items/{id}")
	public ResponseEntity<Sale> addItem(@PathVariable("id") long id, @RequestBody Sale sale) throws Exception {
		return  null;//ResponseEntity.ok().body(salesService.addItem(sale, id));
	}

	@Override
	public ResponseEntity<SaleItem> create(SaleItem object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<SaleItem>> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SaleItem> findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SaleItem> update(long id, SaleItem object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<SaleItem> delete(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
