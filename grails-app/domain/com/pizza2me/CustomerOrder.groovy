package com.pizza2me

/**
 *
 * @author andrea
 */
class CustomerOrder {
	User customer
    Address where
    static hasMany = [items: OrderItem]
    
    static constraints = {
        where nullable:true
    }
}

