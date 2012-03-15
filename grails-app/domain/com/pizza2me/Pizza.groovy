package com.pizza2me

class Pizza {

	static hasMany = [ingredients:Ingredient]
	
	String name
	Double price
	List<Ingredient> ingredients = []

	static constraints = {
		name (nullable:false, blank:false)
		price (nullable:false, blank:false)
		ingredients (nullable:false, blank:false)
	}
	
}
