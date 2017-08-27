package utilities;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public abstract class Utilities
{
	public static Point findBestLocation(int frameWidth, int frameHeight)
	{
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();

		int idealHorizontalLocation = (width / 2) - (frameWidth / 2);
		int idealVerticalLocation = (height / 2) - (frameHeight / 2);
		return new Point(idealHorizontalLocation, idealVerticalLocation);
	}
}