<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <r:layoutResources/>
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyDeQKRsrtavZbtTquDElAYNBrob2uBUUw8&sensor=false">
    </script>
    
    <!-- forced include of  jquery -->
    <%--r:require modules="jquery"/ --%>
    <script src="/pizza2me/static/plugins/jquery-1.7.1/js/jquery/jquery-1.7.1.min.js" type="text/javascript" ></script>
    
    <script type="text/javascript">
      $(document).ready(function() {
          console.log('Ready!!');
      });
    </script>
    
    <script type="text/javascript">
      function positionPinsMap(locations, map) {
        var marker, i;

        for (i = 0; i < locations.length; i++) {  
          marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map
          });
        }
      }    
      
      function initialize() {
        var myLatlng = new google.maps.LatLng(45.8052710, 13.41350130);
        var myOptions = {
          center: myLatlng,
          zoom: 10,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("map_canvas"),
            myOptions);
        
        /*var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title:"Alla catapecchia"
        });*/
        
        /*var locations = [
          ['Al casale', 45.66168610, 12.24575610, 2],
          ['Alla catapecchia', 45.8052710, 13.41350130, 1]
        ];*/
        
        $.get('${createLink(controller: "pizzeria", action:"searched")}', null, 
          function (data) {
            console.log("received " + data);
            var locations = data;
            positionPinsMap(locations, map);
          }
        );

        

      }
    </script>
  </head>
  <body onload="initialize()">
    <div id="map_canvas" style="width:100%; height:100%"></div>
  </body>
</html>