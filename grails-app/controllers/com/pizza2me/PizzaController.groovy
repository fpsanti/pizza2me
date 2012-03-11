package com.pizza2me

import org.springframework.dao.DataIntegrityViolationException

class PizzaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pizzaInstanceList: Pizza.list(params), pizzaInstanceTotal: Pizza.count()]
    }

    def create() {
        [pizzaInstance: new Pizza(params)]
    }

    def save() {
        def pizzaInstance = new Pizza(params)
        if (!pizzaInstance.save(flush: true)) {
            render(view: "create", model: [pizzaInstance: pizzaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'pizza.label', default: 'Pizza'), pizzaInstance.id])
        redirect(action: "show", id: pizzaInstance.id)
    }

    def show() {
        def pizzaInstance = Pizza.get(params.id)
        if (!pizzaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "list")
            return
        }

        [pizzaInstance: pizzaInstance]
    }

    def edit() {
        def pizzaInstance = Pizza.get(params.id)
        if (!pizzaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "list")
            return
        }

        [pizzaInstance: pizzaInstance]
    }

    def update() {
        def pizzaInstance = Pizza.get(params.id)
        if (!pizzaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (pizzaInstance.version > version) {
                pizzaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pizza.label', default: 'Pizza')] as Object[],
                          "Another user has updated this Pizza while you were editing")
                render(view: "edit", model: [pizzaInstance: pizzaInstance])
                return
            }
        }

        pizzaInstance.properties = params

        if (!pizzaInstance.save(flush: true)) {
            render(view: "edit", model: [pizzaInstance: pizzaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pizza.label', default: 'Pizza'), pizzaInstance.id])
        redirect(action: "show", id: pizzaInstance.id)
    }

    def delete() {
        def pizzaInstance = Pizza.get(params.id)
        if (!pizzaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "list")
            return
        }

        try {
            pizzaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
