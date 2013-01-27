package com.wblut.geom;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javolution.util.FastList;

import com.wblut.math.WB_MTRandom;

public class WB_PointCloud extends FastList<WB_Point> {

	public WB_PointCloud() {
		super();
	}

	public WB_PointCloud(Collection<? extends WB_Point> points) {
		super(points);
	}

	public WB_PointCloud(WB_Point[] points) {
		super();
		for (WB_Point point : points) {
			add(point);
		}
	}

	public void sort() {
		Comparator comp = new WB_Point.WB_Comparator3d();
		Collections.sort(this, comp);

	}

	public void sort(Comparator<WB_Point> comp) {
		Collections.sort(this, comp);

	}

	public void shuffle() {
		Collections.shuffle(this, new WB_MTRandom());
	}

	public void shuffle(long seed) {
		Collections.shuffle(this, new WB_MTRandom(seed));
	}

}
