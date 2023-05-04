package az.company.hotelreservation.dao.abstracts;

import az.company.hotelreservation.model.Address;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface AddressDao extends EntityDao<Address>{
    List<Address> getAddressesByParent(String id)throws SQLException, IOException;
}
