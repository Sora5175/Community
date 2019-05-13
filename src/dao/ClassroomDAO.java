package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Classroom;

public interface ClassroomDAO extends GenericDAO<Classroom> {
	public List<Classroom> valuesOfSchool(String sid) throws SQLException;
}
