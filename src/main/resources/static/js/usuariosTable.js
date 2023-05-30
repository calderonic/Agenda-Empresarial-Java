// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

 async function cargarUsuarios() {
// para hcer un llamado al servido, se hace un fetch
      const request = await fetch ('usuarios', {
        method: 'GET',
        headers: {
        // VAMOS A ESTAR UTILIZANDO JSON // EL CONTENDO VA A SER JSON
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }

        //UTILIZADO EN METHOD POST, por ej creamos un nuevo usuario, los modificamos
        //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
      const usuarios = await request.json();


    let listadoHtml = '';

    for (let usuario of usuarios) {
     // console.log(usuarios);

      let usuarioHtml = '<tr><td>'+  usuario.id +'</td><td>'+ usuario.nombre+ '' +usuario.apellido+ '</td><td>' + usuario.email + '</td><td>'+ usuario.telefono +'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a></td></tr>';

        listadoHtml += usuarioHtml; 
    }


         document.querySelector(' #usuarios tbody ').outerHTML = listadoHtml;

 }
