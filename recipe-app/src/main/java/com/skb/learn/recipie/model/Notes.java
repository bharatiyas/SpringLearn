package com.skb.learn.recipie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	// We leave out the Cascade attribute because Recipe is the owner of the relationship here. Because we do not want
	// deletion of a Notes object leads to deletion of the parent Recipe notes
	@OneToOne
	private Recipe recipe;
	
	// Lob - Large Objects. This is to accommodate Large description entries for the Recipe as they will be much larger than 
	// the default String size
	// In DB world this will be mapped to CLOB - Character Large Object
	@Lob
	private String recipeNotes;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public String getRecipeNotes() {
		return recipeNotes;
	}
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}
	
	
}
