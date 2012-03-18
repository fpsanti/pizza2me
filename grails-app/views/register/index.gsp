  <html lang="en">
    <head>
      <meta name="layout" content="main" />
    </head>

<body>

  <div id="pageContent">
        <div class="wrapper clearfix">
          <div class="page-header">
            <h1>Register to Pizza2me</h1>
          </div>

          <div class="row">
            <g:if test="${flash.error}">
              <div class="alert-message error">
                <a class="close" href="#">×</a>
                ${flash.error}
              </div>
            </g:if>

            <g:hasErrors bean="${command}">
              <div class="alert-message error">
                <g:renderErrors bean="${command}" as="list" />
              </div>
            </g:hasErrors>
            <g:form controller="register" action="register">
              <div class="span6">
                <fieldset>
                  <div class="clearfix">
                    <label for="username">Login Name:</label>
                    <div class="input">
                      <input type="text" name='username' tabindex="1" value="${command?.username}"/>
                      <p class="help-block">
                        Mandatory, should be unique
                      </p>
                    </div>
                  </div>

                  <!--div class="clearfix">
                    <label for="name">Name:</label>
                    <div class="input">
                      <input type="text" name='name' tabindex="2" value="${person?.profile?.name?.encodeAsHTML()}"
                             placeholder="Optional"/>
                      <p class="help-block">
                        * Optional
                      </p>
                    </div>
                  </div-->

                  <!--div class="clearfix">
                    <label for="name">Surname:</label>
                    <div class="input">
                      <input type="text" name='surname' tabindex="2" value="${person?.profile?.surname?.encodeAsHTML()}"
                             placeholder="Optional"/>
                      <p class="help-block">
                        * Optional
                      </p>
                    </div>
                  </div-->

                  <div class="clearfix">
                    <label for="password">Password:</label>
                    <div class="input">
                      <input id="password" autocomplete="off" type="password" name='password' tabindex="3" value="${command?.password}"/>
<%--small class="help-inline help-error" id="nomatch" style="display:none;">Passwords don't match</small--%>
                      <p class="help-block">
                        8 chars long with number and special chars
                      </p>
                    </div>
                  </div>

                  <div class="clearfix">
                    <label for="password_confirmation">Confirm Password:</label>
                    <div class="input">
                      <input id="password_confirmation" autocomplete="off" type="password" name='password2' tabindex="4" value="${command?.password2}"/>
                    </div>
                  </div>

                  <div class="clearfix">
                    <label for="email">Email:</label>
                    <div class="input">
                      <input id="email" type="text" name='email' tabindex="5" value="${command?.email}"/>
                    </div>
                  </div>

                </fieldset>
              </div>

              <div class="buttons">
                <span class="formButton">
                  <input type="submit" value="Create" class="btn primary"></input>
                </span>
              </div>

            </g:form>
          </div>
        </div>
  
  
  </div>
<p/>

<%--s2ui:form width='650' height='300' elementId='loginFormContainer'
           titleCode='spring.security.ui.register.description' center='true'>

<g:form action='register' name='registerForm'>

	<g:if test='${emailSent}'>
	<br/>
	<g:message code='spring.security.ui.register.sent'/>
	</g:if>
	<g:else>

	<br/>

	<table>
	<tbody>

		<s2ui:textFieldRow name='username' labelCode='user.username.label' bean="${command}"
                         size='40' labelCodeDefault='Username' value="${command.username}"/>

		<s2ui:textFieldRow name='email' bean="${command}" value="${command.email}"
		                   size='40' labelCode='user.email.label' labelCodeDefault='E-mail'/>

		<s2ui:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"
                             size='40' labelCodeDefault='Password' value="${command.password}"/>

		<s2ui:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"
                             size='40' labelCodeDefault='Password (again)' value="${command.password2}"/>

	</tbody>
	</table>

	<s2ui:submitButton elementId='create' form='registerForm' messageCode='spring.security.ui.register.submit'/>

	</g:else>

</g:form>

</s2ui:form--%>

<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>

</body>
</html>

