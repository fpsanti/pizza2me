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
      <div class="span6">
        <div class="well">
          <sec:ifNotLoggedIn>
              <form action='${resource(file: 'j_spring_security_check')}' method='POST' id='loginForm' class="pull-right">
                <input type='text' class='input-small' name='j_username' id='j_username' value='${request.remoteUser}' placeholder="Username"/>
                <input type='password' class='input-small' name='j_password' id='j_password' placeholder="Password"/>
<%--p>
<label for='remember_me'>Remember me</label>
<input type='checkbox' class='chk' name='_spring_security_remember_me' id='remember_me'
<g:if test='${hasCookie}'>checked='checked'</g:if> />
</p--%>
                <button class="btn" type="submit">Sign in</button>
              </form>
            </sec:ifNotLoggedIn>
        </div>
        New to <strong>Pizza2me</strong>?<g:link controller="register">Join now!</g:link>
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