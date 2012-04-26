package com.pizza2me

class Pizza {

    Pizzeria pizzeria
	String name
	Double price
	List<Ingredient> ingredients

	static constraints = {
		name (nullable:false, blank:false)
		price (nullable:false)
		ingredients (nullable:false)
	}
}
