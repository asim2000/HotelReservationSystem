package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Employee;
import az.company.hotelreservation.model.Person;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll() throws SQLException, IOException;
    public Employee getById(String id) throws SQLException, IOException;
    public void create(Employee entity) throws SQLException, IOException;
    public void update(Employee entity) throws SQLException, IOException;
    public void delete(String id) throws SQLException, IOException;
}
