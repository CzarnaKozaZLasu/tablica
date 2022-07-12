import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardLabel extends JLabel {

	boolean hidden = true;
	Icon icon;
	String text;

	public CardLabel(String text) {
		super(text, null, LEADING);

		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				showCard();
			}
		});
	}

	void hideCard() {
		this.hidden = true;
		this.setIcon(icon);
		this.setText(text);
	}

	void showCard() {
		this.hidden = false;
		this.setIcon(icon);
		this.setText(text);
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
		if (!hidden) {
			super.setIcon(icon);
			return;
		}

		ImageIcon imageIcon = new ImageIcon("./resource/back.png");
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);

		ImageIcon newImageIcon = new ImageIcon(newimg);
		super.setIcon(newImageIcon);
	}

	public void setText(String text) {
		this.text = text;
		if (!hidden)
			super.setText(text);
		else
			super.setText("");
	}

}
