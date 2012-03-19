package com.pizza2me

/**
 *
 * @author andrea
 */
class UserController {
    
    def springSecurityService
    
	def settings() {
        User user = User.get(springSecurityService.principal.id)
        [user: user]
    }
    
    def update() {
        User user = User.get(springSecurityService.principal.id)
        user.properties = params
        log.debug "Saving user $user"
        
        if (!user.save()) {
            render view: "settings"
            return
        }
        redirect url: "/"
    }
}

