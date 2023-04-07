package ninjabrainbot.data.calculator.endereye;

public class F3CData {

	public final double x, y, z, horizontalAngle, verticalAngle;
	public final boolean nether;

	private F3CData(double x, double y, double z, double horizontalAngle, double verticalAngle, boolean nether) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.horizontalAngle = horizontalAngle;
		this.verticalAngle = verticalAngle;
		this.nether = nether;
	}

	public static F3CData tryParseF3CString(String string) {
		if (!(string.startsWith("/execute in minecraft:overworld run tp @s") || string.startsWith("/execute in minecraft:the_nether run tp @s"))) {
			return null;
		}
		String[] substrings = string.split(" ");
		if (substrings.length != 11)
			return null;
		try {
			boolean nether = substrings[2].equals("minecraft:the_nether");
			double x = Double.parseDouble(substrings[6]);
			double y = Double.parseDouble(substrings[7]);
			double z = Double.parseDouble(substrings[8]);
			double horizontalAngle = Double.parseDouble(substrings[9]);
			double verticalAngle = Double.parseDouble(substrings[10]);
			return new F3CData(x, y, z, horizontalAngle, verticalAngle, nether);
		} catch (NullPointerException | NumberFormatException e) {
			return null;
		}
	}

}
