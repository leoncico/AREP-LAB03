function fetchRecommendedExercises() {
    fetch('/show/list')
            .then(response => response.json()) 
            .then(data => {
                const exercises = data.exercises;
                let exerciseList = '';
                exercises.forEach(exercise => {
                    exerciseList += `Ejercicio: ${exercise.name}, Series: ${exercise.series}<br>`;
                });
                document.getElementById('exercises').innerHTML = exerciseList;
            })
            .catch(error => {
                console.error('Error fetching exercises:', error);
            });
}

window.onload = fetchRecommendedExercises;