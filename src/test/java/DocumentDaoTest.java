
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Assertions;
import by.grsu.rogachevskay.immovables.db.model.Document;
import dao.DocumentDaoImpl;
import dao.IDao;


public class DocumentDaoTest extends AbstractTest{
	
	
	private static final IDao<Integer, Document> dao = DocumentDaoImpl.INSTANCE;

@Test
public void testInsert() {
	Document entity = new Document();
	entity.setExtract(634);
	entity.setAct(243);
	entity.setTreaty(345);
	dao.insert(entity);
	Assertions.assertNotNull(entity.getId());
}
@Test
public void testUpdate() {
	Document entity = new Document();
	entity.setExtract(634);
	entity.setAct(243);
	entity.setTreaty(345);
	dao.insert(entity);
	
	Integer newExtract = 634;
	entity.setExtract(newExtract);
	Integer newAct = 243;
	entity.setAct(newAct);
	Integer newTreaty = 345;
	entity.setTreaty(newTreaty);
	dao.update(entity);
	
	Document updatedEntity = dao.getById(entity.getId());
	Assertions.assertEquals( newExtract, updatedEntity.getExtract());
	Assertions.assertEquals( newAct, updatedEntity.getAct());
	Assertions.assertEquals(newTreaty, updatedEntity.getTreaty());
}
@Test
public void testDelete() {
	Document entity = new Document();
	entity.setExtract(634);
	entity.setAct(243);
	entity.setTreaty(345);
	dao.insert(entity);
	
	dao.delete(entity.getId());
	
	Assertions.assertNull(dao.getById(entity.getId()));
}

@Test
public void testGetById() {
	Document entity = new Document();
	entity.setExtract(634);
	entity.setAct(243);
	entity.setTreaty(345);
	dao.insert(entity);
	
	Document selectedEntity = dao.getById(entity.getId());
	
	Assertions.assertEquals( entity.getExtract(), selectedEntity.getExtract());
	Assertions.assertEquals( entity.getAct(), selectedEntity.getAct());
	Assertions.assertEquals( entity.getTreaty(), selectedEntity.getTreaty());
}

@Test
public void testGetAll() {
	int expectedCount = getRandomNumber(1, 5);
	for (int i = 1; i <= expectedCount; i = i + 1) {
		Document entity = new Document();
		entity.setExtract(634+i);
		entity.setAct(243+i);
		entity.setTreaty(345+i);
		dao.insert(entity);
	}
	Assertions.assertEquals(expectedCount, dao.getAll().size());
}
}



