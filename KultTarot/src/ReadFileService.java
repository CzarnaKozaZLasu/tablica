import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileService {

	public ReadFileService() {

	}

	String getHtmlText(String fileName) {

		String text = "<html>";
		Scanner scanner;
		try {
			scanner = new Scanner(new File("./resource/" + fileName + ".txt"), "utf-8");

			while (scanner.hasNextLine()) {
				text += scanner.nextLine() + "<br>";
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		text += "</html>";

		return text;
	}

	String getFirstLine(String fileName) {

		String text = "";
		Scanner scanner;
		try {
			scanner = new Scanner(new File("./resource/" + fileName + ".txt"), "utf-8");
			text += scanner.nextLine();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		text += "";
		return text;
	}

}
