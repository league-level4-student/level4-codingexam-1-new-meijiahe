package scheduler;

public enum Day {

	MONDAY(), TUESDAY(), WEDNESDAY(), THURSDAY(), FRIDAY(), SATURDAY(), SUNDAY();

	private LinkedList<Event> evts;

	Day() { // because constructor's parenthese is not asking for anything//
		this.evts = new LinkedList<Event>();
	}

	void sort() {
		LinkedList<Event> events = new LinkedList<Event>();
		// we want to get the earliest, so we have the latest time to compare with
		// anytime that comes earlier
		while (evts.size() > 0) { // all of the stuff between is getting the earlist time, remove from old list,
									// add to new list
			// by doing that, we will evenetually have all the things lined up in
			// chronological order to the new list//
			Node<Event> current = evts.getHead();
			int earliestPosition = 0;
			for (int i = 0; i < evts.size() - 1; i++) { // the last node doesn't have a next node so size-1
				// node size -1 guarrantee that current will never be the last node
				Node<Event> next = current.getNext(); // two node object can compare the time to find out which one is
														// earlier than another
				String currentTime = current.getValue().getTime();
				String nextTime = next.getValue().getTime();
				if (currentTime.compareTo(nextTime) > 0) { // we want to see if currentTime happens later, so we don't
															// wwant current time, replace it with nextTim
					// cuz the point is to find the earlist in the list.
					current = next;
					earliestPosition = i + 1;
				}
			}
			// we will find the earlist node in our list
			evts.remove(earliestPosition);
			events.add(current.getValue());
		}
		evts = events;
		// get the smalles thing in the old list and put it into the new list so it
		// wouldn't have anything left in the oldlist//
	}

	public LinkedList<Event> getEvts() {
		return evts;
	}

	public void addEvent(Event event) throws SchedulingConflictException { //the exception will be performed when we use this method
		Node<Event> current = evts.getHead();
		for (int i = 0; i < evts.size(); i++) {
			if (current.getValue().getTime().equals(event.getTime())) { // ask if the pass in time is the same as the single event in our list
				throw new SchedulingConflictException ();					// any time in our existed list
			}
			current = current.getNext(); // otherwise it will just keep on asking the first thing in the list
		}
		evts.add(event);
		sort(); // when we add any events to the schedule, we can just sort right after//
		// event is a single event//
	}

	public void removeEvent(String time) { // node is a piece of our list//
		Node<Event> current = evts.getHead(); // now we have a node, <event> let the computer know this is an event//
		for (int i = 0; i < evts.size(); i++) {
			if (current.getValue().getTime().equals(time)) {
				evts.remove(i);
				break; // stop when we find the matching event to time//
			}
			current = current.getNext(); // if we didn't get it we will move to the next thing on the list//
		}

	}

	public String viewEvents() { // we want to view all the events for the day//
		sort();
		String eventsofDay = "";
		Node<Event> current = evts.getHead();
		for (int i = 0; i < evts.size(); i++) {
			eventsofDay += current.getValue().getTime() + ": " + current.getValue().getEventInfo() + "\n";
			current = current.getNext(); // gotten a value from current node, let's move to the next one//
		}
		if (eventsofDay.length() == 0) {
			return "No event is scheduled on this day.";
		}
		return eventsofDay;

	}
}
