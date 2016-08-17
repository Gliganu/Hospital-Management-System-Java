package daoLayer;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domainLayer.Janitor;
import domainLayer.Room;

@Component("roomDAO")
@Repository
@Transactional
public class RoomDAOHibernate implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addOrUpdateRoom(Room room){
		session().saveOrUpdate(room);
	}

	@Override
	public void deleteRoom(int number){
		Criteria crit= session().createCriteria(Room.class);
		crit.add(Restrictions.idEq(number));
		session().delete(crit.uniqueResult());
	}

	@Override
	public List<Room> getAllRooms(){
		List<Room> roomList =  session().createQuery("from Room").list();
		return roomList;
	}

	@Override
	public Room getRoomByNumber(int number){
		Criteria crit= session().createCriteria(Room.class);
		crit.add(Restrictions.idEq(number));
		return (Room) crit.uniqueResult();
	}

	@Override
	public boolean exists(int number) {

		Criteria crit= session().createCriteria(Room.class);
		crit.add(Restrictions.idEq(number));
		return ((Room) crit.uniqueResult()) != null;
		
	}

	@Override
	public List<Room> getRoomsByJanitor(Janitor janitor) {
		Criteria crit= session().createCriteria(Room.class);
		crit.add(Restrictions.eq("janitor",janitor));
		List<Room> roomList =  crit.list();
		return roomList;
	}



}
