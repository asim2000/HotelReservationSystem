package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.CustomerDao;
import az.company.hotelreservation.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> getAll() throws SQLException, IOException {
        List<Customer> customers = new ArrayList<>();
        String sql = "select\n" +
                "    c.id id,\n" +
                "    c.person_id person_id,\n" +
                "    c.created_date created_date,\n" +
                "    c.updated_date updated_date,\n" +
                "    c.active active\n" +
                "    p.address_id a1_id,\n" +
                "    p.contact_id contact_id,\n" +
                "    p.name name,\n" +
                "    p.surname surname,\n" +
                "    p.date_of_birth date_of_birth,\n" +
                "    p.password password,\n" +
                "    p.image image,\n" +
                "    p.gender gender,\n" +
                "    p.account_status account_status,\n" +
                "    p.created_date person_created_date,\n" +
                "    p.updated_date updated_date,\n" +
                "    p.active person_active,\n" +
                "    co.phone phone,\n" +
                "    co.email email,\n" +
                "    co.created_date contact_created_date,\n" +
                "    co.updated_date contact_updated_date,\n" +
                "    co.active contact_active,\n" +
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
                "from\n" +
                "    customer c,\n" +
                "    person p,\n" +
                "    address a1,\n" +
                "    address a2,\n" +
                "    address a3,\n" +
                "    address a4,\n" +
                "    contact co\n" +
                "where\n" +
                "    c.active = 1 and\n" +
                "    c.person_id = p.id and\n" +
                "    p.address_id = a1.id and\n" +
                "    a1.parent_id = a2.id and\n" +
                "    a2.parent_id = a3.id and\n" +
                "    a3.parent_id = a4.id and\n" +
                "    p.contact_id = co.id and\n";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.getResultSet()){
                 while(resultSet.next()){
                     customers.add(setCustomer(resultSet));
                 }
        }
        return customers;
    }

    @Override
    public Customer getById(String id) throws SQLException, IOException {
        String sql = "select\n" +
                "    c.id id,\n" +
                "    c.person_id person_id,\n" +
                "    c.created_date created_date,\n" +
                "    c.updated_date updated_date,\n" +
                "    c.active active\n" +
                "    p.address_id a1_id,\n" +
                "    p.contact_id contact_id,\n" +
                "    p.name name,\n" +
                "    p.surname surname,\n" +
                "    p.date_of_birth date_of_birth,\n" +
                "    p.password password,\n" +
                "    p.image image,\n" +
                "    p.gender gender,\n" +
                "    p.account_status account_status,\n" +
                "    p.created_date person_created_date,\n" +
                "    p.updated_date updated_date,\n" +
                "    p.active person_active,\n" +
                "    co.phone phone,\n" +
                "    co.email email,\n" +
                "    co.created_date contact_created_date,\n" +
                "    co.updated_date contact_updated_date,\n" +
                "    co.active contact_active,\n" +
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
                "from\n" +
                "    customer c,\n" +
                "    person p,\n" +
                "    address a1,\n" +
                "    address a2,\n" +
                "    address a3,\n" +
                "    address a4,\n" +
                "    contact co\n" +
                "where\n" +
                "    c.id = ? and\n" +
                "    c.active = 1 and\n" +
                "    c.person_id = p.id and\n" +
                "    p.address_id = a1.id and\n" +
                "    a1.parent_id = a2.id and\n" +
                "    a2.parent_id = a3.id and\n" +
                "    a3.parent_id = a4.id and\n" +
                "    p.contact_id = co.id and\n";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            preparedStatement.setString(1,id);
            if(resultSet.next())
            return setCustomer(resultSet);
        }
        return null;
    }

    private Customer setCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getString("id"));
        customer.setPersonId(resultSet.getString("person_id"));
        customer.setAddressId(resultSet.getString("a1_id"));
        customer.setContactId(resultSet.getString("contact_id"));
        customer.setName(resultSet.getString("name"));
        customer.setSurname(resultSet.getString("surname"));
        customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
        customer.setPassword(resultSet.getString("password"));
        customer.setGender(Gender.valueOf(resultSet.getString("gender")));
        customer.setAccountStatus(AccountStatus.valueOf(resultSet.getString("account_status")));
        customer.setCreatedDate(resultSet.getDate("created_date"));
        customer.setUpdatedDate(resultSet.getDate("updated_date"));
        customer.setActive(resultSet.getInt("active"));

        customer.setAddress(DaoHelper.setAddress(resultSet,""));

        Contact contact = new Contact();
        contact.setId(resultSet.getString("contact_id"));
        contact.setPhone(resultSet.getString("contact_phone"));
        contact.setEmail(resultSet.getString("contact_email"));
        contact.setCreatedDate(resultSet.getDate("contact_created_date"));
        contact.setUpdatedDate(resultSet.getDate("contact_updated_date"));
        contact.setActive(resultSet.getInt("contact_active"));
        customer.setContact(contact);
        return customer;
    }

    @Override
    public void create(Customer entity) throws SQLException, IOException {
        String sql = "insert into person(address_id," +
                                        "contact_id," +
                                        "name," +
                                        "surname," +
                                        "password," +
                                        "birth_of_date," +
                                        "image," +
                                        "gender" +
                                        "account_status) " +
                    "values(?,?,?,?,?,?,?,?,?)";

        String sql1 = "insert                  " +
                        "into customer(person_id," +
                        "              customer_type," +
                        "values                  " +
                        "     (?,?,?,?)          ";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
            ResultSet resultSet = preparedStatement1.getResultSet()) {

            setPreparedStatement(preparedStatement,preparedStatement1,entity);
            preparedStatement.executeUpdate();

            preparedStatement1.setString(1,resultSet.getString("id"));
            preparedStatement1.executeUpdate();
        }
    }

    private void setPreparedStatement(PreparedStatement preparedStatement, PreparedStatement preparedStatement1, Customer entity) throws SQLException {
            preparedStatement.setString(1,entity.getAddressId());
            preparedStatement.setString(2,entity.getContactId());
            preparedStatement.setString(3,entity.getName());
            preparedStatement.setString(4,entity.getSurname());
            preparedStatement.setString(5,entity.getPassword());
            preparedStatement.setDate(6, (Date) entity.getDateOfBirth());
            preparedStatement.setString(7,entity.getImage());
            preparedStatement.setString(8, String.valueOf(entity.getGender()));
            preparedStatement.setString(9, String.valueOf(entity.getAccountStatus()));

            preparedStatement1.setString(2, String.valueOf(entity.getCustomerType()));
    }

    @Override
    public void update(Customer entity) throws SQLException, IOException {
        String sql =" update               " +
                "      person          " +
                " set                  " +
                "      address_id=?,   " +
                "      contact_id=?,   " +
                "      name=?,         " +
                "      surname=?,      " +
                "      password=?,     " +
                "      birth_of_date=?, " +
                "      image=?,         " +
                "      gender=?,        " +
                "      accoutn_status=?," +
                "      updated_date=sysdate" +
                " where                " +
                "      id=(select      " +
                "               person_id " +
                "          from           " +
                "               employee  " +
                "          where          " +
                "               id=?)     ";

        String sql1 = "update           " +
                "           customer    " +
                "      set              " +
                "          person_id = ?," +
                "          customer_type = ?," +
                "          updated_date = sysdate" +
                "      where            " +
                "          id = ?       ";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement1 =connection.prepareStatement(sql1)) {

            setPreparedStatement(preparedStatement,preparedStatement1,entity);
            preparedStatement.setString(10,entity.getId());
            preparedStatement.executeUpdate();

            preparedStatement1.setString(5,entity.getId());
            preparedStatement1.executeUpdate();
        }
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        String sql = "UPDATE          " +
                "     CUSTOMER   " +
                "SET             " +
                "     ACTIVE = 0, " +
                "     UPDATED_DATE = SYSDATE, " +
                "WHERE           " +
                "     ID = ?     ";

        String sql2 = "UPDATE               " +
                "     PERSON          " +
                "SET                  " +
                "     ACTIVE = 0,      " +
                "     UPDATED_DATE = SYSDATE,      " +
                "WHERE                " +
                "ID = (SELECT         " +
                "           PERSON_ID " +
                "      FROM           " +
                "           CUSTOMER  " +
                "      WHERE          " +
                "           ID = ?)   ";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PreparedStatement preparedStatement2 = connection.prepareStatement(sql2)){
            preparedStatement.setString(1,id);
            preparedStatement2.setString(1,id);
            preparedStatement.execute();
            preparedStatement2.execute();
        }
    }
}
