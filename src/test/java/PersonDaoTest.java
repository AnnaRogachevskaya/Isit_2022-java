import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import by.grsu.rogachevskay.immovables.db.model.Person;
import dao.IDao;
import dao.PersonDaoImpl;

public class PersonDaoTest extends AbstractTest{
		
		

		private static final IDao<Integer, Person> dao = PersonDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Person entity = new Person();
		entity.setType("");
		entity.setName("");
		entity.setAddres("");
		entity.setTelephone("");
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}
	@Test
	public void testUpdate() {
		Person entity = new Person();
		entity.setType("");
		entity.setName("");
		entity.setAddres("");
		entity.setTelephone("");
		dao.insert(entity);
		
		String newType = "";
		entity.setType(newType);
		String newName = "";
		entity.setName(newName);
		String newAddres = "";
		entity.setAddres(newAddres);
		String newTelephone = "";
		entity.setTelephone(newTelephone);
		dao.update(entity);
		
		Person updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals( newType, updatedEntity.getType());
		Assertions.assertEquals( newName, updatedEntity.getName());
		Assertions.assertEquals(newAddres, updatedEntity.getAddres());
		Assertions.assertEquals(newTelephone, updatedEntity.getTelephone());
	}
	@Test
	public void testDelete() {
		Person entity = new Person();
		entity.setType("");
		entity.setName("");
		entity.setAddres("");
		entity.setTelephone("");
		dao.insert(entity);
		
		dao.delete(entity.getId());
		
		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Person entity = new Person();
		entity.setType("");
		entity.setName("");
		entity.setAddres("");
		entity.setTelephone("");		
		dao.insert(entity);
		
		Person selectedEntity = dao.getById(entity.getId());
		
		Assertions.assertEquals( entity.getType(), selectedEntity.getType());
		Assertions.assertEquals( entity.getName(), selectedEntity.getName());
		Assertions.assertEquals( entity.getAddres(), selectedEntity.getAddres());
		Assertions.assertEquals( entity.getTelephone(), selectedEntity.getTelephone());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Person entity = new Person();
			entity.setType("+i");
			entity.setName("+i");
			entity.setAddres("+i");
			entity.setTelephone("+i");
			dao.insert(entity);
		}
		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
	}




