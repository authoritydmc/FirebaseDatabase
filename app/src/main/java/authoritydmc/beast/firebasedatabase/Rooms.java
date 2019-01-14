package authoritydmc.beast.firebasedatabase;

///will be used later when Images and other thing will be added
public class Rooms {
    String name, mobileno, rentamount, status, roomno;
    public static String[] defaultlist = {"RAJ", "BAJ", "AMAN", "JAMES"};

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public Rooms(String name, String mobileno, String rentamount, String status, String roomno) {
        this.name = name;
        this.mobileno = mobileno;
        this.rentamount = rentamount;
        this.status = status;
        this.roomno = roomno;

    }

    public Rooms() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getRentamount() {
        return rentamount;
    }

    public void setRentamount(String rentamount) {
        this.rentamount = rentamount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
