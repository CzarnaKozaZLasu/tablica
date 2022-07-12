import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	Map<Integer, CardInfo> map = new HashMap<Integer, CardInfo>();

	CardInfo getCard(Integer number) {
		return map.get(number);
	}

	Dictionary() {

		int index = 1;

		map.put(index++, new CardInfo("Anthropos"));
		map.put(index++, new CardInfo("Demiurge"));
		map.put(index++, new CardInfo("Astaroth"));
		map.put(index++, new CardInfo("Kether"));
		map.put(index++, new CardInfo("Chokmah"));
		map.put(index++, new CardInfo("Binah"));
		map.put(index++, new CardInfo("Chesed"));
		map.put(index++, new CardInfo("Geburah"));
		map.put(index++, new CardInfo("Tiphareth"));
		map.put(index++, new CardInfo("Netzach"));
		map.put(index++, new CardInfo("Hod"));
		map.put(index++, new CardInfo("Yesod"));
		map.put(index++, new CardInfo("Malkuth"));
		map.put(index++, new CardInfo("Thaumiel"));
		map.put(index++, new CardInfo("Chagidiel"));
		map.put(index++, new CardInfo("Sathariel"));
		map.put(index++, new CardInfo("Gamichicoth"));
		map.put(index++, new CardInfo("Golab"));
		map.put(index++, new CardInfo("Togarini"));
		map.put(index++, new CardInfo("Hareb-Serap"));
		map.put(index++, new CardInfo("Samael"));
		map.put(index++, new CardInfo("Gamaliel"));
		map.put(index++, new CardInfo("Nahemoth"));

		for (int number = 1; number < 10; number++) {
			map.put(index++, new CardInfo("Skull", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new CardInfo("Rose", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new CardInfo("Hourglass", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new CardInfo("Crescent", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new CardInfo("Eye", number));
		}

	}

}
