package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.ServiceDao;
import az.company.hotelreservation.model.Contact;
import az.company.hotelreservation.model.Hotel;
import az.company.hotelreservation.model.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDao {
    @Override
    public List<Service> getAll() throws SQLException, IOException {
        List<Service> services = new ArrayList<>();
        String sql = "select " +
                        "s.id id," +
                        "s.hotel_id hotel_id," +
                        "s.name name," +
                        "s.price price," +
                        "s.description description," +
                        "s.created_date created_date," +
                        "s.updated_date updated_date," +
                        "s.active active," +
                        "h.address_id a1_id," +
                        "h.contact_id contact_id," +
                        "h.name hotel_name," +
                        "h.description hotel_description," +
                        "h.created_date hotel_created_date," +
                        "h.updated_date hotel_updated_date," +
                        "h.active hotel_active," +
                        "c.phone phone," +
                        "c.email email," +
                        "c.created_date contact_created_date," +
                        "c.updated_date contact_updated_date," +
                        "c.active contact_active, " +
                "    a1.parent_id a1_parent_id,\n" +
                "    a1.name a1_name,\n" +
                "    a1.created_date a1_created_date,\n" +
                "    a1.updated_date a1_updated_date,\n" +
                "    a1.active a1_active,\n" +
                "    a2.parent_id a2_parent_id,\n" +
                "    a2.name a2_name,\n" +
                "    a2.created_date a2_created_date,\n" +
                "    a2.updated_date a2_updated_date,\n" +
                "    a2.active a2_active,\n" +
                "    a3.parent_id a3_parent_id,\n" +
                "    a3.name a3_name,\n" +
                "    a3.created_date a3_created_date,\n" +
                "    a3.updated_date a3_updated_date,\n" +
                "    a3.active a3_active,\n" +
                "    a4.parent_id a4_parent_id,\n" +
                "    a4.name a4_name,\n" +
                "    a4.created_date a4_created_date,\n" +
                "    a4.updated_date a4_updated_date,\n" +
                "    a4.active a4_active,\n" +
                    "from " +
                        "service s," +
                        "hotel h," +
                        "address a1," +
                        "address a2," +
                        "address a3," +
                        "address a4," +
                        "contact c " +
                    "where " +
                        "active = 1 and " +
                        "s.hotel_id = h.id and " +
                        "h.address_id = a1.id and " +
                        "a1.parent_id = a2.id and\n" +
                        "a2.parent_id = a3.id and\n" +
                        "a3.parent_id = a4.id and\n" +
                        "s.contact_id = c.id";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                services.add(setService(resultSet));
            }
        }
        return services;
    }

    private Service setService(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setId(resultSet.getString("id"));
        service.setHotelId(resultSet.getString("hotel_id"));
        service.setName(resultSet.getString("name"));
        service.setPrice(resultSet.getFloat("price"));
        service.setDescription(resultSet.getString("description"));
        service.setCreatedDate(resultSet.getDate("created_date"));
        service.setUpdatedDate(resultSet.getDate("updated_date"));
        service.setActive(resultSet.getInt("active"));

        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getString("hotel_id"));
        hotel.setAddressId(resultSet.getString("a1_id"));
        hotel.setContactId(resultSet.getString("contact_id"));
        hotel.setName(resultSet.getString("hotel_name"));
        hotel.setDescription(resultSet.getString("hotel_description"));
        hotel.setCreatedDate(resultSet.getDate("hotel_created_date"));
        hotel.setUpdatedDate(resultSet.getDate("hotel_updated_date"));
        hotel.setActive(resultSet.getInt("hotel_active"));
        hotel.setAddress(DaoHelper.setAddress(resultSet));

        Contact contact = new Contact();
        contact.setId(resultSet.getString("contact_id"));
        contact.setPhone(resultSet.getString("phone"));
        contact.setEmail(resultSet.getString("email"));
        contact.setCreatedDate(resultSet.getDate("contact_created_date"));
        contact.setUpdatedDate(resultSet.getDate("contact_updated_date"));
        contact.setActive(resultSet.getInt("contact_active"));
        hotel.setContact(contact);

        service.setHotel(hotel);
        return service;
    }
    @Override
    public Service getById(String id) throws SQLException, IOException {
        String sql = "select " +
                "s.id id," +
                "s.hotel_id hotel_id," +
                "s.name name," +
                "s.price price," +
                "s.description description," +
                "s.created_date created_date," +
                "s.updated_date updated_date," +
                "s.active active," +
                "h.address_id a1_id," +
                "h.contact_id contact_id," +
                "h.name hotel_name," +
                "h.description hotel_description," +
                "h.created_date hotel_created_date," +
                "h.updated_date hotel_updated_date," +
                "h.active hotel_active," +
                "c.phone phone," +
                "c.email email," +
                "c.created_date contact_created_date," +
                "c.updated_date contact_updated_date," +
                "c.active contact_active, " +
                "    a1.parent_id a1_parent_id,\n" +
                "    a1.name a1_name,\n" +
                "    a1.created_date a1_created_date,\n" +
                "    a1.updated_date a1_updated_date,\n" +
                "    a1.active a1_active,\n" +
                "    a2.parent_id a2_parent_id,\n" +
                "    a2.name a2_name,\n" +
                "    a2.created_date a2_created_date,\n" +
                "    a2.updated_date a2_updated_date,\n" +
                "    a2.active a2_active,\n" +
                "    a3.parent_id a3_parent_id,\n" +
                "    a3.name a3_name,\n" +
                "    a3.created_date a3_created_date,\n" +
                "    a3.updated_date a3_updated_date,\n" +
                "    a3.active a3_active,\n" +
                "    a4.parent_id a4_parent_id,\n" +
                "    a4.name a4_name,\n" +
                "    a4.created_date a4_created_date,\n" +
                "    a4.updated_date a4_updated_date,\n" +
                "    a4.active a4_active,\n" +
                "from " +
                "service s," +
                "hotel h," +
                "address a1," +
                "address a2," +
                "address a3," +
                "address a4," +
                "contact c " +
                "where " +
                "active = 1 and " +
                "id = ? and " +
                "s.hotel_id = h.id and " +
                "h.address_id = a1.id and " +
                "a1.parent_id = a2.id and\n" +
                "a2.parent_id = a3.id and\n" +
                "a3.parent_id = a4.id and\n" +
                "s.contact_id = c.id";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            preparedStatement.setString(1,id);
            if(resultSet.next()){
                return setService(resultSet);
            }
        }
        return null;
    }

    @Override
    public void create(Service entity) throws SQLException, IOException {
        String sql = "insert into " +
                "service(hotel_id,name,price,description) " +
                "values(?,?,?,?)";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            setPreparedStatement(preparedStatement,entity);
        }
    }

    private void setPreparedStatement(PreparedStatement preparedStatement, Service entity) throws SQLException {
        preparedStatement.setString(1,entity.getHotelId());
        preparedStatement.setString(2,entity.getName());
        preparedStatement.setFloat(3,entity.getPrice());
        preparedStatement.setString(4,entity.getDescription());
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(Service entity) throws SQLException, IOException {
        String sql = "update " +
                        "service " +
                    "set " +
                        "hotel_id = ?," +
                        "name = ?," +
                        "price = ?," +
                        "description = ?, " +
                        "updated_date = sysdate " +
                    "where " +
                        "id = ?";
        try (Connection connection = DbHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(5,entity.getId());
            setPreparedStatement(preparedStatement,entity);
        }
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        String sql = "update " +
                        "service " +
                    "set " +
                        "active = 0, " +
                        "updated_date = sysdate " +
                    "where id = ?";
        try (Connection connection = DbHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        }

    }
}
