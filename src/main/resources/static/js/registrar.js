$(document).ready(function() {

});




 async function cargarUsuarios(){

 let datos = {};
 datos.nombre = document.getElementById('txtNombre').value;
  datos.apellido = document.getElementById('txtApellido').value;
    datos.email = document.getElementById('txtEmail').value;
     datos.password = document.getElementById('txtPassword').value;

    let repetircontra = document.getElementById('txtRepetirPassword').value;
   if(!(datos.password == repetircontra)){
   alert("Repite correctamente la contraseña");
    return;
   }

// para hcer un llamado al servido, se hace un fetch
      const request = await fetch ('api/usuarios', { //tenia un error por colocar 'resgistrar'
        method: 'POST',
        headers: {
        // VAMOS A ESTAR UTILIZANDO JSON // EL CONTENDO VA A SER JSON
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },

        //UTILIZADO EN METHOD POST, por ej creamos un nuevo usuario, los modificamos
        body: JSON.stringify(datos)
      });
     // const usuarios = await request.json();
    alert("Usted acaba de hacer su cuenta con exito!");
    window.location.href = 'login.html';
 }




