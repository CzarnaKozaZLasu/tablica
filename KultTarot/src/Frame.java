import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		CardService cardServie = new CardService();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame(cardServie);
					frame.setTitle("Kult Bosko�� Utracona Tarot");
					frame.setIconImage(new ImageIcon("./resource/logo.png").getImage());
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame(CardService cardService) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Dictionary dictionary = new Dictionary();

		JLabel cardOne = new JLabel("");
		cardOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardOne.setForeground(new Color(211, 211, 211));
		cardOne.setBounds(21, 22, 163, 273);
		contentPane.add(cardOne);

		JLabel cardTwo = new JLabel("");
		cardTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardTwo.setForeground(new Color(211, 211, 211));
		cardTwo.setBounds(222, 22, 163, 273);
		contentPane.add(cardTwo);

		JLabel cardThree = new JLabel("");
		cardThree.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardThree.setForeground(new Color(211, 211, 211));
		cardThree.setBounds(427, 22, 163, 273);
		contentPane.add(cardThree);

		JLabel cardFour = new JLabel("");
		cardFour.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardFour.setForeground(new Color(211, 211, 211));
		cardFour.setBounds(21, 334, 163, 273);
		contentPane.add(cardFour);

		JLabel cardFive = new JLabel("");
		cardFive.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardFive.setForeground(new Color(211, 211, 211));
		cardFive.setBounds(222, 334, 163, 273);
		contentPane.add(cardFive);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(638, 22, 347, 585);
		contentPane.add(scrollPane);

		JLabel infoLabel = new JLabel("<html><h2 style=\"color: black\"> <i> Czy mo�emy zaczyna�? </i></h2></html>");

		Border border = infoLabel.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 5);
		infoLabel.setBorder(new CompoundBorder(border, margin));

		scrollPane.setViewportView(infoLabel);
		infoLabel.setBackground(new Color(0, 0, 0));
		infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		infoLabel.setForeground(new Color(0, 0, 0));

		addAdapter(cardOne, infoLabel);
		addAdapter(cardTwo, infoLabel);
		addAdapter(cardThree, infoLabel);
		addAdapter(cardFour, infoLabel);
		addAdapter(cardFive, infoLabel);

		JButton generateButton = new JButton("");

		ImageIcon imageIcon = new ImageIcon("./resource/back.png");
		Image image = imageIcon.getImage();
		generateButton.setBounds(427, 334, 162, 273);
		Image newimg = image.getScaledInstance(generateButton.getWidth(), generateButton.getHeight(),
				java.awt.Image.SCALE_SMOOTH);

		ImageIcon newImageIcon = new ImageIcon(newimg);

		generateButton.setIcon(newImageIcon);

		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> list = generateNumbers();
				cardService.setIconAndText(cardOne, dictionary.getCard(list.get(0)));
				cardService.setIconAndText(cardTwo, dictionary.getCard(list.get(1)));
				cardService.setIconAndText(cardThree, dictionary.getCard(list.get(2)));
				cardService.setIconAndText(cardFour, dictionary.getCard(list.get(3)));
				cardService.setIconAndText(cardFive, dictionary.getCard(list.get(4)));
				infoLabel.setText("");

			}
		});

		contentPane.add(generateButton);

	}

	void addAdapter(JLabel card, JLabel infoLabel) {
		card.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				infoLabel.setText(card.getToolTipText());
			}
		});
	}

	List<Integer> generateNumbers() {

		int max = 68;
		int min = 1;

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		while (numbers.size() < 5) {

			int random = (int) ((Math.random() * (max - min)) + min);

			if (!numbers.contains(random)) {
				numbers.add(random);
			}
		}
		return numbers;
	}
}