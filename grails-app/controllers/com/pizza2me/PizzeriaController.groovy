package com.pizza2me

import grails.converters.JSON
import org.springframework.dao.DataIntegrityViolationException

class PizzeriaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pizzeriaInstanceList: Pizzeria.list(params), pizzeriaInstanceTotal: Pizzeria.count()]
    }
    
    def map() {}
    
    def searched() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        List pizzeriaList = Pizzeria.list(params)
        
        int i = 0
        def res = pizzeriaList.inject([]) { acc, Pizzeria p ->
            acc << [p.name, p.address.latitude, p.address.longitude, i]
            i++
            return acc
        }
        
        render res as JSON
    }

//    def create() {
//        [pizzeriaInstance: new Pizzeria(params)]
//    }
//
//    def save() {
//        def pizzeriaInstance = new Pizzeria(params)
//        if (!pizzeriaInstance.save(flush: true)) {
//            render(view: "create", model: [pizzeriaInstance: pizzeriaInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.created.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), pizzeriaInstance.id])
//        redirect(action: "show", id: pizzeriaInstance.id)
//    }
//
//    def show() {
//        def pizzeriaInstance = Pizzeria.get(params.id)
//        if (!pizzeriaInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [pizzeriaInstance: pizzeriaInstance]
//    }
//
//    def edit() {
//        def pizzeriaInstance = Pizzeria.get(params.id)
//        if (!pizzeriaInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        [pizzeriaInstance: pizzeriaInstance]
//    }
//
//    def update() {
//        def pizzeriaInstance = Pizzeria.get(params.id)
//        if (!pizzeriaInstance) {
//            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        if (params.version) {
//            def version = params.version.toLong()
//            if (pizzeriaInstance.version > version) {
//                pizzeriaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
//                          [message(code: 'pizzeria.label', default: 'Pizzeria')] as Object[],
//                          "Another user has updated this Pizzeria while you were editing")
//                render(view: "edit", model: [pizzeriaInstance: pizzeriaInstance])
//                return
//            }
//        }
//
//        pizzeriaInstance.properties = params
//
//        if (!pizzeriaInstance.save(flush: true)) {
//            render(view: "edit", model: [pizzeriaInstance: pizzeriaInstance])
//            return
//        }
//
//		flash.message = message(code: 'default.updated.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), pizzeriaInstance.id])
//        redirect(action: "show", id: pizzeriaInstance.id)
//    }
//
//    def delete() {
//        def pizzeriaInstance = Pizzeria.get(params.id)
//        if (!pizzeriaInstance) {
//			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "list")
//            return
//        }
//
//        try {
//            pizzeriaInstance.delete(flush: true)
//			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "list")
//        }
//        catch (DataIntegrityViolationException e) {
//			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pizzeria.label', default: 'Pizzeria'), params.id])
//            redirect(action: "show", id: params.id)
//        }
//    }
    
    def search() {
        String city = params.q
        List<Pizzeria> pizzerie = Pizzeria.createCriteria().list {
            eq("address.city", city)
        }
        
        render view: "list", model: [pizzeriaInstanceList: pizzerie, pizzeriaInstanceTotal: pizzerie.size()]
    }
    
    
    def listMenu(long id) {
        Pizzeria pizzeria = Pizzeria.get(id)
        if (!pizzeria) {
            flash.error "The given pizzeria $id hasn't got a defined menù"
            redirect action: "list"
        } else {
            redirect controller: "pizza", action: "showMenu", params: [id: id]
        }
    }
}
