/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package EstudianteTest;

import com.mycompany.estudiante.Estudiante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.List;
/**
 * @author Sara
 */
public class EstudianteTest {
    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante("Ana");
    }

    @Test
    void testAgregarNotaValida() throws Exception {
        estudiante.agregarNota(85);

        Field notasField = Estudiante.class.getDeclaredField("notas");
        notasField.setAccessible(true);
        List<Integer> notas = (List<Integer>) notasField.get(estudiante);

        assertEquals(1, notas.size());
        assertEquals(85, notas.get(0));
    }

    @Test
    void testAgregarNotaInvalida() {
        // Notas fuera de rango deberían lanzar excepción
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(-5));
        assertThrows(IllegalArgumentException.class, () -> estudiante.agregarNota(150));
    }

    @Test
    void testCalcularPromedio() throws Exception {
        estudiante.agregarNota(80);
        estudiante.agregarNota(70);
        estudiante.agregarNota(90);
        double promedio = estudiante.calcularPromedio();
        assertEquals(80.0, promedio, 0.01); // tolerancia de 0.01
    }

    @Test
    void testAprobo() {
        // Simulación: debería aprobar con promedio >= 60
        estudiante.agregarNota(70);
        estudiante.agregarNota(80);

        assertTrue(estudiante.aprobo());

        estudiante = new Estudiante("Ana"); // reset
        estudiante.agregarNota(40);
        estudiante.agregarNota(50);

        assertFalse(estudiante.aprobo());
    }
}
