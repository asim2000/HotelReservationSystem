package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.EmployeeDao;
import az.company.hotelreservation.dao.concretes.EmployeeDaoImpl;
import az.company.hotelreservation.model.Employee;
import az.company.hotelreservation.service.abstracts.EmployeeService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public List<Employee> getAll() throws SQLException, IOException {
        return employeeDao.getAll();
    }

    @Override
    public Employee getById(String id) throws SQLException, IOException {
        return employeeDao.getById(id);
    }

    @Override
    public void create(Employee entity) throws SQLException, IOException {
        employeeDao.create(entity);
    }

    @Override
    public void update(Employee entity) throws SQLException, IOException {
        employeeDao.update(entity);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        employeeDao.delete(id);
    }
}
