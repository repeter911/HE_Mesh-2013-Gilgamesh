package com.wblut.geom;

/**
 * 
 * Helper class to handle coord arrays
 * 
 */
public class WB_Coord {
	private static final int X = 0;
	private static final int Y = 1;
	private static final int Z = 2;
	private static final int XY = 0;
	private static final int YZ = 1;
	private static final int XZ = 2;
	private static int mode2d = XY;
	protected static int X2d = X;
	protected static int Y2d = Y;

	public static void setXY() {
		mode2d = XY;
		X2d = X;
		Y2d = Y;
	}

	public static void setYZ() {
		mode2d = YZ;
		X2d = Y;
		Y2d = Z;
	}

	public static void setXZ() {
		mode2d = XZ;
		X2d = X;
		Y2d = Z;
	}

	public static double[] add(double[] p, double[] q) {
		return new double[] { p[0] + q[0], p[1] + q[1], p[2] + q[2] };
	}

	public static void addSelf(double[] p, double[] q) {
		p[0] += q[0];
		p[1] += q[1];
		p[2] += q[2];
	}

	public static double[] add2d(double[] p, double[] q) {
		return new double[] { p[X2d] + q[X2d], p[Y2d] + q[Y2d] };
	}

	public static void addSelf2d(double[] p, double[] q) {
		p[X2d] += q[X2d];
		p[Y2d] += q[Y2d];
	}

	public static double[] add4d(double[] p, double[] q) {
		return new double[] { p[0] + q[0], p[1] + q[1], p[2] + q[2],
				p[3] + q[3] };
	}

	public static void addSelf4d(double[] p, double[] q) {
		p[0] += q[0];
		p[1] += q[1];
		p[2] += q[2];
		p[3] += q[3];
	}

	public static double[] add(double[] p, double f, double[] q) {
		return new double[] { p[0] + f * q[0], p[1] + f * q[1], p[2] + f * q[2] };
	}

	public static void addSelf(double[] p, double f, double[] q) {
		p[0] += f * q[0];
		p[1] += f * q[1];
		p[2] += f * q[2];
	}

	public static double[] add2d(double[] p, double f, double[] q) {
		return new double[] { p[X2d] + f * q[X2d], p[Y2d] + f * q[Y2d] };
	}

	public static void addSelf2d(double[] p, double f, double[] q) {
		p[X2d] += f * q[X2d];
		p[Y2d] += f * q[Y2d];
	}

	public static double[] add4d(double[] p, double f, double[] q) {
		return new double[] { p[0] + f * q[0], p[1] + f * q[1],
				p[2] + f * q[2], p[3] + f * q[3] };
	}

	public static void addSelf4d(double[] p, double f, double[] q) {
		p[0] += f * q[0];
		p[1] += f * q[1];
		p[2] += f * q[2];
		p[3] += f * q[3];
	}

	public static double[] add(double f, double[] p, double g, double[] q) {
		return new double[] { f * p[0] + g * q[0], f * p[1] + g * q[1],
				f * p[2] + g * q[2] };
	}

	public static void addSelf(double f, double[] p, double g, double[] q) {
		p[0] *= f;
		p[1] *= f;
		p[2] *= f;
		p[0] += g * q[0];
		p[1] += g * q[1];
		p[2] += g * q[2];
	}

	public static double[] add2d(double f, double[] p, double g, double[] q) {
		return new double[] { f * p[X2d] + g * q[X2d], f * p[Y2d] + g * q[Y2d] };
	}

	public static void addSelf2d(double f, double[] p, double g, double[] q) {
		p[X2d] *= f;
		p[Y2d] *= f;
		p[X2d] += g * q[X2d];
		p[Y2d] += g * q[Y2d];
	}

	public static double[] add4d(double f, double[] p, double g, double[] q) {
		return new double[] { f * p[0] + g * q[0], f * p[1] + g * q[1],
				f * p[2] + g * q[2], f * p[3] + g * q[3] };
	}

