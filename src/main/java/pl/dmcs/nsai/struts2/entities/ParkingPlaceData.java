package pl.dmcs.nsai.struts2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parking_places")
public class ParkingPlaceData extends AbstractEntity implements Comparable<ParkingPlaceData> {
	private static final long serialVersionUID = -5762220801587440108L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(nullable = false)
	private Integer orderNum;

	@ManyToOne(fetch = FetchType.EAGER)
	private ParkingData parkingData;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "parkingPlaceData")
	private List<ParkingPlaceReservationData> placeReservations;

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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ParkingPlaceData other = (ParkingPlaceData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public ParkingData getParkingData() {
		return parkingData;
	}

	public void setParkingData(ParkingData parkingData) {
		this.parkingData = parkingData;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public int compareTo(ParkingPlaceData o) {
		return orderNum.compareTo(o.orderNum);
	}
}
