package domainLayer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "disease")
public class Disease {

	@Id
	private String name;
	
	@NotNull
	private SeverityType severity;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "DISEASE_DRUG", 
	joinColumns = { @JoinColumn(name = "DISEASE_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "DRUG_ID") })
	private List<Drug> drugList = new ArrayList<>();

	public Disease() {
		// TODO Auto-generated constructor stub
	}

	public Disease(String name, SeverityType severity, List<Drug> drugList) {
		super();
		this.name = name;
		this.severity = severity;
		this.drugList = drugList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SeverityType getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityType severity) {
		this.severity = severity;
	}

	public List<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<Drug> drugList) {
		this.drugList = drugList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
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
		Disease other = (Disease) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (severity != other.severity)
			return false;
		return true;
	}

	
	
	
	

	
}
