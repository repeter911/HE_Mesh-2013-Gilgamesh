package com.wblut.geom;

public class WB_Vector extends WB_Point {

	public WB_Vector() {
		_coords = new double[4];
		_coords[3] = 0;
	}

	public WB_Vector(double x, double y) {
		_coords = new double[4];
		set(x, y);
	}

	public WB_Vector(double x, double y, double z) {
		_coords = new double[4];
		set(x, y, z);
	}

	public WB_Vector(double[] v) {
		_coords = new double[4];
		set(v);
	}

	public WB_Vector(WB_Vector p) {
		_coords = new double[4];
		set(p);
	}

	public void set(double x, double y) {
		set2d(0, x);
		set2d(1, y);
		_coords[3] = 0;
	}

	public void set(double x, double y, double z) {
		_coords[0] = x;
		_coords[1] = y;
		_coords[2] = z;
		_coords[3] = 0;

	}

	public void set(double[] v) {
		for (int i = 0; i < v.length; i++) {
			_coords[i] = v[i];
		}
		_coords[3] = 0;
	}

	public void set(WB_Vector p) {
		set(p._coords);
	}

	public void set(int i, double v) {
		_coords[i] = v;
	}

	public WB_Vector get() {
		return new WB_Vector(this);
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

	protected static WB_Vector vectorFromArray(double[] coords) {
		WB_Vector result = new WB_Vector();
		result._coords = coords;
		result._coords[3] = 0;
		return result;
	}

	public WB_Vector add(WB_Point p) {
		return vectorFromArray(WB_Coord.add(_coords, p._coords));
	}

	public WB_Vector addSelf(WB_Point p) {
		WB_Coord.addSelf(_coords, p._coords);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector add(double f, WB_Point p) {
		return vectorFromArray(WB_Coord.add(_coords, f, p._coords));
	}

	public WB_Vector addSelf(double f, WB_Point p) {
		WB_Coord.addSelf(_coords, f, p._coords);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector add(double f, double g, WB_Point p) {
		return vectorFromArray(WB_Coord.add(f, _coords, g, p._coords));
	}

	public WB_Vector addSelf(double f, double g, WB_Point p) {
		WB_Coord.addSelf(f, _coords, f, p._coords);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector sub(WB_Point p) {
		return vectorFromArray(WB_Coord.sub(_coords, p._coords));
	}

	public WB_Vector subSelf(WB_Point p) {
		WB_Coord.subSelf(_coords, p._coords);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector mul(double f) {
		return vectorFromArray(WB_Coord.mul(_coords, f));
	}

	public WB_Vector mulSelf(double f) {
		WB_Coord.mulSelf(_coords, f);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector div(double f) {
		return vectorFromArray(WB_Coord.div(_coords, f));
	}

	public WB_Vector divSelf(double f) {
		WB_Coord.divSelf(_coords, f);
		_coords[3] = 0;
		return this;
	}

	public WB_Vector scale(double[] f) {
		return vectorFromArray(WB_Coord.scale(_coords, f));
	}

	public WB_Vector scaleSelf(double[] f) {
		WB_Coord.scaleSelf(_coords, f);
		_coords[3] = 0;
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

	public double normalize() {
		double d = length();
		divSelf(d);
		return d;
	}

	public WB_Vector norm() {
		double d = length();
		return div(d);
	}

}
