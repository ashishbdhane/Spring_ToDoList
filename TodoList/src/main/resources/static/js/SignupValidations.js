/**
 * 
 */

 function passwordsMatch(){
	 var password1 = document.getElementsByName("password").value;
     var password2 = document.getElementsByName("rePassword").value;
     console.log(password1);
     console.log(password2);
     let re = /^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{7,}$/;

    if(password1.length <8){
        alert("password too short");
        return false;
     }
    else if(!re.test(password1)){
        alert("password too weak ");
        return false;
     }
    else if(password1!=password2 ){
        alert("passwords do not match");
        return false;
     }
     return true;
 }