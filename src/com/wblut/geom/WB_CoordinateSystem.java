package com.wblut.geom;

import com.wblut.math.WB_Epsilon;

public class WB_CoordinateSystem {
	private WB_CoordinateSystem _parent;

	protected final static WB_CoordinateSystem WORLD() {
		return new WB_CoordinateSystem(true);
	}

	private WB_Point _origin;
	private WB_Vector _X;
	private WB_Vector _Y;
	private WB_Vector _Z;
	private boolean _isWorld;

	protected WB_CoordinateSystem(final WB_Point origin, final WB_Vector x,
			final WB_Vector y, final WB_Vector z,
			final WB_CoordinateSystem parent) {
		_origin = origin.get();
		_X = x.get();
		_Y = y.get();
		_Z = z.get();
		_parent = parent;
		_isWorld = (_parent == null);
	}

	protected WB_CoordinateSystem(final boolean world) {
		_origin = WB_Point.ZERO();
		_X = WB_Vector.X();
		_Y = WB_Vector.Y();
		_Z = WB_Vector.Z();
		_isWorld = world;
		_parent = (world) ? null : WORLD();
	}

	public WB_CoordinateSystem() {
		this(false);
	}

	public WB_CoordinateSystem(final WB_CoordinateSystem parent) {
		_origin = WB_Point.ZERO();
		_X = WB_Vector.X();
		_Y = WB_Vector.Y();
		_Z = WB_Vector.Z();
		_parent = parent;
		_isWorld = (_parent == null);
	}

	public WB_CoordinateSystem get() {
		return new WB_CoordinateSystem(_origin, _X, _Y, _Z, _parent);
	}

	protected void set(final WB_Point origin, final WB_Vector x,
			final WB_Vector y, final WB_Vector z) {
		_origin = origin.get();
		_X = x.get();
		_Y = y.get();
		_Z = z.get();
	}

	public WB_CoordinateSystem setParent(final WB_CoordinateSystem parent) {
		_parent = parent;
		_isWorld = (_parent == null);
		return this;
	}

	public WB_CoordinateSystem setOrigin(final WB_Point o) {
		_origin.set(o);
		return this;
	}

	public WB_CoordinateSystem setOrigin(final double ox, final double oy,
			final double oz) {
		_origin.set(ox, oy, oz);
		return this;
	}

