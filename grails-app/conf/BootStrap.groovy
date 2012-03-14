import grails.util.Environment
import com.pizza2me.User
import com.pizza2me.Profile
import com.pizza2me.Role
import com.pizza2me.UserRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->
        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                createFakeUsers()
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
}
