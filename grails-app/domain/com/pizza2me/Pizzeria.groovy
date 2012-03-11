package com.pizza2me

class Pizzeria {

	String name
	String address

	static constraints = {
		name (nullable:false, blank:false)
		address (nullable:false, blank:false)
	}
}
