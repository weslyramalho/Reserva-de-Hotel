package entitie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

public class Reservation {
	private Integer roomNumber;
	private Data checkin;
	private Data checkout;
	
	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Data checkin, Data checkout) {
		if (!checkout.after(checkin)) {
			throw new DomainException("A data de saida deve ser posterior à data de entrada ")
		}
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
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return 0;
	}
	public void updateDates(Date checkin, Date checkout ) {
			Date now = new Date();
			if(checkin.before(now) || checkout.before(now)) {
				throw new DomainException("As datas de reserva para atualização devem ser datas futuras");
			
		}
			if(!checkout.after(checkin)) {
				throw new DomainException("A data de saida deve ser posterior à data de entrada");

			}
			this.checkin = checkin;
			this.checkout = checkout;
	}
	
	@Override
	public String toString() {
		return "Room"
				+ roomnumber
				+ ", check-in: "
				+ df.format(checkin)
				+ ", checkout: "
				+ df.format(checkout)
				+ ", "
				+ duration()
				+ " nights";
	}
	
	
	

}
