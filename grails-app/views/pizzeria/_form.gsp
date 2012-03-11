<%@ page import="com.pizza2me.Pizzeria" %>



<div class="fieldcontain ${hasErrors(bean: pizzeriaInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="pizzeria.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${pizzeriaInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pizzeriaInstance, field: 'address', 'error')} required">
	<label for="address">
		<g:message code="pizzeria.address.label" default="Address" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address" required="" value="${pizzeriaInstance?.address}"/>
</div>

