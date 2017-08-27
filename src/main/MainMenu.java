package main;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import utilities.Utilities;

public class MainMenu
{
	private final static String MENUPANEL = "Main panel with buttons";
	private final static String OPTIONSPANEL = "Options panel";

	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 600;

	private JFrame frame;
	private JPanel panel;

	private JButton menuStartButton;
	private JButton menuOptionsButton;
	private JButton menuExitButton;
	private JButton optionsBackButton;

	void initialize()
	{
		CardLayout cardLayout = new CardLayout();
		MigLayout migLayout = new MigLayout("align 50% 50%");

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(Color.BLACK);
		menuPanel.setAlignmentY(JPanel.CENTER_ALIGNMENT);
		menuPanel.setLayout(migLayout);
		JPanel optionsPanel = new JPanel();
		optionsPanel.setBackground(Color.BLACK);

		panel = new JPanel(cardLayout);
		panel.add(menuPanel, MENUPANEL);
		panel.add(optionsPanel, OPTIONSPANEL);

		createButtons();
		addButtonActions();

		menuPanel.add(menuStartButton, "wrap, grow");
		menuPanel.add(menuOptionsButton, "wrap, grow");
		menuPanel.add(menuExitButton, "wrap, grow");
		optionsPanel.add(optionsBackButton);

		frame = new JFrame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(Utilities.findBestLocation(FRAME_WIDTH, FRAME_HEIGHT));
		frame.setTitle("Geek Fighter 64");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				exitAction();
			}
		});

		frame.add(panel);
		frame.setVisible(true);
	}

	private void createButtons()
	{
		menuStartButton = new JButton("Start");
		menuOptionsButton = new JButton("Options");
		menuExitButton = new JButton("Exit");
		optionsBackButton = new JButton("Back");
	}

	private void addButtonActions()
	{
		menuStartButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameFrame game = new GameFrame();
				game.initialize();
			}
		});
		menuOptionsButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, OPTIONSPANEL);
			}
		});
		menuExitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				exitAction();
			}
		});
		optionsBackButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				CardLayout cl = (CardLayout) (panel.getLayout());
				cl.show(panel, MENUPANEL);
			}
		});
	}

	private void exitAction()
	{
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?!?!?!????", "Stop playing??", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
}