package scheduler;

public enum Day {
	
	 MONDAY(),
	 TUESDAY(),
	 WEDNESDAY(),
	 THURSDAY(),
	 FRIDAY(),
	 SATURDAY(),
	 SUNDAY();
	 
	 private LinkedList<Event> evts;

	 
	 Day(){ // because constructor's parenthese is not asking for anything//
		 this.evts = new LinkedList <Event> ();
	 }

	 public LinkedList<Event> getEvts() {
	  return evts;
	 }
	 public void addEvent (Event event) { 
		 evts.add(event);
		 //event is a single event//
	 }
	 
	 public void removeEvent (String time) { // node is a piece of our list//
		 Node <Event> current = evts.getHead(); // now we have a node, <event> let the computer know this is an event//
		for (int i = 0;i<evts.size();i++) {
			if (current.getValue().getTime().equals(time)) {
				evts.remove(i);
				break; //stop when we find the matching event to time//
			}
			current = current.getNext();		 // if we didn't get it we will move to the next thing on the list//
			}
	
	 }
	 public String viewEvents() { // we want to view all the events for the day//
		 String eventsofDay= "";
		 Node <Event> current = evts.getHead();
		 for (int i=0;i<evts.size();i++) {
			 eventsofDay += current.getValue().getTime()+": "+current.getValue().getEventInfo()+"\n";
			 current = current.getNext(); // gotten a value from current node, let's move to the next one//
		 }
		 if (eventsofDay.length()==0) {
			 return "No event is scheduled on this day.";
		 }
		 return eventsofDay;
		 
	 }
}
