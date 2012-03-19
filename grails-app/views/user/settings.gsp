  <html lang="en">
    <head>
      <meta name="layout" content="main" />
    </head>

<body>

  <div id="pageContent">
        <div class="wrapper clearfix">
          <div class="page-header">
            <h1>${user?.username}'s account settings</h1>
          </div>

          <div class="row">
            <g:if test="${flash.error}">
              <div class="alert-message error">
                <a class="close" href="#">×</a>
                ${flash.error}
              </div>
            </g:if>

            <g:hasErrors bean="${user}">
              <div class="alert-message error">
                <g:renderErrors bean="${user}" as="list" />
              </div>
            </g:hasErrors>
            <g:form controller="user" action="update">
              <div class="row">
                <div class="span6">
                  <fieldset>
                    <div class="clearfix">
                      <label for="email">Email:</label>
                      <div class="input">
                        <input id="email" type="text" name='profile.email' tabindex="1" value="${user?.profile?.email}"/>
                      </div>
                    </div>
                  </fieldset>
  
                  <fieldset>
                    <div class="clearfix">
                      <label for="email">Name:</label>
                      <div class="input">
                        <input id="name" type="text" name='profile.name' tabindex="2" value="${user?.profile?.name}"/>
                      </div>
                    </div>
                  </fieldset>
  
                  <fieldset>
                    <div class="clearfix">
                      <label for="email">Surname:</label>
                      <div class="input">
                        <input id="surname" type="text" name='profile.surname' tabindex="3" value="${user?.profile?.surname}"/>
                      </div>
                    </div>
                  </fieldset>
  
                  <fieldset>
                    <div class="clearfix">
                      <label for="email">Address:</label>
                      <div class="input">
                        <input id="address" type="text" name='profile.address' tabindex="4" value="${user?.profile?.address}"/>
                      </div>
                    </div>
                  </fieldset>
                </div>
              </div>  

              <div class="buttons">
                <span class="formButton">
                  <input type="submit" value="Update" class="btn primary"></input>
                </span>
              </div>

            </g:form>
          </div>
        </div>
  </div>
<p/>