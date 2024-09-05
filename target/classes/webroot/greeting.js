function fetchName() {
        event.preventDefault();
        const nombre = document.getElementById('name').value;
        const url = `/show/greeting?name=${encodeURIComponent(nombre)}`;

        console.log(url);
        fetch(url)
            .then(response => response.text())
            .then(data => {
                document.getElementById('response').innerText = data;
            })
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('response').innerText = 'Hubo un error al procesar la solicitud.';
            });
}

document.getElementById('form').addEventListener('submit', fetchName);