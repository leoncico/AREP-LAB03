package escuelaing.edu.co.spring.prueba;

import escuelaing.edu.co.spring.GetMapping;
import escuelaing.edu.co.spring.ListExerciseService;
import escuelaing.edu.co.spring.RequestMapping;
import escuelaing.edu.co.spring.RequestParam;
import escuelaing.edu.co.spring.RestController;

@RestController
public class RutineController {
    @RequestMapping(path = "/show/list", method = "GET")
    public static String recommended(){
        return ListExerciseService.responseRecommended();
    }

    @GetMapping(value = "/show/greeting")
    public static String showName(@RequestParam(value = "name", defaultValue = "LeonardoDefault") String name){
        return "Bienvenido" + name;
    }
}
