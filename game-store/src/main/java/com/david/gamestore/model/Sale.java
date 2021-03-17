package com.david.gamestore.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Classe modelo para entidade sales
 * @author david
 *
 */
@Entity
@Table(name = "sales")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(precision = 15, scale = 2, nullable = false)
	private BigDecimal freight;
	
	@NotBlank
	@Column(precision = 15, scale = 2, nullable = false)
	private BigDecimal subtotal;
	
	@NotBlank
	@Column(precision = 15, scale = 2, nullable = false)
	private BigDecimal total;
	
	@NotBlank
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sale", fetch = FetchType.LAZY, orphanRemoval = false)
	private List<SaleItem> salesItems;
	
	@JsonIgnore
	@Transient
	private List<BigDecimal> checkout;
	
	public Sale() {
		//CONSTRUTOR VAZIO
	}

	public Sale(@NotBlank BigDecimal freight, @NotBlank BigDecimal subtotal, @NotBlank BigDecimal total,
			@NotBlank List<SaleItem> salesItems, List<BigDecimal> checkout) {
		super();
		this.freight = freight;
		this.subtotal = subtotal;
		this.total = total;
		this.salesItems = salesItems;
		this.checkout = checkout;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getFreight() {
		return freight;
	}
	
	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<SaleItem> getSalesItems() {
		return salesItems;
	}
	
	public void setSalesItems(List<SaleItem> salesItems) {
		this.salesItems = salesItems;
	}
	
	public List<BigDecimal> getCheckout() {
		return checkout;
	}
	
	public void setCheckout(List<BigDecimal> checkout) {
		this.checkout = checkout;
	}
	
}
