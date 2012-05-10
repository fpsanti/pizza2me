<!doctype html>
<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <r:script>
      $('div[id^="item_"]').click(function (e){
        console.log("TODO change the lateral map");
      });
    </r:script>
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span4">
          <g:each in="${pizzeriaInstanceList}" status="i" var="pizzeria">
            <div id="item_$i" class="pizzeria span4">
              <g:render template="address" model="['pizzeria': pizzeria]"/>
              <div class="span2 offset1">
                <g:link class="btn btn-primary" action="listMenu" id="${pizzeria.id}">View menù</g:link>
              </div>
            </div>
          </g:each>
          <div class="pagination">
            <g:paginate total="${pizzeriaInstanceTotal}" />
          </div>
        </div>
        <div id="mapPanel" class="span8">
          <iframe style="width:600px;height:300px"
              src="/pizza2me/pizzeria/map"></iframe>
        </div>
      </div>  
    </div>  
  </body>
</html>
