package domainLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="drug")
public class Drug {

	@Id
	@Size(min=3,max=30)
	public String name;
	@NotNull
	private String substances;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="drugList")
	private List<Disease> diseaseList = new ArrayList<>();
	
	public Drug() {
		// TODO Auto-generated constructor stub
	}

	public Drug(String name, String substances, List<Disease> diseaseList) {
		super();
		this.name = name;
		this.substances = substances;
		this.diseaseList = diseaseList;
	}
	public Drug(String name, String substances) {
		super();
		this.name = name;
		this.substances = substances;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubstances() {
		return substances;
	}

	public void setSubstances(String substances) {
		this.substances = substances;
	}

	public List<Disease> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<Disease> diseaseList) {
		this.diseaseList = diseaseList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((substances == null) ? 0 : substances.hashCode());
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
		Drug other = (Drug) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (substances == null) {
			if (other.substances != null)
				return false;
		} else if (!substances.equals(other.substances))
			return false;
		return true;
	}

	
	
	

	
	
	
	
}
