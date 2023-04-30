package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.EmployeeDao;
import az.company.hotelreservation.model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAll() throws SQLException, IOException {
        String sql = "SELECT                                       " +
                "     E.ID ID,                                 " +
                "     E.POSITION POSITION,                     " +
                "     E.PARENT_ID PARENT_ID,                   " +
                "     E.HOTEL_ID HOTEL_ID,            " +
                "     E.CREATED_DATE EMPLOYEE_CREATED_DATE, " +
                "     E.ACTIVE EMPLOYEE_ACTIVE,       " +
                "     PE.POSITION EMPLOYEE_PARENT_POSITION,    " +
                "     PE.PERSON_ID EMPLOYEE_PARENT_PERSON_ID,  " +
                "     PE.CREATED_DATE EMPLOYEE_PARENT_CREATED_DATE,  " +
                "     PE.ACTIVE EMPLOYEE_PARENT_ACTIVE,        " +
                "     H.NAME HOTEL_NAME,              " +
                "     H.ADDRESS_ID HOTEL_ADDRESS_ID,  " +
                "     H.CONTACT_ID HOTEL_CONTACT_ID,  " +
                "     H.DESCRIPTION HOTEL_DESCRIPTION," +
                "     H.RATING HOTEL_RATING,          " +
                "     H.CREATED_DATE HOTEL_CREATED_DATE,    " +
                "     H.ACTIVE HOTEL_ACTIVE,          " +
                "     H_A1.PARENT_ID HOTEL_A2_ID,      " +
                "     H_A1.NAME HOTEL_A1_NAME,      " +
                "     H_A1.CREATED_DATE HOTEL_A1_CREATED_DATE,      " +
                "     H_A1.UPDATED_DATE HOTEL_A1_UPDATED_DATE,      " +
                "     H_A1.ACTIVE HOTEL_A1_ACTIVE,      " +
                "     H_A2.PARENT_ID HOTEL_A3_ID,      " +
                "     H_A2.NAME HOTEL_A2_NAME,      " +
                "     H_A2.CREATED_DATE HOTEL_A2_CREATED_DATE,      " +
                "     H_A2.UPDATED_DATE HOTEL_A2_UPDATED_DATE,      " +
                "     H_A2.ACTIVE HOTEL_A2_ACTIVE,      " +
                "     H_A3.PARENT_ID HOTEL_A4_ID,      " +
                "     H_A3.NAME HOTEL_A3_NAME,      " +
                "     H_A3.CREATED_DATE HOTEL_A3_CREATED_DATE,      " +
                "     H_A3.UPDATED_DATE HOTEL_A3_UPDATED_DATE,      " +
                "     H_A3.ACTIVE HOTEL_A3_ACTIVE,      " +
                "     H_A4.NAME HOTEL_A4_NAME,      " +
                "     H_A4.CREATED_DATE HOTEL_A4_CREATED_DATE,      " +
                "     H_A4.UPDATED_DATE HOTEL_A4_UPDATED_DATE,      " +
                "     H_A4.ACTIVE HOTEL_A4_ACTIVE,      " +
                "     P.NAME NAME,                    " +
                "     P.SURNAME SURNAME,              " +
                "     P.IMAGE IMAGE,                  " +
                "     P.PASSWORD PASSWORD,            " +
                "     P.DATE_OF_BIRTH DATE_OF_BIRTH,  " +
                "     P.GENDER GENDER,                " +
                "     P.ACCOUNT_STATUS ACCOUNT_STATUS," +
                "     P.ADDRESS_ID PERSON_A1_ID,      " +
                "     P.CONTACT_ID PERSON_CONTACT_ID,      " +
                "     P.ACTIVE ACTIVE,          " +
                "     P.CREATED_DATE CREATED_DATE     " +
                "     P_A1.PARENT_ID PERSON_A2_ID,      " +
                "     P_A1.NAME PERSON_A1_NAME,      " +
                "     P_A1.CREATED_DATE PERSON_A1_CREATED_DATE,      " +
                "     P_A1.UPDATED_DATE PERSON_A1_UPDATED_DATE,      " +
                "     P_A1.ACTIVE PERSON_A1_ACTIVE,      " +
                "     P_A2.PARENT_ID PERSON_A3_ID,      " +
                "     P_A2.NAME PERSON_A2_NAME,      " +
                "     P_A2.CREATED_DATE PERSON_A2_CREATED_DATE,      " +
                "     P_A2.UPDATED_DATE PERSON_A2_UPDATED_DATE,      " +
                "     P_A2.ACTIVE PERSON_A2_ACTIVE,      " +
                "     P_A3.PARENT_ID PERSON_A4_ID,      " +
                "     P_A3.NAME PERSON_A3_NAME,      " +
                "     P_A3.CREATED_DATE PERSON_A3_CREATED_DATE,      " +
                "     P_A3.UPDATED_DATE PERSON_A3_UPDATED_DATE,      " +
                "     P_A3.ACTIVE PERSON_A3_ACTIVE,      " +
                "     P_A4.NAME PERSON_A4_NAME,      " +
                "     P_A4.CREATED_DATE PERSON_A4_CREATED_DATE,      " +
                "     P_A4.UPDATED_DATE PERSON_A4_UPDATED_DATE,      " +
                "     P_A4.ACTIVE PERSON_A4_ACTIVE,      " +
                "     A.PARENT_ID ADDRESS_PARENT_ID," +
                "     A.NAME ADDRESS_NAME,          " +
                "     A.CREATED_DATE ADDRESS_CREATED_DATE," +
                "     PC.EMAIL PERSON_EMAIL,                " +
                "     PC.PHONE PERSON_PHONE,                " +
                "     PC.CREATED_DATE PERSON_CONTACT_CREATED_DATE," +
                "     PC.UPDATED_DATE PERSON_CONTACT_UPDATED_DATE," +
                "     PC.ACTIVE PERSON_CONTACT_ACTIVE,  " +
                "     HC.EMAIL HOTEL_EMAIL,                " +
                "     HC.PHONE HOTEL_PHONE,                " +
                "     HC.CREATED_DATE HOTEL_CONTACT_CREATED_DATE," +
                "     HC.UPDATED_DATE HOTEL_CONTACT_UPDATED_DATE," +
                "     HC.ACTIVE HOTEL_CONTACT_ACTIVE,  " +
                "FROM                           " +
                "    PERSON P,                  " +
                "    EMPLOYEE E,                " +
                "    EMPLOYEE PE,               " +
                "    ADDRESS P_A1," +
                "    ADDRESS P_A2," +
                "    ADDRESS P_A3," +
                "    ADDRESS P_A4," +
                "    ADDRESS H_A1," +
                "    ADDRESS H_A2," +
                "    ADDRESS H_A3," +
                "    ADDRESS H_A4," +
                "    CONTACT PC,                 " +
                "    CONTACT HC,                 " +
                "    HOTEL H                    " +
                "WHERE                          " +
                "     E.ACTIVE = 1 AND          " +
                "     P.ID = E.PERSON_ID AND    " +
                "     P.ADDRESS_ID = P_A1.ID and" +
                "     P_A1.PARENT_ID = P_A2.ID and" +
                "     P_A2.PARENT_ID = P_A3.ID and" +
                "     P_A3.PARENT_ID = P_A4.ID and" +
                "     H.ADDRESS_ID = H_A1.ID and" +
                "     H_A1.PARENT_ID = H_A2.ID and" +
                "     H_A2.PARENT_ID = H_A3.ID and" +
                "     H_A3.PARENT_ID = H_A4.ID and" +
                "     P.CONTACT_ID = PC.ID AND   " +
                "     H.CONTACT_ID = HC.ID AND   " +
                "     E.HOTEL_ID = H.ID";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery()
        ) {
            List<Employee> employees = new ArrayList<>();
            while(rs.next()){
                employees.add(setEmployee(rs));
            }
            return employees;
        }
    }

    @Override
    public Employee getById(String id) throws SQLException, IOException {
        String sql = "SELECT                                       " +
                        "     E.ID ID,                                 " +
                        "     E.POSITION POSITION,                     " +
                        "     E.PARENT_ID PARENT_ID,                   " +
                        "     E.HOTEL_ID HOTEL_ID,            " +
                        "     E.CREATED_DATE EMPLOYEE_CREATED_DATE, " +
                        "     E.UPDATED_DATE EMPLOYEE_UPDATED_DATE, " +
                        "     E.ACTIVE EMPLOYEE_ACTIVE,       " +
                        "     PE.POSITION EMPLOYEE_PARENT_POSITION,    " +
                        "     PE.PERSON_ID EMPLOYEE_PARENT_PERSON_ID,  " +
                        "     PE.CREATED_DATE EMPLOYEE_PARENT_CREATED_DATE,  " +
                        "     PE.UPDATED_DATE EMPLOYEE_PARENT_UPDATED_DATE,  " +
                        "     PE.ACTIVE EMPLOYEE_PARENT_ACTIVE,        " +
                        "     H.NAME HOTEL_NAME,              " +
                        "     H.ADDRESS_ID HOTEL_ADDRESS_ID,  " +
                        "     H.CONTACT_ID HOTEL_CONTACT_ID,  " +
                        "     H.DESCRIPTION HOTEL_DESCRIPTION," +
                        "     H.RATING HOTEL_RATING,          " +
                        "     H.CREATED_DATE HOTEL_CREATED_DATE,    " +
                        "     H.UPDATED_DATE HOTEL_UPDATED_DATE,    " +
                        "     H.ACTIVE HOTEL_ACTIVE,          " +
                        "     H_A1.PARENT_ID HOTEL_A2_ID,      " +
                        "     H_A1.NAME HOTEL_A1_NAME,      " +
                        "     H_A1.CREATED_DATE HOTEL_A1_CREATED_DATE,      " +
                        "     H_A1.UPDATED_DATE HOTEL_A1_UPDATED_DATE,      " +
                        "     H_A1.ACTIVE HOTEL_A1_ACTIVE,      " +
                        "     H_A2.PARENT_ID HOTEL_A3_ID,      " +
                        "     H_A2.NAME HOTEL_A2_NAME,      " +
                        "     H_A2.CREATED_DATE HOTEL_A2_CREATED_DATE,      " +
                        "     H_A2.UPDATED_DATE HOTEL_A2_UPDATED_DATE,      " +
                        "     H_A2.ACTIVE HOTEL_A2_ACTIVE,      " +
                        "     H_A3.PARENT_ID HOTEL_A4_ID,      " +
                        "     H_A3.NAME HOTEL_A3_NAME,      " +
                        "     H_A3.CREATED_DATE HOTEL_A3_CREATED_DATE,      " +
                        "     H_A3.UPDATED_DATE HOTEL_A3_UPDATED_DATE,      " +
                        "     H_A3.ACTIVE HOTEL_A3_ACTIVE,      " +
                        "     H_A4.NAME HOTEL_A4_NAME,      " +
                        "     H_A4.CREATED_DATE HOTEL_A4_CREATED_DATE,      " +
                        "     H_A4.UPDATED_DATE HOTEL_A4_UPDATED_DATE,      " +
                        "     H_A4.ACTIVE HOTEL_A4_ACTIVE,      " +
                        "     P.NAME NAME,                    " +
                        "     P.SURNAME SURNAME,              " +
                        "     P.IMAGE IMAGE,                  " +
                        "     P.PASSWORD PASSWORD,            " +
                        "     P.DATE_OF_BIRTH DATE_OF_BIRTH,  " +
                        "     P.GENDER GENDER,                " +
                        "     P.ACCOUNT_STATUS ACCOUNT_STATUS," +
                        "     P.ADDRESS_ID PERSON_A1_ID,      " +
                        "     P.CONTACT_ID PERSON_CONTACT_ID,      " +
                        "     P.ACTIVE ACTIVE,          " +
                        "     P.CREATED_DATE CREATED_DATE     " +
                        "     P.UPDATED_DATE UPDATED_DATE     " +
                        "     P_A1.PARENT_ID PERSON_A2_ID,      " +
                        "     P_A1.NAME PERSON_A1_NAME,      " +
                        "     P_A1.CREATED_DATE PERSON_A1_CREATED_DATE,      " +
                        "     P_A1.UPDATED_DATE PERSON_A1_UPDATED_DATE,      " +
                        "     P_A1.ACTIVE PERSON_A1_ACTIVE,      " +
                        "     P_A2.PARENT_ID PERSON_A3_ID,      " +
                        "     P_A2.NAME PERSON_A2_NAME,      " +
                        "     P_A2.CREATED_DATE PERSON_A2_CREATED_DATE,      " +
                        "     P_A2.UPDATED_DATE PERSON_A2_UPDATED_DATE,      " +
                        "     P_A2.ACTIVE PERSON_A2_ACTIVE,      " +
                        "     P_A3.PARENT_ID PERSON_A4_ID,      " +
                        "     P_A3.NAME PERSON_A3_NAME,      " +
                        "     P_A3.CREATED_DATE PERSON_A3_CREATED_DATE,      " +
                        "     P_A3.UPDATED_DATE PERSON_A3_UPDATED_DATE,      " +
                        "     P_A3.ACTIVE PERSON_A3_ACTIVE,      " +
                        "     P_A4.NAME PERSON_A4_NAME,      " +
                        "     P_A4.CREATED_DATE PERSON_A4_CREATED_DATE,      " +
                        "     P_A4.UPDATED_DATE PERSON_A4_UPDATED_DATE,      " +
                        "     P_A4.ACTIVE PERSON_A4_ACTIVE,      " +
                        "     A.PARENT_ID ADDRESS_PARENT_ID," +
                        "     A.NAME ADDRESS_NAME,          " +
                        "     A.CREATED_DATE ADDRESS_CREATED_DATE," +
                        "     A.UPDATED_DATE ADDRESS_UPDATED_DATE," +
                        "     PC.EMAIL PERSON_EMAIL,                " +
                        "     PC.PHONE PERSON_PHONE,                " +
                        "     PC.CREATED_DATE PERSON_CONTACT_CREATED_DATE," +
                        "     PC.UPDATED_DATE PERSON_CONTACT_UPDATED_DATE," +
                        "     PC.ACTIVE PERSON_CONTACT_ACTIVE,  " +
                        "     HC.EMAIL HOTEL_EMAIL,                " +
                        "     HC.PHONE HOTEL_PHONE,                " +
                        "     HC.CREATED_DATE HOTEL_CONTACT_CREATED_DATE," +
                        "     HC.UPDATED_DATE HOTEL_CONTACT_UPDATED_DATE," +
                        "     HC.ACTIVE HOTEL_CONTACT_ACTIVE,  " +
                        "FROM                           " +
                        "    PERSON P, " +
                        "    PERSON PP,            " +
                        "    EMPLOYEE E,                " +
                        "    EMPLOYEE PE,               " +
                        "    ADDRESS P_A1," +
                        "    ADDRESS P_A2," +
                        "    ADDRESS P_A3," +
                        "    ADDRESS P_A4," +
                        "    ADDRESS H_A1," +
                        "    ADDRESS H_A2," +
                        "    ADDRESS H_A3," +
                        "    ADDRESS H_A4," +
                        "    CONTACT PC,                 " +
                        "    CONTACT HC,                 " +
                        "    HOTEL H                    " +
                        "WHERE                          " +
                        "     E.ACTIVE = 1 AND          " +
                        "     ID = ? AND          " +
                        "     P.ID = E.PERSON_ID AND    " +
                        "     P.ADDRESS_ID = P_A1.ID and" +
                        "     P_A1.PARENT_ID = P_A2.ID and" +
                        "     P_A2.PARENT_ID = P_A3.ID and" +
                        "     P_A3.PARENT_ID = P_A4.ID and" +
                        "     H.ADDRESS_ID = H_A1.ID and" +
                        "     H_A1.PARENT_ID = H_A2.ID and" +
                        "     H_A2.PARENT_ID = H_A3.ID and" +
                        "     H_A3.PARENT_ID = H_A4.ID and" +
                        "     P.CONTACT_ID = PC.ID AND   " +
                        "     H.CONTACT_ID = HC.ID AND   " +
                        "     E.HOTEL_ID = H.ID AND" +
                        "     PE.PERSON_ID = PP.ID";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery()
        ) {
            preparedStatement.setString(1,id);
            if (rs.next())
            return setEmployee(rs);
        }
        return null;
    }
    private Employee setEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();

        employee.setId(rs.getString("ID"));
        employee.setName(rs.getString("NAME"));
        employee.setSurname(rs.getString("SURNAME"));
        employee.setPassword(rs.getString("PASSWORD"));
        employee.setImage(rs.getString("IMAGE"));
        employee.setAccountStatus(AccountStatus.valueOf(rs.getString("ACCOUNT_STATUS")));
        employee.setGender(Gender.valueOf(rs.getString("GENDER")));
        employee.setDateOfBirth(rs.getDate("DATE_OF_BIRTH"));
        employee.setAddressId(rs.getString("PERSON_A1_ID"));
        employee.setAddress(DaoHelper.setAddress(rs,"PERSON_"));
        employee.setPosition(Position.valueOf(rs.getString("POSITION")));
        employee.setParentId(rs.getString("EMPLOYEE_PARENT_ID"));
        employee.setHotelId(rs.getString("HOTEL_ID"));
        employee.setHotel(DaoHelper.setHotel(rs,""));
        employee.setContactId(rs.getString("PERSON_CONTACT_ID"));
        employee.setContact(DaoHelper.setContact(rs,""));
        employee.setCreatedDate(rs.getDate("EMPLOYEE_CREATED_DATE"));
        employee.setUpdatedDate(rs.getDate("EMPLOYEE_UPDATED_DATE"));
        employee.setActive(rs.getInt("EMPLOYEE_ACTIVE"));


        return employee;
    }

    @Override
    public void create(Employee entity) throws SQLException, IOException {
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
                      "into employee(person_id," +
                      "              parent_id," +
                      "              hotel_id, " +
                      "              position) " +
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

    @Override
    public void update(Employee entity) throws SQLException, IOException {
        String sql =" update               " +
                    "      person          " +
                    " set                  " +
                    "      address_id=?,   " +
                    "      contact_id=?,   " +
                    "      name=?,         " +
                    "      surname=?,      " +
                    "      password=?,     " +
                    "      birth_of_date=? " +
                    "      image=?         " +
                    "      gender=?        " +
                    "      accoutn_status=?" +
                    " where                " +
                    "      id=(select      " +
                    "               person_id " +
                    "          from           " +
                    "               employee  " +
                    "          where          " +
                    "               id=?)     ";

        String sql1 = "update           " +
                "           employee    " +
                "      set              " +
                "          person_id = ?" +
                "          parent_id = ?" +
                "          hotel_id = ? " +
                "          position = ? " +
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
                     "     EMPLOYEE   " +
                     "SET             " +
                     "     ACTIVE = 0 " +
                     "WHERE           " +
                     "     ID = ?     ";

        String sql2 = "UPDATE               " +
                      "     PERSON          " +
                      "SET                  " +
                      "     ACTIVE = 0      " +
                      "WHERE                " +
                      "ID = (SELECT         " +
                      "           PERSON_ID " +
                      "      FROM           " +
                      "           EMPLOYEE  " +
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
    public void setPreparedStatement(PreparedStatement preparedStatement,PreparedStatement preparedStatement1,Employee entity){
        try {
            preparedStatement.setString(1,entity.getAddressId());
            preparedStatement.setString(2,entity.getContactId());
            preparedStatement.setString(3,entity.getName());
            preparedStatement.setString(4,entity.getSurname());
            preparedStatement.setString(5,entity.getPassword());
            preparedStatement.setDate(6, (Date) entity.getDateOfBirth());
            preparedStatement.setString(7,entity.getImage());
            preparedStatement.setString(8, String.valueOf(entity.getGender()));
            preparedStatement.setString(9, String.valueOf(entity.getAccountStatus()));

            preparedStatement1.setString(2,entity.getParentId());
            preparedStatement1.setString(3,entity.getHotelId());
            preparedStatement1.setString(4, String.valueOf(entity.getPosition()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}