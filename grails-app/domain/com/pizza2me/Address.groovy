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
    BigDecimal latitude
    BigDecimal longitude
    
    static belongsTo = Profile
    
    //TODO define validators
    static constraints = {
        street nullable:true
        number nullable:true
        cap nullable:true
        city nullable:true
        province nullable:true
        latitude nullable:true
        longitude nullable:true
    }
}

