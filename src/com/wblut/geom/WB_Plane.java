package com.wblut.geom;

/**
 * 3D plane.
 */
public class WB_Plane {
	public static final WB_Plane XY() {
		return new WB_Plane(0, 0, 0, 0, 0, 1);
	}

	public static final WB_Plane XZ() {
		return new WB_Plane(0, 0, 0, 0, 1, 0);
	}

	public static final WB_Plane YZ() {
		return new WB_Plane(0, 0, 0, 1, 0, 0);
	}

	/** Plane normal. */
	private WB_Vector n;
	/** Origin. */
	private WB_Point origin;
	/**
	 * d-parameter: p.n = d with p point on plane, n the normal and . the dot
	 * product.
	 */
	private double d;

	/**
	 * Instantiates a new WB_Plane.
	 * 
	 * @param p1
	 *            first point on plane
	 * @param p2
	 *            second point on plane
	 * @param p3
	 *            third point on plane
	 */
	public WB_Plane(final WB_Point p1, final WB_Point p2, final WB_Point p3) {
		final WB_Vector v21 = p2.subToVector(p1);
		final WB_Vector v31 = p3.subToVector(p1);
		n = new WB_Vector(v21.cross(v31));
		n.normalize();
		d = n.dot(p1);
		origin = p1.get();
	}

	/**
	 * Set plane.
	 * 
	 * @param p1
	 *            first point on plane
	 * @param p2
	 *            second point on plane
	 * @param p3
	 *            third point on plane
	 */
	public void set(final WB_Point p1, final WB_Point p2, final WB_Point p3) {
		p1.get();
		final WB_Vector v21 = p2.subToVector(p1);
		final WB_Vector v31 = p3.subToVector(p1);
		n = v21.cross(v31);
		n.normalize();
		d = n.dot(p1);
		origin = p1.get();
	}

	/**
	 * Instantiates a new WB_Plane.
	 * 
	 * @param o
	 *            origin
	 * @param n
	 *            normal
	 */
	public WB_Plane(final WB_Point o, final WB_Vector n) {
		origin = o.get();
		this.n = n.get();
		n.normalize();
		d = this.n.dot(origin);
	}

	/**
	 * Set plane.
	 * 
	 * @param o
	 *            origin
	 * @param n
	 *            normal
	 */
	public void set(final WB_Point o, final WB_Vector n) {
		origin = o.get();
		this.n = n.get();
		n.normalize();
		d = this.n.dot(origin);
	}

	/**
	 * Instantiates a new WB_Plane.
	 * 
	 * @param ox
	 *            x-coordinate of origin
	 * @param oy
	 *            y-coordinate of origin
	 * @param oz
	 *            z-coordinate of origin
	 * @param nx
	 *            x-coordinate of normal
	 * @param ny
	 *            y-coordinate of normal
	 * @param nz
	 *            z-coordinate of normal
	 */
	public WB_Plane(final double ox, final double oy, final double oz,
			final double nx, final double ny, final double nz) {
		origin = new WB_Point(ox, oy, oz);
		n = new WB_Vector(nx, ny, nz);
		n.normalize();
		d = n.dot(origin);
	}

	/**
	 * Set plane.
	 * 
	 * @param ox
	 *            x-coordinate of origin
	 * @param oy
	 *            y-coordinate of origin
	 * @param oz
	 *            z-coordinate of origin
	 * @param nx
	 *            x-coordinate of normal
	 * @param ny
	 *            y-coordinate of normal
	 * @param nz
	 *            z-coordinate of normal
	 */
	public void set(final double ox, final double oy, final double oz,
			final double nx, final double ny, final double nz) {
		origin = new WB_Point(ox, oy, oz);
		n = new WB_Vector(nx, ny, nz);
		n.normalize();
		d = n.dot(origin);
	}

	/**
	 * Instantiates a new WB_Plane.
	 * 
	 * @param n
	 *            normal
	 * @param d
	 *            d-parameter: p.n=d, for any point p on the plane
	 */
	public WB_Plane(final WB_Vector n, final double d) {
		this.n = new WB_Vector(n);
		n.normalize();
		this.d = d;
		origin = new WB_Point(n);
		origin.mul(d);
	}

	/**
	 * Set plane.
	 * 
	 * @param n
	 *            normal
	 * @param d
	 *            d-parameter
	 */
	public void set(final WB_Vector n, final double d) {
		this.n = new WB_Vector(n);
		n.normalize();
		this.d = d;
		origin = new WB_Point(n);
		origin.mul(d);
	}

	/**
	 * Get copy.
	 * 
	 * @return copy
	 */
	public WB_Plane get() {
		return new WB_Plane(origin, n);
	}

	/**
	 * Get plane normal.
	 * 
	 * @return copy of plane normal
	 */
	public WB_Vector getNormal() {
		return n.get();
	}

	/**
	 * Get d.
	 * 
	 * @return d
	 */
	public double d() {
		return d;
	}

	/**
	 * Get origin.
	 * 
	 * @return origin, if plane was not created using points then this returns
	 *         the projection of (0,0,0) on the plane
	 */
	public WB_Point getOrigin() {
		return origin;
	}

	/**
	 * Flip normal.
	 */
	public void flipNormal() {
		n.mul(-1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Plane o: [" + origin + "] n: [" + n + "] d: [" + d + "]";
	}

	public static WB_Classify classifyPointFast(final WB_Point a,
			final WB_Point b, final WB_Point c, final WB_Point p) {

		double signp = (p.subToVector(a)).dot((b.subToVector(a)).cross(c
				.subToVector(a)));
		if (signp == 0)
			return WB_Classify.COPLANAR;
		if (signp > 0)
			return WB_Classify.FRONT;
		return WB_Classify.BACK;
	}

	public static WB_Classify classifyPoint(final WB_Point a, final WB_Point b,
			final WB_Point c, final WB_Point p) {

		WB_Predicates predicates = new WB_Predicates();
		double signp = predicates.orientTetra(a.coords, b.coords, c.coords,
				p.coords);
		if (signp == 0)
			return WB_Classify.COPLANAR;
		if (signp > 0)
			return WB_Classify.FRONT;
		return WB_Classify.BACK;
	}

	public static WB_Classify classifyPointsFast(final WB_Point p,
			final WB_Point q, final WB_Point a, final WB_Point b,
			final WB_Point c) {
		final double signp = (p.subToVector(a)).dot((b.subToVector(a)).cross(c
				.subToVector(a)));
		final double signq = (q.subToVector(a)).dot((b.subToVector(a)).cross(c
				.subToVector(a)));
		if (signp == 0 && signq == 0) {
			return WB_Classify.COPLANAR;
		}
		if ((signp > 0 && signq < 0) || (signp < 0 && signq > 0)) {
			if (signp == 0 || signq == 0) {
				return WB_Classify.DIFF;
			}
			return WB_Classify.DIFFEXCL;
		}
		if ((signp > 0 && signq > 0) || (signp < 0 && signq < 0)) {
			if (signp == 0 || signq == 0) {
				return WB_Classify.SAME;
			}
			return WB_Classify.SAMEEXCL;
		}
		return null;

	}

	public static WB_Classify classifyPoints(final WB_Point p,
			final WB_Point q, final WB_Point a, final WB_Point b,
			final WB_Point c) {
		WB_Predicates predicates = new WB_Predicates();
		return predicates.diffsides(a.coords, b.coords, c.coords, p.coords,
				q.coords);
	}
}
