package com.david.gamestore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.david.gamestore.model.Sale;
import com.david.gamestore.model.SaleItem;
import com.david.gamestore.repository.SaleRepository;
import com.david.gamestore.service.SalesService;

public class SalesServiceImpl implements SalesService {

	@Autowired
	private SaleRepository saleRepository;

	@Override
	public void addItem(Sale sale, SaleItem saleItem) throws Exception {
		sale.getItems().add(saleItem);
	}

	@Override
	public void removeItem(Sale sale, SaleItem saleItem) throws Exception {
		sale.getItems().remove(saleItem);

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

}
