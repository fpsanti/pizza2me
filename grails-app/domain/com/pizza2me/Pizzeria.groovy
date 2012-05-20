package com.pizza2me

class Pizzeria {
	String name
	Address address
    String phone
    String email
    String website

    static embedded = ['address']
    
	static constraints = {
		name (nullable:false, blank:false)
		address (nullable:false)
        phone nullable: true
        email nullable: true
        website nullable: true
	}
}

