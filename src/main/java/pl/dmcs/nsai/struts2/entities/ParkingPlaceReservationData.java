package pl.dmcs.nsai.struts2.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "parking_places_reservations")
public class ParkingPlaceReservationData extends AbstractEntity {
	private static final long serialVersionUID = -5502659745472922550L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date bookingDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private ParkingPlaceData parkingPlaceData;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private UserData UserData;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkingPlaceData == null) ? 0 : parkingPlaceData.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingPlaceReservationData other = (ParkingPlaceReservationData) obj;
		if (parkingPlaceData == null) {
			if (other.parkingPlaceData != null)
				return false;
		} else if (!parkingPlaceData.equals(other.parkingPlaceData))
			return false;
		return true;
	}

	public ParkingPlaceReservationData() {
		this.bookingDate = Calendar.getInstance().getTime();
	}
	
	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public ParkingPlaceData getParkingPlaceData() {
		return parkingPlaceData;
	}

	public void setParkingPlaceData(ParkingPlaceData parkingPlaceData) {
		this.parkingPlaceData = parkingPlaceData;
	}

	public UserData getUserData() {
		return UserData;
	}

	public void setUserData(UserData userData) {
		UserData = userData;
	}
}
