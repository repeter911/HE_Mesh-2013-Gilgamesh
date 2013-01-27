/*
 * Copyright (c) 2010, Frederik Vanhoutte This library is free software; you can
 * redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 * http://creativecommons.org/licenses/LGPL/2.1/ This library is distributed in
 * the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */
package com.wblut.geom;

import com.wblut.math.WB_Epsilon;
import com.wblut.math.WB_M33;
import com.wblut.math.WB_M44;

// TODO: Auto-generated Javadoc
/**
 * Generic transform class in homogeneous coordinates.
 */
public class WB_Transform {
	/** Transform matrix. */
	private WB_M44 T;
	/** Inverse transform matrix. */
	private WB_M44 invT;

	/**
	 * Instantiates a new WB_Transfrom.
	 */
	public WB_Transform() {
		T = new WB_M44(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
		invT = new WB_M44(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
	}

	/**
	 * Add translation to transform.
	 * 
	 * @param v
	 *            vector
	 * @return self
	 */
	public WB_Transform addTranslate(final WB_Point v) {
		T = new WB_M44(1, 0, 0, v.x(), 0, 1, 0, v.y(), 0, 0, 1, v.z(), 0, 0, 0,
				1).mult(T);
		invT = invT.mult(new WB_M44(1, 0, 0, -v.x(), 0, 1, 0, -v.y(), 0, 0, 1,
				-v.z(), 0, 0, 0, 1));
		return this;
	}

	public WB_Transform addTranslate(final WB_Point v, final double f) {
		T = new WB_M44(1, 0, 0, f * v.x(), 0, 1, 0, f * v.y(), 0, 0, 1, f
				* v.z(), 0, 0, 0, 1).mult(T);
		invT = invT.mult(new WB_M44(1, 0, 0, -f * v.x(), 0, 1, 0, -f * v.y(),
				0, 0, 1, -f * v.z(), 0, 0, 0, 1));
		return this;
	}

	/**
	 * Add non-uniform scale to transform.
	 * 
	 * @param s
	 *            scaling vector
	 * @return self
	 */
	public WB_Transform addScale(final WB_Vector s) {
		T = new WB_M44(s.x(), 0, 0, 0, 0, s.y(), 0, 0, 0, 0, s.z(), 0, 0, 0, 0,
				1).mult(T);
		invT = invT.mult(new WB_M44(1.0 / s.x(), 0, 0, 0, 0, 1.0 / s.y(), 0, 0,
				0, 0, 1.0 / s.z(), 0, 0, 0, 0, 1));
		return this;
	}

	/**
	 * Add non-uniform scale to transform.
	 * 
	 * @param sx
	 *            scaling vector
	 * @param sy
	 *            scaling vector
	 * @param sz
	 *            scaling vector
	 * @return self
	 */
	public WB_Transform addScale(final double sx, final double sy,
			final double sz) {
		T = new WB_M44(sx, 0, 0, 0, 0, sy, 0, 0, 0, 0, sz, 0, 0, 0, 0, 1)
				.mult(T);
		invT = invT.mult(new WB_M44(1.0 / sx, 0, 0, 0, 0, 1.0 / sy, 0, 0, 0, 0,
				1.0 / sz, 0, 0, 0, 0, 1));
		return this;
	}

	/**
	 * Add uniform scale to transform.
	 * 
	 * @param s
	 *            scaling point
	 * @return self
	 */
	public WB_Transform addScale(final double s) {
		T = new WB_M44(s, 0, 0, 0, 0, s, 0, 0, 0, 0, s, 0, 0, 0, 0, 1).mult(T);
		invT = invT.mult(new WB_M44(1 / s, 0, 0, 0, 0, 1 / s, 0, 0, 0, 0,
				1 / s, 0, 0, 0, 0, 1));
		return this;
	}

	/**
	 * Add rotation about X-axis.
	 * 
	 * @param angle
	 *            angle in radians
	 * @return self
	 */
	public WB_Transform addRotateX(final double angle) {
		final double s = Math.sin(angle);
		final double c = Math.cos(angle);
		final WB_M44 tmp = new WB_M44(1, 0, 0, 0, 0, c, -s, 0, 0, s, c, 0, 0,
				0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(tmp.getTranspose());
		return this;
	}

	/**
	 * Add rotation about Y-axis.
	 * 
	 * @param angle
	 *            angle in radians
	 * @return self
	 */
	public WB_Transform addRotateY(final double angle) {
		final double s = Math.sin(angle);
		final double c = Math.cos(angle);
		final WB_M44 tmp = new WB_M44(c, 0, s, 0, 0, 1, 0, 0, -s, 0, c, 0, 0,
				0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(tmp.getTranspose());
		return this;
	}

	/**
	 * Add rotation about Z-axis.
	 * 
	 * @param angle
	 *            angle in radians
	 * @return self
	 */
	public WB_Transform addRotateZ(final double angle) {
		final double s = Math.sin(angle);
		final double c = Math.cos(angle);
		final WB_M44 tmp = new WB_M44(c, -s, 0, 0, s, c, 0, 0, 0, 0, 1, 0, 0,
				0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(tmp.getTranspose());
		return this;
	}

	/**
	 * Add rotation about arbitrary axis in origin.
	 * 
	 * @param angle
	 *            angle in radians
	 * @param axis
	 *            WB_Vector
	 * @return self
	 */
	public WB_Transform addRotate(final double angle, final WB_Vector axis) {
		final WB_Vector a = new WB_Vector(axis);
		a.normalize();
		final double s = Math.sin(angle);
		final double c = Math.cos(angle);
		final WB_M44 tmp = new WB_M44(
				a.x() * a.x() + (1.f - a.x() * a.x()) * c, a.x() * a.y()
						* (1.f - c) - a.z() * s, a.x() * a.z() * (1.f - c)
						+ a.y() * s, 0, a.x() * a.y() * (1.f - c) + a.z() * s,
				a.y() * a.y() + (1.f - a.y() * a.y()) * c, a.y() * a.z()
						* (1.f - c) - a.x() * s, 0, a.x() * a.z() * (1.f - c)
						- a.y() * s, a.y() * a.z() * (1.f - c) + a.x() * s,
				a.z() * a.z() + (1.f - a.z() * a.z()) * c, 0, 0, 0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(tmp.getTranspose());
		return this;
	}

	/**
	 * Add rotation about arbitrary axis in point.
	 * 
	 * @param angle
	 *            angle in radians
	 * @param p
	 *            point
	 * @param axis
	 *            WB_Vector
	 * @return self
	 */
	public WB_Transform addRotateAboutAxis(final double angle,
			final WB_Point p, final WB_Vector axis) {
		addTranslate(p, -1);
		addRotate(angle, axis);
		addTranslate(p);
		return this;
	}

	/**
	 * Add a object-to-world transform.
	 * 
	 * @param origin
	 *            object origin in world coordinates
	 * @param up
	 *            object up direction in world coordinates
	 * @param front
	 *            object front direction in world coordinates
	 * @return self
	 */
	public WB_Transform addObjectToWorld(final WB_Point origin,
			final WB_Point up, final WB_Point front) {
		final WB_Vector dir = front.subToVector(origin);
		dir.normalize();
		final WB_Vector tup = up.subToVector(origin);
		tup.normalize();
		final WB_Vector right = dir.cross(tup);
		final WB_Vector newUp = right.cross(dir);
		final WB_M44 tmp = new WB_M44(right.x(), dir.x(), newUp.x(),
				origin.x(), right.y(), dir.y(), newUp.y(), origin.y(),
				right.z(), dir.z(), newUp.z(), origin.z(), 0, 0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(tmp.inverse());
		return this;
	}

	public WB_Transform addFromCSToCS(final WB_CoordinateSystem CS1,
			final WB_CoordinateSystem CS2) {
		addFromCSToWorld(CS1);
		addFromWorldToCS(CS2);
		return this;
	}

	public WB_Transform addFromCSToWorld(final WB_CoordinateSystem CS) {
		WB_CoordinateSystem current = CS;
		while (!current.isWorld()) {
			addFromCSToParent(current);
			current = current.getParent();
		}
		return this;
	}

	public WB_Transform addFromWorldToCS(final WB_CoordinateSystem CS) {
		WB_Transform tmp = new WB_Transform();
		tmp.addFromCSToWorld(CS);
		T = tmp.invT.mult(T);
		invT = invT.mult(tmp.T);
		return this;
	}

	public WB_Transform addFromCSToParent(final WB_CoordinateSystem CS) {
		WB_CoordinateSystem WCS = WB_CoordinateSystem.WORLD();
		if (CS.isWorld()) {
			return this;
		}
		final WB_Vector ex1 = CS.getX(), ey1 = CS.getY(), ez1 = CS.getZ();
		final WB_Point o1 = CS.getOrigin();
		final WB_Vector ex2 = WCS.getX(), ey2 = WCS.getY(), ez2 = WCS.getZ();
		final WB_Point o2 = WCS.getOrigin();
		final double xx = ex2.dot(ex1);
		final double xy = ex2.dot(ey1);
		final double xz = ex2.dot(ez1);
		final double yx = ey2.dot(ex1);
		final double yy = ey2.dot(ey1);
		final double yz = ey2.dot(ez1);
		final double zx = ez2.dot(ex1);
		final double zy = ez2.dot(ey1);
		final double zz = ez2.dot(ez1);
		final WB_M44 tmp = new WB_M44(xx, xy, xz, 0, yx, yy, yz, 0, zx, zy, zz,
				0, 0, 0, 0, 1);
		final WB_M44 invtmp = new WB_M44(xx, yx, zx, 0, xy, yy, zy, 0, xz, yz,
				zz, 0, 0, 0, 0, 1);
		T = tmp.mult(T);
		invT = invT.mult(invtmp);
		addTranslate(o1.sub(o2));
		return this;
	}

	public WB_Transform addFromParentToCS(final WB_CoordinateSystem CS) {
		if (CS.isWorld()) {
			return this;
		}
		WB_Transform tmp = new WB_Transform();
		tmp.addFromCSToParent(CS);
		T = tmp.invT.mult(T);
		invT = invT.mult(tmp.T);
		return this;
	}

	public WB_Transform addMirrorX() {
		addScale(-1, 1, 1);
		return this;
	}

	public WB_Transform addMirrorY() {
		addScale(1, -1, 1);
		return this;
	}

	public WB_Transform addMirrorZ() {
		addScale(1, 1, -1);
		return this;
	}

	public WB_Transform addInvert() {
		addScale(-1, -1, -1);
		return this;
	}

	public WB_Transform addMirrorX(final WB_Point p) {
		addTranslate(p, -1);
		addScale(-1, 1, 1);
		addTranslate(p);
		return this;
	}

	public WB_Transform addMirrorY(final WB_Point p) {
		addTranslate(p, -1);
		addScale(1, -1, 1);
		addTranslate(p);
		return this;
	}

	public WB_Transform addMirrorZ(final WB_Point p) {
		addTranslate(p, -1);
		addScale(1, 1, -1);
		addTranslate(p);
		return this;
	}

	public WB_Transform addInvert(final WB_Point p) {
		addTranslate(p, -1);
		addScale(-1, -1, -1);
		addTranslate(p);
		return this;
	}

	public WB_Transform addMirror(final WB_Plane P) {
		final WB_M33 tmp = P.getNormal().tensor(P.getNormal());
		final double Qn = P.getNormal().dot(P.getOrigin());
		final WB_M44 Tr = new WB_M44(1 - 2 * tmp.m11, -2 * tmp.m12, -2
				* tmp.m13, 0, -2 * tmp.m21, 1 - 2 * tmp.m22, -2 * tmp.m23, 0,
				-2 * tmp.m31, -2 * tmp.m32, 1 - 2 * tmp.m33, 0, 2 * Qn
						* P.getNormal().x(), 2 * Qn * P.getNormal().y(), 2 * Qn
						* P.getNormal().z(), 1);
		T = Tr.mult(T);
		invT = invT.mult(Tr);
		return this;
	}

	public WB_Transform addShear(final WB_Plane P, final WB_Vector v,
			final double angle) {
		final WB_Vector lv = v.get();
		lv.normalize();
		double tana = Math.tan(angle);
		final WB_M33 tmp = P.getNormal().tensor(lv);
		final double Qn = P.getNormal().dot(P.getOrigin());
		WB_M44 Tr = new WB_M44(1 + tana * tmp.m11, tana * tmp.m12, tana
				* tmp.m13, 0, tana * tmp.m21, 1 + tana * tmp.m22, tana
				* tmp.m23, 0, tana * tmp.m31, tana * tmp.m32, 1 + tana
				* tmp.m33, 0, -Qn * lv.x(), -Qn * lv.y(), -Qn * lv.z(), 1);
		T = Tr.mult(T);
		tana *= -1;
		Tr = new WB_M44(1 + tana * tmp.m11, tana * tmp.m12, tana * tmp.m13, 0,
				tana * tmp.m21, 1 + tana * tmp.m22, tana * tmp.m23, 0, tana
						* tmp.m31, tana * tmp.m32, 1 + tana * tmp.m33, 0, -Qn
						* lv.x(), -Qn * lv.y(), -Qn * lv.z(), 1);
		invT = invT.mult(Tr);
		return this;
	}

	/**
	 * Apply transform to point.
	 * 
	 * @param p
	 *            point
	 * @return new WB_XYZ
	 */
	public WB_Point applyAsPoint(final WB_Point p) {
		final double xp = T.m11 * p.x() + T.m12 * p.y() + T.m13 * p.z() + T.m14;
		final double yp = T.m21 * p.x() + T.m22 * p.y() + T.m23 * p.z() + T.m24;
		final double zp = T.m31 * p.x() + T.m32 * p.y() + T.m33 * p.z() + T.m34;
		double wp = T.m41 * p.x() + T.m42 * p.y() + T.m43 * p.z() + T.m44;
		if (WB_Epsilon.isZero(wp)) {
			return new WB_Point(xp, yp, zp);
		}
		wp = 1.0 / wp;
		return new WB_Point(xp * wp, yp * wp, zp * wp);
	}

	public WB_Point applyAsPoint(final double x, final double y, final double z) {
		final double xp = T.m11 * x + T.m12 * y + T.m13 * z + T.m14;
		final double yp = T.m21 * x + T.m22 * y + T.m23 * z + T.m24;
		final double zp = T.m31 * x + T.m32 * y + T.m33 * z + T.m34;
		double wp = T.m41 * x + T.m42 * y + T.m43 * z + T.m44;
		if (WB_Epsilon.isZero(wp)) {
			return new WB_Point(xp, yp, zp);
		}
		wp = 1.0 / wp;
		return new WB_Point(xp * wp, yp * wp, zp * wp);
	}

	/**
	 * Apply transform to point.
	 * 
	 * @param p
	 *            point
	 */
	public void applySelfAsPoint(final WB_Point p) {
		final double x = (T.m11 * p.x() + T.m12 * p.y() + T.m13 * p.z() + T.m14);
		final double y = (T.m21 * p.x() + T.m22 * p.y() + T.m23 * p.z() + T.m24);
		final double z = (T.m31 * p.x() + T.m32 * p.y() + T.m33 * p.z() + T.m34);
		double wp = (T.m41 * p.x() + T.m42 * p.y() + T.m43 * p.z() + T.m44);
		wp = 1.0 / wp;
		p.set(x * wp, y * wp, z * wp);
	}

	/**
	 * Apply transform to vector.
	 * 
	 * @param p
	 *            vector
	 * @return new WB_Vector
	 */
	public WB_Vector applyAsVector(final WB_Vector p) {
		final double xp = (T.m11 * p.x() + T.m12 * p.y() + T.m13 * p.z());
		final double yp = (T.m21 * p.x() + T.m22 * p.y() + T.m23 * p.z());
		final double zp = (T.m31 * p.x() + T.m32 * p.y() + T.m33 * p.z());
		return new WB_Vector(xp, yp, zp);
	}

	public WB_Vector applyAsVector(final double x, final double y,
			final double z) {
		final double xp = (T.m11 * x + T.m12 * y + T.m13 * z);
		final double yp = (T.m21 * x + T.m22 * y + T.m23 * z);
		final double zp = (T.m31 * x + T.m32 * y + T.m33 * z);
		return new WB_Vector(xp, yp, zp);
	}

	/**
	 * Apply transform to vector.
	 * 
	 * @param p
	 *            vector
	 */
	public void applySelfAsVector(final WB_Vector p) {
		final double x = (T.m11 * p.x() + T.m12 * p.y() + T.m13 * p.z());
		final double y = (T.m21 * p.x() + T.m22 * p.y() + T.m23 * p.z());
		final double z = (T.m31 * p.x() + T.m32 * p.y() + T.m33 * p.z());
		p.set(x, y, z);
	}

	public WB_Vector applyAsNormal(final WB_Vector p) {
		final double nx = (invT.m11 * p.x() + invT.m21 * p.y() + invT.m31
				* p.z());
		final double ny = (invT.m12 * p.x() + invT.m22 * p.y() + invT.m32
				* p.z());
		final double nz = (invT.m13 * p.x() + invT.m23 * p.y() + invT.m33
				* p.z());
		return new WB_Vector(nx, ny, nz);
	}

	public WB_Vector applyAsNormal(final double x, final double y,
			final double z) {
		final double nx = (invT.m11 * x + invT.m21 * y + invT.m31 * z);
		final double ny = (invT.m12 * x + invT.m22 * y + invT.m32 * z);
		final double nz = (invT.m13 * x + invT.m23 * y + invT.m33 * z);
		return new WB_Vector(nx, ny, nz);
	}

	/**
	 * Apply transform to normal
	 * 
	 * @param n
	 *            normal
	 */
	public void applySelfAsNormal(final WB_Vector n) {
		final double x = (invT.m11 * n.x() + invT.m21 * n.y() + invT.m31
				* n.z());
		final double y = (invT.m12 * n.x() + invT.m22 * n.y() + invT.m32
				* n.z());
		final double z = (invT.m13 * n.x() + invT.m23 * n.y() + invT.m33
				* n.z());
		n.set(x, y, z);
	}

	/**
	 * Invert transform.
	 */
	public void inverse() {
		WB_M44 tmp;
		tmp = T;
		T = invT;
		invT = tmp;
	}

	/**
	 * Clear transform.
	 */
	public void clear() {
		T = new WB_M44(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
		invT = new WB_M44(1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1);
	}

	public WB_CoordinateSystem apply(final WB_CoordinateSystem CS) {
		final WB_Point o = CS.getOrigin();
		final WB_Vector x = CS.getX();
		final WB_Vector y = CS.getY();
		final WB_Vector z = CS.getZ();
		applySelfAsPoint(o);
		applySelfAsVector(x);
		applySelfAsVector(y);
		applySelfAsVector(z);
		x.normalize();
		y.normalize();
		z.normalize();
		CS.set(o, x, y, z);
		return CS;
	}

	@Override
	public String toString() {
		final String s = "WB_Transform3d T:" + "\n" + "[" + T.m11 + ", "
				+ T.m12 + ", " + T.m13 + ", " + T.m14 + "]" + "\n" + "["
				+ T.m21 + ", " + T.m22 + ", " + T.m23 + ", " + T.m24 + "]"
				+ "\n" + "[" + T.m31 + ", " + T.m32 + ", " + T.m33 + ", "
				+ T.m34 + "]" + "\n" + "[" + T.m41 + ", " + T.m42 + ", "
				+ T.m43 + ", " + T.m44 + "]";
		return s;
	}
}
