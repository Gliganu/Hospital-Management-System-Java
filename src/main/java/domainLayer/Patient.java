package domainLayer;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "patient")
public class Patient {

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 3, max = 30)
	private String name;
	@Min(0)
	@Max(100)
	private int age;
	@NotNull
	private Timestamp dateOfAdmission;

	@ManyToOne
	@JoinColumn(referencedColumnName = "name")
	private Disease disease;

	@ManyToOne
	@JoinColumn(referencedColumnName = "name")
	private Section section;

	@ManyToOne
	@JoinColumn(referencedColumnName = "number")
	private Room room;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private Doctor doctor;
	

	public Patient() {

	}
	
	public Patient(String name, int age, Timestamp dateOfAdmission,
			Disease disease, Section section, Room room, Doctor doctor) {
		super();
		this.name = name;
		this.age = age;
		this.dateOfAdmission = dateOfAdmission;
		this.disease = disease;
		this.section = section;
		this.room = room;
		this.doctor = doctor;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Timestamp getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(Timestamp dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((dateOfAdmission == null) ? 0 : dateOfAdmission.hashCode());
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		Patient other = (Patient) obj;
		if (age != other.age)
			return false;
		if (dateOfAdmission == null) {
			if (other.dateOfAdmission != null)
				return false;
		} else if (!dateOfAdmission.equals(other.dateOfAdmission))
			return false;
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}

	
	
	

	

	
}
