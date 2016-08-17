package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import daoLayer.JanitorDAO;
import daoLayer.RoomDAO;
import domainLayer.Janitor;
import domainLayer.Room;

@ContextConfiguration(locations = { "classpath:config/dao-context.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class RoomDAOTests {

	@Autowired
	private JanitorDAO janitorDAO;
	@Autowired
	private RoomDAO roomDAO;

	@Autowired
	private DataSource dataSource;

	@Before
	public void init() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("delete from room");
		jdbcTemplate.execute("delete from janitor");
		addJanitors();
		addRooms();
	}

	private Janitor janitor1;
	private Janitor janitor2;
	private Janitor janitor3;

	private Room room1;
	private Room room2;
	private Room room3;

	
	private void addRooms() {
		room1 = new Room(101, 1, janitor1);
		room2 = new Room(345, 6, janitor3);
		room3 = new Room(543, 5, janitor3);
	}

	@Test
	public void testCreate() {
		roomDAO.addOrUpdateRoom(room1);
		roomDAO.addOrUpdateRoom(room2);
		roomDAO.addOrUpdateRoom(room3);

		List<Room> roomList = roomDAO.getAllRooms();
		assertEquals("Three users should have been created and retrieved", 3,
				roomList.size());
	}

	 //@Test
	public void testRetrieve() {
		roomDAO.addOrUpdateRoom(room1);
		assertTrue(roomDAO.exists(room1.getNumber()));
		assertTrue(roomDAO.getRoomByNumber(room1.getNumber()).equals(
				room1));
	}

	 //@Test
	public void testDelete() {
		 roomDAO.addOrUpdateRoom(room1);
		 roomDAO.addOrUpdateRoom(room2);

		 roomDAO.deleteRoom(room1.getNumber());
		 roomDAO.deleteRoom(room2.getNumber());

		List<Room> roomList = roomDAO.getAllRooms();
		assertEquals("Three shouldn't be any users in the db", 0,
				roomList.size());
	}
	
	private void addJanitors() {
		janitor1 = new Janitor("Nea Vasile");
		janitor2 = new Janitor("Olguta");
		janitor3 = new Janitor("Nea Costica");

		janitorDAO.addOrUpdateJanitor(janitor1);
		janitorDAO.addOrUpdateJanitor(janitor2);
		janitorDAO.addOrUpdateJanitor(janitor3);
	}
	

}