	public static void addSelf4d(double f, double[] p, double g, double[] q) {
		p[0] *= f;
		p[1] *= f;
		p[2] *= f;
		p[3] *= f;
		p[0] += g * q[0];
		p[1] += g * q[1];
		p[2] += g * q[2];
		p[3] += g * q[3];
	}

	public static double[] sub(double[] p, double[] q) {
		return new double[] { p[0] - q[0], p[1] - q[1], p[2] - q[2] };
	}

	public static void subSelf(double[] p, double[] q) {
		p[0] -= q[0];
		p[1] -= q[1];
		p[2] -= q[2];
	}

	public static double[] sub2d(double[] p, double[] q) {
		return new double[] { p[X2d] - q[X2d], p[Y2d] - q[Y2d] };
	}

	public static void subSelf2d(double[] p, double[] q) {
		p[X2d] -= q[X2d];
		p[Y2d] -= q[Y2d];
	}

	public static double[] sub4d(double[] p, double[] q) {
		return new double[] { p[0] - q[0], p[1] - q[1], p[2] - q[2],
				p[3] - q[3] };
	}

	public static void subSelf4d(double[] p, double[] q) {
		p[0] -= q[0];
		p[1] -= q[1];
		p[2] -= q[2];
		p[3] -= q[3];
	}

	public static double[] mul(double[] p, double f) {
		return new double[] { f * p[0], f * p[1], f * p[2] };
	}

	public static void mulSelf(double[] p, double f) {
		p[0] *= f;
		p[1] *= f;
		p[2] *= f;
	}

	public static double[] mul2d(double[] p, double f) {
		return new double[] { f * p[X2d], f * p[Y2d] };
	}

	public static void mulSelf2d(double[] p, double f) {
		p[X2d] *= f;
		p[Y2d] *= f;
	}

	public static double[] mul4d(double[] p, double f) {
		return new double[] { f * p[0], f * p[1], f * p[2], f * p[3] };
	}

	public static void mulSelf4d(double[] p, double f) {
		p[0] *= f;
		p[1] *= f;
		p[2] *= f;
		p[3] *= f;
	}

	public static double[] div(double[] p, double f) {
		double invf = 1.0 / f;
		return new double[] { invf * p[0], invf * p[1], invf * p[2] };
	}

	public static void divSelf(double[] p, double f) {
		double invf = 1.0 / f;
		p[0] *= invf;
		p[1] *= invf;
		p[2] *= invf;
	}

	public static double[] div2d(double[] p, double f) {
		double invf = 1.0 / f;
		return new double[] { invf * p[X2d], invf * p[Y2d] };
	}

	public static void divSelf2d(double[] p, double f) {
		double invf = 1.0 / f;
		p[X2d] *= invf;
		p[Y2d] *= invf;
	}

	public static double[] div4d(double[] p, double f) {
		double invf = 1.0 / f;
		return new double[] { invf * p[0], invf * p[1], invf * p[2],
				invf * p[3] };
	}

	public static void divSelf4d(double[] p, double f) {
		double invf = 1.0 / f;
		p[0] *= invf;
		p[1] *= invf;
		p[2] *= invf;
		p[3] *= invf;
	}

	public static double[] scale(double[] p, double[] q) {
		return new double[] { p[0] * q[0], p[1] * q[1], p[2] * q[2] };
	}

	public static void scaleSelf(double[] p, double[] q) {
		p[0] *= q[0];
		p[1] *= q[1];
		p[2] *= q[2];
	}

	public static double[] scale2d(double[] p, double[] q) {
		return new double[] { p[X2d] * q[0], p[Y2d] * q[1] };
	}

	public static void scaleSelf2d(double[] p, double[] q) {
		p[X2d] *= q[0];
		p[Y2d] *= q[1];
	}

	public static double[] scale4d(double[] p, double[] q) {
		return new double[] { p[0] * q[0], p[1] * q[1], p[2] * q[2],
				p[3] * q[3] };
	}

	public static void scaleSelf4d(double[] p, double[] q) {
		p[0] *= q[0];
		p[1] *= q[1];
		p[2] *= q[2];
		p[3] *= q[3];
	}

}
