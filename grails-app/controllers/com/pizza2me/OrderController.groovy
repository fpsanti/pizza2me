package com.pizza2me

/**
 *
 * @author andrea
 */
class OrderController {
    
    def springSecurityService
    
	def chooseDestination(long orderId) {
        User user = User.get(springSecurityService.principal.id)
        [availableDestinations: [user.profile.address]]
    }
}

