package com.wblut;

public class WB_Version {
	public static final WB_Version CURRENT_VERSION = new WB_Version();
	public static final int MAJOR = 2;
	public static final int MINOR = 0;
	public static final int PATCH = 0;
	private static final String releaseInfo = "Gilgamesh";

	public static void main(final String[] args) {
		System.out.println(CURRENT_VERSION);
	}

	private WB_Version() {
	}

	public int getMajor() {
		return MAJOR;
	}

	public int getMinor() {
		return MINOR;
	}

	public int getPatch() {
		return PATCH;
	}

	@Override
	public String toString() {
		String ver = "W:Blut HE_Mesh " + MAJOR + "." + MINOR + "." + PATCH;
		if (releaseInfo != null && releaseInfo.length() > 0) {
			return ver + " " + releaseInfo;
		}
		return ver;
	}
}