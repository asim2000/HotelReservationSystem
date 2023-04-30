package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Contact;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ContactService {
    public List<Contact> getAll() throws SQLException, IOException;
    public Contact getById(String id) throws SQLException, IOException;
    public void create(Contact entity) throws SQLException, IOException;;
    public void update(Contact entity) throws SQLException, IOException;;
    public void delete(String id) throws SQLException, IOException;
}
