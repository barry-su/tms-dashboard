/*Dynamically change status according to the data from back-end
 * Below is just an example with test data
 * */

var stompClient = null;
		$(window).load(function() {
			var socket = new SockJS('/changestatus');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
            	stompClient.send("/app/changestatus", {}, '');
                stompClient.subscribe('/topic/terminal/changestatus', function(greeting){
                    var randomNum = JSON.parse(greeting.body).content;
                    var badge1 = $("li[data-nodeid='2'] .badge");
                    var badge2 = $("li[data-nodeid='5'] .badge");
                    var badge3 = $("li[data-nodeid='9'] .badge");
                    switch(randomNum)
                    {
                    case '0': 
                    	badge1.html('<i class="glyphicon glyphicon-info-sign"></i>');
                		badge2.html('<i class="glyphicon glyphicon-remove-sign"></i>');
                		badge3.html('<i class="glyphicon glyphicon-exclamation-sign"></i>');
                		break;
                    case '1':
                    	badge1.html('<i class="glyphicon glyphicon-remove-sign"></i>');
                		badge2.html('<i class="glyphicon glyphicon-exclamation-sign"></i>');
                		badge3.html('<i class="glyphicon glyphicon-remove-sign"></i>');
                		break;
                    case '2':
                    	badge1.html('<i class="glyphicon glyphicon-exclamation-sign"></i>');
                		badge2.html('<i class="glyphicon glyphicon-info-sign"></i>');
                		badge3.html('<i class="glyphicon glyphicon-info-sign"></i>');
                		break;
                    }
                });
            });
	    });