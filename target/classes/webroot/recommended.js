function fetchRecommendedExercises() {
    // Realiza una petición GET utilizando fetch
    fetch('/recommended/list')  // Asegúrate de que la URL y el puerto coincidan con tu configuración
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();  // Procesa la respuesta como texto
        })
        .then(data => {
            // Inserta la respuesta en el elemento con id 'exercises'
            document.getElementById('exercises').innerText = data;
        })
        .catch(error => {
            console.error('Error fetching recommended exercises:', error);
        });
}


window.onload = fetchRecommendedExercises;