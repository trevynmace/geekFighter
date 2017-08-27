package main;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import player.Player;
import player.PlayerControls;
import utilities.Utilities;

public class GameFrame extends JFrame implements KeyListener
{
	private static final long serialVersionUID = 1L;
	private int FRAME_WIDTH = 800;
	private int FRAME_HEIGHT = 600;

	private final ImageIcon background = new ImageIcon(getClass().getResource("/images/battleBackground.jpg"));
	private JLabel backgroundContainer = new JLabel(background);

	private JLabel player1Label;
	private JLabel player2Label;

	public GameFrame()
	{
		addKeyListener(this);
		setContentPane(backgroundContainer);
		setUndecorated(true);
		setLayout(new BorderLayout());
		setLocation(Utilities.findBestLocation(FRAME_WIDTH, FRAME_HEIGHT));
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
	}

	public void initialize()
	{
		createPlayerOne();
		createPlayerTwo();
	}

	private void createPlayerOne()
	{
		String player1ImagePath = "/images/sailorMoon.png";
		PlayerControls player1Controls = new PlayerControls(KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_W, KeyEvent.VK_R, KeyEvent.VK_T);
		Player player1 = new Player(player1ImagePath, player1Controls);

		player1Label = new JLabel(player1);
		player1Label.setSize(player1.getIconWidth(), player1.getIconHeight());
		player1Label.setVisible(true);

		add(player1Label, BorderLayout.WEST);
	}

	private void createPlayerTwo()
	{
		String player2ImagePath = "/images/ryu.png";
		PlayerControls player2Controls = new PlayerControls(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_K, KeyEvent.VK_L);
		Player player2 = new Player(player2ImagePath, player2Controls);

		player2Label = new JLabel(player2);
		player2Label.setSize(player2.getIconWidth(), player2.getIconHeight());
		player2Label.setVisible(true);

		add(player2Label, BorderLayout.EAST);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyPressed = e.getKeyCode();

		if (keyPressed == KeyEvent.VK_A)
		{
			int currentPlayer1XCoord = player1Label.getX();
			int currentPlayer1YCoord = player1Label.getY();
			player1Label.setLocation(currentPlayer1XCoord - 10, currentPlayer1YCoord);
		}

		if (keyPressed == KeyEvent.VK_D)
		{
			int currentPlayer1XCoord = player1Label.getX();
			int currentPlayer1YCoord = player1Label.getY();
			player1Label.setLocation(currentPlayer1XCoord + 10, currentPlayer1YCoord);
		}

		if (keyPressed == KeyEvent.VK_ESCAPE)
		{
			if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit??", "Quit game?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
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