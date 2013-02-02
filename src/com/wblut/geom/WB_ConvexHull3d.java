package com.wblut.geom;

import quickhull3d.Point3d;
import quickhull3d.QuickHull3D;

public class WB_ConvexHull3d {
	public static int[][] getConvexHull(final WB_Point[] points) {
		int n = points.length;
		if (n < 4) {
			return new int[0][0];
		}
		final Point3d[] locpoints = new Point3d[n];
		for (int i = 0; i < n; i++) {
			locpoints[i] = new Point3d(points[i].coords[0],
					points[i].coords[1], points[i].coords[2]);
		}
		final QuickHull3D hull = new QuickHull3D();
		hull.build(locpoints);
		// hull.triangulate();
		final int[][] result = hull.getFaces(QuickHull3D.POINT_RELATIVE);
		return result;
	}
}
