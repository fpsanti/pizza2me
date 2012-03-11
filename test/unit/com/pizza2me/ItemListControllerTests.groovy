package com.pizza2me



import org.junit.*
import grails.test.mixin.*

@TestFor(ItemListController)
@Mock(ItemList)
class ItemListControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemList/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemListInstanceList.size() == 0
        assert model.itemListInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.itemListInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemListInstance != null
        assert view == '/itemList/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemList/show/1'
        assert controller.flash.message != null
        assert ItemList.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemList/list'


        populateValidParams(params)
        def itemList = new ItemList(params)

        assert itemList.save() != null

        params.id = itemList.id

        def model = controller.show()

        assert model.itemListInstance == itemList
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemList/list'


        populateValidParams(params)
        def itemList = new ItemList(params)

        assert itemList.save() != null

        params.id = itemList.id

        def model = controller.edit()

        assert model.itemListInstance == itemList
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemList/list'

        response.reset()


        populateValidParams(params)
        def itemList = new ItemList(params)

        assert itemList.save() != null

        // test invalid parameters in update
        params.id = itemList.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemList/edit"
        assert model.itemListInstance != null

        itemList.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemList/show/$itemList.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemList.clearErrors()

        populateValidParams(params)
        params.id = itemList.id
        params.version = -1
        controller.update()

        assert view == "/itemList/edit"
        assert model.itemListInstance != null
        assert model.itemListInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemList/list'

        response.reset()

        populateValidParams(params)
        def itemList = new ItemList(params)

        assert itemList.save() != null
        assert ItemList.count() == 1

        params.id = itemList.id

        controller.delete()

        assert ItemList.count() == 0
        assert ItemList.get(itemList.id) == null
        assert response.redirectedUrl == '/itemList/list'
    }
}
