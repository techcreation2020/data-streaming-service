$( window ).ready(function() {
  connect();
});

function connect() {
  var socket = new SockJS('/websocket');
  stompClient = Stomp.over(socket);
  stompClient.connect({}, function (frame) {
      stompClient.subscribe('/topic/pushNotification', function (notification) {
    	  alert(notification.body);
    	  var data = JSON.parse(notification.body);
    	  
    	  var $row = $('<div>Transaction Id: '+data.transaction_id+'<br/> User: '+data.user+'</div>');
          $('#listContainer').append($row);
       });
  });
}