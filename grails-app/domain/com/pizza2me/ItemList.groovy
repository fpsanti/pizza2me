package com.pizza2me

class ItemList {

	static hasMany = [itemList:Pizza]
	
	List<Pizza> itemList

	static constraints = {
		itemList (nullable:false, blank:false)
	}
	
}
