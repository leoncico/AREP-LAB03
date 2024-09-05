package escuelaing.edu.co.spring;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RutineControllerTest {

    @Test
    public void testRecommended() {
        // Configuración
    
        String name = "John";

        // Llamar al método
        String response = RutineController.recommended();

        // Verificar el resultado esperado
        assertEquals("{\"exercises\":[{\"name\":\"press\", \"series\":2}, {\"name\":\"sentadilla\", \"series\":8}, {\"name\":\"press militar\", \"series\":5}, {\"name\":\"elevaciones laterales\", \"series\":3}, {\"name\":\"Curl Femoral\", \"series\":3}]}", response);
    }

    @Test
    public void testShowName() {
        String name = "John";

        String response = RutineController.showName(name);

        assertEquals("Bienvenido John", response);
    }


}