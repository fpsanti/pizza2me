<%@ page import="com.pizza2me.ItemList" %>



<div class="fieldcontain ${hasErrors(bean: itemListInstance, field: 'itemList', 'error')} required">
	<label for="itemList">
		<g:message code="itemList.itemList.label" default="Item List" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="itemList" from="${com.pizza2me.Pizza.list()}" multiple="multiple" optionKey="id" size="5" required="" value="${itemListInstance?.itemList*.id}" class="many-to-many"/>
</div>

