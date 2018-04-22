package com.skb.learn.recipie.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Recipe {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	private String directions;
	
	// In DB world this will be mapped to BLOB - Byte Large Object
	@Lob
	private Byte[] image;
	
	// To make Recipe the owner (parent) of the relationship we put cacade attribute. This means that deletion of a Recipe
	// row will delete the related child Note row
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;
	
	// To make Recipe the owner (parent) of the relationship we put cascade attribute. CascaseType.ALL will persist all 
	// operations. 
	// MappedBy specifies the property on the child class (Ingredient). Which means that this Recipe will get stored in the
	// recipe property of the Ingredient class
	// Using a Set for Ingredients so that you get a unique set of Ingredients. You may also choose to use List
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients;
	
	// ORDINAL is the default value. This will lead to the values getting stored in the DB as 1,2,3,...
	// STRING will lead to the values being stored as the Strings mentioned in the Enum.
	// Storing STRING be better because if you add a new value to the Enum definition by adding a new enum value in between
	// the existing values then it will change the ORDINAL positions of the String. 
	// For example if you add VERY_EASY in the begining then EASY becomes 2, MODERATE becomes 3 and HARD becomes 4. 
	// Then in the DB it will start reflecting wrong values.
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDirections() {
		return directions;
	}
	public void setDirections(String directions) {
		this.directions = directions;
	}
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public Notes getNotes() {
		return notes;
	}
	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
}
