package com.wblut.math;

/**
 * Gives the number of m-dimensional hypercubes on the boundary of a
 * n-dimensional hypercube
 * 
 * @author Frederik Vanhoutte
 */
public class WB_Emn {
	public static int number(final int m, final int n) {
		if (m < 0) {
			return 0;
		}
		if (n < 0) {
			return 0;
		}
		if ((m == 0) && (n == 0)) {
			return 1;
		}
		if (m == 0) {
			return (int) Math.pow(2, n);
		}
		return (2 * number(m, n - 1) + number(m - 1, n - 1));
	}

	public static void main(final String[] args) {
		for (int i = 0; i < 4; i++) {
			System.out.println("n=" + i);
			for (int j = 0; j < 4; j++) {
				System.out.println("     m=" + j + ": " + number(j, i));
			}
		}
	}
}
