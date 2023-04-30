package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Address;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    public List<Address> getAll() throws SQLException, IOException;
    public Address getById(String id) throws SQLException, IOException;
    public void create(Address entity) throws SQLException, IOException;
    public void update(Address entity) throws SQLException, IOException;
    public void delete(String id) throws SQLException, IOException;
}
