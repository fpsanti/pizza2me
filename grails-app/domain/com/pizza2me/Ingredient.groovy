package com.pizza2me

class Ingredient {

	String name

	static constraints = {
		name (nullable:false, blank:false)
	}
}
