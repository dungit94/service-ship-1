// Get the modal
var modal = document.getElementById('id01');
 $("#id01").modal({"backdrop": "static"});
// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
       
    }
    
}