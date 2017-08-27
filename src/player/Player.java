package player;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Player extends ImageIcon implements KeyListener
{
	private static final long serialVersionUID = 1L;
	private PlayerControls controls;

	public Player(String path, PlayerControls controls)
	{
		this.controls = controls;

		ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
		Image image = imageIcon.getImage().getScaledInstance(imageIcon.getIconWidth() / 2, imageIcon.getIconHeight() / 2, Image.SCALE_DEFAULT);
		setImage(image);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyPressed = e.getKeyCode();

		int leftKey = controls.getLeftKey();
		int rightKey = controls.getRightKey();
		int spaceKey = controls.getSpaceKey();
		int punchKey = controls.getPunchKey();
		int kickKey = controls.getKickKey();

		if (keyPressed == leftKey)
		{
			//move character left
		}
		if (keyPressed == rightKey)
		{

		}
		if (keyPressed == spaceKey)
		{

		}
		if (keyPressed == punchKey)
		{

		}
		if (keyPressed == kickKey)
		{

		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}