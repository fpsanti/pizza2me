package com.pizza2me

/**
 *
 * @author andrea
 */
class Address {
	String street
    String number //format <n>/<A-z>
    String cap //only digits
    String city
    String province
    
    //TODO validators
    static constraints = {
        street (nullable:false, blank:false)
        number (nullable:false, blank:false)
        cap (nullable:false, blank:false)
        city (nullable:false, blank:false)
        province (nullable:false, blank:false)
    }
}

