package domainLayer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {

	@Id
	private Integer number;
	@NotNull
	private Integer floor;
	@NotNull
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Janitor janitor;

	public Room() {
		// TODO Auto-generated constructor stub
	}

	public Room(int number, int floor, Janitor janitor) {
		super();
		this.number = number;
		this.floor = floor;
		this.janitor = janitor;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Janitor getJanitor() {
		return janitor;
	}

	public void setJanitor(Janitor janitor) {
		this.janitor = janitor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + ((janitor == null) ? 0 : janitor.hashCode());
		result = prime * result + number;
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
		Room other = (Room) obj;
		if (floor != other.floor)
			return false;
		if (janitor == null) {
			if (other.janitor != null)
				return false;
		} else if (!janitor.equals(other.janitor))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	
	

}
