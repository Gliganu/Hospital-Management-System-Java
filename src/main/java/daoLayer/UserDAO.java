package daoLayer;

import java.util.List;

import domainLayer.User;

public interface UserDAO {

	public void addOrUpdateUser(User user);
	
	public void deleteUser(String username);

	public List<User> getAllUsers();
	
	public User getUserByUsername(String username);
	
	public boolean exists(String username);

	public void changePassword(String username, String password);
	
}
