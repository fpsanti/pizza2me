package com.pizza2me



import org.junit.*
import grails.test.mixin.*

@TestFor(PizzeriaController)
@Mock(Pizzeria)
class PizzeriaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pizzeria/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pizzeriaInstanceList.size() == 0
        assert model.pizzeriaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.pizzeriaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pizzeriaInstance != null
        assert view == '/pizzeria/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pizzeria/show/1'
        assert controller.flash.message != null
        assert Pizzeria.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pizzeria/list'


        populateValidParams(params)
        def pizzeria = new Pizzeria(params)

        assert pizzeria.save() != null

        params.id = pizzeria.id

        def model = controller.show()

        assert model.pizzeriaInstance == pizzeria
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pizzeria/list'


        populateValidParams(params)
        def pizzeria = new Pizzeria(params)

        assert pizzeria.save() != null

        params.id = pizzeria.id

        def model = controller.edit()

        assert model.pizzeriaInstance == pizzeria
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pizzeria/list'

        response.reset()


        populateValidParams(params)
        def pizzeria = new Pizzeria(params)

        assert pizzeria.save() != null

        // test invalid parameters in update
        params.id = pizzeria.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pizzeria/edit"
        assert model.pizzeriaInstance != null

        pizzeria.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pizzeria/show/$pizzeria.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pizzeria.clearErrors()

        populateValidParams(params)
        params.id = pizzeria.id
        params.version = -1
        controller.update()

        assert view == "/pizzeria/edit"
        assert model.pizzeriaInstance != null
        assert model.pizzeriaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pizzeria/list'

        response.reset()

        populateValidParams(params)
        def pizzeria = new Pizzeria(params)

        assert pizzeria.save() != null
        assert Pizzeria.count() == 1

        params.id = pizzeria.id

        controller.delete()

        assert Pizzeria.count() == 0
        assert Pizzeria.get(pizzeria.id) == null
        assert response.redirectedUrl == '/pizzeria/list'
    }
}
