package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.ContactDao;
import az.company.hotelreservation.dao.concretes.ContactDaoImpl;
import az.company.hotelreservation.model.Contact;
import az.company.hotelreservation.service.abstracts.ContactService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ContactServiceImpl implements ContactService
{
    private ContactDao contactDao = new ContactDaoImpl();
    @Override
    public List<Contact> getAll() throws SQLException, IOException {
        return contactDao.getAll();
    }

    @Override
    public Contact getById(String id) throws SQLException, IOException {
        return contactDao.getById(id);
    }

    @Override
    public void create(Contact entity) throws SQLException, IOException {
        contactDao.create(entity);
    }

    @Override
    public void update(Contact entity) throws SQLException, IOException {
        contactDao.update(entity);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        contactDao.delete(id);
    }
}
