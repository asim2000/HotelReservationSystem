package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.AddressDao;
import az.company.hotelreservation.dao.concretes.AddressDaoImpl;
import az.company.hotelreservation.model.Address;
import az.company.hotelreservation.service.abstracts.AddressService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddressServiceImpl implements AddressService{
    private AddressDao addressDao;
    public AddressServiceImpl(AddressDao addressDao){
        this.addressDao = addressDao;
    }
    @Override
    public List<Address> getAll() throws SQLException, IOException {
        return addressDao.getAll();
    }

    @Override
    public Address getById(String id) throws SQLException, IOException {
        return addressDao.getById(id);
    }

    @Override
    public void create(Address address) throws SQLException, IOException {
        addressDao.create(address);
    }

    @Override
    public void update(Address address) throws SQLException, IOException {
        addressDao.update(address);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        addressDao.delete(id);
    }

    @Override
    public List<Address> getAddressesByParent(String id) throws SQLException, IOException{
        return addressDao.getAddressesByParent(id);
    }

}
