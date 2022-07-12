import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SmallCardLabel extends CardLabel{

	public SmallCardLabel(String text) {
		super(text);
	}

	@Override
	String getPathToImage() {
		return "./resource/additionalCard.png";
	}


}
