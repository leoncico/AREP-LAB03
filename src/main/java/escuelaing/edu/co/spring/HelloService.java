package escuelaing.edu.co.spring;

@RestController
public class HelloService {
    
    @GetMapping("/hello")
    public static String hello(){
        return "Hello world!";
    }
    
    @GetMapping("/pi")
    public static double pi(){
        return Math.PI;
    }
    
    @GetMapping("/avogadro")
    public static double avogadro(){
        return 6.02214076e23;
    }
    
    @GetMapping("/speedLight")
    public static int speedLight(){
        return 299792458;
    }
}
