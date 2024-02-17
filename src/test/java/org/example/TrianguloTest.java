package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TrianguloTest {

    @Test
    public void testEsEscaleno() {
        Triangulo triangulo = new Triangulo(2, 3, 4);
        assertTrue(triangulo.esEscaleno());
        assertFalse(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsIsosceles() {
        Triangulo triangulo = new Triangulo(2, 2, 3);
        assertFalse(triangulo.esEscaleno());
        assertTrue(triangulo.esIsosceles());
        assertFalse(triangulo.esEquilatero());
    }

    @Test
    public void testEsEquilatero() {
        assertFalse(new Triangulo(1, 1, 1).esEscaleno());
        assertFalse(new Triangulo(1, 1, 1).esIsosceles());
        assertTrue(new Triangulo(1, 1, 1).esEquilatero());
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
        assertEquals(TipoDeTriangulo.escaleno, escaleno.tipo());
        assertEquals("T[2, 3, 4]", escaleno.toString());
        assertEquals(TipoDeTriangulo.isosceles, isosceles.tipo());
        assertEquals("T[2, 2, 3]", isosceles.toString());
        assertEquals(TipoDeTriangulo.equilatero, equilatero.tipo());
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
        assertEquals(new Triangulo(2, 3, 4), Triangulo.creaTriangulo("2 3 4"));
        assertEquals(new Triangulo(2, 2, 3), Triangulo.creaTriangulo("2 2 3"));
        assertEquals(new Triangulo(1, 1, 1), Triangulo.creaTriangulo("1 1 1"));
    }

    @Test
    public void testError1() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 1 2");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError2() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 2 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError3() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("2 1 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Un lado mayor o igual que la suma de los otros dos", exception.getMessage());
    }

    @Test
    public void testError4() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 1 0");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError5() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 0 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError6() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("0 1 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError7() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 0 0");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError8() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("0 1 0");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError9() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("0 0 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError10() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("0 0 0");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Uno o más lados menores o iguales que 0", exception.getMessage());
    }

    @Test
    public void testError11() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 1 c");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Argumento invalido", exception.getMessage());
    }

    @Test
    public void testError12() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Número de argumentos invalido", exception.getMessage());
    }

    @Test
    public void testError13() {
        Exception exception = null;

        try {
            Triangulo.creaTriangulo("1 1 1 1");
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertTrue(exception instanceof TrianguloException);
        assertEquals("Número de argumentos invalido", exception.getMessage());
    }
}