var host = 'http://localhost:8080';
$(document).ready(function(){
	$('.userTxnListTable').hide();
	connect();
});

function connect() {
	var count = 1;
	
	  var socket = new SockJS('/stream-service/websocket');
	  stompClient = Stomp.over(socket);
	  stompClient.connect({}, function (frame) {
	      stompClient.subscribe('/topic/pushNotification', function (notification) {
	    	  var data = JSON.parse(notification.body);	    	  
	    	  var $list = $('#transactionListBody');
	    	  
	    	  var $row = $list.find('#'+data.id);
	    	  if($row && $row.length ==1 ) {
	    		  $row.find('#'+data.id+'balance').html(data.balance);	    		  
	    		  $row.data("user-data", data);
	    	  }	else {
	    		  var $tr = $('<tr id="'+data.id+'"><div class="row">'+
	  				'<th scope="row">'+ count++ +'</th><td>'+data.userName.toUpperCase()+'</td>'+
	  				'<td>'+data.fund.fundName.toUpperCase()+'</td>'+
	  				'<td id="' + data.id + 'balance">'+data.balance+'</td>'+
	  				'<td><button type="button" class="transactionDetailBtn btn btn-sm btn-light">Details</button</td></div></tr>');
	    		  $tr.data("user-data", data);	  		
	    		  $list.prepend($tr);
	    	  }	    	 
	       });
	  });
	}

$(document).on('click', '.transactionDetailBtn', function() {		
	var $table = $('.userTxnListTable');
	var data = $(this).parents('tr').data('user-data');	
	$.ajax({
		url: host + "/apiService/api/getUserTransaction/" + data.id + '/' + data.fund.id,
		type:'GET',		
		dataType:'json',
		success: function(responseData) {
			var data = responseData.data;
			if(data){
				var individualData = data;
				var $tbody = $('#userTxnListBody').empty();
				var count = individualData.length + 1;
				$('#userDetailHeader').empty()
					.append('<h4 style="color:white; margin-left:15px;">Transactions of User '+individualData[0].user.userName.toUpperCase()+' and ' 
							+' Security '+individualData[0].fund.fundName.toUpperCase()+'<h4>');
				for(var i in individualData) {
					count--;
					var $tr = $('<tr id="' + individualData[i].id + '><div class="row">'+
							'<th scope="row">'+(count)+'</th><td>'+individualData[i].transactionType.toUpperCase()+'</td>'+
							'<td>'+individualData[i].transactionUnit+'</td>'+
							'<td>'+individualData[i].createOn+'</td>'+
							'</tr>');
					$tbody.prepend($tr);
				}
			} else if(responseData.messages && responseData.messages.length != 0) {
				var msg = '';
				var messages = responseData.messages;
				for(var i in messages) {
					msg += messages[i].message;
				}
				$('#message').empty().append('<span class="error-message">* '+ msg +'</span>');
			}
			
		}, 
		error:function(error,jqXHR, t) {
			console.log(error);
			console.log(jqXHR);
			console.log(t);
		}
	});		
	$table.show();	
});
