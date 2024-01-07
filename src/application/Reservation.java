package application;
import java.util.Date;



public class Reservation {
	
	
	private int ReservationID;
	private int GuestID;
	private int RoomID;
	private int PaymentID;
	private Date CheckInDate;
	private Date CheckOutDate;
	private String RoomNumber;
	private String LastName;
	private String FirstName;
	private double Amount;
	private Date PaymentDate;
	
	public Reservation(int reservationID, int guestID, int roomID,int paymentID, Date checkInDate, Date checkOutDate,String roomNumber, String lastName, String firstName,
			
						double moun , Date paymentDate) {
		super();
		ReservationID = reservationID;
		GuestID = guestID;
		RoomID = roomID;
		PaymentID = paymentID;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		RoomNumber = roomNumber;
		LastName = lastName;
		FirstName = firstName;
		Amount=moun;
		PaymentDate=paymentDate;
	}

	public int getReservationID() {
		return ReservationID;
	}

	public void setReservationID(int reservationID) {
		ReservationID = reservationID;
	}

	public int getGuestID() {
		return GuestID;
	}

	public void setGuestID(int guestID) {
		GuestID = guestID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	public Date getCheckInDate() {
		return CheckInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return CheckOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}

	public String getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public int getPaymentID() {
		return PaymentID;
	}

	public void setPaymentID(int paymentID) {
		PaymentID = paymentID;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}
	
	
	
	
	
	
	
}
