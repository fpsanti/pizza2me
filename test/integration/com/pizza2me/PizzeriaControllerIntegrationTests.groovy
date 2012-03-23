package com.pizza2me

import org.junit.*
import grails.test.mixin.*

class PizzeriaControllerIntegrationTests extends GroovyTestCase {
    
    void testSearch() {
        String cityName = "Freecastle"
        Pizzeria p = new Pizzeria(name: "Al casale", address: new Address(street: "via Roma", number:"22/A", city: cityName))
        assert p.save() != null
        def controller = new PizzeriaController()

        //Exercise
        controller.params.q = cityName
        controller.search()
        
        //verify
        println "${controller.modelAndView}"
        assert controller.modelAndView.viewName == "/pizzeria/list"
        def model = controller.modelAndView.model
        assert !model.pizzeriaInstanceList.empty
        assert model.pizzeriaInstanceList[0].address.city == cityName
        assert model.pizzeriaInstanceTotal == 1
    }

    //TODO add a test for not matching pizzeria
}
