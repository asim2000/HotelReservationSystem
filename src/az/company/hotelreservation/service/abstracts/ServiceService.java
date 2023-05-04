package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Address;
import az.company.hotelreservation.model.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ServiceService {
    public List<Service> getAll() throws SQLException, IOException;
    public Service getById(String id) throws SQLException, IOException;
    public void create(Service entity) throws SQLException, IOException;
    public void update(Service entity) throws SQLException, IOException;
    public void delete(String id) throws SQLException, IOException;
}
