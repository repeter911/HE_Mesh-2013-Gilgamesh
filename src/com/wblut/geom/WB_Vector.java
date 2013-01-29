package com.wblut.geom;

import com.wblut.math.WB_M33;

public class WB_Vector extends WB_Point {

	public static WB_Vector ZERO() {
		return new WB_Vector();
	}

	public static WB_Vector X() {
		return new WB_Vector(1, 0, 0);
	}

	public static WB_Vector Y() {
		return new WB_Vector(0, 1, 0);
	}

	public static WB_Vector Z() {
		return new WB_Vector(0, 0, 1);
	}

	public WB_Vector() {
		super();
	}

	public WB_Vector(double x, double y) {
		super(x, y);
	}

	public WB_Vector(double x, double y, double z) {
		super(x, y, z);
	}

	public WB_Vector(double[] v) {

		super(v);
	}

	public WB_Vector(WB_Point p) {
		super(p);
	}

	public WB_Vector get() {
		return new WB_Vector(this);
	}

	protected static WB_Vector vectorFromArray(double[] coords) {
		WB_Vector result = new WB_Vector();
		result.coords = coords;
		return result;
	}

	public WB_Vector add(WB_Point p) {
		return vectorFromArray(WB_Coord.add(coords, p.coords));
	}

	public WB_Vector addSelf(WB_Point p) {
		WB_Coord.addSelf(coords, p.coords);
		return this;
	}

	public WB_Vector add(double f, WB_Point p) {
		return vectorFromArray(WB_Coord.add(coords, f, p.coords));
	}

	public WB_Vector addSelf(double f, WB_Point p) {
		WB_Coord.addSelf(coords, f, p.coords);
		return this;
	}

	public WB_Vector add(double f, double g, WB_Point p) {
		return vectorFromArray(WB_Coord.add(f, coords, g, p.coords));
	}

	public WB_Vector addSelf(double f, double g, WB_Point p) {
		WB_Coord.addSelf(f, coords, f, p.coords);
		return this;
	}

	public WB_Vector sub(WB_Point p) {
		return vectorFromArray(WB_Coord.sub(coords, p.coords));
	}

	public WB_Vector subSelf(WB_Point p) {
		WB_Coord.subSelf(coords, p.coords);
		return this;
	}

	public WB_Vector mul(double f) {
		return vectorFromArray(WB_Coord.mul(coords, f));
	}

	public WB_Vector mulSelf(double f) {
		WB_Coord.mulSelf(coords, f);
		return this;
	}

	public WB_Vector div(double f) {
		return vectorFromArray(WB_Coord.div(coords, f));
	}

	public WB_Vector divSelf(double f) {
		WB_Coord.divSelf(coords, f);
		return this;
	}

	public WB_Vector scale(double[] f) {
		return vectorFromArray(WB_Coord.scale(coords, f));
	}

	public WB_Vector scaleSelf(double[] f) {
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

	public WB_Vector normalize() {
		double d = length();
		return divSelf(d);
	}

	public WB_Vector getUnitVector() {
		double d = length();
		return div(d);
	}

	public double dot(WB_Point v) {
		return WB_Coord.dot(coords, v.coords);
	}

	public double dot2d(WB_Point v) {
		return WB_Coord.dot2d(coords, v.coords);
	}

	public WB_Vector cross(WB_Point v) {
		return vectorFromArray(WB_Coord.cross(coords, v.coords));
	}

	public WB_Vector crossSelf(WB_Point v) {
		WB_Coord.cross(coords, v.coords);
		return this;
	}

	public int compareTo(Object o) {
		if (!(o instanceof com.wblut.geom.WB_Vector)) {
			throw new IllegalArgumentException(
					"Can't compare a WB_Vector to this object.");
		}
		WB_Vector t = (WB_Vector) o;

		for (int i = 0; i < 3; i++) {
			if (coords[i] < t.coords[i]) {
				return -1;
			} else if (coords[i] > t.coords[i]) {
				return 1;
			}
		}
		return 0;
	}

	public void rotate(final double angle, final double x, final double y,
			final double z) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotate(angle, new WB_Vector(x, y, z));
		raa.applySelfAsVector(this);
	}

	public void rotate(final double angle, final WB_Vector a) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotate(angle, a);
		raa.applySelfAsVector(this);
	}

	public void rotate(final double angle, final WB_Point p1, final WB_Point p2) {
		final WB_Transform raa = new WB_Transform();
		raa.addRotate(angle, p2.subToVector(p1));
		raa.applySelfAsVector(this);
	}

	public WB_M33 tensor(WB_Point v) {
		return WB_Coord.tensor(coords, v.coords);
	}

	public String toString() {
		return new String("WB_Vector [" + coords[0] + ", " + coords[1] + ", "
				+ coords[2] + "]");
	}
}
