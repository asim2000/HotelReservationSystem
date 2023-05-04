package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.CustomerDao;
import az.company.hotelreservation.dao.concretes.CustomerDaoImpl;
import az.company.hotelreservation.model.Customer;
import az.company.hotelreservation.service.abstracts.CustomerService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;
    public CustomerServiceImpl(CustomerDao customerDao){
        this.customerDao = customerDao;
    }
    @Override
    public List<Customer> getAll() throws SQLException, IOException {
        return customerDao.getAll();
    }

    @Override
    public Customer getById(String id) throws SQLException, IOException {
        return customerDao.getById(id);
    }

    @Override
    public void create(Customer entity) throws SQLException, IOException {
        customerDao.create(entity);
    }

    @Override
    public void update(Customer entity) throws SQLException, IOException {
        customerDao.update(entity);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        customerDao.delete(id);
    }
}
