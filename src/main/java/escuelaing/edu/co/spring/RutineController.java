package escuelaing.edu.co.spring;

@RestController
public class RutineController {
    @RequestMapping(path = "/show/list", method = "GET")
    public static String recommended(){
        return ListExerciseService.responseRecommended();
    }

    @GetMapping(value = "/show/greeting")
    public static String showName(@RequestParam(value = "name", defaultValue = "LeonardoDefault") String name){
        return "Bienvenido " + name;
    }
}
