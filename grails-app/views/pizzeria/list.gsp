<%@ page import="com.pizza2me.Pizzeria" %>
<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span4">
          <g:each in="${pizzeriaInstanceList}" status="i" var="pizzeria">
            <div class="pizzeria">
              ${fieldValue(bean: pizzeria, field: "name")} <br/>
              ${fieldValue(bean: pizzeria, field: "address.city")} <br/>
              <g:link class="btn btn-primary" action="listMenu" id="${pizzeria.id}">Menù</g:link>
            </div>
          </g:each>
          <div class="pagination">
            <g:paginate total="${pizzeriaInstanceTotal}" />
          </div>
        </div>
        <div class="span8">
          Here goes the map of the pizzeria selected
        </div>
      </div>  
    </div>  
  </body>
</html>
