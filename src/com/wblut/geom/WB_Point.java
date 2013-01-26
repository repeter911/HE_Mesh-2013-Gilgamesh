package com.wblut.geom;

public class WB_Point {
	private double[] _coords;

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
		set2d(0, y);
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

	private WB_Point pointFromArray(double[] coords) {
		WB_Point result = new WB_Point();
		result._coords = coords;
		return result;
	}

	public WB_Point add(WB_Point p) {
		return pointFromArray(WB_Coord.add(_coords, p._coords));
	}

	public WB_Point addSelf(WB_Point p) {
		WB_Coord.addSelf(_coords, p._coords);
		return this;
	}

	public WB_Point add(float f, WB_Point p) {
		return pointFromArray(WB_Coord.add(_coords, f, p._coords));
	}

	public WB_Point addSelf(float f, WB_Point p) {
		WB_Coord.addSelf(_coords, f, p._coords);
		return this;
	}

	public WB_Point add(float f, float g, WB_Point p) {
		return pointFromArray(WB_Coord.add(f, _coords, g, p._coords));
	}

	public WB_Point addSelf(float f, float g, WB_Point p) {
		WB_Coord.addSelf(f, _coords, f, p._coords);
		return this;
	}

	public WB_Point sub(WB_Point p) {
		return pointFromArray(WB_Coord.sub(_coords, p._coords));
	}

	public WB_Point subSelf(WB_Point p) {
		WB_Coord.subSelf(_coords, p._coords);
		return this;
	}

	public WB_Point mul(float f) {
		return pointFromArray(WB_Coord.mul(_coords, f));
	}

	public WB_Point mulSelf(float f) {
		WB_Coord.mulSelf(_coords, f);
		return this;
	}

	public WB_Point div(float f) {
		return pointFromArray(WB_Coord.div(_coords, f));
	}

	public WB_Point divSelf(float f) {
		WB_Coord.divSelf(_coords, f);
		return this;
	}

	public WB_Point scale(double[] f) {
		return pointFromArray(WB_Coord.scale(_coords, f));
	}

	public WB_Point scaleSelf(double[] f) {
		WB_Coord.scaleSelf(_coords, f);
		return this;
	}

}
