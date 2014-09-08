package things;

import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Things {
	
	/*This is a program that does
	well, things...*/
	
	public static boolean isNumeric(String str){
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	
	public static void allTheThings(String things){
		Integer manythings = 0;
		JFrame frame = new JFrame("Things");
		JTextArea text = new JTextArea("TEXT");
		
		text.setSize(200,100);
		frame.setSize(200,100);
		frame.add(text);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		if(things.equalsIgnoreCase("All")){
			for(int i=1; i<3; i++){
				text.setText(manythings+" THINGS");
				manythings++;
				i=1;
				if(manythings==2147483647){
					frame.setVisible(false);
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					JOptionPane.showMessageDialog(null, "I'm sorry but I've run out of things to do.\nI guess you have done them all...", null, 1, null);
					i=3;
				}
			}
		}else{
			if (isNumeric(things)){
				Integer intmany = Integer.parseInt(things);
				for(int i=1; i<=intmany; i++){
					text.setText(i+" THINGS");
				}
				JOptionPane.showMessageDialog(null, "Congratulations you did "+intmany+" things!", null, 1, null);
			}else{
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "What do you mean by that?\nWe are incabable of doing that..", null, 1, null);
			}
		}
		frame.setVisible(false);
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	public static void main(String args[]){ //The start is down here because I said so...
		String many = JOptionPane.showInputDialog(null, "How many things should we do?", null);
		allTheThings(many);
	}
}