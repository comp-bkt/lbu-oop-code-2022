package patrick.week7;

public class SmartBulb {

	private boolean currentOnStatus = false;
	private int id = -1;
	private String zone = "default";
	private int hub_id;
	
	
	public SmartBulb(int hub_id, int id) {
		this.hub_id = hub_id;
		this.id = id;
	}
	
	public void turnBulbOn(int hub_id) {
		if(this.hub_id==hub_id)
			this.currentOnStatus = true;
	}
	
	public void turnBulbOff(int hub_id) {
		if(this.hub_id==hub_id)
			this.currentOnStatus = false;
	}
	
	public void reset() {
		this.hub_id = 0;
		this.id = -1;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
}
