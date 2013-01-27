package com.wblut.geom;

import java.util.Comparator;

public class WB_Point implements Comparable {
	public double[] coords;

	public static WB_Point ZERO() {
		return new WB_Point();
	}

	public static WB_Point X() {
		return new WB_Point(1, 0, 0);
	}

	public static WB_Point Y() {
		return new WB_Point(0, 1, 0);
	}

	public static WB_Point Z() {
		return new WB_Point(0, 0, 1);
	}

	public WB_Point() {
		coords = new double[3];

	}

	public WB_Point(double x, double y) {
		coords = new double[3];
		set(x, y);
	}

	public WB_Point(double x, double y, double z) {
		coords = new double[3];
		set(x, y, z);
	}

	public WB_Point(double[] v) {
		coords = new double[3];
		set(v);
	}

	public WB_Point(WB_Point p) {
		coords = new double[3];
		set(p);
	}

	public void set(double x, double y) {
		set2d(0, x);
		set2d(1, y);

	}

	public void set(double x, double y, double z) {
		coords[0] = x;
		coords[1] = y;
		coords[2] = z;

	}

	public void set(double[] v) {
		for (int i = 0; i < v.length; i++) {
			coords[i] = v[i];
		}

	}

	public void set(WB_Point p) {
		set(p.coords);
	}

	public void set(int i, double v) {
		coords[i] = v;
	}

	public WB_Point get() {
		return new WB_Point(this);
	}

	public double get(int i) {
		return coords[i];
	}

	public double x() {
		return coords[0];
	}

	public double y() {
		return coords[1];
	}

	public double z() {
		return coords[2];
	}

	public float xf() {
		return (float) coords[0];
	}

	public float yf() {
		return (float) coords[1];
	}

	public float zf() {
		return (float) coords[2];
	}

	public int xi() {
		return (int) coords[0];
	}

	public int yi() {
		return (int) coords[1];
	}

	public int zi() {
		return (int) coords[2];
	}

	public void set2d(int i, double v) {
		if (i == 0) {
			coords[WB_Coord.X2d] = v;
		} else if (i == 1) {
			coords[WB_Coord.Y2d] = v;
		}
	}

	public double get2d(int i) {
		if (i == 0) {
			return coords[WB_Coord.X2d];
		} else if (i == 1) {
			return coords[WB_Coord.Y2d];
		} else {
			return Double.NaN;
		}
	}

	public double x2d() {
		return coords[WB_Coord.X2d];
	}

	public double y2d() {
		return coords[WB_Coord.Y2d];
	}

	public float xf2d() {
		return (float) coords[WB_Coord.X2d];
	}

	public float yf2d() {
		return (float) coords[WB_Coord.Y2d];
	}

	public int xi2d() {
		return (int) coords[WB_Coord.X2d];
	}

	public int yi2d() {
		return (int) coords[WB_Coord.Y2d];
	}

	public double[] toArray2d() {
		return new double[] { coords[WB_Coord.X2d], coords[WB_Coord.Y2d] };
	}

	public double[] toArray() {
		return new double[] { coords[0], coords[1], coords[2] };
	}

	private static WB_Point pointFromArray(double[] coords) {
		WB_Point result = new WB_Point();
		result.coords = coords;
		return result;
	}

	public WB_Point add(WB_Point p) {
		return pointFromArray(WB_Coord.add(coords, p.coords));
	}

	public WB_Point addSelf(WB_Point p) {
		WB_Coord.addSelf(coords, p.coords);

		return this;
	}

	public WB_Point add(double f, WB_Point p) {
		return pointFromArray(WB_Coord.add(coords, f, p.coords));
	}

	public WB_Point addSelf(double f, WB_Point p) {
		WB_Coord.addSelf(coords, f, p.coords);

		return this;
	}

	public WB_Point add(double f, double g, WB_Point p) {
		return pointFromArray(WB_Coord.add(f, coords, g, p.coords));
	}

	public WB_Point addSelf(double f, double g, WB_Point p) {
		WB_Coord.addSelf(f, coords, f, p.coords);

		return this;
	}

	public WB_Point sub(WB_Point p) {
		return pointFromArray(WB_Coord.sub(coords, p.coords));
	}

	public WB_Vector subToVector(WB_Point p) {
		return WB_Vector.vectorFromArray(WB_Coord.sub(coords, p.coords));
	}

	public WB_Point subSelf(WB_Point p) {
		WB_Coord.subSelf(coords, p.coords);

		return this;
	}

	public WB_Point mul(double f) {
		return pointFromArray(WB_Coord.mul(coords, f));
	}

	public WB_Point mulSelf(double f) {
		WB_Coord.mulSelf(coords, f);

		return this;
	}

	public WB_Point div(double f) {
		return pointFromArray(WB_Coord.div(coords, f));
	}

	public WB_Point divSelf(double f) {
		WB_Coord.divSelf(coords, f);

		return this;
	}

	public WB_Point scale(double[] f) {
		return pointFromArray(WB_Coord.scale(coords, f));
	}

	public WB_Point scaleSelf(double[] f) {
		WB_Coord.scaleSelf(coords, f);
		return this;
	}

	public double length() {
		return WB_Coord.length(coords);
	}

	public double sqLength() {
		return WB_Coord.sqLength(coords);
	}

