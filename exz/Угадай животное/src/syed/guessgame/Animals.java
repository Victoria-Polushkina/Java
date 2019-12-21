package syed.guessgame;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Animals implements Runnable{
	
	public Base cow = new Base(4, true, true, Base.SIZE_CATTLE, Base.COLOR_BROWN, Base.MOO, "������", false, true, Base.MIDDLE);
	public Base sheep = new Base(4, true, false, Base.SIZE_DOG, Base.COLOR_WHITE, Base.BAA, "������", false, false, Base.MIDDLE);
	public Base dog = new Base(4, true, false, Base.SIZE_DOG, Base.COLOR_OTHER, Base.WOOF, "������", false, true, Base.TOP);
	public Base pig = new Base(4, true, false, Base.SIZE_DOG, Base.COLOR_PINK, Base.OINK, "������", false, true, Base.MIDDLE);
	public Base spider = new Base(8, false, false, Base.SIZE_INSECT, Base.COLOR_OTHER, Base.NONE, "����", false, true, Base.MIDDLE);
	public Base chicken = new Base(2, false, false, Base.SIZE_RODENT, Base.COLOR_WHITE, Base.CLUCK, "������", true, true, Base.MIDDLE);
	public Base cat = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_YELLOW, Base.MEOW, "�����", false, true, Base.TOP);
	public Base hamster = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_OTHER, Base.SQUEAK, "�����", false, true, Base.MIDDLE);
	public Base owl = new Base(2, true, false, Base.SIZE_RODENT, Base.COLOR_OTHER, Base.TWITTWOO, "����", true, true, Base.TOP);
	public Base cockroach = new Base(8, false, false, Base.SIZE_INSECT, Base.COLOR_BROWN, Base.CLICK, "�������", true, true, Base.MIDDLE);
	public Base goat = new Base(4, true, true, Base.SIZE_DOG, Base.COLOR_OTHER, Base.BAA, "����", false, true, Base.MIDDLE);
	public Base platypus = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_BROWN, Base.OTHER, "�������", false, false, Base.MIDDLE);
	public Base frog = new Base(4, false, false, Base.SIZE_RODENT, Base.COLOR_GREEN, Base.CROAK, "�������", false, true, Base.MIDDLE);
	public Base giraffe = new Base(4, true, false, Base.SIZE_BIGGER, Base.COLOR_BROWN, Base.OTHER, "�����", false, true, Base.MIDDLE);
	public Base fly = new Base(6, false, false, Base.SIZE_INSECT, Base.COLOR_BLACK, Base.BUZZ, "�����", true, true, Base.MIDDLE);
	public Base beetle = new Base(6, false, false, Base.SIZE_INSECT, Base.COLOR_OTHER, Base.NONE, "���", true, true, Base.MIDDLE);
	public Base horse = new Base(4, true, false, Base.SIZE_CATTLE, Base.COLOR_WHITE, Base.OTHER, "������", false, true, Base.MIDDLE);
	public Base bear = new Base(4, true, false, Base.SIZE_CATTLE, Base.COLOR_BROWN, Base.OTHER, "�������", false, false, Base.TOP);
	public Base rabbit = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_OTHER, Base.OTHER, "������", false, true, Base.MIDDLE);
	public Base lion = new Base(4, true, false, Base.SIZE_CATTLE, Base.COLOR_YELLOW, Base.ROAR, "���", false, true, Base.TOP);
	public Base bird = new Base(2, true, false, Base.SIZE_RODENT, Base.COLOR_OTHER, Base.OTHER, "�����", true, true, Base.MIDDLE);
	public Base flea = new Base(6, false, false, Base.SIZE_INSECT, Base.COLOR_BROWN, Base.OTHER, "�����", false, true, Base.MIDDLE);
	public Base penguin = new Base(2, true, false, Base.SIZE_DOG, Base.COLOR_OTHER, Base.OTHER, "�������", false, true, Base.MIDDLE);
	public Base squirrel = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_BROWN, Base.OTHER, "�����", false, true, Base.MIDDLE);
	public Base meercat = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_OTHER, Base.OTHER, "�������", false, true, Base.MIDDLE);
	public Base elephant = new Base(4, true, false, Base.SIZE_BIGGER, Base.COLOR_GREY, Base.TRUMPETS, "����", false, false, Base.TOP);
	public Base turtle = new Base(4, true, false, Base.SIZE_RODENT, Base.COLOR_GREEN, Base.OTHER, "��������", false, true, Base.MIDDLE);
	public Base seal = new Base(2, true, false, Base.SIZE_BIGGER, Base.COLOR_OTHER, Base.OTHER, "������", false, true, Base.MIDDLE);
	public Base zebra = new Base(4, true, false, Base.SIZE_CATTLE, Base.COLOR_OTHER, Base.OTHER, "�����", false, true, Base.MIDDLE);
	public Base panda = new Base(4, true, false, Base.SIZE_DOG, Base.COLOR_OTHER, Base.OTHER, "�����", false, true, Base.MIDDLE);
	public Base flamingo = new Base(2, true, false, Base.SIZE_DOG, Base.COLOR_PINK, Base.OTHER, "��������", true, false, Base.MIDDLE);
	public Base cheeta = new Base(4, true, false, Base.SIZE_DOG, Base.COLOR_YELLOW, Base.OTHER, "������", false, true, Base.TOP);
	public Base monkey = new Base( 2, true, false, Base.SIZE_DOG, Base.COLOR_BROWN, Base.OTHER, "��������", false, false, Base.TOP);

	public List<String>	animalNameList	= new ArrayList<String>();
	public List<Base>	animalList = new ArrayList<Base>();

	public Animals() {
		Field[] animals = this.getClass().getDeclaredFields();
		for (Field f:animals) {
			if(f.getType().equals(Base.class)){
				try {
					animalList.add((Base) f.get(this));
					animalNameList.add(((Base) f.get(this)).getName());
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void run() {
		String jtaTextTemp = "Animals List:\n\n";
		for (int i = 0; i < animalList.size(); i++) {
			try {
				jtaTextTemp += animalList.get(i).getName() + "\n";
				System.out.println(animalList.get(i).getName());
			} catch (Exception e) {
				System.err.println("<Intelligence> FAILED TO ADD '" + animalNameList.get(i) + "' TO LIST");
			}

		}
		MainClass.jta.setText(jtaTextTemp);
	}

}
