
public class StandardCardLabel extends CardLabel {

	public StandardCardLabel(String text) {
		super(text);
	}

	@Override
	String getPathToImage() {
		return "./resource/back.png";
	}

}
