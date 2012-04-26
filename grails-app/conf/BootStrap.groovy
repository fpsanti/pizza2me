import grails.util.Environment
import com.pizza2me.User
import com.pizza2me.Profile
import com.pizza2me.Role
import com.pizza2me.UserRole
import com.pizza2me.Pizzeria
import com.pizza2me.Address
import com.pizza2me.Pizza
import com.pizza2me.Ingredient

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                createFakeUsers()
                createPizzeria()
                break
            case Environment.PRODUCTION:
                initRoles()
                break    
        }
    }
    
    def destroy = {
    }
    
    private createFakeUsers() {
        def userRole = Role.findByAuthority('ROLE_USER') ?: new Role(authority: 'ROLE_USER').save()
        def makerRole = Role.findByAuthority('ROLE_MAKER') ?: new Role(authority: 'ROLE_MAKER').save()
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save()
        
        if (userRole == null) {
            println "can't create user role"
        }
        
        if (User.findByUsername("fkuser")) {
            println "Fake user already exists, skip fake date creation phase"
            return;
        }
        def user = new User(username:"fkuser", 
            password: /*springSecurityService.encodePassword(*/"passwd"/*)*/,
            enabled: true, 
            profile: new Profile(name: 'Utonto', surname: 'Utonto', email: 'fake@gmail.com')).save(flush: true)
        UserRole.create(user, userRole)
    }
    
    
    private createPizzeria() {
        Pizzeria alCasale = new Pizzeria(name: "Al casale", address: new Address(street: "via Roma", number:"22/A", city: "Treviso")).save()
        Pizzeria catapecchia = new Pizzeria(name: "Alla catapecchia", address: new Address(street: "via Roma", number:"1", city: "Fiumicello")).save()
        
        //Defines some pizzas
        Ingredient tomato = new Ingredient(name: "tomato").save()
        Ingredient mozzarella = new Ingredient(name: "mozzarella").save()
        Ingredient origan = new Ingredient(name: "origan").save()
        Ingredient sausage = new Ingredient(name: "sausage").save()
        Ingredient onion = new Ingredient(name: "onion").save()
        
        Pizza marinara = new Pizza(name: "marinara", price: 3.50, ingredients: [tomato, origan, onion]).save()
        println "marinara is ${marinara.name}"
        
        marinara.pizzeria = alCasale
        assert marinara.save() != null
    }
}
