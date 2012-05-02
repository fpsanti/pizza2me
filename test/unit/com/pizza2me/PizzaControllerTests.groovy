package com.pizza2me

import org.junit.*
import grails.test.mixin.*

/**
 *
 * @author andrea
 */
@TestFor(PizzaController)
@Mock([Pizza, Pizzeria, Ingredient])
class PizzaControllerTests {
    
	void testComputeTotal() {
        Pizzeria alCasale = new Pizzeria(name: "Al casale", address: new Address(street: "via Roma", number:"22/A", city: "Treviso")).save()
        
        //Defines some pizzas
        Ingredient tomato = new Ingredient(name: "tomato").save()
        Ingredient mozzarella = new Ingredient(name: "mozzarella").save()
        Ingredient origan = new Ingredient(name: "origan").save()
        Ingredient sausage = new Ingredient(name: "sausage").save()
        Ingredient onion = new Ingredient(name: "onion").save()
        
        Pizza marinara = new Pizza(name: "marinara", price: 3.50)
        marinara.addToIngredients(tomato)
        marinara.addToIngredients(origan)
        marinara.addToIngredients(onion)
        
        marinara.pizzeria = alCasale
        
        marinara.save()
        println marinara.errors
        
        assert marinara.save() != null
        
        params."pizza_1.partialCount" = 3
        
        //Exercise
        /*def model = */controller.computeTotal()
        
        //Verify
//        assert model.total == 3 * 3.50
//        assert '{"total":"Great"}' == response.text
        assert 3 * 3.50 == response.json.total
    }
}

