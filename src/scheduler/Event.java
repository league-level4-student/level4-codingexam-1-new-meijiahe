package scheduler;

public enum Event {
	
	 MONDAY(Days.Monday,new LinkedList<SingleEvent>()),
	 TUESDAY(Days.Tuesday, new LinkedList<SingleEvent>()),
	 WEDNESDAY(Days.Wednesday,new LinkedList<SingleEvent>()),
	 THURSDAY(Days.Thursday, new LinkedList<SingleEvent>()),
	 FRIDAY(Days.Friday, new LinkedList<SingleEvent>()),
	 SATURDAY(Days.Saturday, new LinkedList<SingleEvent>()),
	 SUNDAY(Days.Sunday, new LinkedList<SingleEvent>());
	 
	 private LinkedList<SingleEvent> evts;
	 private Days dd;
	 
	 Event(Days dd, LinkedList<SingleEvent> evts){
	  this.dd =dd;
	  this.evts = evts;
	 }

	 public LinkedList<SingleEvent> getEvts() {
	  return evts;
	 }
	 
	 public Days getDays() {
	  return dd;
	 }
	 
	
}
