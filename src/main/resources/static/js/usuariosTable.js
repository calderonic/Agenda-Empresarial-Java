// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});




 async function cargarUsuarios() {
// para hcer un llamado al servido, se hace un fetch
      const request = await fetch ('api/usuarios', {
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

       let botonEliminar = '<a href="#" onclick = "eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"> <i class="fas fa-trash"></i></a>'

       let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;

      let usuarioHtml = '<tr><td>'+  usuario.id +'</td> <td>'+ usuario.nombre+ '' +usuario.apellido+ '</td><td>' + usuario.email + '</td><td>'+ telefonoTexto +'</td><td>'+ botonEliminar +'</td></tr>';

        listadoHtml += usuarioHtml; 
    }


         document.querySelector(' #usuarios tbody ').outerHTML = listadoHtml;

 }






 async function eliminarUsuario(id) {

    if(!confirm('¿Desea eliminar el elemento seleccionado?')) {
    return;
    }
  //  alert(id);
// para hcer un llamado al servido, se hace un fetch
      const request = await fetch ('api/usuarios/' + id, {
        method: 'DELETE',
        headers: {
        // VAMOS A ESTAR UTILIZANDO JSON // EL CONTENDO VA A SER JSON
           'Accept': 'application/json',
           'Content-Type': 'application/json'
        }

                                                                         //UTILIZADO EN METHOD POST, por ej creamos un nuevo usuario, los modificamos
                                                                                 //body: JSON.stringify({a: 1, b: 'Textual content'})
      });
     // transformacion a json, no lo utilizamos por que no tenemos una respuesat de json
     //const usuarios = await request.json();


    location.reload()

 }



