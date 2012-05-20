<html>
  <head>
    <meta name="layout" content="main">
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <r:require modules="jquery"/>
    <r:script>
      $(document).ready(function () {
        $("#computeTotal").click(function () {
          $.post('${createLink(controller: "pizza", action:"computeTotal")}',
            $("#frmMenu").serialize(), function(data) {
              document.getElementById("totalResult").innerHTML = data.total;
            }, 'json');
        });
        
        $("#issueOrder").click(function () {
          $("#frmMenu").submit();
        });
      });
    </r:script>
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span8">
          <g:form name="frmMenu" url="[action:'issueOrder',controller:'pizza']">
            <g:each in="${pizzas}" var="pizza">
              <div class="pizzeria">
                ${fieldValue(bean: pizza, field: "name")} &nbsp; ${fieldValue(bean: pizza, field: "price")} <br/>
                <g:each in="${pizza.ingredients}" var="ingredient">
                    ${fieldValue(bean: ingredient, field: "name")} &nbsp;
                </g:each>
                <g:textField name="pizza_${pizza.id}.partialCount" value="TODO" />
              </div>
            </g:each>
          </g:form>
          <%--div class="pagination">
          <g:paginate total="${pizzeriaInstanceTotal}" />
          </div--%>
        </div>

        <div class="span4">
          <div class ="orderSummary">
            <button id="computeTotal" class="btn btn-primary" value="Compute">Compute</button>
            Total pizzas <div id="totalResult"></div>
            <button id="issueOrder" class="btn btn-primary" value="Order">Order Now</button>
          </div>
        </div>
      </div>  
    </div>  
  </body>
</html>