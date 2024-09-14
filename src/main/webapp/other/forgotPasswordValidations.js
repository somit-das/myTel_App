  function fun1(){
        var user=document.getElementById("txt").value;   
if (!isNaN(user)){   
if(user.length==10){  
	document.getElementById("errorMsg1").innerHTML="";
  }  
  else{
	document.getElementById("errorMsg1").innerHTML="Enter A Valid Mobile Number".italics().fontcolor('red');
} }
else{
	var x=document.getElementById("txt").value;  
	var msg=document.getElementById("errorMsg1");
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		msg.innerHTML="Please Enter a Valid Email Address".italics().fontcolor('red');    
  }  
  else{
	msg.innerHTML="";
}		
}
 }
        
function fun2(){
	var password=document.getElementById("txt2").value;
	var regExp= /(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\w{6,15}/;
	var msg=document.getElementById("errorMsg2");
	if(password.match(regExp)){
		msg.innerHTML="";
	}
		else if(password.length<6){
				msg.innerHTML="Password Shouldn't be less than 6 Chars".italics().fontcolor('red');	
		}
		else if(password.length>15){
				msg.innerHTML="Password Shouldn't be greater than 15 Chars".italics().fontcolor('red');	
		}
	else{
			msg.innerHTML="Please Enter a Valid Password".italics().fontcolor('red');	
		}
}

function fun3(){
		var password=document.getElementById("txt2").value;
	var password2=document.getElementById("txt3").value;
	var msg=document.getElementById("errorMsg3");
	if(password2==password){
		msg.innerHTML="";
	}
	else{
			msg.innerHTML="Confirm Password must be match".italics().fontcolor('red');	
		}
}

function backButton(){
	window.location.href="index.html";
}