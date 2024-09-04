
package escuelaing.edu.co.spring;

public class AddExerciseService implements RESTService {

    private ExerciseService exerciseService;

    public AddExerciseService(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @Override
    public String response(String request) {
    String[] params = request.split("\\?");
    if (params.length < 2) return "{\"error\":\"Invalid request\"}";

    String[] queryParams = params[1].split("&");
    String name = null;
    Integer series = null;

    for (String param : queryParams) {
        String[] pair = param.split("=");
        if (pair.length == 2) {
            String key = pair[0];
            String value = pair[1];

            if (key.equals("name")) {
                name = value;
            } else if (key.equals("series")) {
                series = Integer.parseInt(value);
            }
        }
    }

    if (name == null || series == null) {
        return "{\"error\":\"Missing parameters\"}";
    }

    exerciseService.addExercise(name, series);
    return "{\"name\":\"" + name + "\", \"series\":" + series + "}";
}
    
}
