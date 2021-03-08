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
import javax.validation.constraints.NotBlank;

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
	private List<SaleItem> items;
	
	public Sale() {
		//CONSTRUTOR VAZIO
	}

	public Sale(@NotBlank BigDecimal freight, @NotBlank BigDecimal subtotal, @NotBlank BigDecimal total,
			@NotBlank List<SaleItem> items) {
		super();
		this.freight = freight;
		this.subtotal = subtotal;
		this.total = total;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public List<SaleItem> getItems() {
		return items;
	}
	
}
