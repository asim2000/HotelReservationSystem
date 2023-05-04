package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Contact;
import az.company.hotelreservation.model.Customer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    public List<Customer> getAll() throws SQLException, IOException;
    public Customer getById(String id) throws SQLException, IOException;
    public void create(Customer entity) throws SQLException, IOException;;
    public void update(Customer entity) throws SQLException, IOException;;
    public void delete(String id) throws SQLException, IOException;
}