	public WB_CoordinateSystem setXY(final WB_Vector X, final WB_Vector Y) {
		_X.set(X);
		_X.normalize();
		_Y.set(Y);
		_Y.normalize();
		_Z = _X.cross(_Y);
		if (WB_Epsilon.isZeroSq(_Z.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Z.normalize();
		_Y = _Z.cross(_X);
		_Y.normalize();
		return this;
	}

	public WB_CoordinateSystem setYX(final WB_Vector Y, final WB_Vector X) {
		_X.set(X);
		_X.normalize();
		_Y.set(Y);
		_Y.normalize();
		_Z = _X.cross(_Y);
		if (WB_Epsilon.isZeroSq(_Z.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Z.normalize();
		_X = _Y.cross(_Z);
		_X.normalize();
		return this;
	}

	public WB_CoordinateSystem setXZ(final WB_Vector X, final WB_Vector Z) {
		_X.set(X);
		_X.normalize();
		_Z.set(Z);
		_Z.normalize();
		_Y = _Z.cross(X);
		if (WB_Epsilon.isZeroSq(_Y.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Y.normalize();
		_Z = _X.cross(_Y);
		_Z.normalize();
		return this;
	}

	public WB_CoordinateSystem setZX(final WB_Vector Z, final WB_Vector X) {
		_X.set(X);
		_X.normalize();
		_Z.set(Z);
		_Z.normalize();
		_Y = _Z.cross(_X);
		if (WB_Epsilon.isZeroSq(_Y.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Y.normalize();
		_X = _Y.cross(_Z);
		_X.normalize();
		return this;
	}

	public WB_CoordinateSystem setYZ(final WB_Vector Y, final WB_Vector Z) {
		_Y.set(Y);
		_Y.normalize();
		_Z.set(Z);
		_Z.normalize();
		_X = _Y.cross(_Z);
		if (WB_Epsilon.isZeroSq(_X.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_X.normalize();
		_Z = _X.cross(_Y);
		_Z.normalize();
		return this;
	}

	public WB_CoordinateSystem setZY(final WB_Vector Z, final WB_Vector Y) {
		_Y.set(Y);
		_Y.normalize();
		_Z.set(Z);
		_Z.normalize();
		_X = _Y.cross(_Z);
		if (WB_Epsilon.isZeroSq(_X.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_X.normalize();
		_Y = _Z.cross(_X);
		_Y.normalize();
		return this;
	}

	public WB_Vector getX() {
		return _X.get();
	}

	public WB_Vector getY() {
		return _Y.get();
	}

	public WB_Vector getZ() {
		return _Z.get();
	}

	public WB_Point getOrigin() {
		return _origin.get();
	}

	public WB_CoordinateSystem getParent() {
		return _parent;
	}

	public boolean isWorld() {
		return _isWorld;
	}

	public WB_CoordinateSystem setXY(final double xx, final double xy,
			final double xz, final double yx, final double yy, final double yz) {
		_X.set(xx, xy, xz);
		_X.normalize();
		_Y.set(yx, yy, yz);
		_Y.normalize();
		_Z = _X.cross(_Y);
		if (WB_Epsilon.isZeroSq(_Z.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Z.normalize();
		_Y = _Z.cross(_X);
		_Y.normalize();
		return this;
	}

	public WB_CoordinateSystem setYX(final double yx, final double yy,
			final double yz, final double xx, final double xy, final double xz) {
		_X.set(xx, xy, xz);
		_X.normalize();
		_Y.set(yx, yy, yz);
		_Y.normalize();
		_Z = _X.cross(_Y);
		if (WB_Epsilon.isZeroSq(_Z.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Z.normalize();
		_X = _Y.cross(_Z);
		_X.normalize();
		return this;
	}

	public WB_CoordinateSystem setXZ(final double xx, final double xy,
			final double xz, final double zx, final double zy, final double zz) {
		_X.set(xx, xy, xz);
		_X.normalize();
		_Z.set(zx, zy, zz);
		_Z.normalize();
		_Y = _Z.cross(_X);
		if (WB_Epsilon.isZeroSq(_Y.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Y.normalize();
		_Z = _X.cross(_Y);
		_Z.normalize();
		return this;
	}

	public WB_CoordinateSystem setZX(final double zx, final double zy,
			final double zz, final double xx, final double xy, final double xz) {
		_X.set(xx, xy, xz);
		_X.normalize();
		_Z.set(zx, zy, zz);
		_Z.normalize();
		_Y = _Z.cross(_X);
		if (WB_Epsilon.isZeroSq(_Y.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_Y.normalize();
		_X = _Y.cross(_Z);
		_X.normalize();
		return this;
	}

	public WB_CoordinateSystem setYZ(final double yx, final double yy,
			final double yz, final double zx, final double zy, final double zz) {
		_Y.set(yx, yy, yz);
		_Y.normalize();
		_Z.set(zx, zy, zz);
		_Z.normalize();
		_X = _Y.cross(_Z);
		if (WB_Epsilon.isZeroSq(_X.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_X.normalize();
		_Z = _X.cross(_Y);
		_Z.normalize();
		return this;
	}

	public WB_CoordinateSystem setZY(final double zx, final double zy,
			final double zz, final double yx, final double yy, final double yz) {
		_Y.set(yx, yy, yz);
		_Y.normalize();
		_Z.set(zx, zy, zz);
		_Z.normalize();
		_X = _Y.cross(_Z);
		if (WB_Epsilon.isZeroSq(_X.sqLength())) {
			throw new IllegalArgumentException("Vectors can not be parallel.");
		}
		_X.normalize();
		_Y = _Z.cross(_X);
		_Y.normalize();
		return this;
	}

	public WB_CoordinateSystem setX(final WB_Vector X) {
		final WB_Vector lX = X.get();
		lX.normalize();
		final WB_Vector tmp = lX.cross(_X);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_X.dot(lX)), tmp);
		} else if (_X.dot(lX) < -1 + WB_Epsilon.EPSILON) {
			flipX();
		}
		return this;
	}

	public WB_CoordinateSystem setY(final WB_Vector Y) {
		final WB_Vector lY = Y.get();
		lY.normalize();
		final WB_Vector tmp = lY.cross(_Y);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_Y.dot(lY)), tmp);
		} else if (_Y.dot(lY) < -1 + WB_Epsilon.EPSILON) {
			flipY();
		}
		return this;
	}

	public WB_CoordinateSystem setZ(final WB_Vector Z) {
		final WB_Vector lZ = Z.get();
		lZ.normalize();
		final WB_Vector tmp = lZ.cross(_Z);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_Z.dot(lZ)), tmp);
		} else if (_Z.dot(lZ) < -1 + WB_Epsilon.EPSILON) {
			flipZ();
		}
		return this;
	}

	public WB_CoordinateSystem rotateX(final double a) {
		_Y.rotate(a, _X);
		_Z.rotate(a, _X);
		return this;
	}

	public WB_CoordinateSystem rotateY(final double a) {
		_X.rotate(a, _Y);
		_Z.rotate(a, _Y);
		return this;
	}

	public WB_CoordinateSystem rotateZ(final double a) {
		_X.rotate(a, _Z);
		_Y.rotate(a, _Z);
		return this;
	}

	public WB_CoordinateSystem rotate(final double a, final WB_Vector v) {
		final WB_Vector lv = v.get();
		lv.normalize();
		_X.rotate(a, lv);
		_Y.rotate(a, lv);
		_Z.rotate(a, lv);
		return this;
	}

	public WB_Transform getTransformFromParent() {
		final WB_Transform result = new WB_Transform();
		result.addFromParentToCS(this);
		return result;
	}

	public WB_Transform getTransformToParent() {
		final WB_Transform result = new WB_Transform();
		result.addFromCSToParent(this);
		return result;
	}

	public WB_Transform getTransformFromWorld() {
		final WB_Transform result = new WB_Transform();
		result.addFromWorldToCS(this);
		return result;
	}

	public WB_Transform getTransformToWorld() {
		final WB_Transform result = new WB_Transform();
		result.addFromCSToWorld(this);
		return result;
	}

	public WB_Transform getTransformFrom(final WB_CoordinateSystem CS) {
		final WB_Transform result = new WB_Transform();
		result.addFromCSToCS(CS, this);
		return result;
	}

	public WB_Transform getTransformTo(final WB_CoordinateSystem CS) {
		final WB_Transform result = new WB_Transform();
		result.addFromCSToCS(this, CS);
		return result;
	}

	public WB_CoordinateSystem setX(final double xx, final double xy,
			final double xz) {
		final WB_Vector lX = new WB_Vector(xx, xy, xz);
		lX.normalize();
		final WB_Vector tmp = lX.cross(_X);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_X.dot(lX)), tmp);
		} else if (_X.dot(lX) < -1 + WB_Epsilon.EPSILON) {
			flipX();
		}
		return this;
	}

	public WB_CoordinateSystem setY(final double yx, final double yy,
			final double yz) {
		final WB_Vector lY = new WB_Vector(yx, yy, yz);
		lY.normalize();
		final WB_Vector tmp = lY.cross(_Y);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_Y.dot(lY)), tmp);
		} else if (_Y.dot(lY) < -1 + WB_Epsilon.EPSILON) {
			flipY();
		}
		return this;
	}

	public WB_CoordinateSystem setZ(final double zx, final double zy,
			final double zz) {
		final WB_Vector lZ = new WB_Vector(zx, zy, zz);
		lZ.normalize();
		final WB_Vector tmp = lZ.cross(_Z);
		if (!WB_Epsilon.isZeroSq(tmp.sqLength())) {
			rotate(-Math.acos(_Z.dot(lZ)), tmp);
		} else if (_Z.dot(lZ) < -1 + WB_Epsilon.EPSILON) {
			flipZ();
		}
		return this;
	}

	public void flipX() {
		_X.mul(-1);
		_Y.mul(-1);
	}

	public void flipY() {
		_X.mul(-1);
		_Y.mul(-1);
	}

	public void flipZ() {
		_Z.mul(-1);
		_Y.mul(-1);
	}

	@Override
	public String toString() {
		return "WB_CoordinateSystem: origin: " + _origin + " [X=" + _X + ", Y="
				+ _Y + ", Z=" + _Z + "]";
	}
}
