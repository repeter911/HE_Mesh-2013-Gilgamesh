
package com.wblut.math;

import com.wblut.WB_Epsilon;


/**
 * 2x2 Matrix.
 * 
 * @author Frederik Vanhoutte (W:Blut) 2010
 */
public class WB_M22 {
	/** First row. */
	public double m11, m12;
	/** Second row. */
	public double m21, m22;

	/**
	 * Instantiates a new WB_M33.
	 */
	public WB_M22() {
	}

	/**
	 * Instantiates a new WB_M33.
	 * 
	 * @param matrix22
	 *            double[3][3] array of values
	 */
	public WB_M22(final double[][] matrix22) {
		m11 = matrix22[0][0];
		m12 = matrix22[0][1];
		m21 = matrix22[1][0];
		m22 = matrix22[1][1];
	}

	/**
	 * Instantiates a new WB_M33.
	 * 
	 * @param m11
	 *            m11
	 * @param m12
	 *            m12
	 * @param m13
	 *            m13
	 * @param m21
	 *            m21
	 * @param m22
	 *            m22
	 * @param m23
	 *            m23
	 * @param m31
	 *            m31
	 * @param m32
	 *            m32
	 * @param m33
	 *            m33
	 */
	public WB_M22(final double m11, final double m12, final double m21,
			final double m22) {
		this.m11 = m11;
		this.m12 = m12;
		this.m21 = m21;
		this.m22 = m22;
	}

	/**
	 * Set values.
	 * 
	 * @param matrix22
	 *            double[2][2] array of values
	 */
	public void set(final double[][] matrix22) {
		m11 = matrix22[0][0];
		m12 = matrix22[0][1];
		m21 = matrix22[1][0];
		m22 = matrix22[1][1];
	}

	/**
	 * Set values.
	 * 
	 * @param matrix22
	 *            float[2][2] array of values
	 */
	public void set(final float[][] matrix22) {
		m11 = matrix22[0][0];
		m12 = matrix22[0][1];
		m21 = matrix22[1][0];
		m22 = matrix22[1][1];
	}

	/**
	 * Set values.
	 * 
	 * @param matrix22
	 *            int[2][2] array of values
	 */
	public void set(final int[][] matrix22) {
		m11 = matrix22[0][0];
		m12 = matrix22[0][1];
		m21 = matrix22[1][0];
		m22 = matrix22[1][1];
	}

	/**
	 * Set values.
	 * 
	 * @param m11
	 *            m11
	 * @param m12
	 *            m12
	 * @param m13
	 *            m13
	 * @param m21
	 *            m21
	 * @param m22
	 *            m22
	 * @param m23
	 *            m23
	 * @param m31
	 *            m31
	 * @param m32
	 *            m32
	 * @param m33
	 *            m33
	 */
	public void set(final double m11, final double m12, final double m21,
			final double m22) {
		this.m11 = m11;
		this.m12 = m12;
		this.m21 = m21;
		this.m22 = m22;
	}

	/**
	 * Set values.
	 * 
	 * @param m
	 *            matrix WB_M33
	 */
	public void set(final WB_M22 m) {
		m11 = m.m11;
		m12 = m.m12;
		m21 = m.m21;
		m22 = m.m22;
	}

	/**
	 * Get copy.
	 * 
	 * @return copy
	 */
	public WB_M22 get() {
		return new WB_M22(m11, m12, m21, m22);
	}

	/**
	 * Get row as array.
	 * 
	 * @param i
	 *            0,1,2
	 * @return row
	 */
	public double[] row(final int i) {
		if (i == 0) {
			return new double[] {m11, m12};
		}
		if (i == 1) {
			return new double[] {m21, m22};
		}
		return null;
	}

	/**
	 * Get column as array.
	 * 
	 * @param i
	 *            0,1,2
	 * @return col
	 */
	public double[] col(final int i) {
		if (i == 0) {
			return new double[] {m11, m21};
		}
		if (i == 1) {
			return new double[] {m12, m22};
		}
		return null;
	}

