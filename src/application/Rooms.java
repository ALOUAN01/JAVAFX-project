package application;

import java.util.Date;

public class Rooms {
		
		private int RoomID;
	    private String RoomNumber;
	    private String RoomType;
	    private String BedNumbers;
	    private String Availability;
	    private String Rate;

	    public Rooms(int Id, String RoomNumber, String RoomType, String BedNumbers, String Availability,String Rate){
	        this.RoomID = Id;
	    	this.RoomNumber=RoomNumber;
	    	this.RoomType=RoomType;
	    	this.BedNumbers=BedNumbers;
	    	this.Availability=Availability;
	    	this.Rate=Rate; 
	    	   }

		public int getRoomID() {
			return RoomID;
		}

		public void setRoomID(int roomID) {
			RoomID = roomID;
		}

		public String getRoomNumber() {
			return RoomNumber;
		}

		public void setRoomNumber(String roomNumber) {
			RoomNumber = roomNumber;
		}

		public String getRoomType() {
			return RoomType;
		}

		public void setRoomType(String roomType) {
			RoomType = roomType;
		}

		public String getBedNumbers() {
			return BedNumbers;
		}

		public void setBedNumbers(String bedNumbers) {
			BedNumbers = bedNumbers;
		}

		public String getAvailability() {
			return Availability;
		}

		public void setAvailability(String availability) {
			Availability = availability;
		}

		public String getRate() {
			return Rate;
		}

		public void setRate(String rate){
			Rate = rate;
		}
		

		
	   
	


}
