package com.pizza2me



import org.junit.*
import grails.test.mixin.*

@TestFor(PizzaController)
@Mock(Pizza)
class PizzaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pizza/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pizzaInstanceList.size() == 0
        assert model.pizzaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.pizzaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pizzaInstance != null
        assert view == '/pizza/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pizza/show/1'
        assert controller.flash.message != null
        assert Pizza.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pizza/list'


        populateValidParams(params)
        def pizza = new Pizza(params)

        assert pizza.save() != null

        params.id = pizza.id

        def model = controller.show()

        assert model.pizzaInstance == pizza
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pizza/list'


        populateValidParams(params)
        def pizza = new Pizza(params)

        assert pizza.save() != null

        params.id = pizza.id

        def model = controller.edit()

        assert model.pizzaInstance == pizza
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pizza/list'

        response.reset()


        populateValidParams(params)
        def pizza = new Pizza(params)

        assert pizza.save() != null

        // test invalid parameters in update
        params.id = pizza.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pizza/edit"
        assert model.pizzaInstance != null

        pizza.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pizza/show/$pizza.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pizza.clearErrors()

        populateValidParams(params)
        params.id = pizza.id
        params.version = -1
        controller.update()

        assert view == "/pizza/edit"
        assert model.pizzaInstance != null
        assert model.pizzaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pizza/list'

        response.reset()

        populateValidParams(params)
        def pizza = new Pizza(params)

        assert pizza.save() != null
        assert Pizza.count() == 1

        params.id = pizza.id

        controller.delete()

        assert Pizza.count() == 0
        assert Pizza.get(pizza.id) == null
        assert response.redirectedUrl == '/pizza/list'
    }
}
