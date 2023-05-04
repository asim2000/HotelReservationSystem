package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.model.Address;
import az.company.hotelreservation.model.Contact;
import az.company.hotelreservation.model.Hotel;
import az.company.hotelreservation.model.Rating;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoHelper {
    public static Address setAddress(ResultSet resultSet,String s) throws SQLException {
        Address address1 = new Address();
        address1.setId(resultSet.getString(s+"A1_ID"));
        address1.setParentId(resultSet.getString(s+"A1_PARENT_ID"));
        address1.setName(resultSet.getString(s+"A1_NAME"));
        address1.setCreatedDate(resultSet.getDate(s+"A1_CREATED_DATE"));
        address1.setUpdatedDate(resultSet.getDate(s+"A1_UPDATED_DATE"));
        address1.setActive(resultSet.getInt(s+"A1_ACTIVE"));

        Address address2 = new Address();
        address2.setId(resultSet.getString(s+"A1_PARENT_ID"));
        address2.setParentId(resultSet.getString(s+"A2_PARENT_ID"));
        address2.setName(resultSet.getString(s+"A2_NAME"));
        address2.setCreatedDate(resultSet.getDate(s+"A2_CREATED_DATE"));
        address2.setUpdatedDate(resultSet.getDate(s+"A2_UPDATED_DATE"));
        address2.setActive(resultSet.getInt(s+"A2_ACTIVE"));

        Address address3 = new Address();
        address3.setId(resultSet.getString(s+"A2_PARENT_ID"));
        address3.setParentId(resultSet.getString(s+"A3_PARENT_ID"));
        address3.setName(resultSet.getString(s+"A3_NAME"));
        address3.setCreatedDate(resultSet.getDate(s+"A3_CREATED_DATE"));
        address3.setUpdatedDate(resultSet.getDate(s+"A3_UPDATED_DATE"));
        address3.setActive(resultSet.getInt(s+"A3_ACTIVE"));

        Address address4 = new Address();
        address4.setId(resultSet.getString(s+"A3_PARENT_ID"));
        address4.setName(resultSet.getString(s+"A4_NAME"));
        address4.setCreatedDate(resultSet.getDate(s+"A4_CREATED_DATE"));
        address4.setUpdatedDate(resultSet.getDate(s+"A4_UPDATED_DATE"));
        address4.setActive(resultSet.getInt(s+"A4_ACTIVE"));

        address1.setParent(address2);
        address2.setParent(address3);
        address3.setParent(address4);

        return address1;
    }
    public static Hotel setHotel(ResultSet resultSet,String entityName) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getString(entityName+"hotel_id"));
        hotel.setAddressId(resultSet.getString(entityName+"hotel_a1_id"));
        hotel.setAddress(setAddress(resultSet,"hotel_"));
        hotel.setContactId(resultSet.getString(entityName+"hotel_contact_id"));
        hotel.setContact(setContact(resultSet,"hotel_"));
        hotel.setName(resultSet.getString(entityName+"hotel_name"));
        hotel.setDescription(resultSet.getString(entityName+"hotel_description"));
        hotel.setRating(Rating.valueOf(resultSet.getString(entityName+"hotel_rating")));
        hotel.setCreatedDate(resultSet.getDate(entityName+"hotel_created_date"));
        hotel.setUpdatedDate(resultSet.getDate(entityName+"hotel_updated_date"));
        hotel.setActive(resultSet.getInt(entityName+"hotel_active"));
        return hotel;
    }
    public static Contact setContact(ResultSet resultSet,String entityName) throws SQLException {
        Contact contact = new Contact();
        contact.setId(resultSet.getString(entityName+"contact_id"));
        contact.setPhone(resultSet.getString(entityName+"contact_phone"));
        contact.setEmail(resultSet.getString(entityName+"contact_email"));
        contact.setCreatedDate(resultSet.getDate(entityName+"contact_created_date"));
        contact.setUpdatedDate(resultSet.getDate(entityName+"contact_updated_date"));
        contact.setActive(resultSet.getInt(entityName+"contact_active"));
        return contact;
    }
}
