package pl.dmcs.nsai.struts2.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "parkings")
public class ParkingData extends AbstractEntity {
	private static final long serialVersionUID = -8635031445997751456L;

	public static final Integer MAX_CAPACITY = 50;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false, length = 100)
	private String streetName;
	
	@Column(nullable = false)
	private Integer capacity;
	
	@OneToMany(mappedBy = "parkingData")
	private Set<ParkingPlaceData> places;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Set<ParkingPlaceData> getPlaces() {
		return places;
	}

	public void setPlaces(Set<ParkingPlaceData> places) {
		this.places = places;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}
