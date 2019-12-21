package syed.guessgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MainClass extends JFrame{
	
	private static MainClass m = new MainClass();
	private static Specifications I = new Specifications();
	private static Animals A = new Animals();
	public static JFrame frame = new JFrame();
	private Color bodycolor= new Color(253,253,201);
	public static String eol = System.getProperty("line.separator");
	
	public static JTextArea jta = new JTextArea();
	
	
	public static Thread animals = new Thread(A);
	public static Thread logic = new Thread(I);
	
	
	
	public static void main(String[] args){
		m.setUpFrame();
		m.centreWindow(frame);
		JOptionPane.showMessageDialog(null, "Добро пожаловать в игру Угадай животное!"+eol+"Повеселись!", "Угадай животное", JOptionPane.INFORMATION_MESSAGE);
		animals.start();
		JOptionPane.showMessageDialog(null, "Выбери животное из списка...", "Угадай животное", JOptionPane.INFORMATION_MESSAGE);
		logic.start();
		
	}
	
	/**Frame set up*/
	private void setUpFrame(){
		frame.setTitle("Угадай животное");
		frame.setVisible(true);
		frame.setSize(600,600);
		frame.getContentPane();
		frame.setBackground(Color.BLUE);
		frame.setFocusable(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jta.setEditable(false);
		frame.add(jta);

	}
	
	public void centreWindow(Window frame) {
	    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x1 = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y1 = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x1, y1);
	    
	}
	
	
	}
	

