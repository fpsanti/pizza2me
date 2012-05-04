<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <r:require modules="jquery"/>
    
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span8">
            <g:each in="${availableDestinations}" var="dest">
              <div>
                ${fieldValue(bean: dest, field: "city")} &nbsp;
                ${fieldValue(bean: dest, field: "street")} &nbsp; 
                ${fieldValue(bean: dest, field: "number")} <br/>
              </div>
              Address ID: ${dest.id} <br/>
              Order ID: ${orderId}
              <g:link action="order" params="[addressId: dest.id, orderId: orderId]"> Deliver here </g:link>
            </g:each>
        </div>
      </div>  
    </div>  
  </body>
</html>