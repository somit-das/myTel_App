  function fun1(){
        var user=document.getElementById("txt").value;
        if(user.charCodeAt(0)>=65 && user.charCodeAt(0)<=90){
            document.getElementById("errorMsg1").innerHTML="";
        }
        else{
            document.getElementById("errorMsg1").innerHTML="<h6>Name Must Start with Upper Case Letter</h6>".italics().fontcolor('red');
        }
        }
        
   function mobileValidations(){  
  var num=document.getElementById("mob").value; 
if (isNaN(num)){  
	 document.getElementById("errorMsg2").innerHTML="<h6>Mobile No Doesn't Contain Letters</h6>".italics().fontcolor('red');  
}
else if(num.length==10){  
	document.getElementById("errorMsg2").innerHTML="";
  }  
  else{	
 document.getElementById("errorMsg2").innerHTML="<h6>Enter A Valid Mobile Number</h6>".italics().fontcolor('red');
	}
} 

function fun3(){
	var password=document.getElementById("txt3").value;
	var regExp= /(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\w{6,15}/;
	var msg=document.getElementById("errorMsg3");
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

function fun22()  
{  
var x=document.getElementById("txt22").value;  
	var msg=document.getElementById("errorMsg22");
var atposition=x.indexOf("@");  
var dotposition=x.lastIndexOf(".");  
if (atposition<1 || dotposition<atposition+2 || dotposition+2>=x.length){  
		msg.innerHTML="Please Enter a Valid Email Address".italics().fontcolor('red'); 
    
  }  
  else{
	msg.innerHTML="";
}
}