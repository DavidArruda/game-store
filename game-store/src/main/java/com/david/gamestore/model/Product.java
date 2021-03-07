package com.david.gamestore.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * Classe modelo para entidade Product
 * @author david
 *
 */
@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Column(nullable = false, length = 120)
    private String name;
    
	@NotBlank
	@Column(nullable = false, length = 120)
    private BigDecimal price;
    
    private short score;
    
    @Column(columnDefinition = "text")
    private String image;
    
    @Deprecated
    public Product() {
    	//CONSTRUTOR VAZIO	
    }

	public Product(@NotBlank String name, @NotBlank BigDecimal price, short score, String image) {
		super();
		this.name = name;
		this.price = price;
		this.score = score;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public short getScore() {
		return score;
	}

	public String getImage() {
		return image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
