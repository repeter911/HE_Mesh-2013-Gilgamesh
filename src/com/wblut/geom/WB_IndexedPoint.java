package com.wblut.geom;

public class WB_IndexedPoint extends WB_Point {
	public int index;

	public WB_IndexedPoint() {
		super();
		index = -1;

	}

	public WB_IndexedPoint(double x, double y, int i) {
		super(x, y);
		index = i;
	}

	public WB_IndexedPoint(double x, double y, double z, int i) {
		super(x, y, z);
		index = i;

	}

	public WB_IndexedPoint(double[] v, int i) {
		super(v);
		index = i;
	}

	public WB_IndexedPoint(WB_Point p, int i) {
		super(p);
		index = i;
	}

	public int index() {
		return index;
	}

	public String toString() {
		return new String("WB_Point [" + coords[0] + ", " + coords[1] + ", "
				+ coords[2] + "], index=" + index);
	}
}
