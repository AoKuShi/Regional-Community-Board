package kr.ac.kopo.address.vo;

public class AddressVO {
    private String address;  // 사용자가 입력한 주소
    private double latitude;  // 위도
    private double longitude; // 경도

    public AddressVO() {}

    public AddressVO(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

	@Override
	public String toString() {
		return "AddressVO [address=" + address + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
    
}
