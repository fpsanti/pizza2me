package com.pizza2me

class ItemList {

	List<Pizza> itemList

	static constraints = {
		itemList (nullable:false, blank:false)
	}
}
