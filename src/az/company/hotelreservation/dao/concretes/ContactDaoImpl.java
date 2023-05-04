package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.ContactDao;
import az.company.hotelreservation.model.Contact;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements ContactDao {

    @Override
    public List<Contact> getAll() throws SQLException, IOException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "select" +
                    "    id," +
                    "    phone," +
                    "    email," +
                    "    created_date," +
                    "    updated_date," +
                    "    active" +
                    "from" +
                    "    contact" +
                    "where" +
                    "    active = 1";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()){
                contacts.add(setContact(resultSet));
            }
        }
        return contacts;
    }

    private Contact setContact(ResultSet resultSet) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getString("id"));
        contact.setPhone(resultSet.getString("phone"));
        contact.setEmail(resultSet.getString("email"));
        contact.setCreatedDate(resultSet.getDate("created_date"));
        contact.setUpdatedDate(resultSet.getDate("updated_date"));
        contact.setActive(resultSet.getInt("active"));
        return contact;
    }

    @Override
    public Contact getById(String id) throws SQLException, IOException {
        String sql = "select" +
                "    id," +
                "    phone," +
                "    email," +
                "    created_date," +
                "    updated_date," +
                "    active" +
                "from" +
                "    contact" +
                "where" +
                "    active = 1 and" +
                "    id = ?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){

            preparedStatement.setString(1,id);

            if (resultSet.next()){
                return setContact(resultSet);
            }
        }
        return null;
    }

    @Override
    public void create(Contact entity) throws SQLException, IOException {
        String sql = "insert" +
                     "into" +
                        "contact(phone,email)" +
                     "values" +
                        "(?,?)";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,entity.getPhone());
            preparedStatement.setString(2,entity.getEmail());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Contact entity) throws SQLException, IOException {
        String sql = "update" +
                        "contact" +
                     "set" +
                        "phone = ?," +
                        "email = ?," +
                        "updated_date = sysdate" +
                     "where id = ?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,entity.getPhone());
            preparedStatement.setString(2,entity.getEmail());
            preparedStatement.setString(3,entity.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        String sql = "update" +
                        "contact" +
                     "set" +
                        "active = 0," +
                        "updated_date = sysdate" +
                     "where" +
                        "id = ?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        }
    }
}
