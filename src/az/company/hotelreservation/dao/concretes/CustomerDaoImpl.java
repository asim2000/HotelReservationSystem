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
        String sql = " select " +
                    "    c.id id," +
                    "    c.person_id person_id," +
                    "    c.customer_type customer_type," +
                    "    c.created_date created_date," +
                    "    c.updated_date updated_date," +
                    "    c.active active," +
                    "    p.address_id a1_id," +
                    "    p.contact_id contact_id," +
                    "    p.name name," +
                    "    p.surname surname," +
                    "    p.date_of_birth date_of_birth," +
                    "    p.password password," +
                    "    p.image image," +
                    "    p.gender gender," +
                    "    p.account_status account_status," +
                    "    p.created_date person_created_date," +
                    "    p.updated_date updated_date," +
                    "    p.active person_active," +
                    "    co.phone contact_phone," +
                    "    co.email contact_email," +
                    "    co.created_date contact_created_date," +
                    "    co.updated_date contact_updated_date," +
                    "    co.active contact_active," +
                    "    a1.parent_id a1_parent_id," +
                    "    a1.name a1_name," +
                    "    a1.created_date a1_created_date," +
                    "    a1.updated_date a1_updated_date," +
                    "    a1.active a1_active," +
                    "    a2.parent_id a2_parent_id," +
                    "    a2.name a2_name," +
                    "    a2.created_date a2_created_date," +
                    "    a2.updated_date a2_updated_date," +
                    "    a2.active a2_active," +
                    "    a3.parent_id a3_parent_id," +
                    "    a3.name a3_name," +
                    "    a3.created_date a3_created_date," +
                    "    a3.updated_date a3_updated_date," +
                    "    a3.active a3_active," +
                    "    a4.parent_id a4_parent_id," +
                    "    a4.name a4_name," +
                    "    a4.created_date a4_created_date," +
                    "    a4.updated_date a4_updated_date," +
                    "    a4.active a4_active" +
                    " from " +
                    "    customer c," +
                    "    person p," +
                    "    address a1," +
                    "    address a2," +
                    "    address a3," +
                    "    address a4," +
                    "    contact co" +
                    " where " +
                    "    c.active = 1 and" +
                    "    c.person_id = p.id and" +
                    "    p.address_id = a1.id and" +
                    "    a1.parent_id = a2.id and" +
                    "    a2.parent_id = a3.id and" +
                    "    a3.parent_id = a4.id and" +
                    "    p.contact_id = co.id";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
                 while(resultSet.next()){
                     customers.add(setCustomer(resultSet));
                 }
        }
        return customers;
    }
    

    @Override
    public Customer getById(String id) throws SQLException, IOException {
        String sql = " select " +
                    "    c.id id," +
                    "    c.person_id person_id," +
                    "    c.customer_type customer_type," +
                    "    c.created_date created_date," +
                    "    c.updated_date updated_date," +
                    "    c.active active," +
                    "    p.address_id a1_id," +
                    "    p.contact_id contact_id," +
                    "    p.name name," +
                    "    p.surname surname," +
                    "    p.date_of_birth date_of_birth," +
                    "    p.password password," +
                    "    p.image image," +
                    "    p.gender gender," +
                    "    p.account_status account_status," +
                    "    p.created_date person_created_date," +
                    "    p.updated_date updated_date," +
                    "    p.active person_active," +
                    "    co.phone contact_phone," +
                    "    co.email contact_email," +
                    "    co.created_date contact_created_date," +
                    "    co.updated_date contact_updated_date," +
                    "    co.active contact_active," +
                    "    a1.parent_id a1_parent_id," +
                    "    a1.name a1_name," +
                    "    a1.created_date a1_created_date," +
                    "    a1.updated_date a1_updated_date," +
                    "    a1.active a1_active," +
                    "    a2.parent_id a2_parent_id," +
                    "    a2.name a2_name," +
                    "    a2.created_date a2_created_date," +
                    "    a2.updated_date a2_updated_date," +
                    "    a2.active a2_active," +
                    "    a3.parent_id a3_parent_id," +
                    "    a3.name a3_name," +
                    "    a3.created_date a3_created_date," +
                    "    a3.updated_date a3_updated_date," +
                    "    a3.active a3_active," +
                    "    a4.parent_id a4_parent_id," +
                    "    a4.name a4_name," +
                    "    a4.created_date a4_created_date," +
                    "    a4.updated_date a4_updated_date," +
                    "    a4.active a4_active" +
                    " from " +
                    "    customer c," +
                    "    person p," +
                    "    address a1," +
                    "    address a2," +
                    "    address a3," +
                    "    address a4," +
                    "    contact co" +
                    " where " +
                    "    c.id = ? and" +
                    "    c.active = 1 and" +
                    "    c.person_id = p.id and" +
                    "    p.address_id = a1.id and" +
                    "    a1.parent_id = a2.id and" +
                    "    a2.parent_id = a3.id and" +
                    "    a3.parent_id = a4.id and" +
                    "    p.contact_id = co.id";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            return setCustomer(resultSet);
        }
        return null;
    }

    private Customer setCustomer(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();
        customer.setId(resultSet.getString("id"));
        customer.setPersonId(resultSet.getString("person_id"));
        customer.setCustomerType(CustomerType.valueOf(resultSet.getString("customer_type")));
        customer.setAddressId(resultSet.getString("a1_id"));
        customer.setContactId(resultSet.getString("contact_id"));
        customer.setName(resultSet.getString("name"));
        customer.setSurname(resultSet.getString("surname"));
        customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
        customer.setPassword(resultSet.getString("password"));
        customer.setGender(Gender.valueOf(resultSet.getString("gender")));
        customer.setImage(resultSet.getString("image"));
        customer.setAccountStatus(AccountStatus.valueOf(resultSet.getString("account_status")));
        customer.setCreatedDate(resultSet.getDate("created_date"));
        customer.setUpdatedDate(resultSet.getDate("updated_date"));
        customer.setActive(resultSet.getInt("active"));

        customer.setAddress(DaoHelper.setAddress(resultSet,""));
        customer.setContact(DaoHelper.setContact(resultSet, ""));
        return customer;
    }

    @Override
    public void create(Customer entity) throws SQLException, IOException {
        String insertContact = "insert into contact(phone,email) values(?,?)";
        String insertAddress = "insert into address(parent_id,name) values(?,?)";
        String insertPerson = "insert into person(address_id," +
                                        "contact_id," +
                                        "name," +
                                        "surname," +
                                        "password," +
                                        "date_of_birth," +
                                        "image," +
                                        "gender) "  +
                    "  values(?,?,?,?,?,?,?,?)";

        String insertCustomer = "insert                  " +
                        "into customer(person_id," +
                        "              customer_type)" +
                        " values                  " +
                        "     (?,?)          ";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement contactPreparedStatement = connection.prepareStatement(insertContact,new String[]{"Id"} );
            PreparedStatement addressPreparedStatement = connection.prepareStatement(insertAddress, new String[]{"Id"});
            PreparedStatement personPreparedStatement = connection.prepareStatement(insertPerson, new String[]{"Id"});
            PreparedStatement customerPreparedStatement = connection.prepareStatement(insertCustomer)) {
            
            contactPreparedStatement.setString(1, entity.getContact().getPhone());
            contactPreparedStatement.setString(2, entity.getContact().getEmail());
            contactPreparedStatement.execute();
            ResultSet contactResultSet = contactPreparedStatement.getGeneratedKeys();
            String contactId = null;
            if(contactResultSet.next()){
                contactId = contactResultSet.getString(1);
            }
            addressPreparedStatement.setString(1, entity.getAddress().getParentId());
            addressPreparedStatement.setString(2, entity.getAddress().getName());
            addressPreparedStatement.execute();
            ResultSet addressResultSet = addressPreparedStatement.getGeneratedKeys();
            String addressId = null;
            if(addressResultSet.next()){
                addressId = addressResultSet.getString(1);
            }
            personPreparedStatement.setString(1, addressId);
            personPreparedStatement.setString(2, contactId);
            personPreparedStatement.setString(3, entity.getName());
            personPreparedStatement.setString(4, entity.getSurname());
            personPreparedStatement.setString(5, entity.getPassword());
            personPreparedStatement.setDate(6, new java.sql.Date(entity.getDateOfBirth().getTime()));
            personPreparedStatement.setString(7, entity.getImage());
            personPreparedStatement.setString(8, String.valueOf(entity.getGender()));
            personPreparedStatement.execute();
            ResultSet personResultSet = personPreparedStatement.getGeneratedKeys();
            String personId = null;
            if(personResultSet.next()){
                System.out.println("Id: " + personResultSet.getString(1));
            personId = personResultSet.getString(1);
            }
            customerPreparedStatement.setString(1, personId);
            customerPreparedStatement.setString(2, "Customer");
            customerPreparedStatement.execute();
        }
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

            //setPreparedStatement(preparedStatement,preparedStatement1,entity);
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
