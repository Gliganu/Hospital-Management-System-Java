package daoLayer;

import java.util.List;

import domainLayer.Intern;
import domainLayer.Section;

public interface SectionDAO {

	public void addOrUpdateSection(Section section);
	
	public void deleteSection(String name);

	public List<Section> getAllSections();
	
	public Section getSectionbyName(String name);
	
	public boolean exists(String name);
	
}
