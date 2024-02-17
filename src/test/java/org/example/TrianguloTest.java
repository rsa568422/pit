package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrianguloTest {

    @Test
    public void testEsEscaleno1() {
        assertTrue(new Triangulo(2, 3, 4).esEscaleno());
    }

    @Test
    public void testEsEscaleno2() {
        assertTrue(new Triangulo(2, 4, 3).esEscaleno());
    }

    @Test
    public void testEsEscaleno3() {
        assertTrue(new Triangulo(3, 2, 4).esEscaleno());
    }

    @Test
    public void testEsEscaleno4() {
        assertTrue(new Triangulo(3, 4, 2).esEscaleno());
    }

    @Test
    public void testEsEscaleno5() {
        assertTrue(new Triangulo(4, 2, 3).esEscaleno());
    }

    @Test
    public void testEsEscaleno6() {
        assertTrue(new Triangulo(4, 3, 2).esEscaleno());
    }

    @Test
    public void testEsIsosceles1() {
        assertTrue(new Triangulo(2, 2, 3).esIsosceles());
    }

    @Test
    public void testEsIsosceles2() {
        assertTrue(new Triangulo(2, 3, 2).esIsosceles());
    }

    @Test
    public void testEsIsosceles3() {
        assertTrue(new Triangulo(3, 2, 2).esIsosceles());
    }

    @Test
    public void testEsEquilatero() {
        assertTrue(new Triangulo(1, 1, 1).esEquilatero());
    }

    @Test (expected = TrianguloException.class)
    public void testError1() {
        Triangulo.creaTriangulo("1 1 2");
    }

    @Test (expected = TrianguloException.class)
    public void testError2() {
        Triangulo.creaTriangulo("1 1 0");
    }

    @Test (expected = TrianguloException.class)
    public void testError3() {
        Triangulo.creaTriangulo("1 1 c");
    }

    @Test (expected = TrianguloException.class)
    public void testError4() {
        Triangulo.creaTriangulo("1 1");
    }

    @Test (expected = TrianguloException.class)
    public void testError5() {
        Triangulo.creaTriangulo("1 1 1 1");
    }

    @Test
    public void testTipo1() {
        assertEquals(TipoDeTriangulo.escaleno, new Triangulo(2, 3, 4).tipo());
    }

    @Test
    public void testTipo2() {
        assertEquals(TipoDeTriangulo.isosceles, new Triangulo(2, 2, 3).tipo());
    }

    @Test
    public void testTipo3() {
        assertEquals(TipoDeTriangulo.equilatero, new Triangulo(1, 1, 1).tipo());
    }

    @Test
    public void testCreaTriangulo1() {
        assertEquals(TipoDeTriangulo.escaleno, Triangulo.creaTriangulo("2 3 4").tipo());
    }

    @Test
    public void testCreaTriangulo2() {
        assertEquals(TipoDeTriangulo.isosceles, Triangulo.creaTriangulo("2 2 3").tipo());
    }

    @Test
    public void testCreaTriangulo3() {
        assertEquals(TipoDeTriangulo.equilatero, Triangulo.creaTriangulo("1 1 1").tipo());
    }

    @Test
    public void testTestToString1() {
        assertEquals("T[2, 3, 4]", Triangulo.creaTriangulo("2 3 4").toString());
    }

    @Test
    public void testTestToString2() {
        assertEquals("T[2, 2, 3]", Triangulo.creaTriangulo("2 2 3").toString());
    }

    @Test
    public void testTestToString3() {
        assertEquals("T[1, 1, 1]", Triangulo.creaTriangulo("1 1 1").toString());
    }

    @Test
    public void testTestEquals1() {
        assertEquals(new Triangulo(2, 3, 4), Triangulo.creaTriangulo("2 3 4"));
    }

    @Test
    public void testTestEquals2() {
        assertEquals(new Triangulo(2, 2, 3), Triangulo.creaTriangulo("2 2 3"));
    }

    @Test
    public void testTestEquals3() {
        assertEquals(new Triangulo(1, 1, 1), Triangulo.creaTriangulo("1 1 1"));
    }
}