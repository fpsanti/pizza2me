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
            <g:each in="${orders}" var="order">
              <div>
                To be delivered at
                ${fieldValue(bean: order, field: "where")}<br/>
              </div>
            </g:each>
        </div>
      </div>  
    </div>  
  </body>
</html>