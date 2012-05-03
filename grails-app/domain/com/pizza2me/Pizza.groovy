package com.pizza2me

class Pizza {

    Pizzeria pizzeria
	String name
	Double price
	List<Ingredient> ingredients
    
    static hasMany = [ingredients: Ingredient]

	static constraints = {
		name (nullable:false, blank:false)
		price (nullable:false)
	}
}
