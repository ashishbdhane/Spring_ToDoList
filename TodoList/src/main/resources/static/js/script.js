/**
 * 
 */
/*const button=document.querySelector("button"),
	toast=document.querySelector(".toast"),
	inprogess=document.querySelector(".close"),
	progess=document.querySelector(".progress");
	
	button.addEventListener("click",()=>{
		toast.classList.add("active");
		progess.classList.add("active");
		
		setTimeout(()=>{
			toast.className.remove("active")
		},5000)
	})
*/
message = document.querySelector(".message");


window.addEventListener('load', (event) => {
		
		setTimeout(()=>{
			message.remove();
		},5000)
});