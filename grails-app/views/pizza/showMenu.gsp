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
      });
    </r:script>
  </head>
  <body>
    <div class="content">
      <div class="row">
        <div class="span6">
          <form id="frmMenu">
            <g:each in="${pizzas}" var="pizza">
              <div class="pizzeria">
                ${fieldValue(bean: pizza, field: "name")} &nbsp; ${fieldValue(bean: pizza, field: "price")} <br/>
                <g:each in="${pizza.ingredients}" var="ingredient">
                    ${fieldValue(bean: ingredient, field: "name")} &nbsp;
                </g:each>
                <g:textField name="pizza_${pizza.id}.partialCount" value="TODO" />
              </div>
            </g:each>
          </form>
          <%--div class="pagination">
          <g:paginate total="${pizzeriaInstanceTotal}" />
          </div--%>
        </div>

        <div class="span6">
          <button id="computeTotal" class="btn btn-primary" value="Compute">Compute</button>
          Total pizzas <div id="totalResult" />
        </div>
      </div>  
    </div>  
  </body>
</html>