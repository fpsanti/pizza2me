<html>
  <head>
    <title>Welcome to Pizza 2 me</title>
    <meta name="layout" content="main" />
    <style type="text/css" media="screen">
      #nav {
        margin-top:20px;
        margin-left:30px;
        width:228px;
        float:left;

      }
      .homePagePanel * {
        margin:0px;
      }
      .homePagePanel .panelBody ul {
        list-style-type:none;
        margin-bottom:10px;
      }
      .homePagePanel .panelBody h1 {
        text-transform:uppercase;
        font-size:1.1em;
        margin-bottom:10px;
      }
      .homePagePanel .panelBody {
        background: url(images/leftnav_midstretch.png) repeat-y top;
        margin:0px;
        padding:15px;
      }
      .homePagePanel .panelBtm {
        background: url(images/leftnav_btm.png) no-repeat top;
        height:20px;
        margin:0px;
      }

      .homePagePanel .panelTop {
        background: url(images/leftnav_top.png) no-repeat top;
        height:11px;
        margin:0px;
      }
      h2 {
        margin-top:15px;
        margin-bottom:15px;
        font-size:1.2em;
      }
      #pageBody {
        margin-left:280px;
        margin-right:20px;
      }
    </style>
  </head>
  <body>
    <!-- Main hero unit for a primary marketing message or call to action -->
    <div class="hero-unit">
      <h1>Pizza2me</h1>
      <p>The place to place your pizza desire!</p>
      <!--p><a class="btn primary large">Learn more &raquo;</a></p-->
    </div>

    <div class="row">
      <div class="span6">
        <ul class="media-grid">
           TODO put list images 
          <%--li><img src="${resource(dir:'images',file:'notebook.png')}"/></li--%>
        </ul>
      </div>
      <div class="span4">
        New to <strong>Pizza2me</strong>? Join now!
        <g:if test="${flash.message}">
          <div class="alert-message error">
            <a class="close" href="#">×</a>
${flash.message}
          </div>
        </g:if>
        <g:hasErrors bean="${person}">
          <div class="alert-message error">
            <g:renderErrors bean="${person}" as="list" />
          </div>
        </g:hasErrors>

        <g:form controller="register" action="save">
          <div class="span6">
            <fieldset>
              <div class="clearfix">
                <label for="userId">Login Name:</label>
                <div class="input">
                  <input type="text" name='userId' tabindex="1" value="${person?.userId?.encodeAsHTML()}"/>
                  <p class="help-block">
                      Mandatory, should be unique
                  </p>
                </div>
              </div>

              <div class="clearfix">
                <label for="name">Name:</label>
                <div class="input">
                  <input type="text" name='name' tabindex="2" value="${person?.profile?.name?.encodeAsHTML()}"
                         placeholder="Optional"/>
                  <p class="help-block">
                      * Optional
                </p>
                </div>
              </div>
              
              <div class="clearfix">
                <label for="name">Surname:</label>
                <div class="input">
                  <input type="text" name='surname' tabindex="2" value="${person?.profile?.surname?.encodeAsHTML()}"
                         placeholder="Optional"/>
                  <p class="help-block">
                      * Optional
                </p>
                </div>
              </div>
              
              <div class="clearfix">
                <label for="password">Password:</label>
                <div class="input">
                  <input id="password" autocomplete="off" type="password" name='password' tabindex="3" value="${person?.password?.encodeAsHTML()}"/>
<%--small class="help-inline help-error" id="nomatch" style="display:none;">Passwords don't match</small--%>
                </div>
              </div>

              <div class="clearfix">
                <label for="password_confirmation">Confirm Password:</label>
                <div class="input">
                  <input id="password_confirmation" autocomplete="off" type="password" name='repassword' tabindex="4" value="${person?.password?.encodeAsHTML()}"/>
                </div>
              </div>

              <div class="clearfix">
                <label for="email">Email:</label>
                <div class="input">
                  <input id="email" type="text" name='profile.email' tabindex="5" value="${person?.profile?.email?.encodeAsHTML()}"/>
                </div>
              </div>

              <div class="clearfix">
                <label for="code">Enter Code: </label>
                <div class="input">
                  <input id="code" type="text" name='captcha' tabindex="6" size="8"/>
                  <img src="${createLink(controller:'captcha', action:'index')}" align="absmiddle"/>
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
  </body>

  <script type='text/javascript'>
  <!--
  (function(){
        document.forms['loginForm'].elements['j_username'].focus();
  })();
  // -->
  </script>
</html>