	/**
	 * Add matrix.
	 * 
	 * @param m
	 *            matrix
	 */
	public void add(final WB_M22 m) {
		m11 += m.m11;
		m12 += m.m12;
		m21 += m.m21;
		m22 += m.m22;
	}

	/**
	 * Subtract matrix.
	 * 
	 * @param m
	 *            matrix
	 */
	public void sub(final WB_M22 m) {
		m11 -= m.m11;
		m12 -= m.m12;
		m21 -= m.m21;
		m22 -= m.m22;
	}

	/**
	 * Multiply with scalar.
	 * 
	 * @param f
	 *            factor
	 */
	public void mult(final double f) {
		m11 *= f;
		m12 *= f;
		m21 *= f;
		m22 *= f;
	}

	/**
	 * Divide by scalar.
	 * 
	 * @param f
	 *            factor
	 */
	public void div(final double f) {
		final double invf = (f == 0) ? 0 : 1.0 / f;
		m11 *= invf;
		m12 *= invf;
		m21 *= invf;
		m22 *= invf;
	}

	/**
	 * Multiply matrices into new matrix.
	 * 
	 * @param m
	 *            matrix
	 * @param n
	 *            matrix
	 * @return result
	 */
	public static WB_M22 mul(final WB_M22 m, final WB_M22 n) {
		return new WB_M22(m.m11 * n.m11 + m.m12 * n.m21, m.m11 * n.m12 + m.m12
				* n.m22, m.m21 * n.m11 + m.m22 * n.m21, m.m21 * n.m12 + m.m22
				* n.m22);
	}

	/**
	 * Multiply with matrix into new matrix.
	 * 
	 * @param n
	 *            matrix
	 * @return result
	 */
	public WB_M22 mul(final WB_M22 n) {
		return new WB_M22(m11 * n.m11 + m12 * n.m21, m11 * n.m12 + m12 * n.m22,
				m21 * n.m11 + m22 * n.m21, m21 * n.m12 + m22 * n.m22);
	}

	/**
	 * Multiply vector and matrix into new vector.
	 * 
	 * @param v
	 *            vector
	 * @param m
	 *            matrix
	 * @return result
	 */
	public static double[] mul(final double x, double y, final WB_M22 m) {
		return new double[] {x * m.m11 + y * m.m21, x * m.m12
				+ y * m.m22};
	}

	/**
	 * Multiply matrix and vector into new vector.
	 * 
	 * @param m
	 *            matrix
	 * @param v
	 *            vector
	 * @return result
	 */
	public static double[] mul(final WB_M22 m, final double x, double y) {
		return new double[] {x * m.m11 + y * m.m12, x * m.m21
				+ y * m.m22};
	}

	/**
	 * Get determinant of matrix.
	 * 
	 * @return determinant
	 */
	public double det() {
		return m11 * m22 - m12 * m21;
	}

