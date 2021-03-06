package com.skb.learn.recipie.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ingredient {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String description;
	private BigDecimal amount;
	
	// We do not want to specify Cascade here because we do not want deletion of an Ingredient to delete the Recipe as well.
	// This will leave Recipe as the parent of the relation
	@ManyToOne
	private Recipe recipe;

	// FetchType = Eager will have Hibernate to retrieve the value from the DB everytime. Eager is the default Fetch Type.
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	
	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}


	
}
