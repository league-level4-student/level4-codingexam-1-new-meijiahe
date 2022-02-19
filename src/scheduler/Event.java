package scheduler;

public class Event {
	private String time;
	private String eventInfo;
	
	Event (String time, String eventInfo){
		this.time = time;
		this.eventInfo = eventInfo;
	}
	String getTime() {
		
		return time;
	}
	String getEventInfo() {
		return eventInfo;
	}
}
