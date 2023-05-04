package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.CreditCardDao;
import az.company.hotelreservation.model.CreditCard;
import az.company.hotelreservation.model.CreditCardType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardDaoImpl implements CreditCardDao {
    @Override
    public List<CreditCard> getAll() throws SQLException, IOException {
        List<CreditCard> creditCards = new ArrayList<>();
        String sql = "select" +
                        "cc.id id," +
                        "cc.card_number card_number," +
                        "cc.exp_month exp_month," +
                        "cc.exp_year exp_year," +
                        "cc.credit_card_type credit_card_type," +
                        "cc.created_date created_date," +
                        "cc.updated_date updated_date," +
                        "cc.active active" +
                    "from" +
                        "credit_card cc" +
                    "where" +
                        "active = 1";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet =preparedStatement.executeQuery()){
                while (resultSet.next()){
                    creditCards.add(setCreditCard(resultSet));
                }
        }
        return creditCards;
    }

    private CreditCard setCreditCard(ResultSet resultSet) throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(resultSet.getString("id"));
        creditCard.setCardNumber(resultSet.getString("cardNumber"));
        creditCard.setCreditCardType(CreditCardType.valueOf(resultSet.getString("credit_card_type")));
        creditCard.setExpMonth(resultSet.getInt("exp_month"));
        creditCard.setExpYear(resultSet.getInt("exp_year"));
        creditCard.setCreatedDate(resultSet.getDate("created_date"));
        creditCard.setUpdatedDate(resultSet.getDate("updated_date"));
        creditCard.setActive(resultSet.getInt("active"));
        return creditCard;
    }

    @Override
    public CreditCard getById(String id) throws SQLException, IOException {
        String sql = "select" +
                "cc.id id," +
                "cc.card_number card_number," +
                "cc.exp_month exp_month," +
                "cc.exp_year exp_year," +
                "cc.credit_card_type credit_card_type," +
                "cc.created_date created_date," +
                "cc.updated_date updated_date," +
                "cc.active active" +
                "from" +
                "credit_card cc" +
            "where" +
                "id = ? and" +
                "active = 1";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet =preparedStatement.executeQuery()){
            preparedStatement.setString(1,id);
            if (resultSet.next()){
                return setCreditCard(resultSet);
            }
        }
        return null;
    }

    @Override
    public void create(CreditCard entity) throws SQLException, IOException {
        String sql = "insert" +
                    "into" +
                        "credit_card" +
                        "(card_number," +
                        " exp_month," +
                        " exp_year," +
                        " credit_card_type)" +
                    "values" +
                        "(?,?,?,?)";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             setPreparedStatement(preparedStatement,entity);
        }
    }

    private void setPreparedStatement(PreparedStatement preparedStatement,CreditCard entity) throws SQLException {
        preparedStatement.setString(1,entity.getCardNumber());
        preparedStatement.setInt(2,entity.getExpMonth());
        preparedStatement.setInt(3,entity.getExpYear());
        preparedStatement.setString(4, String.valueOf(entity.getCreditCardType()));
        preparedStatement.executeUpdate();
    }

    @Override
    public void update(CreditCard entity) throws SQLException, IOException {
        String sql = "upadte" +
                        "credit_card" +
                    "set" +
                        "card_number = ?," +
                        "exp_month = ?," +
                        "exp_year = ?," +
                        "credit_card_type = ?" +
                        "updated_date = sysdate" +
                    "where" +
                        "id = ?";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(5,entity.getId());
             setPreparedStatement(preparedStatement,entity);
        }
    }

    @Override
    public void delete(String id) throws SQLException, IOException {
        String sql = "update" +
                        "credit_card" +
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
