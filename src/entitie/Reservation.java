package entitie;

import java.util.Date;

import javax.xml.crypto.Data;

public class Reservation {
	private Integer roomNumber;
	private Data checkin;
	private Data checkout;
	
	public Reservation(Integer roomNumber, Data checkin, Data checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Data getCheckin() {
		return checkin;
	}
	
	public Data getCheckout() {
		return checkout;
	}
	
	public Integer duration() {
		return 0;
	}
	public void updateDates(Date checkin, Date checkout ) {
		
	}
	
	
	

}
