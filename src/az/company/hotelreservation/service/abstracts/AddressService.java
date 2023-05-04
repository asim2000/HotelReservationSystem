package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Address;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AddressService {
    List<Address> getAll() throws SQLException, IOException;
    Address getById(String id) throws SQLException, IOException;
    void create(Address entity) throws SQLException, IOException;
    void update(Address entity) throws SQLException, IOException;
    void delete(String id) throws SQLException, IOException;
    List<Address> getAddressesByParent(String id) throws SQLException, IOException;;
}
