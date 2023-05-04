package az.company.hotelreservation.service.abstracts;

import az.company.hotelreservation.model.Address;
import az.company.hotelreservation.model.CreditCard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CreditCardService {
    public List<CreditCard> getAll() throws SQLException, IOException;
    public CreditCard getById(String id) throws SQLException, IOException;
    public void create(CreditCard entity) throws SQLException, IOException;
    public void update(CreditCard entity) throws SQLException, IOException;
    public void delete(String id) throws SQLException, IOException;
}
