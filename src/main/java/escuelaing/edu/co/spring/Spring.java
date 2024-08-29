/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escuelaing.edu.co.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author david.pineros-c
 */
public class Spring {
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException, IllegalAccessException, InvocationTargetException{
        Class c = Class.forName(args[0]);
        Map<String, Method> services = new HashMap();
        
        //Cargar componentes
        if(c.isAnnotationPresent(RestController.class)){
            Method[] methods = c.getDeclaredMethods();
            for(Method method: methods){
                if(method.isAnnotationPresent(GetMapping.class)){
                    String key = method.getAnnotation(GetMapping.class).value();
                    services.put(key, method);
                }
                
            }
        }
        
        URL serviceurl = new URL("http://localhost:8080/App/hello");
        String path = serviceurl.getPath();
        System.out.println("Path: " + path);
        String servicename = path.substring(4);
        System.out.println("Service name: " + servicename);
        Method methodService = services.get(servicename);
        System.out.println("Respuesta servicio: " + methodService.invoke(null));

        URL serviceurl1 = new URL("http://localhost:8080/App/pi");
        String path1 = serviceurl1.getPath();
        System.out.println("Path: " + path1);
        String servicename1 = path1.substring(4);
        System.out.println("Service name: " + servicename1);
        Method methodService1 = services.get(servicename1);
        System.out.println("Respuesta servicio: " + methodService1.invoke(null));
        
        URL serviceurl2 = new URL("http://localhost:8080/App/avogadro");
        String path2 = serviceurl2.getPath();
        System.out.println("Path: " + path2);
        String servicename2 = path2.substring(4);
        System.out.println("Service name: " + servicename2);
        Method methodService2 = services.get(servicename2);
        System.out.println("Respuesta servicio: " + methodService2.invoke(null));
        
        URL serviceurl3 = new URL("http://localhost:8080/App/speedLight");
        String path3 = serviceurl3.getPath();
        System.out.println("Path: " + path3);
        String servicename3 = path3.substring(4);
        System.out.println("Service name: " + servicename3);
        Method methodService3 = services.get(servicename3);
        System.out.println("Respuesta servicio: " + methodService3.invoke(null));
    }
}
