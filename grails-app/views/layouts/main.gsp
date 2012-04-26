<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<html lang="en">  
  <head>
    <meta charset="utf-8">
    <title>Pizza2me, from crazy crew</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href="../assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
    </style>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <%-- TODO  link rel="shortcut icon" href="../assets/ico/favicon.ico" --%>
    <link href="${resource(dir: 'css', file: 'pizza2me.css')}" type="text/css" rel="stylesheet">

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
              <g:form class="navbar-search pull-left" action="search" controller="pizzeria">
                <input type="text" class="search-query" name="q" placeholder="Search" />
              </g:form>
              <ul class="nav pull-right">
                <li class="dropdown">
                  <a href="#" data-toggle="dropdown" class="dropdown-toggle"><sec:username/><!--b class="caret"/--></a>
                  <ul class="dropdown-menu">
                    <li><a href="${createLink(controller: 'user', action: 'settings')}">Settings</a></li>
                    <li class="divider"></li>
                    <li><a href="${createLink(controller: 'logout', action: 'index')}">Sign out</a></li>
                  </ul>
                </li>
              </ul>
            </sec:ifLoggedIn>
          </div>
        </div> <!--navbar-inner  -->
    </div> <!--navbar  -->
    
    <div class="container">
      <g:layoutBody/>
      <hr/>
      <footer>
        Pizza2me is made with love in Eastern Italy <br/>
        <p>Version <g:meta name="app.version"/> on Grails <g:meta name="app.grails.version"/></p>
      </footer>
    </div>  <!--container  -->
    
     <g:javascript library="application"/>
    <r:layoutResources />
</body>
</html>