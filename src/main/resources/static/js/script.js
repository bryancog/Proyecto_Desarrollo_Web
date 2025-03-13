/***************************************
 * Validar formulario de Ciudad
 ***************************************/
function validarCiudad() {
    const nombre = document.querySelector('[name="nombre"]').value.trim();
    const impuesto = document.querySelector('[name="impuesto"]').value.trim();
  
    if (!nombre) {
      alert("El nombre de la ciudad es obligatorio.");
      return false; // Evita el envío del formulario
    }
    // Ejemplo de validación de impuesto negativo
    if (impuesto && parseFloat(impuesto) < 0) {
      alert("El impuesto no puede ser negativo.");
      return false;
    }
    return true; // Continúa con el envío
  }
  
  /***************************************
   * Mostrar/ocultar campos para Rutas Inseguras
   ***************************************/
  function toggleInseguraFields() {
    const seguraCheckbox = document.getElementById("seguraCheckbox");
    const danoField = document.getElementById("danoField");
    const causaField = document.getElementById("causaField");
  
    if (!seguraCheckbox || !danoField || !causaField) {
      return; // Evita errores si no estamos en la página de rutas
    }
  
    // Si la ruta es segura, ocultamos daño y causa
    if (seguraCheckbox.checked) {
      danoField.style.display = "none";
      causaField.style.display = "none";
    } else {
      danoField.style.display = "block";
      causaField.style.display = "block";
    }
  }
  
  /***************************************
   * Mensajes o acciones extra
   ***************************************/
  console.log("script.js cargado correctamente");
  
  // Puedes agregar más funciones para alertas, peticiones AJAX, etc.
  