package az.company.hotelreservation.dao.abstracts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EntityDao<T> {
    public List<T> getAll() throws SQLException, IOException;
    public T getById(String id) throws SQLException, IOException;
    public void create(T entity) throws SQLException, IOException;;
    public void update(T entity) throws SQLException, IOException;;
    public void delete(String id) throws SQLException, IOException;
}
