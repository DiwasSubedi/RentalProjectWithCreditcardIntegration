 var contextRoot = "/" + window.location.pathname.split( '/' )[1];
 function makeAjaxCall(){
	 var dataToSend = JSON.stringify(serializeObject($('#carForm')));
	 console.log("infunction");
	 alert(dataToSend);	 
 };
function makeAjaxCall1(){
	var dataToSend = JSON.stringify(serializeObject($('#employeeForm')));
	
	
	$.ajax({
		type: 'POST',
		url: contextRoot + '/addverynewCar',
		dataType: "json",           // Accepts
 		data:dataToSend,
 		contentType: 'application/json', 
		success: function(data) {
		/*	$('#formInput').html("");
			$("#formInput").append( '<H3 align="center"> New Employee Information <H3>');                
			$('#formInput').append("<H4 align='center'>First Name:  " +  data.firstName + "</h4>"  );
			$('#formInput').append("<H4 align='center'>Last Name: " + data.lastName  + "</h4>" );
			$('#formInput').append("<H4 align='center'>Email: " +  data.email + "</h4>");
			$("#formInput").append('<h4 align="center"> <a href="#" onclick="toggle_visibility(\'formInput\');resetForm(\'employeeForm\');"><b>EXIT</b> </a> </h4>');
			make_visible('formInput');*/
			
			alert(data);
			/*make_hidden('errors');*/
		},

		error: function(errorObject){
			
			/*if (errorObject.responseJSON.errorType == "ValidationError") {
	 			
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#errors').show();
	 	 	        make_visible('errors');
	 	 	        make_hidden('formInput');
	 	 	        
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}		*/	
			
			alert("failed");
		}	
	});
	
	 
}
$( function() {
    $( "#datePicker1" ).datepicker();
  } );
$( function() {
    $( "#datePicker2" ).datepicker();
  } );

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};



