package com.wblut.processing;

import java.util.Collection;
import java.util.List;

import processing.core.PApplet;

import com.wblut.geom.WB_Point;

public class WB_Render3d {
	private final PApplet _home;

	public WB_Render3d(final PApplet home) {
		_home = home;
	}

	public void drawPoint(final WB_Point point) {
		_home.point(point.xf(), point.yf(), point.zf());
	}

	public void drawPoints(final Collection<? extends WB_Point> points) {
		if (points != null) {
			for (WB_Point point : points) {
				_home.point(point.xf(), point.yf(), point.zf());
			}
		}
	}

	public void drawPoints(final WB_Point[] points) {
		if (points != null) {
			for (WB_Point point : points) {
				_home.point(point.xf(), point.yf(), point.zf());
			}
		}
	}

	public void drawSegment(final WB_Point p, final WB_Point q) {
		_home.line(p.xf(), p.yf(), p.zf(), q.xf(), q.yf(), q.zf());
	}

	public void drawSegment(int[] indices, List<? extends WB_Point> points) {
		drawSegment(points.get(indices[0]), points.get(indices[1]));
	}

	public void drawSegments(int[] indices, List<? extends WB_Point> points) {
		for (int i = 0; i < indices.length; i += 2) {
			drawSegment(points.get(indices[i]), points.get(indices[i + 1]));
		}
	}

	public void drawTriangle(final WB_Point p0, final WB_Point p1,
			final WB_Point p2) {
		_home.beginShape(PApplet.TRIANGLES);
		vertex(p0);
		vertex(p1);
		vertex(p2);
		_home.endShape();
	}

	public void drawTriangle(int[] indices, List<? extends WB_Point> points) {
		drawTriangle(points.get(indices[0]), points.get(indices[1]),
				points.get(indices[2]));
	}

	public void drawTriangles(int[] indices, List<? extends WB_Point> points) {
		for (int i = 0; i < indices.length; i += 3) {
			drawTriangle(points.get(indices[i]), points.get(indices[i + 1]),
					points.get(indices[i + 2]));
		}
	}

	public void drawTetrahedron(final WB_Point p0, final WB_Point p1,
			final WB_Point p2, final WB_Point p3) {
		_home.beginShape(PApplet.TRIANGLES);
		vertex(p0);
		vertex(p1);
		vertex(p2);

		vertex(p1);
		vertex(p0);
		vertex(p3);

		vertex(p2);
		vertex(p1);
		vertex(p3);

		vertex(p0);
		vertex(p2);
		vertex(p3);

		_home.endShape();
	}

	public void drawTetrahedron(int[] indices, List<? extends WB_Point> points) {
		drawTetrahedron(points.get(indices[0]), points.get(indices[1]),
				points.get(indices[2]), points.get(indices[3]));
	}

	public void drawTetrahedra(int[] indices, List<? extends WB_Point> points) {
		for (int i = 0; i < indices.length; i += 4) {
			drawTetrahedron(points.get(indices[i]), points.get(indices[i + 1]),
					points.get(indices[i + 2]), points.get(indices[i + 3]));
		}
	}

	private void vertex(WB_Point p) {
		_home.vertex(p.xf(), p.yf(), p.zf());
	}

}
