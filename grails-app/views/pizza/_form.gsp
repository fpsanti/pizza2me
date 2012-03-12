<%@ page import="com.pizza2me.Pizza" %>



<div class="fieldcontain ${hasErrors(bean: pizzaInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="pizza.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${pizzaInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pizzaInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="pizza.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="price" required="" value="${fieldValue(bean: pizzaInstance, field: 'price')}"/>
</div>

