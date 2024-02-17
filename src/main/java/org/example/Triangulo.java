package org.example;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Triangulo {
	private final int p;
	private final int q;
	private final int r;
	private final TipoDeTriangulo tipo;
	
	public Triangulo(int p, int q, int r) {
		if (p > 0 && q > 0 && r > 0) {
			if (chk_lados(p, q, r)) {
				int[] values = {p, q, r};
				Arrays.sort(values);
				this.p = values[0];
				this.q = values[1];
				this.r = values[2];
				if (this.esEquilatero()) {
					tipo = TipoDeTriangulo.equilatero;
				} else if (this.esEscaleno()) {
					tipo = TipoDeTriangulo.escaleno;
				} else {
					tipo = TipoDeTriangulo.isosceles;
				}
			} else {
				throw new TrianguloException("Un lado mayor o igual que la suma de los otros dos");
			}
			
		} else {
			throw new TrianguloException("Uno o más lados menores o iguales que 0");
		}
	}
	
	private boolean chk_lados(int p, int q, int r) {
		return (p + q > r) && (p + r > q) && (q + r > p);
	}
	
	public boolean esEscaleno() {
		return (p != q) && (p != r) && (q != r);
	}
	
	public boolean esIsosceles() {
		return !esEscaleno() && !esEquilatero();
	}
	
	public boolean esEquilatero() {
		return (p == q) && (q == r);
	}
	
	public TipoDeTriangulo tipo() {
		return tipo;
	}
	
	public static Triangulo creaTriangulo(String arg) {
		StringTokenizer st = new StringTokenizer(arg);
		int[] v = new int[3];
		int argc = 0;
		while (st.hasMoreTokens()) {
			if (argc < 3) {
				try {
					v[argc] = Integer.parseInt(st.nextToken());
					argc++;
				} catch (Exception e) {
					throw new TrianguloException("Argumento invalido");
				}
			} else {
				throw new TrianguloException("Número de argumentos invalido");
			}
		}
		if (argc < 3) {
			throw new TrianguloException("Número de argumentos invalido");
		}
		return new Triangulo(v[0], v[1], v[2]);
	}
	
	/* --- Necesario para corregir errores --------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "T[" + p + ", " + q + ", " + r + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Triangulo && this.toString().equals(obj.toString());
	}
	/* --------------------------------------------------------------------------------------------------------- */
}