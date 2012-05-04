package com.pizza2me

/**
 *
 * @author andrea
 */
class OrderController {
    
    def springSecurityService
    
	def chooseDestination(long id) {
        User user = User.get(springSecurityService.principal.id)
        
        println "user.profile.address ${user.profile.address}"
        [orderId: id, availableDestinations: [user.profile.address]]
    }
    
    def order(long orderId, long addressId) {
        println "order invoked with params $params"
        Address destination = Address.get(addressId)
        if (!destination) {
            flash.error = "Cant' find the address for the given ID ${addressId}"
            redirect action: "chooseDestination", id: orderId
            return
        }
        
        CustomerOrder order = CustomerOrder.get(orderId)
        order.where = destination
        order.save()
        
        User user = User.get(springSecurityService.principal.id)
        List<CustomerOrder> orders = CustomerOrder.findAllByCustomer(user)
        render view: "orderStatus", model: [orders: orders]
    }
}

