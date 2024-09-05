package escuelaing.edu.co.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class Spring {

    private static Spring instance;
    private ComponentLoader components;
    private final Map<String, Method> getRoutes = new HashMap<>();


    private Spring() {
        this.components = new ComponentLoader(Rutine.class);
        saveMappings();
    }


    public static Spring getInstance() {
        if (instance == null) {
            instance = new Spring();
        }
        return instance;
    }


    private void saveMappings() {
        for (Class<?> cls : components.getClassComponents()) {
            if(cls.isAnnotationPresent(RestController.class)){
                for (Method method : cls.getDeclaredMethods()) {
                    String path;

                    
                    if (method.isAnnotationPresent(RequestMapping.class)) {
                        path = method.getAnnotation(RequestMapping.class).path();
                    }else{
                        path = method.getAnnotation(GetMapping.class).value();
                    }
                    getRoutes.put(path,method);
                }
            }
        }
    }


    public static Method findMappingMethod(String path) {
        Method method = null;
        Spring springServer = getInstance();
        if(springServer.getRoutes.containsKey(path)){
            method = springServer.getRoutes.get(path);
        }
        return method;
    }

}

