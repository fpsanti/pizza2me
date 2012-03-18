<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<html lang="en">  
  <head>
    <%--meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"--%>
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Pizza2me"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%--link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">--%>
  <r:require modules="bootstrap"/>
  <g:layoutHead/>
  <r:layoutResources />
</head>
<body>
<div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
          <div class="container">
            <a class="brand" href="#">Pizza2me</a>
            <sec:ifLoggedIn>
              <g:form class="navbar-search pull-left" action="search" controller="search">
                <input type="text" class="search-query" name="q" placeholder="Search" />
                <input type="hidden" name="itemType" value="${itemType}"/>
              </g:form>
            </sec:ifLoggedIn>  
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
  
            <sec:ifLoggedIn>      
              <ul class="nav secondary-nav">
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle"><sec:username/></a>
                  <ul class="dropdown-menu">
  
                    <li><a href="${createLink(controller: 'user', action: 'account')}">Settings</a></li>
                    <li class="divider"></li>
                    <li><a href="${createLink(controller: 'logout', action: 'index')}">Sign out</a></li>
                  </ul>
                </li>
              </ul>
<%--g:link controller="logout" action="index" class="pull-right">Sign out</g:link--%>
            </sec:ifLoggedIn>
          </div>
        </div> <!--navbar-inner  -->
    </div> /<!--navbar  -->
    
    <div class="container">
      <g:layoutBody/>
      <hr>
      <footer>
        Pizza2me is made with love in Eastern Italy <br/>
        <p>Version <g:meta name="app.version"/> on Grails <g:meta name="app.grails.version"/></p>
      </footer>
    </div>  <!--container  -->
    
     <g:javascript library="application"/>
    <r:layoutResources />
</body>
</html>