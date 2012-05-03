package com.pizza2me

/**
 *
 * @author andrea
 */
class Utils {
    
    static def scanPizzaOrder(Map m, Closure c) {
        m.each { String key, value ->
            if (key.startsWith('pizza_') && key.endsWith('.partialCount')) {
                long idPizza = key[key.indexOf('_')+1..key.indexOf('.partialCount')-1] as long
                int quantity = value as int
                Pizza pizza = Pizza.get(idPizza)
                c.call(pizza, quantity)
            }
        }
    }
	
}

