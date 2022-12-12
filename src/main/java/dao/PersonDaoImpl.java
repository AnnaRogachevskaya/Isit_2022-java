package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.rogachevskay.immovables.db.model.Person;

public class PersonDaoImpl extends AbstractDao implements IDao<Integer, Person> {

	// single instance of this class to be used by the all consumers
	public static final PersonDaoImpl INSTANCE = new PersonDaoImpl();

	// private constructor disallows instantiation of this class ('Singleton'
	// pattern) outside of current class
	private PersonDaoImpl() {
		super();
	}
	@Override
	public void insert(Person entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into person(type, name, addres, telephone) values(?,?,?)");
			pstmt.setString(1, entity.getType());
			pstmt.setString(2, entity.getName());
			pstmt.setString(3, entity.getAddres());
			pstmt.setString(4, entity.getTelephone());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "person"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Person entity", e);
		}
	}

	@Override
	public void update(Person entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update person set type=?, name=?, addres? where id=?");
			pstmt.setString(1, entity.getType());
			pstmt.setString(2, entity.getName());
			pstmt.setString(3, entity.getAddres());
			pstmt.setInt(4, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Person entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from person where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete person entity", e);
		}

	}

	@Override
	public Person getById(Integer id) {
		Person entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from person where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Person entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Person> getAll() {
		List<Person> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from person");
			while (rs.next()) {
				Person entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Person entities", e);
		}

		return entitiesList;
	}

	private Person rowToEntity(ResultSet rs) throws SQLException {
		Person entity = new Person();
		entity.setId(rs.getInt("id"));
		entity.setType(rs.getString("type"));
		entity.setName(rs.getString("name"));
		entity.setAddres(rs.getString("addres"));
		entity.setTelephone(rs.getString("telephone"));
		return entity;
	}

	

	@Override
	public int count() {
		throw new RuntimeException("not implemented");
	}

}
