package things;

import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Things {
	
	/*This is a program that does
	well, things...*/
	
	public static boolean isNumeric(String str){ //Checks if a string is numeric
	  NumberFormat formatter = NumberFormat.getInstance();
	  ParsePosition pos = new ParsePosition(0);
	  formatter.parse(str, pos);
	  return str.length() == pos.getIndex();
	}
	
	public static void allTheThings(String things){ //This is where it does all the things
		Integer manythings = 0; //Keeps track of how many things it's done
		JFrame frame = new JFrame("Things"); //Setting up the GUI to display how many things have been done
		JTextArea text = new JTextArea("TEXT");
		
		text.setSize(200,100); //More GUI stuff
		frame.setSize(200,100);
		frame.add(text);
		frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		if(things.equalsIgnoreCase("All")){ //If the user wants to do all the things...
			for(int i=1; i<3; i++){ //Then this loops until the max an integer can hold
				text.setText(NumberFormat.getNumberInstance(Locale.US).format(manythings)+" THINGS"); //Formats and displays how many
				manythings++; //Increases the counter
				i=1; //Keeps the loop going (yes I could have done this easier but that's too much effort...
				if(manythings==2147483647){ //If you have done all the things then good for you. You get nothing.. But a message.
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null, "I'm sorry but I've run out of things to do.\nI guess you have done them all...", null, 1, null);
					i=3; //Stops the loop
				}
			}
		}else{ //If the user didn't choose to do all the things
			if (isNumeric(things)){ //Check if what the user entered is a number
				Integer intmany = Integer.parseInt(things); //If it is then we shall do that many things
				for(int i=1; i<=intmany; i++){ //LOOP
					text.setText(NumberFormat.getNumberInstance(Locale.US).format(i)+" THINGS"); //Format and display again..
				}
				JOptionPane.showMessageDialog(null, "Congratulations you did "+intmany+" things!", null, 1, null); //Congratulations you did x amount of things!...
			}else{ //If the user did not want to do all the things and did not enter a number then there's nothing to do
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "What do you mean by that?\nWe are incabable of doing that..", null, 1, null); //Except yell at them
			}
		}
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); //Goodbye GUI
	}
	
	public static void main(String args[]){ //The start is down here because I said so...
		String many = JOptionPane.showInputDialog(null, "How many things should we do?", null); //We have to ask them how many things we should do
		allTheThings(many); //Do the amount of things they want
	}
}