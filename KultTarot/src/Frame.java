import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class Frame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UIManager.put("ToolTip.background", new ColorUIResource(238, 238, 238));
		ToolTipManager.sharedInstance().setDismissDelay(1000 * 10);
		ToolTipManager.sharedInstance().setInitialDelay(500);

		ReadFileService readFileService = new ReadFileService();
		CardService cardServie = new CardService(readFileService);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame(cardServie, readFileService);
					frame.setTitle("Kult Boskoœæ Utracona Tarot");
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
	public Frame(CardService cardService, ReadFileService readFileService) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1009, 663);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Dictionary dictionary = new Dictionary();

		CardLabel cardOne = new StandardCardLabel("");
		cardOne.setToolTipText(editToolTipText(readFileService.getHtmlText("card2")));
		cardOne.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardOne.setForeground(new Color(211, 211, 211));
		cardOne.setBounds(21, 22, 163, 273);
		contentPane.add(cardOne);

		CardLabel cardTwo = new StandardCardLabel("");
		cardTwo.setToolTipText(editToolTipText(readFileService.getHtmlText("card1")));
		cardTwo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardTwo.setForeground(new Color(211, 211, 211));
		cardTwo.setBounds(222, 22, 163, 273);
		contentPane.add(cardTwo);

		CardLabel cardThree = new StandardCardLabel("");
		cardThree.setToolTipText(editToolTipText(readFileService.getHtmlText("card4")));
		cardThree.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardThree.setForeground(new Color(211, 211, 211));
		cardThree.setBounds(427, 22, 163, 273);
		contentPane.add(cardThree);

		CardLabel cardFour = new StandardCardLabel("");
		cardFour.setToolTipText(editToolTipText(readFileService.getHtmlText("card3")));
		cardFour.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardFour.setForeground(new Color(211, 211, 211));
		cardFour.setBounds(21, 334, 163, 273);
		contentPane.add(cardFour);

		CardLabel cardFive = new StandardCardLabel("");
		cardFive.setToolTipText(editToolTipText(readFileService.getHtmlText("card5")));
		cardFive.setFont(new Font("Tahoma", Font.BOLD, 12));
		cardFive.setForeground(new Color(211, 211, 211));
		cardFive.setBounds(222, 334, 163, 273);
		contentPane.add(cardFive);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(638, 22, 347, 585);
		contentPane.add(scrollPane);

		JLabel infoLabel = new JLabel("<html><h2 style=\"color: black\"> <i> Czy mo¿emy zaczynaæ? </i></h2></html>");

		Border border = infoLabel.getBorder();
		Border margin = new EmptyBorder(10, 10, 10, 5);
		infoLabel.setBorder(new CompoundBorder(border, margin));

		scrollPane.setViewportView(infoLabel);
		infoLabel.setBackground(new Color(0, 0, 0));
		infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		infoLabel.setForeground(new Color(0, 0, 0));

		CardLabel cardAdditionalOne = new SmallCardLabel("");
		cardAdditionalOne.setBounds(427, 480, 83, 127);

		CardLabel cardAdditionalTwo = new SmallCardLabel("");
		cardAdditionalTwo.setBounds(427, 343, 83, 127);

		CardLabel cardAdditionalThree = new SmallCardLabel("");
		cardAdditionalThree.setBounds(520, 343, 83, 127);

		addAdapter(cardOne, infoLabel);
		addAdapter(cardTwo, infoLabel);
		addAdapter(cardThree, infoLabel);
		addAdapter(cardFour, infoLabel);
		addAdapter(cardFive, infoLabel);
		addAdapter(cardAdditionalOne, infoLabel);
		addAdapter(cardAdditionalTwo, infoLabel);
		addAdapter(cardAdditionalThree, infoLabel);

		JButton generateButton = new JButton("");

		ImageIcon imageIcon = new ImageIcon("./resource/deck.png");
		Image image = imageIcon.getImage();
		generateButton.setBounds(520, 480, 94, 127);
		Image newimg = image.getScaledInstance(generateButton.getWidth(), generateButton.getHeight(),
				java.awt.Image.SCALE_SMOOTH);

		ImageIcon newImageIcon = new ImageIcon(newimg);

		generateButton.setIcon(newImageIcon);

		generateButton.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				cardOne.hideCard();
				cardTwo.hideCard();
				cardThree.hideCard();
				cardFour.hideCard();
				cardFive.hideCard();
				cardAdditionalOne.hideCard();
				cardAdditionalTwo.hideCard();
				cardAdditionalThree.hideCard();
				List<Integer> list = generateNumbers();
				cardService.setIconAndText(cardOne, dictionary.getCard(list.get(0)));
				cardService.setIconAndText(cardTwo, dictionary.getCard(list.get(1)));
				cardService.setIconAndText(cardThree, dictionary.getCard(list.get(2)));
				cardService.setIconAndText(cardFour, dictionary.getCard(list.get(3)));
				cardService.setIconAndText(cardFive, dictionary.getCard(list.get(4)));
				cardService.setIconAndText(cardAdditionalOne, dictionary.getCard(list.get(5)));
				cardService.setIconAndText(cardAdditionalTwo, dictionary.getCard(list.get(6)));
				cardService.setIconAndText(cardAdditionalThree, dictionary.getCard(list.get(7)));
				infoLabel.setText("");

			}
		});

		contentPane.add(generateButton);

		contentPane.add(cardAdditionalOne);

		contentPane.add(cardAdditionalTwo);

		contentPane.add(cardAdditionalThree);

	}

	void addAdapter(CardLabel card, JLabel infoLabel) {
		card.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				infoLabel.setText(card.getDescription());
			}
		});
	}

	List<Integer> generateNumbers() {

		int max = 69;
		int min = 1;

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		while (numbers.size() < 8) {

			int random = (int) ((Math.random() * (max - min)) + min);

			if (!numbers.contains(random)) {
				numbers.add(random);
			}
		}
		return numbers;
	}

	private String editToolTipText(String text) {
		return this.editText(this.editText(this
				.editText(this.editText(this.editText(this.editText(text, "POSTAÆ:"), "LOKACJA:"), "KULT:"), "W¥TKI:"),
				"STWORZENIE:"), "ARTEFAKT:");
	}

	private String editText(String text, String word) {
		return text.replaceFirst(word, "<b><span style=\"color: #ef6602\">" + word + "</span></b>");
	}
}
