package pl.dmcs.nsai.struts2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "parkings")
public class ParkingData extends AbstractEntity {
	private static final long serialVersionUID = -8635031445997751456L;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(nullable = false)
	private Double posX;

	@Column(nullable = false)
	private Double posY;

	@Column(nullable = false)
	private Double width;

	@Column(nullable = false)
	private Double height;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPosX() {
		return posX;
	}

	public void setPosX(Double posX) {
		this.posX = posX;
	}

	public Double getPosY() {
		return posY;
	}

	public void setPosY(Double posY) {
		this.posY = posY;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
}
