// Call the dataTables jQuery plugin
$(document).ready(function() {
    //ready
});

async function iniciarSession(){
      let datos = {}
      datos.email = document.getElementById('email').value
      datos.password = document.getElementById('password').value

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });
      response = await request.text()
      console.log(response)
      if(response == "OK"){
        window.location.href = "usuarios.html"
      }else{
        alert("Los credenciales son incorrectos. Por favor intente nuevamente.")
      }
}