	/**
	 * Computes the sign of the determinant of the 2x2 matrix with the given
	 * entries, in a robust way.
	 * 
	 * @return -1 if the determinant is negative,
	 * @return 1 if the determinant is positive,
	 * @return 0 if the determinant is 0.
	 */
	public int signOfDet() {
		// returns -1 if the determinant is negative,
		// returns 1 if the determinant is positive,
		// returns 0 if the determinant is null.
		int sign;
		double swap;
		double k;
		long count = 0;
		sign = 1;
		if ((m11 == 0.0) || (m22 == 0.0)) {
			if ((m12 == 0.0) || (m21 == 0.0)) {
				return 0;
			} else if (m12 > 0) {
				if (m21 > 0) {
					return -sign;
				} else {
					return sign;
				}
			} else {
				if (m21 > 0) {
					return sign;
				} else {
					return -sign;
				}
			}
		}
		if ((m12 == 0.0) || (m21 == 0.0)) {
			if (m22 > 0) {
				if (m11 > 0) {
					return sign;
				} else {
					return -sign;
				}
			} else {
				if (m11 > 0) {
					return -sign;
				} else {
					return sign;
				}
			}
		}
		if (0.0 < m12) {
			if (0.0 < m22) {
				if (m12 <= m22) {
					;
				} else {
					sign = -sign;
					swap = m11;
					m11 = m21;
					m21 = swap;
					swap = m12;
					m12 = m22;
					m22 = swap;
				}
			} else {
				if (m12 <= -m22) {
					sign = -sign;
					m21 = -m21;
					m22 = -m22;
				} else {
					swap = m11;
					m11 = -m21;
					m21 = swap;
					swap = m12;
					m12 = -m22;
					m22 = swap;
				}
			}
		} else {
			if (0.0 < m22) {
				if (-m12 <= m22) {
					sign = -sign;
					m11 = -m11;
					m12 = -m12;
				} else {
					swap = -m11;
					m11 = m21;
					m21 = swap;
					swap = -m12;
					m12 = m22;
					m22 = swap;
				}
			} else {
				if (m12 >= m22) {
					m11 = -m11;
					m12 = -m12;
					m21 = -m21;
					m22 = -m22;
					;
				} else {
					sign = -sign;
					swap = -m11;
					m11 = -m21;
					m21 = swap;
					swap = -m12;
					m12 = -m22;
					m22 = swap;
				}
			}
		}
		if (0.0 < m11) {
			if (0.0 < m21) {
				if (m11 <= m21) {
					;
				} else {
					return sign;
				}
			} else {
				return sign;
			}
		} else {
			if (0.0 < m21) {
				return -sign;
			} else {
				if (m11 >= m21) {
					sign = -sign;
					m11 = -m11;
					m21 = -m21;
					;
				} else {
					return -sign;
				}
			}
		}
		while (true) {
			count = count + 1;
			k = Math.floor(m21 / m11);
			m21 = m21 - k * m11;
			m22 = m22 - k * m12;
			if (m22 < 0.0) {
				return -sign;
			}
			if (m22 > m12) {
				return sign;
			}
			if (m11 > m21 + m21) {
				if (m12 < m22 + m22) {
					return sign;
				}
			} else {
				if (m12 > m22 + m22) {
					return -sign;
				} else {
					m21 = m11 - m21;
					m22 = m12 - m22;
					sign = -sign;
				}
			}
			if (m22 == 0.0) {
				if (m21 == 0.0) {
					return 0;
				} else {
					return -sign;
				}
			}
			if (m21 == 0.0) {
				return sign;
			}
			k = Math.floor(m11 / m21);
			m11 = m11 - k * m21;
			m12 = m12 - k * m22;
			if (m12 < 0.0) {
				return sign;
			}
			if (m12 > m22) {
				return -sign;
			}
			if (m21 > m11 + m11) {
				if (m22 < m12 + m12) {
					return -sign;
				}
			} else {
				if (m22 > m12 + m12) {
					return sign;
				} else {
					m11 = m21 - m11;
					m12 = m22 - m12;
					sign = -sign;
				}
			}
			if (m12 == 0.0) {
				if (m11 == 0.0) {
					return 0;
				} else {
					return sign;
				}
			}
			if (m11 == 0.0) {
				return -sign;
			}
		}
	}

	/**
	 * Transpose matrix.
	 */
	public void transpose() {
		final double tmp = m12;
		m12 = m21;
		m21 = tmp;
	}

	/**
	 * Get the transpose.
	 * 
	 * @return transposed matrix
	 */
	public WB_M22 getTranspose() {
		return new WB_M22(m11, m21, m12, m22);
	}

	/**
	 * Inverse matrix.
	 * 
	 * @return inverse
	 */
	public WB_M22 inverse() {
		final double d = det();
		if (WB_Epsilon.isZero(d)) {
			return null;
		}
		final WB_M22 I = new WB_M22(m22, -m12, -m21, m11);
		I.div(d);
		return I;
	}

	/**
	 * Return matrix as array.
	 * 
	 * @return double[2][2]
	 */
	public double[][] toArray() {
		return new double[][] { { m11, m12 }, { m21, m22 } };
	}
}
