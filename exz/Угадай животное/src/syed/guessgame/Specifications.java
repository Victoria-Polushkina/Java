package syed.guessgame;

import java.util.List;

import javax.swing.JOptionPane;

public class Specifications implements Runnable {

	private Animals A = new Animals();

	String jtaTextTemp = "Animals list:\n\n";

	Object[]	howManyLegs	= { " 2 ", " 4 ", " 6 ", " 8 " };
	Object[]	tailWings	= { "да", "нет" };
	Object[]	size		= { "Размером с насекомое", "Размером с грызуна/кошку", "Размером с собаку", "Размером с крупный рогатый скот", "Большоооооой" };
	Object[]	sound		= { "Бее", "Муу", "Гав", "Ква", "нет", "Хрю", "Ко-ко-ко", "Мяу", "Писк", "Твить", "Кукареку", "ЖЖЖ","РррРрРР", "УУУУУ",
			"Другой" };
	Object[]	fchain		= { "Посередине", "Сверху" };

	Object[] color = { "Розовый", "Коричневый", "Зеленый", "Белый", "Черный", "Желтый", "Серый","Другой" };

	List<String>		animalNameList	= A.animalNameList;
	List<Base>	animalList		= A.animalList;
	

	int numOfAnimals;

	@Override
	public void run() {
		updateRemainingAnimals();
		howManyLegsAreThere();
	}

	/** Спрашивает игрока, сколько ног у выбранного животного */
	public void howManyLegsAreThere() {
		int question1 = JOptionPane.showOptionDialog(null, "Сколько ног у вашего животного?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, howManyLegs, howManyLegs[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 2) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 4) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 2) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 6) {
					animalList.remove(i);
				}
			}
		}
		if (question1 == 3) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i).getNumOfLegs() != 8) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (animalList.size() > 1) {
			doesItHaveATail();
		}
	}

	/** Спрашивает игрока, есть ли у выбранного животного хвост */
	public void doesItHaveATail() {
		int question1 = JOptionPane.showOptionDialog(null, "У вашего животного есть хвост?", "Угадай животное", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (!animalList.get(i).hasTail()) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasTail()) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();

		if (numOfAnimals > 1) {
			canMakeMilkForHuman();
		}

	}

	/** Спрашивает игрока, может ли выбранное животное давать молоко */
	public void canMakeMilkForHuman() {
		int question1 = JOptionPane.showOptionDialog(null, "Может ли ваше животное давать молоко?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (!animalList.get(i).makesMilkForHumans()) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).makesMilkForHumans()) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();

		if (numOfAnimals > 1) {
			howBigIsIt();
		}
	}

	/** Спрашивает игрока, насколько велико выбранное животное */
	public void howBigIsIt() {
		int question1 = JOptionPane.showOptionDialog(null, "Какой размера ваше животное?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, size, size[0]);
		if (question1 == 0) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSize() != 0) {
						animalList.remove(i);
					}
				}
			}
		}
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) != null) {
				if (animalList.get(i).getSize() != question1) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whatColorIsIt();
		}
	}

	/** Спрашивает игрока, какого цвета выбранное животное */
	public void whatColorIsIt() {
		int question1 = JOptionPane.showOptionDialog(null, "Какого цвета ваше животное?", "Угадай животное", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, color, color[0]);
		System.out.println(color[question1]);
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i) != null) {
				if (animalList.get(i).getColor() != (question1 + 1)) {
					animalList.remove(i);
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whatSoundDoesItMake();
		}

	}

	public void whatSoundDoesItMake() {
		int question1 = JOptionPane.showOptionDialog(null, "Какой звук издает ваше животное?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, sound, sound[0]);
		if (question1 == 0) {// baa
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 1) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// moo
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 2) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 2) {// woof
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 3) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 3) {// croak
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 4) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 4) {// none
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 5) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 5) {// oink
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 6) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 6) {// cluck
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 7) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 7) {// meow
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 8) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 8) {// squeak
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 9) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 9) {// twittwoo
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 10) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 10) {// click
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 11) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 11) {// buzz
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 12) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 12) {// roar
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 13) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 13) {// trumpets
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 14) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 14) {// other
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getSound() != 15) {
						animalList.remove(i);
					}
				}
			}
		}
		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			doesItHaveWingsThatFly();
		}

	}

	public void doesItHaveWingsThatFly() {
		int question1 = JOptionPane.showOptionDialog(null, "Может ли ваше животное летать?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {// true
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasWings() != true) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// false
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasWings() != false) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			canItHaveMoreThan1ColorOnItsBody();
		}
	}

	public void canItHaveMoreThan1ColorOnItsBody() {
		int question1 = JOptionPane.showOptionDialog(null,
				"Может ли ваше животное иметь 2 цвета на своем теле?" + MainClass.eol + "(больше 2 цветов)", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, tailWings, tailWings[0]);
		if (question1 == 0) {// true
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasMoreThan1Color() != true) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// false
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).hasMoreThan1Color() != false) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			whereIsItOnTheFoodChain();
		}
	}

	public void whereIsItOnTheFoodChain() {
		int question1 = JOptionPane.showOptionDialog(null, "Каков уровень вашего животного в пищевой цепи?", "Угадай животное",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, fchain, fchain[0]);
		if (question1 == 0) {// middle
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getFoodChainPlace() != 1) {
						animalList.remove(i);
					}
				}
			}
		}
		if (question1 == 1) {// top
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					if (animalList.get(i).getFoodChainPlace() != 2) {
						animalList.remove(i);
					}
				}
			}
		}

		updateRemainingAnimals();
		if (numOfAnimals > 1) {
			// System.exit(1);
			JOptionPane.showMessageDialog(null, "Извините, но я подумал о" + numOfAnimals + " животные любят это.", "Угадай животное", 2);
		}
	}

	public void updateRemainingAnimals() {
		jtaTextTemp = "Animals list:\n\n";
		numOfAnimals = 0;
		for (int i = 0; i < animalList.size(); i++) {
			try {
				jtaTextTemp += animalList.get(i).getName() + "\n";
				System.out.println(animalList.get(i).getName());
			} catch (Exception e) {
				System.err.println("<Intelligence> FAILED TO ADD '" + animalNameList.get(i) + "' TO LIST");
			}

			if (animalList.get(i) != null) {
				numOfAnimals += 1;
			}

		}
		MainClass.jta.setText(jtaTextTemp);

		if (numOfAnimals == 1) {
			for (int i = 0; i < animalList.size(); i++) {
				if (animalList.get(i) != null) {
					JOptionPane.showMessageDialog(null, "Я догадался, что ваше животное - это" + animalList.get(i).getName() + "",
							"Animal Guesser", 1);
				}
			}
		}
		if (numOfAnimals == 0) {
			JOptionPane.showMessageDialog(null, "У меня нет таких животных в моем списке!  Вы хотите добавить свое животное в список?", "Угадай животное", 1);
		}

	}

}
