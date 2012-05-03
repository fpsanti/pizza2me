package com.pizza2me

/**
 *
 * @author andrea
 */
class Order {
	User customer
    Address where
    static hasMany = [items: OrderItem]
}

