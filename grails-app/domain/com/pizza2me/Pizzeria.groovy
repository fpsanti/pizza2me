package com.pizza2me

class Pizzeria {
	String name
	Address address

    static embedded = ['address']
    
	static constraints = {
		name (nullable:false, blank:false)
		address (nullable:false, blank:false)
	}
}
