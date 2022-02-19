package scheduler;

import javax.swing.JOptionPane;

/*
 * Objective: Create a weekly scheduling application.
 * 
 * You may create any additional enums, classes, methods or variables needed
 * to accomplish the requirements below:
 * 
 * - You should use an array filled with enums for the days of the week and each
 *   enum should contain a LinkedList of events that includes a time and what is 
 *   happening at the event. 
 * 
 * - The user should be able to to interact with your application through the
 *   console and have the option to add events, view events or remove events by
 *   day.
 *   
 * - Each day's events should be sorted by chronological order.
 *  
 * - If the user tries to add an event on the same day and time as another event
 *   throw a SchedulingConflictException(created by you) that tells the user
 *   they tried to double book a time slot.
 *   
 * - Make sure any enums or classes you create have properly encapsulated member
 *   variables.
 */
public class Scheduler {

	static Day[] week = { Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY };

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			String[] actions = new String[] { "Add", "Remove", "View" };
//input dialog can display a message//
			int chosenAction = JOptionPane.showOptionDialog(null, "What action do you want to do?", null,
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, actions, actions[0]);
			// default option is the first thing of the options (singular action),0 first
			// opiton in the list//
			if (chosenAction == 0) {
				addEvents();
			}
			if (chosenAction == 1) { // to remove the events//
				removeEvents();
			}
			if (chosenAction == 2) { // to view events//
				viewEvents();
			}
		}

	}

	static void addEvents() { // we have made a method to get and add event to our days//
		int day = JOptionPane.showOptionDialog(null, "What day do you want to schedule an event?", "Pick a day",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, week, week[0]);
		// week is use my name's array and set this option. week[0] is the default
		// option//
		String time = JOptionPane.showInputDialog("What is the time you want?");
	//	int time = Integer.parseInt(timestring);//
		String eventinfo = JOptionPane.showInputDialog("what is the event info?");
		Event ev = new Event(time, eventinfo); // create an event object, now let particular day to add event//
		week[day].addEvent(ev); // now we add one event to day//

	}

	// if a varible is created inside a method it can't be used outside of the
	// method (local varaibel)//
	static void removeEvents() {

		int day = JOptionPane.showOptionDialog(null, "What day do you want to remove an event?", "Pick a day",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, week, week[0]);
		// week is use my name's array and set this option. week[0] is the default
		// option//
		String time = JOptionPane.showInputDialog("What is the time you want to remove?");
		//int time = Integer.parseInt(timestring);
		week[day].removeEvent(time); // now we remove one event to the accordinate day//

	}

	static void viewEvents() {
		int day = JOptionPane.showOptionDialog(null, "What day do you want to view events?", "Pick a day",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, week, week[0]);
		// week is use my name's array and set this option. week[0] is the default
		// option//
		// we only need the day date. //
		String eventResponse = week[day].viewEvents(); // we have our event info of the day//
		JOptionPane.showMessageDialog(null, eventResponse);
		
	}

	void sort(Day[] week) {
		for (int i = 0; i < week.length; i++) {
			for (int j = i + 1; j < week.length; j++) {
				if (week[i].equals(week[j])) {
					Day t = week[i];
					week[i] = week[j];
					week[j] = t;
				}
			}
		}

	}
}
