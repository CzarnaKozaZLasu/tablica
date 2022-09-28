import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardService {

	private final ReadFileService readFileService;

	public CardService(ReadFileService readFileService) {
		this.readFileService = readFileService;
	}

	public void setIconAndText(CardLabel card, CardInfo cardInfo, boolean showNames) {

		String name = cardInfo.name;
		int number = cardInfo.number;
		String text = "";

		if (number != 0)
			text = number + "";

		String cardText = this.readFileService.getFirstLine(name + text);
		String description = this.readFileService.getHtmlText(name + text);
		description = editText(description, "Postacie:");
		description = editText(description, "Miejsca:");
		description = editText(description, "Organizacje:");
		description = editText(description, "Zdarzenia:");
		description = editText(description, "Stworzenia:");
		description = editText(description, "Przedmioty:");

		card.setDescriptiont(description);

		ImageIcon imageIcon = new ImageIcon("./resource/" + name + ".png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(card.getWidth(), card.getHeight(), java.awt.Image.SCALE_SMOOTH);

		if (number != 0) {
			if (showNames)
				card.setText("<html> <center> <p style=\"font-size:30px; color: white\">" + cardText.substring(0, 1)
						+ " </p>" + "<p style=\"color:white\">" + cardText.substring(2) + "</p>"
						+ "<br> <br> <br> <br> <br> </center> </html>");
			else {
				card.setText("<html> <center> <br> <br> <p style=\"font-size:40px; color: white\">"
						+ cardText.substring(0, 1) + "<br> <br> </center> </html>");
			}
		} else
			card.setText("");

		card.setHorizontalTextPosition(JLabel.CENTER);
		card.setVerticalTextPosition(JLabel.CENTER);

		ImageIcon newImageIcon = new ImageIcon(newimg);
		card.setIcon(newImageIcon);

	}

	private String editText(String text, String word) {
		return text.replaceFirst(word, "<b><span style=\"color: #b30000\">" + word + "</span></b>");
	}

}
