package dao;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.rogachevskay.immovables.db.model.Document;


public class DocumentDaoImpl extends AbstractDao implements IDao<Integer, Document> {

	// single instance of this class to be used by the all consumers
	public static final DocumentDaoImpl INSTANCE = new DocumentDaoImpl();

	// private constructor disallows instantiation of this class ('Singleton'
	// pattern) outside of current class
	private DocumentDaoImpl() {
		super();
	}

	@Override
	public void insert(Document entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("insert into document(extract, act, treaty, act) values(?,?,?)");
			pstmt.setInt(1, entity.getExtract());
			pstmt.setInt(2, entity.getAct());
			pstmt.setInt(3, entity.getTreaty());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "document"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Document entity", e);
		}
	}

	@Override
	public void update(Document entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update document set extract=?, act=? where id=?");
			pstmt.setInt(1, entity.getExtract());
			pstmt.setInt(2, entity.getAct());
			pstmt.setInt(3, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Document entity", e);
		}
	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from brand where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Document entity", e);
		}

	}

	@Override
	public Document getById(Integer id) {
		Document entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from brand where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Document entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Document> getAll() {
		List<Document> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from document");
			while (rs.next()) {
				Document entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Document entities", e);
		}

		return entitiesList;
	}

	private Document rowToEntity(ResultSet rs) throws SQLException {
		Document entity = new Document();
		entity.setId(rs.getInt("id"));
		entity.setExtract(rs.getInt("extract"));
		entity.setAct(rs.getInt("act"));
		entity.setTreaty(rs.getInt("treaty"));
		return entity;
	}

	

	@Override
	public int count() {
		throw new RuntimeException("not implemented");
	}

}
