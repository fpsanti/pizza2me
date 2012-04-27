<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.list.label" args="[entityName]" /></title>
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span12">
          <g:each in="${pizzas}" var="pizza">
            <div class="pizzeria">
              ${fieldValue(bean: pizza, field: "name")} &nbsp; ${fieldValue(bean: pizza, field: "price")} <br/>
              <g:each in="${pizza.ingredients}" var="ingredient">
                ${fieldValue(bean: ingredient, field: "name")} &nbsp;
              </g:each>
            </div>
          </g:each>
          <%--div class="pagination">
            <g:paginate total="${pizzeriaInstanceTotal}" />
          </div--%>
        </div>
      </div>  
    </div>  
  </body>
</html>