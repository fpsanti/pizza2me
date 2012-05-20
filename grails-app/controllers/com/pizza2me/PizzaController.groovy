package com.pizza2me

import org.springframework.dao.DataIntegrityViolationException

class PizzaController {
    
    def springSecurityService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def showMenu(long id) {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        
        Pizzeria pizzeria = Pizzeria.get(id)
        
        println "pizzeria ID is $id and pizzeria obj is $pizzeria"
        
        //[max: 3, offset: 2, sort: "title", order: "desc"]
        int numPizzas = Pizza.countByPizzeria(pizzeria)
        List<Pizza> pizzas = Pizza.findAllByPizzeria(pizzeria, params)
        println "found pizzas: $pizzas for pizzeria: $pizzeria"
        
        [pizzas: pizzas, pizzaInstanceTotal: numPizzas]
    }
    
    /**
     * Given the user selection and quantities computes the total price
     **/
    def computeTotal() {
        println "found params $params"
        double computedTotal = 0
        Utils.scanPizzaOrder(params) { pizza, int quantity ->
            computedTotal += (pizza.price * quantity)
        }
        
        render(contentType:"text/json") {
            total = computedTotal
        }
    }
    
    def issueOrder() {
        User customer = User.get(springSecurityService.principal.id)
        CustomerOrder newOrder = new CustomerOrder()
        Utils.scanPizzaOrder(params) { pizza, int quantity ->
            newOrder.addToItems(new OrderItem(pizza: pizza, quantity: quantity))
        }
        newOrder.customer = customer
        
        if (newOrder.save(flush: true) == null) {
            println newOrder.errors
            flash.error = "Error issue the order"
            redirect action: "showMenu"
        } else {
            println " newOrder.id is ${newOrder.id}"
            redirect controller: "order", action: "chooseDestination", id: newOrder.id
        }
    }
    
//    def create() {
//        [pizzaInstance: new Pizza(params)]
//    }
//
//    def save() {
//        def pizzaInstance = new Pizza(params)
//        if (!pizzaInstance.save(flush: true)) {
//            render(view: "create", model: [pizzaInstance: pizzaInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.created.message', args: [message(code: 'pizza.label', default: 'Pizza'), pizzaInstance.id])
//        redirect(action: "show", id: pizzaInstance.id)
//    }
//
//    def show() {
//        def pizzaInstance = Pizza.get(params.id)
//        if (!pizzaInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [pizzaInstance: pizzaInstance]
//    }
//
//    def edit() {
//        def pizzaInstance = Pizza.get(params.id)
//        if (!pizzaInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [pizzaInstance: pizzaInstance]
//    }
//
//    def update() {
//        def pizzaInstance = Pizza.get(params.id)
//        if (!pizzaInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        if (params.version) {
//            def version = params.version.toLong()
//            if (pizzaInstance.version > version) {
//                pizzaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
//                          [message(code: 'pizza.label', default: 'Pizza')] as Object[],
//                          "Another user has updated this Pizza while you were editing")
//                render(view: "edit", model: [pizzaInstance: pizzaInstance])
//                return
//            }
//        }
//
//        pizzaInstance.properties = params
//
//        if (!pizzaInstance.save(flush: true)) {
//            render(view: "edit", model: [pizzaInstance: pizzaInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.updated.message', args: [message(code: 'pizza.label', default: 'Pizza'), pizzaInstance.id])
//        redirect(action: "show", id: pizzaInstance.id)
//    }
//
//    def delete() {
//        def pizzaInstance = Pizza.get(params.id)
//        if (!pizzaInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        try {
//            pizzaInstance.delete(flush: true)
//			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "list")
//        }
//        catch (DataIntegrityViolationException e) {
//			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
//            redirect(action: "show", id: params.id)
//        }
//    }
}
