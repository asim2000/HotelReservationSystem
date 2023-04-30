package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.AddressDao;
import az.company.hotelreservation.model.Address;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDaoImpl implements AddressDao{
    @Override
    public List<Address> getAll() throws SQLException, IOException {
        List<Address> addresses = new ArrayList<>();
        String sql = "SELECT \n" +
                "    A1.ID A1_ID,\n" +
                "    A1.PARENT_ID A1_PARENT_ID,\n" +
                "    A1.NAME A1_NAME,\n" +
                "    A1.CREATED_DATE A1_CREATED_DATE,\n" +
                "    A1.UPDATED_DATE A1_UPDATED_DATE,\n" +
                "    A1.ACTIVE A1_ACTIVE,\n" +
                "    A2.PARENT_ID A2_PARENT_ID,\n" +
                "    A2.NAME A2_NAME,\n" +
                "    A2.CREATED_DATE A2_CREATED_DATE,\n" +
                "    A2.UPDATED_DATE A2_UPDATED_DATE,\n" +
                "    A2.ACTIVE A2_ACTIVE,\n" +
                "    A3.PARENT_ID A3_PARENT_ID,\n" +
                "    A3.NAME A3_NAME,\n" +
                "    A3.CREATED_DATE A3_CREATED_DATE,\n" +
                "    A3.UPDATED_DATE A3_UPDATED_DATE,\n" +
                "    A3.ACTIVE A3_ACTIVE,\n" +
                "    A4.NAME A4_NAME,\n" +
                "    A4.CREATED_DATE A4_CREATED_DATE,\n" +
                "    A4.UPDATED_DATE A4_UPDATED_DATE,\n" +
                "    A4.ACTIVE A4_ACTIVE\n" +
                "FROM\n" +
                "    ADDRESS A1,\n" +
                "    ADDRESS A2,\n" +
                "    ADDRESS A3,\n" +
                "    ADDRESS A4\n" +
                "WHERE\n" +
                "    A1.ACTIVE = 1 AND\n" +
                "    A1.PARENT_ID = A2.ID AND\n" +
                "    A2.PARENT_ID = A3.ID AND\n" +
                "    A3.PARENT_ID = A4.ID";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             while(resultSet.next()){
               addresses.add(DaoHelper.setAddress(resultSet,""));
            }
        }
        return addresses;
    }

    @Override
    public Address getById(String id) throws SQLException, IOException {
        String sql = "SELECT \n" +
                "    A1.ID A1_ID,\n" +
                "    A1.PARENT_ID A1_PARENT_ID,\n" +
                "    A1.NAME A1_NAME,\n" +
                "    A1.CREATED_DATE A1_CREATED_DATE,\n" +
                "    A1.UPDATED_DATE A1_UPDATED_DATE,\n" +
                "    A1.ACTIVE A1_ACTIVE,\n" +
                "    A2.PARENT_ID A2_PARENT_ID,\n" +
                "    A2.NAME A2_NAME,\n" +
                "    A2.CREATED_DATE A2_CREATED_DATE,\n" +
                "    A2.UPDATED_DATE A2_UPDATED_DATE,\n" +
                "    A2.ACTIVE A2_ACTIVE,\n" +
                "    A3.PARENT_ID A3_PARENT_ID,\n" +
                "    A3.NAME A3_NAME,\n" +
                "    A3.CREATED_DATE A3_CREATED_DATE,\n" +
                "    A3.UPDATED_DATE A3_UPDATED_DATE,\n" +
                "    A3.ACTIVE A3_ACTIVE,\n" +
                "    A4.NAME A4_NAME,\n" +
                "    A4.CREATED_DATE A4_CREATED_DATE,\n" +
                "    A4.UPDATED_DATE A4_UPDATED_DATE,\n" +
                "    A4.ACTIVE A4_ACTIVE\n" +
                "FROM\n" +
                "    ADDRESS A1,\n" +
                "    ADDRESS A2,\n" +
                "    ADDRESS A3,\n" +
                "    ADDRESS A4\n" +
                "WHERE\n" +
                "    A1.ACTIVE = 1 AND\n" +
                "    A1.ID = ? AND\n" +
                "    A1.PARENT_ID = A2.ID AND\n" +
                "    A2.PARENT_ID = A3.ID AND\n" +
                "    A3.PARENT_ID = A4.ID";

        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.getResultSet()) {
            preparedStatement.setString(1,id);
            return DaoHelper.setAddress(resultSet,"");
        }
    }
    @Override
    public void create(Address address) throws SQLException, IOException {
        String sql = "insert into address(parent_id,name) values(?,?)";
        try (Connection connection = DbHelper.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,address.getParentId());
            preparedStatement.setString(2,address.getName());
            preparedStatement.execute();
        }
    }

    @Override
    public void update(Address address) throws SQLException, IOException {
        String sql = "update address set name=?,parent_id=?,updated_date=sysdate where id=?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,address.getName());
            preparedStatement.setString(2,address.getParentId());
            preparedStatement.setString(3,address.getId());
            preparedStatement.execute();
        }
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        String sql = "UPDATE ADDRESS SET ACTIVE = CASE WHEN (SELECT ID FROM PERSON WHERE ADDRESS_ID = ?) IS NULL THEN 0 ELSE 1 END,UPDATED_DATE = CASE WHEN (SELECT ID FROM PERSON WHERE ADDRESS_ID = '7B34F3B782DE41FE97BA09B86E73BE19') IS NULL THEN SYSDATE ELSE NULL END WHERE ID = ?";
        try(Connection connection = DbHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        }
    }
}