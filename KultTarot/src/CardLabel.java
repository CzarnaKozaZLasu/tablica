import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class CardLabel extends JLabel {

	private boolean hidden = true;
	private Icon icon;
	private String text;
	private String description;
	private String tooltipText;

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
		this.setToolTipText(tooltipText);
	}

	void showCard() {
		this.hidden = false;
		this.setIcon(icon);
		this.setText(text);
		this.setToolTipText(tooltipText);
	}

	public void setToolTipText(String text) {
		this.tooltipText = text;
		if (!hidden) {
			super.setToolTipText(text);
			return;
		}

		super.setToolTipText("");
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
		if (!hidden) {
			super.setIcon(icon);
			return;
		}

		ImageIcon imageIcon = new ImageIcon(getPathToImage());
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

	public void setDescriptiont(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	abstract String getPathToImage();
}
