package domainLayer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue
	private int id;
	@Size(min=3,max=40)
	private String name;
	@NotNull
	@Min(30)
	@Max(80)
	private int age;
	@Min(10)
	private int yearsInPractice;
	@ManyToOne
	@JoinColumn(referencedColumnName="name")
	private Section section; // many to one
	
	public Doctor() {
		
	}
	
	public Doctor(String name, int age, int yearsInPractice,
			Section section) {
		super();
		this.name = name;
		this.age = age;
		this.yearsInPractice = yearsInPractice;
		this.section = section;
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


	public Section getSection() {
		return section;
	}


	public void setSection(Section section) {
		this.section = section;
	}


	public int getYearsInPractice() {
		return yearsInPractice;
	}


	public void setYearsInPractice(int yearsInPractice) {
		this.yearsInPractice = yearsInPractice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
		result = prime * result + yearsInPractice;
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
		Doctor other = (Doctor) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		if (yearsInPractice != other.yearsInPractice)
			return false;
		return true;
	}


	
	


	
	
	



	
}
