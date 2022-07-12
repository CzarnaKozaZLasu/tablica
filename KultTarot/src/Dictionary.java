import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	Map<Integer, Card> map = new HashMap<Integer, Card>();

	Card getCard(Integer number) {
		return map.get(number);
	}

	Dictionary() {

		int index = 1;

		map.put(index++, new Card("Anthropos"));
		map.put(index++, new Card("Demiurge"));
		map.put(index++, new Card("Astaroth"));
		map.put(index++, new Card("Kether"));
		map.put(index++, new Card("Chokmah"));
		map.put(index++, new Card("Binah"));
		map.put(index++, new Card("Chesed"));
		map.put(index++, new Card("Geburah"));
		map.put(index++, new Card("Tiphareth"));
		map.put(index++, new Card("Netzach"));
		map.put(index++, new Card("Hod"));
		map.put(index++, new Card("Yesod"));
		map.put(index++, new Card("Malkuth"));
		map.put(index++, new Card("Thaumiel"));
		map.put(index++, new Card("Chagidiel"));
		map.put(index++, new Card("Sathariel"));
		map.put(index++, new Card("Gamichicoth"));
		map.put(index++, new Card("Golab"));
		map.put(index++, new Card("Togarini"));
		map.put(index++, new Card("Hareb-Serap"));
		map.put(index++, new Card("Samael"));
		map.put(index++, new Card("Gamaliel"));
		map.put(index++, new Card("Nahemoth"));

		for (int number = 1; number < 10; number++) {
			map.put(index++, new Card("Skull", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new Card("Rose", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new Card("Hourglass", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new Card("Crescent", number));
		}
		for (int number = 1; number < 10; number++) {
			map.put(index++, new Card("Eye", number));
		}

	}

}
