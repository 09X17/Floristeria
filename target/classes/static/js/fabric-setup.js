// fabric-setup.js
$(document).ready(function() {
    const canvas = new fabric.Canvas('canvas');

    // Agregar un rectángulo como ejemplo
    const rect = new fabric.Rect({
        left: 100,
        top: 100,
        fill: 'red',
        width: 50,
        height: 50
    });
    canvas.add(rect);

    // Agregar una flor (puedes usar imágenes o formas)
    // Por ejemplo, agregar una imagen de flor
    fabric.Image.fromURL('path/to/flower.png', function(img) {
        img.set({
            left: 150,
            top: 150
        });
        canvas.add(img);
    });

    // Guardar el diseño
    $('#guardarDiseño').click(function() {
        const json = canvas.toJSON();
        // Aquí podrías hacer una solicitud AJAX para guardar el diseño en tu backend
        console.log(JSON.stringify(json)); // Para pruebas
    });
});
