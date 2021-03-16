package com.david.gamestore.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.gamestore.model.Product;
import com.david.gamestore.model.Sale;
import com.david.gamestore.model.SaleItem;
import com.david.gamestore.repository.ProductRepository;
import com.david.gamestore.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Sale addItem(Sale sale, Long idItem) throws Exception {
		SaleItem saleItem = new SaleItem(productRepository.findById(idItem).get(), sale);

		if (sale.getSalesItems() == null) {
			sale.setSalesItems(new ArrayList<>());
		}

		sale.getSalesItems().add(saleItem);
		return sale;
	}

	@Override
	public void removeItem(Sale sale, Long idItem) throws Exception {
		SaleItem saleItem = new SaleItem(productRepository.findById(idItem).get(), sale);
		sale.getSalesItems().remove(saleItem);
	}

	@Override
	public List<BigDecimal> getCheckOut(Sale sale) throws Exception {
		return sale.getCheckout();
	}

	@Override
	public BigDecimal calculateFreight(List<SaleItem> saleItems) throws Exception {
		BigDecimal freghitValue = BigDecimal.ZERO;

		if (saleItems.size() > 0) {
			BigDecimal numberItems = BigDecimal.valueOf(saleItems.size());
			freghitValue = numberItems.multiply(BigDecimal.TEN);
		}

		return freghitValue;
	}

	@Override
	public List<Product> findAllProducts() throws Exception {
		return productRepository.findAll();
	}

}
