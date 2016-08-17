package daoLayer;

import java.util.List;

import domainLayer.Janitor;
import domainLayer.Room;

public interface RoomDAO {

	public void addOrUpdateRoom(Room room);
	
	public void deleteRoom(int number);

	public List<Room> getAllRooms();
	
	public Room getRoomByNumber(int number );
	
	public boolean exists(int number);
	
	public List<Room> getRoomsByJanitor(Janitor janitor);
	
}