	public double length2d() {
		return WB_Coord.length2d(coords);
	}

	public double sqLength2d() {
		return WB_Coord.sqLength2d(coords);
	}

	public double distance(WB_Point p) {
		return WB_Coord.distance(coords, p.coords);
	}

	public double sqDistance(WB_Point p) {
		return WB_Coord.sqDistance(coords, p.coords);
	}

	public double distance2d(WB_Point p) {
		return WB_Coord.distance2d(coords, p.coords);
	}

	public double sqDistance2d(WB_Point p) {
		return WB_Coord.sqDistance2d(coords, p.coords);
	}

	public int compareTo(Object o) {
		if (!(o instanceof com.wblut.geom.WB_Point)) {
			throw new IllegalArgumentException(
					"Can't compare a WB_Point to this object.");
		}
		WB_Point t = (WB_Point) o;

		for (int i = 0; i < 3; i++) {
			if (coords[i] < t.coords[i]) {
				return -1;
			} else if (coords[i] > t.coords[i]) {
				return 1;
			}
		}
		return 0;
	}

	public void rotateAboutOrigin(final double angle, final double x,
			final double y, final double z) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotate(angle, new WB_Vector(x, y, z));
		raa.applySelfAsPoint(this);
	}

	public void rotateAboutOrigin(final double angle, final WB_Vector a) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotate(angle, a);
		raa.applySelfAsPoint(this);
	}

	public void rotateAboutAxis(final double angle, final double ox,
			final double oy, final double oz, final double ax, final double ay,
			final double az) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, new WB_Point(ox, oy, oz), new WB_Vector(
				ax, ay, az));
		raa.applySelfAsPoint(this);
	}

	public void rotateAboutAxis(final double angle, final WB_Point p,
			final WB_Vector a) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, p, a);
		raa.applySelfAsPoint(this);
	}

	public void rotateAboutAxis(final double angle, final WB_Point p1,
			final WB_Point p2) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotateAboutAxis(angle, p1, p2.subToVector(p1));
		raa.applySelfAsPoint(this);
	}

	public static class WB_Comparator3d implements Comparator<WB_Point> {

		public static int compare(double a, double b) {
			if (a < b)
				return -1;
			if (a > b)
				return 1;

			if (Double.isNaN(a)) {
				if (Double.isNaN(b))
					return 0;
				return -1;
			}

			if (Double.isNaN(b))
				return 1;
			return 0;
		}

		public static final int XYZ = 0;
		public static final int XZY = 1;
		public static final int YXZ = 2;
		public static final int YZX = 3;
		public static final int ZXY = 4;
		public static final int ZYX = 5;
		private int I0, I1, I2;
		private int mode;

		public WB_Comparator3d() {
			setMode(XYZ);
		}

		private void setMode(int m) {
			mode = m;
			setIndices();
		}

		private void setIndices() {
			switch (mode) {
			case XYZ:
				I0 = 0;
				I1 = 1;
				I2 = 2;
				break;
			case XZY:
				I0 = 0;
				I1 = 2;
				I2 = 1;
				break;
			case YXZ:
				I0 = 1;
				I1 = 0;
				I2 = 2;
				break;
			case YZX:
				I0 = 1;
				I1 = 2;
				I2 = 0;
				break;
			case ZXY:
				I0 = 2;
				I1 = 0;
				I2 = 1;
				break;
			case ZYX:
				I0 = 2;
				I1 = 1;
				I2 = 0;
				break;
			default:
				I0 = 0;
				I1 = 1;
				I2 = 2;
				break;

			}

		}

		public WB_Comparator3d(int mode) {
			setMode(mode);
		}

		public int compare(WB_Point c1, WB_Point c2) {
			int compX = compare(c1.coords[I0], c2.coords[I0]);
			if (compX != 0)
				return compX;
			int compY = compare(c1.coords[I1], c2.coords[I1]);
			if (compY != 0)
				return compY;
			return compare(c1.coords[I2], c2.coords[I2]);

		}
	}

	public static class WB_Comparator2d implements Comparator<WB_Point> {

		public static int compare(double a, double b) {
			if (a < b)
				return -1;
			if (a > b)
				return 1;

			if (Double.isNaN(a)) {
				if (Double.isNaN(b))
					return 0;
				return -1;
			}

			if (Double.isNaN(b))
				return 1;
			return 0;
		}

		public static final int XY = 0;
		public static final int YX = 1;

		private int I0, I1;
		private int mode;

		public WB_Comparator2d() {
			setMode(XY);
		}

		private void setMode(int m) {
			mode = m;
			setIndices();
		}

		private void setIndices() {
			switch (mode) {
			case XY:
				I0 = WB_Coord.X2d;
				I1 = WB_Coord.Y2d;
				break;
			case YX:
				I0 = WB_Coord.Y2d;
				I1 = WB_Coord.X2d;
				break;
			default:
				I0 = WB_Coord.X2d;
				I1 = WB_Coord.Y2d;
				break;
			}

		}

		public WB_Comparator2d(int mode) {
			setMode(mode);
		}

		public int compare(WB_Point c1, WB_Point c2) {
			int compX = compare(c1.coords[I0], c2.coords[I0]);
			if (compX != 0)
				return compX;
			return compare(c1.coords[I1], c2.coords[I1]);

		}
	}

}
