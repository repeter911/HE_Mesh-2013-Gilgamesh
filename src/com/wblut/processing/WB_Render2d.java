package com.wblut.processing;

import java.util.Collection;

import processing.core.PApplet;

import com.wblut.geom.WB_Point;

public class WB_Render2d {
	private final PApplet _home;

	public WB_Render2d(final PApplet home) {
		_home = home;
	}

	public void drawPoint(final WB_Point point) {
		_home.point(point.xf2d(), point.yf2d());
	}

	public void drawPoints(final Collection<? extends WB_Point> points) {
		if (points != null) {
			for (WB_Point point : points) {
				_home.point(point.xf2d(), point.yf2d());
			}
		}
	}

	public void drawPoints(final WB_Point[] points) {
		if (points != null) {
			for (WB_Point point : points) {
				_home.point(point.xf2d(), point.yf2d());
			}
		}
	}

	public void drawLine(final WB_Point p, final WB_Point q) {
		_home.line(p.xf2d(), p.yf2d(), q.xf2d(), q.yf2d());
	}

}
