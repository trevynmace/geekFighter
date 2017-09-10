package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import player.Player;
import player.PlayerControls;
import utilities.Utilities;

public class GameFrame extends JFrame implements KeyListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	private int FRAME_WIDTH = 800;
	private int FRAME_HEIGHT = 600;

	private final ImageIcon background = new ImageIcon(getClass().getResource("/images/battleBackground.jpg"));
	private JLabel backgroundContainer = new JLabel(background);

	private JLabel player1Label;
	private JLabel player2Label;

	private final Timer timer = new Timer(10, this);
	private AtomicReference<Double> player1Speed = new AtomicReference<Double>();
	private AtomicReference<Double> player2Speed = new AtomicReference<Double>();

	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	private boolean isAPressed = false;
	private boolean isDPressed = false;

	public GameFrame()
	{
		player1Speed.set(2.0);
		player2Speed.set(2.0);

		timer.start();

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
		if (e.getKeyCode() == KeyEvent.VK_A)
		{
			isAPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D)
		{
			isDPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			isLeftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			isRightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			if (JOptionPane.showConfirmDialog(this, "Are you sure you want to quit??", "Quit game?", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource().equals(timer))
		{
			movePlayers();
		}
	}

	private void movePlayers()
	{
		double currentPlayer1Speed = player1Speed.get();
		if (player1Speed.get().doubleValue() < 4)
		{
			player1Speed.set(currentPlayer1Speed + 0.15);
		}
		double currentPlayer2Speed = player2Speed.get();
		if (player2Speed.get().doubleValue() < 4)
		{
			player2Speed.set(currentPlayer2Speed + 0.15);
		}

		int currentPlayer1XCoord;
		int currentPlayer1YCoord;
		int currentPlayer2XCoord;
		int currentPlayer2YCoord;

		if (isAPressed)
		{
			currentPlayer1XCoord = player1Label.getX();
			currentPlayer1YCoord = player1Label.getY();
			player1Label.setLocation((int) (currentPlayer1XCoord - 1 - (player1Speed.get().doubleValue() * player1Speed.get().doubleValue())), currentPlayer1YCoord);
		}
		if (isDPressed)
		{
			currentPlayer1XCoord = player1Label.getX();
			currentPlayer1YCoord = player1Label.getY();
			player1Label.setLocation((int) (currentPlayer1XCoord + 1 + (player1Speed.get().doubleValue() * player1Speed.get().doubleValue())), currentPlayer1YCoord);
		}
		if (isLeftPressed)
		{
			currentPlayer2XCoord = player2Label.getX();
			currentPlayer2YCoord = player2Label.getY();
			player2Label.setLocation((int) (currentPlayer2XCoord - 1 - (player2Speed.get().doubleValue() * player2Speed.get().doubleValue())), currentPlayer2YCoord);
		}
		if (isRightPressed)
		{
			currentPlayer2XCoord = player2Label.getX();
			currentPlayer2YCoord = player2Label.getY();
			player2Label.setLocation((int) (currentPlayer2XCoord + 1 + (player2Speed.get().doubleValue() * player2Speed.get().doubleValue())), currentPlayer2YCoord);
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		int keyReleased = e.getKeyCode();

		if (keyReleased == KeyEvent.VK_A || keyReleased == KeyEvent.VK_D)
		{
			player1Speed.set(2.0);
		}

		if (keyReleased == KeyEvent.VK_LEFT || keyReleased == KeyEvent.VK_RIGHT)
		{
			player2Speed.set(2.0);
		}

		if (keyReleased == KeyEvent.VK_A)
		{
			isAPressed = false;
		}
		if (keyReleased == KeyEvent.VK_D)
		{
			isDPressed = false;
		}
		if (keyReleased == KeyEvent.VK_LEFT)
		{
			isLeftPressed = false;
		}
		if (keyReleased == KeyEvent.VK_RIGHT)
		{
			isRightPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}