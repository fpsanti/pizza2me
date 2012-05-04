package com.pizza2me

class Profile {
    static belongsTo = User
    
    String name
    String surname
    String email
    String timeZone
    String country
    int maxItems = 10
    Address address
    
    boolean emailShow = false
    
//    static embedded = ['address']

    static constraints = {
//        email(email: true)
        email(nullable: true, blank: true, email: true)
        timeZone(nullable: true)
        country(nullable: true)
        maxItems(range: 10..100)
        name(nullable: true, blank: true)
        surname(nullable: true, blank: true)
        address(nullable: true)
    }
}
