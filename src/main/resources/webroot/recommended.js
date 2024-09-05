function fetchRecommendedExercises() {
    fetch('/show/list')
        .then(response => response.json())
        .then(data => {
            const exercises = data.exercises;
            const tableBody = document.querySelector('#exerciseTable tbody');
            tableBody.innerHTML = '';

            exercises.forEach(exercise => {
                const row = document.createElement('tr');
                const nameCell = document.createElement('td');
                nameCell.textContent = exercise.name;
                row.appendChild(nameCell);
                const seriesCell = document.createElement('td');
                seriesCell.textContent = exercise.series;
                row.appendChild(seriesCell);
                tableBody.appendChild(row);
            });
        })
        .catch(error => {
            console.error('Error fetching exercises:', error);
        });
}

window.onload = fetchRecommendedExercises;
