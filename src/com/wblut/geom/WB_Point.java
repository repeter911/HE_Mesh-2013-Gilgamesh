package com.wblut.geom;

import java.util.Comparator;

public class WB_Point implements Comparable {
	protected double[] _coords;

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
		_coords = new double[4];
		_coords[3] = 1;
	}

	public WB_Point(double x, double y) {
		_coords = new double[4];
		set(x, y);
	}

	public WB_Point(double x, double y, double z) {
		_coords = new double[4];
		set(x, y, z);
	}

	public WB_Point(double[] v) {
		_coords = new double[4];
		set(v);
	}

	public WB_Point(WB_Point p) {
		_coords = new double[4];
		set(p);
	}

	public void set(double x, double y) {
		set2d(0, x);
		set2d(1, y);
		_coords[3] = 1;
	}

	public void set(double x, double y, double z) {
		_coords[0] = x;
		_coords[1] = y;
		_coords[2] = z;
		_coords[3] = 1;
	}

	public void set(double[] v) {
		for (int i = 0; i < v.length; i++) {
			_coords[i] = v[i];
		}
		_coords[3] = 1;
	}

	public void set(WB_Point p) {
		set(p._coords);
	}

	public void set(int i, double v) {
		_coords[i] = v;
	}

	public WB_Point get() {
		return new WB_Point(this);
	}

	public double get(int i) {
		return _coords[i];
	}

	public double x() {
		return _coords[0];
	}

	public double y() {
		return _coords[1];
	}

	public double z() {
		return _coords[2];
	}

	public double w() {
		return _coords[3];
	}

	public float xf() {
		return (float) _coords[0];
	}

	public float yf() {
		return (float) _coords[1];
	}

	public float zf() {
		return (float) _coords[2];
	}

	public float wf() {
		return (float) _coords[3];
	}

	public int xi() {
		return (int) _coords[0];
	}

	public int yi() {
		return (int) _coords[1];
	}

	public int zi() {
		return (int) _coords[2];
	}

	public int wi() {
		return (int) _coords[3];
	}

	public void set2d(int i, double v) {
		if (i == 0) {
			_coords[WB_Coord.X2d] = v;
		} else if (i == 1) {
			_coords[WB_Coord.Y2d] = v;
		}
	}

	public double get2d(int i) {
		if (i == 0) {
			return _coords[WB_Coord.X2d];
		} else if (i == 1) {
			return _coords[WB_Coord.Y2d];
		} else {
			return Double.NaN;
		}
	}

	public double x2d() {
		return _coords[WB_Coord.X2d];
	}

	public double y2d() {
		return _coords[WB_Coord.Y2d];
	}

	public float xf2d() {
		return (float) _coords[WB_Coord.X2d];
	}

	public float yf2d() {
		return (float) _coords[WB_Coord.Y2d];
	}

	public int xi2d() {
		return (int) _coords[WB_Coord.X2d];
	}

	public int yi2d() {
		return (int) _coords[WB_Coord.Y2d];
	}

	public double[] toArray2d() {
		return new double[] { _coords[WB_Coord.X2d], _coords[WB_Coord.Y2d] };
	}

	public double[] toArray3d() {
		return new double[] { _coords[0], _coords[1], _coords[2] };
	}

	public double[] toArray4d() {
		return new double[] { _coords[0], _coords[1], _coords[2], _coords[3] };
	}

	private static WB_Point pointFromArray(double[] coords) {
		WB_Point result = new WB_Point();
		result._coords = coords;
		result._coords[3] = 1;
		return result;
	}

	public WB_Point add(WB_Point p) {
		return pointFromArray(WB_Coord.add(_coords, p._coords));
	}

	public WB_Point addSelf(WB_Point p) {
		WB_Coord.addSelf(_coords, p._coords);
		_coords[3] = 1;
		return this;
	}

	public WB_Point add(double f, WB_Point p) {
		return pointFromArray(WB_Coord.add(_coords, f, p._coords));
	}

	public WB_Point addSelf(double f, WB_Point p) {
		WB_Coord.addSelf(_coords, f, p._coords);
		_coords[3] = 1;
		return this;
	}

	public WB_Point add(double f, double g, WB_Point p) {
		return pointFromArray(WB_Coord.add(f, _coords, g, p._coords));
	}

	public WB_Point addSelf(double f, double g, WB_Point p) {
		WB_Coord.addSelf(f, _coords, f, p._coords);
		_coords[3] = 1;
		return this;
	}

	public WB_Point sub(WB_Point p) {
		return pointFromArray(WB_Coord.sub(_coords, p._coords));
	}

	public WB_Vector subToVector(WB_Point p) {
		return WB_Vector.vectorFromArray(WB_Coord.sub(_coords, p._coords));
	}

	public WB_Point subSelf(WB_Point p) {
		WB_Coord.subSelf(_coords, p._coords);
		_coords[3] = 1;
		return this;
	}

	public WB_Point mul(double f) {
		return pointFromArray(WB_Coord.mul(_coords, f));
	}

	public WB_Point mulSelf(double f) {
		WB_Coord.mulSelf(_coords, f);
		_coords[3] = 1;
		return this;
	}

	public WB_Point div(double f) {
		return pointFromArray(WB_Coord.div(_coords, f));
	}

	public WB_Point divSelf(double f) {
		WB_Coord.divSelf(_coords, f);
		_coords[3] = 1;
		return this;
	}

	public WB_Point scale(double[] f) {
		return pointFromArray(WB_Coord.scale(_coords, f));
	}

	public WB_Point scaleSelf(double[] f) {
		WB_Coord.scaleSelf(_coords, f);
		_coords[3] = 1;
		return this;
	}

	public double length() {
		return WB_Coord.length(_coords);
	}

	public double sqLength() {
		return WB_Coord.sqLength(_coords);
	}

	public double length2d() {
		return WB_Coord.length2d(_coords);
	}

	public double sqLength2d() {
		return WB_Coord.sqLength2d(_coords);
	}

	public double distance(WB_Point p) {
		return WB_Coord.distance(_coords, p._coords);
	}

	public double sqDistance(WB_Point p) {
		return WB_Coord.sqDistance(_coords, p._coords);
	}

	public double distance2d(WB_Point p) {
		return WB_Coord.distance2d(_coords, p._coords);
	}

	public double sqDistance2d(WB_Point p) {
		return WB_Coord.sqDistance2d(_coords, p._coords);
	}

	public int compareTo(Object o) {
		if (!(o instanceof com.wblut.geom.WB_Point)) {
			throw new IllegalArgumentException(
					"Can't compare a WB_Point to this object.");
		}
		WB_Point t = (WB_Point) o;

		for (int i = 0; i < 3; i++) {
			if (_coords[i] < t._coords[i]) {
				return -1;
			} else if (_coords[i] > t._coords[i]) {
				return 1;
			}
		}
		return 0;
	}

	public static class WB_Comparator3d implements Comparator {

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

		private static final int XYZ = 0;
		private static final int XZY = 1;
		private static final int YXZ = 2;
		private static final int YZX = 3;
		private static final int ZXY = 4;
		private static final int ZYX = 5;
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

		public int compare(Object o1, Object o2) {
			WB_Point c1 = (WB_Point) o1;
			WB_Point c2 = (WB_Point) o2;
			int compX = compare(c1._coords[I0], c2._coords[I0]);
			if (compX != 0)
				return compX;
			int compY = compare(c1._coords[I1], c2._coords[I1]);
			if (compY != 0)
				return compY;
			return compare(c1._coords[I2], c2._coords[I2]);

		}
	}

	public static class WB_Comparator2d implements Comparator {

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

		private static final int XY = 0;
		private static final int YX = 1;

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

		public int compare(Object o1, Object o2) {
			WB_Point c1 = (WB_Point) o1;
			WB_Point c2 = (WB_Point) o2;
			int compX = compare(c1._coords[I0], c2._coords[I0]);
			if (compX != 0)
				return compX;
			return compare(c1._coords[I1], c2._coords[I1]);

		}
	}

}
