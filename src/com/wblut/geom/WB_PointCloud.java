package com.wblut.geom;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javolution.util.FastList;

import com.wblut.math.WB_MTRandom;

public class WB_PointCloud<P extends WB_Point> extends FastList<P> {

	public WB_PointCloud() {
		super();
	}

	public WB_PointCloud(Collection<? extends P> points) {
		super(points);
	}

	public WB_PointCloud(P[] points) {
		super();
		for (P point : points) {
			add(point);
		}
	}

	public void sort() {
		Comparator comp = new WB_Point.WB_Comparator3d();
		Collections.sort(this, comp);

	}

	public void sort(int mode) {
		Comparator comp = new WB_Point.WB_Comparator3d(mode);

		Collections.sort(this, comp);

	}

	public void sort(Comparator<WB_Point> comp) {
		Collections.sort(this, comp);

	}

	public void shuffle() {
		Collections.shuffle(this, new WB_MTRandom());
	}

	public String getString() {
		String string = new String();
		int i = 0;
		for (P p : this) {
			string += i + ": " + p.toString();
			string += System.getProperty("line.separator");
			i++;
		}
		string += i + " points.";
		return string;
	}

}
