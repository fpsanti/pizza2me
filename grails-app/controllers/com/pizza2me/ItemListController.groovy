package com.pizza2me

import org.springframework.dao.DataIntegrityViolationException

class ItemListController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [itemListInstanceList: ItemList.list(params), itemListInstanceTotal: ItemList.count()]
    }

    def create() {
        [itemListInstance: new ItemList(params)]
    }

    def save() {
        def itemListInstance = new ItemList(params)
        if (!itemListInstance.save(flush: true)) {
            render(view: "create", model: [itemListInstance: itemListInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'itemList.label', default: 'ItemList'), itemListInstance.id])
        redirect(action: "show", id: itemListInstance.id)
    }

    def show() {
        def itemListInstance = ItemList.get(params.id)
        if (!itemListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "list")
            return
        }

        [itemListInstance: itemListInstance]
    }

    def edit() {
        def itemListInstance = ItemList.get(params.id)
        if (!itemListInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "list")
            return
        }

        [itemListInstance: itemListInstance]
    }

    def update() {
        def itemListInstance = ItemList.get(params.id)
        if (!itemListInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (itemListInstance.version > version) {
                itemListInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'itemList.label', default: 'ItemList')] as Object[],
                          "Another user has updated this ItemList while you were editing")
                render(view: "edit", model: [itemListInstance: itemListInstance])
                return
            }
        }

        itemListInstance.properties = params

        if (!itemListInstance.save(flush: true)) {
            render(view: "edit", model: [itemListInstance: itemListInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'itemList.label', default: 'ItemList'), itemListInstance.id])
        redirect(action: "show", id: itemListInstance.id)
    }

    def delete() {
        def itemListInstance = ItemList.get(params.id)
        if (!itemListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "list")
            return
        }

        try {
            itemListInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemList.label', default: 'ItemList'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
