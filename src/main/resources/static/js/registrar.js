// Call the dataTables jQuery plugin
$(document).ready(function() {
    //ready
});

async function registrarUsuario(){
      let datos = {}
      datos.nombre = document.getElementById('nombre').value
      datos.apellido = document.getElementById('apellido').value
      datos.telefono = document.getElementById('telefono').value
      datos.email = document.getElementById('email').value
      datos.password = document.getElementById('password').value

      let repetirpassword = document.getElementById('repetirpassword').value
      if( repetirpassword != datos.password){
        alert('La contrasena que escribiste es diferente!!!')
        return;
      }

      const request = await fetch('api/usuarios', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
      });
      console.log(datos)
      alert("La cuenta fue registrada con exito.")
      window.location.href = "login.html"
}

