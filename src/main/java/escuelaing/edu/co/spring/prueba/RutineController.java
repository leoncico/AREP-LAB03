package escuelaing.edu.co.spring.prueba;

import escuelaing.edu.co.spring.ListExerciseService;
import escuelaing.edu.co.spring.RequestMapping;
import escuelaing.edu.co.spring.RestController;

@RestController
public class RutineController {
    @RequestMapping(path = "/recommended/list", method = "GET")
    public static String recommended(){
        return ListExerciseService.responseRecommended();
    }
}
