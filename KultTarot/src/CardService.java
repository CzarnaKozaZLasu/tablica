import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardService {

	public CardService() {
	}

	public void setIconAndText(JLabel card, Card cardInfo) {

		String name = cardInfo.name;
		int number = cardInfo.number;
		String text = "";
		String cardText = "";

		if (number != 0)
			text = number + "";

		String tooltipText = "<html>";
		Scanner scanner;
		try {
			scanner = new Scanner(new File("./resource/" + name + text + ".txt"), "utf-8");
			cardText += scanner.nextLine();
			tooltipText += cardText + "<br>";

			while (scanner.hasNextLine()) {
				tooltipText += scanner.nextLine() + "<br>";
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		tooltipText += "</html>";

		tooltipText = editText(tooltipText, "Postacie:");
		tooltipText = editText(tooltipText, "Miejsca:");
		tooltipText = editText(tooltipText, "Organizacje:");
		tooltipText = editText(tooltipText, "Zdarzenia:");
		tooltipText = editText(tooltipText, "Stworzenia:");
		tooltipText = editText(tooltipText, "Przedmioty:");

		card.setToolTipText(tooltipText);

		ImageIcon imageIcon = new ImageIcon("./resource/" + name + ".png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(card.getWidth(), card.getHeight(), java.awt.Image.SCALE_SMOOTH);

		if (number != 0)
			card.setText("<html> <center> <p style=\"font-size:30px\">" + cardText.substring(0, 1) + " </p>"
					+ cardText.substring(2) + "<br> <br> <br> <br> <br> </center> </html>");
		else
			card.setText("");

		card.setHorizontalTextPosition(JLabel.CENTER);
		card.setVerticalTextPosition(JLabel.CENTER);

		ImageIcon newImageIcon = new ImageIcon(newimg);
		card.setIcon(newImageIcon);

	}

	private String editText(String text, String word) {
		return text.replaceFirst(word, "<b><span style=\"color: #ef6602\">" + word + "</span></b>");
	}

}
