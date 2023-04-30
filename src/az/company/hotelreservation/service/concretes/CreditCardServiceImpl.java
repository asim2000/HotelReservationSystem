package az.company.hotelreservation.service.concretes;

import az.company.hotelreservation.dao.abstracts.CreditCardDao;
import az.company.hotelreservation.dao.concretes.CreditCardDaoImpl;
import az.company.hotelreservation.model.CreditCard;
import az.company.hotelreservation.service.abstracts.CreditCardService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {
    private CreditCardDao creditCardDao = new CreditCardDaoImpl();
    @Override
    public List<CreditCard> getAll() throws SQLException, IOException {
        return creditCardDao.getAll();
    }

    @Override
    public CreditCard getById(String id) throws SQLException, IOException {
        return creditCardDao.getById(id);
    }

    @Override
    public void create(CreditCard entity) throws SQLException, IOException {
        creditCardDao.create(entity);
    }

    @Override
    public void update(CreditCard entity) throws SQLException, IOException {
        creditCardDao.update(entity);
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        creditCardDao.delete(id);
    }
}
