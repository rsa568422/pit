package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrianguloTest {

    @Test
    public void testEsEscaleno1() {
        Triangulo triangulo = new Triangulo(2, 3, 4);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEscaleno2() {
        Triangulo triangulo = new Triangulo(2, 4, 3);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEscaleno3() {
        Triangulo triangulo = new Triangulo(3, 2, 4);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEscaleno4() {
        Triangulo triangulo = new Triangulo(3, 4, 2);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEscaleno5() {
        Triangulo triangulo = new Triangulo(4, 2, 3);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEscaleno6() {
        Triangulo triangulo = new Triangulo(4, 3, 2);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsIsosceles1() {
        Triangulo triangulo = new Triangulo(2, 2, 3);
        assertFalse(triangulo.esEscaleno());
        assertTrue(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsIsosceles2() {
        Triangulo triangulo = new Triangulo(2, 3, 2);
        assertFalse(triangulo.esEscaleno());
        assertTrue(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsIsosceles3() {
        Triangulo triangulo = new Triangulo(3, 2, 2);
        assertFalse(triangulo.esEscaleno());
        assertTrue(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEquilatero() {
        Triangulo triangulo = new Triangulo(1, 1, 1);
        assertFalse(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertTrue(triangulo.esEquilatero());
    }

    @Test
    public void testTipo() {
        Triangulo escaleno = new Triangulo(2, 3, 4);
        Triangulo isosceles = new Triangulo(2, 2, 3);
        Triangulo equilatero = new Triangulo(1, 1, 1);
        assertEquals(TipoDeTriangulo.escaleno, escaleno.tipo());
        assertNotEquals(TipoDeTriangulo.isosceles, escaleno.tipo());
        assertNotEquals(TipoDeTriangulo.equilatero, escaleno.tipo());
        assertNotEquals(TipoDeTriangulo.escaleno, isosceles.tipo());
        assertEquals(TipoDeTriangulo.isosceles, isosceles.tipo());
        assertNotEquals(TipoDeTriangulo.equilatero, isosceles.tipo());
        assertNotEquals(TipoDeTriangulo.escaleno, equilatero.tipo());
        assertNotEquals(TipoDeTriangulo.isosceles, equilatero.tipo());
        assertEquals(TipoDeTriangulo.equilatero, equilatero.tipo());
    }

    @Test
    public void testCreaTriangulo() {
        Triangulo escaleno = Triangulo.creaTriangulo("2 3 4");
        Triangulo isosceles = Triangulo.creaTriangulo("2 2 3");
        Triangulo equilatero = Triangulo.creaTriangulo("1 1 1");
        assertEquals("T[2, 3, 4]", escaleno.toString());
        assertEquals("T[2, 2, 3]", isosceles.toString());
        assertEquals("T[1, 1, 1]", equilatero.toString());
    }

    @Test
    public void testTestToString() {
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("2 3 4").toString());
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("2 4 3").toString());
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("3 2 4").toString());
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("3 4 2").toString());
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("4 2 3").toString());
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("4 3 2").toString());
        assertEquals("T[2, 2, 3]", Triangulo.creaTriangulo("2 2 3").toString());
        assertEquals("T[2, 2, 3]", Triangulo.creaTriangulo("2 3 2").toString());
        assertEquals("T[2, 2, 3]", Triangulo.creaTriangulo("3 2 2").toString());
        assertEquals("T[1, 1, 1]", Triangulo.creaTriangulo("1 1 1").toString());
    }

    @Test
    public void testTestEquals() {
        Triangulo escaleno = new Triangulo(2, 3, 4);
        Triangulo isosceles = new Triangulo(2, 2, 3);
        Triangulo equilatero = new Triangulo(1, 1, 1);
        assertEquals(escaleno, Triangulo.creaTriangulo("2 3 4"));
        assertNotEquals(escaleno, Triangulo.creaTriangulo("2 2 3"));
        assertNotEquals(escaleno, Triangulo.creaTriangulo("1 1 1"));
        assertNotEquals(isosceles, Triangulo.creaTriangulo("2 3 4"));
        assertEquals(isosceles, Triangulo.creaTriangulo("2 2 3"));
        assertNotEquals(isosceles, Triangulo.creaTriangulo("1 1 1"));
        assertNotEquals(equilatero, Triangulo.creaTriangulo("2 3 4"));
        assertNotEquals(equilatero, Triangulo.creaTriangulo("2 2 3"));
        assertEquals(equilatero, Triangulo.creaTriangulo("1 1 1"));
    }

    @Test
    public void testError1() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 1 2")
        );
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError2() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 2 1")
        );
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError3() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("2 1 1")
        );
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError4() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 1 0")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError5() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 0 1")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError6() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("0 1 1")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError7() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 0 0")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError8() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("0 1 0")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError9() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("0 0 1")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError10() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("0 0 0")
        );
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError11() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 1 c")
        );
        assertEquals("Argumento invalido", exception.getMessage());
    }

    @Test
    public void testError12() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 1")
        );
        assertEquals("Número de argumentos invalido", exception.getMessage());
    }

    @Test
    public void testError13() {
        TrianguloException exception = assertThrows(
                TrianguloException.class,
                () -> Triangulo.creaTriangulo("1 1 1 1")
        );
        assertEquals("Número de argumentos invalido", exception.getMessage());
    }
}