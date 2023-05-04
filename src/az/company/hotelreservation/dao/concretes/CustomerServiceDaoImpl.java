package az.company.hotelreservation.dao.concretes;

import az.company.hotelreservation.dao.abstracts.CustomerServiceDao;
import az.company.hotelreservation.model.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceDaoImpl implements CustomerServiceDao {
    @Override
    public List<CustomerService> getAll() throws SQLException, IOException {
        List<CustomerService> customerServices = new ArrayList<>();
        String sql = "select \n" +
                "    cs.Id id,\n" +
                "    cs.customer_id customer_id,\n" +
                "    cs.service_id service_id,\n" +
                "    cs.created_date created_date,\n" +
                "    cs.updated_date updated_date,\n" +
                "    cs.active active,\n" +
                "    cu.person_id customer_person_id,\n" +
                "    cu.customer_type customer_type,\n" +
                "    cu.created_date customer_created_date,\n" +
                "    cu.updated_date customer_updated_date,\n" +
                "    cu.active customer_active,\n" +
                "    s.hotel_id hotel_id,\n" +
                "    s.name service_name,\n" +
                "    s.price service_price,\n" +
                "    s.description service_description,\n" +
                "    s.created_date service_created_date,\n" +
                "    s.updated_date service_updated_date,\n" +
                "    s.active service_active,\n" +
                "    h.address_id hotel_a1_id,\n" +
                "    h.contact_id hotel_contact_id,\n" +
                "    h.name hotel_name,\n" +
                "    h.rating hotel_rating,\n" +
                "    h.description hotel_description,\n" +
                "    h.created_date hotel_created_date,\n" +
                "    h.updated_date hotel_updated_date,\n" +
                "    h.active hotel_active,\n" +
                "    h_a1.parent_id h_a1_parent_id,\n" +
                "    h_a1.name hotel_a1_name,\n" +
                "    h_a1.created_date hotel_a1_created_date,\n" +
                "    h_a1.updated_date hotel_a1_updated_date,\n" +
                "    h_a1.active hotel_a1_active,\n" +
                "    h_a2.parent_id hotel_a2_parent_id,\n" +
                "    h_a2.name hotel_a2_name,\n" +
                "    h_a2.created_date hotel_a2_created_date,\n" +
                "    h_a2.updated_date hotel_a2_updated_date,\n" +
                "    h_a2.active hotel_a2_active,\n" +
                "    h_a3.parent_id hotel_a3_parent_id,\n" +
                "    h_a3.name hotel_a3_name,\n" +
                "    h_a3.created_date hotel_a3_created_date,\n" +
                "    h_a3.updated_date hotel_a3_updated_date,\n" +
                "    h_a3.active hotel_a3_active,\n" +
                "    h_a4.name hotel_a4_name,\n" +
                "    h_a4.created_date hotel_a4_created_date,\n" +
                "    h_a4.updated_date hotel_a4_updated_date,\n" +
                "    h_a4.active hotel_a4_active,\n" +
                "    p.address_id person_a1_id,\n" +
                "    p.contact_id person_contact_id,\n" +
                "    p.name person_name,\n" +
                "    p.surname person_surname,\n" +
                "    p.date_of_birth person_date_of_birth,\n" +
                "    p.password person_password,\n" +
                "    p.image person_image,\n" +
                "    p.gender person_gender,\n" +
                "    p.created_date person_created_date,\n" +
                "    p.updated_date person_updated_date,\n" +
                "    p.active person_active,\n" +
                "    p_a1.parent_id person_a1_parent_id,\n" +
                "    p_a1.name person_a1_name,\n" +
                "    p_a1.created_date person_a1_created_date,\n" +
                "    p_a1.updated_date person_a1_updated_date,\n" +
                "    p_a1.active person_a1_active,\n" +
                "    p_a2.parent_id person_a2_parent_id,\n" +
                "    p_a2.name person_a2_name,\n" +
                "    p_a2.created_date person_a2_created_date,\n" +
                "    p_a2.updated_date person_a2_updated_date,\n" +
                "    p_a2.active person_a2_active,\n" +
                "    p_a3.parent_id person_a3_parent_id,\n" +
                "    p_a3.name person_a3_name,\n" +
                "    p_a3.created_date person_a3_created_date,\n" +
                "    p_a3.updated_date person_a3_updated_date,\n" +
                "    p_a3.active person_a3_active,\n" +
                "    p_a4.name person_a4_name,\n" +
                "    p_a4.created_date person_a4_created_date,\n" +
                "    p_a4.updated_date person_a4_updated_date,\n" +
                "    p_a4.active person_a4_active,\n" +
                "    p_co.phone person_contact_phone,\n" +
                "    p_co.email person_contact_email,\n" +
                "    p_co.created_date person_contact_created_date,\n" +
                "    p_co.updated_date person_contact_updated_date,\n" +
                "    p_co.active person_contact_active,\n" +
                "    h_co.phone hotel_contact_phone,\n" +
                "    h_co.email hotel_contact_email,\n" +
                "    h_co.created_date hotel_contact_created_date,\n" +
                "    h_co.updated_date hotel_contact_updated_date,\n" +
                "    h_co.active hotel_contact_active\n" +
                "from\n" +
                "    customer_service cs,\n" +
                "    customer cu,\n" +
                "    service s,\n" +
                "    person p,\n" +
                "    address h_a1,\n" +
                "    address h_a2,\n" +
                "    address h_a3,\n" +
                "    address h_a4,\n" +
                "    address p_a1,\n" +
                "    address p_a2,\n" +
                "    address p_a3,\n" +
                "    address p_a4,\n" +
                "    contact h_co,\n" +
                "    contact p_co,\n" +
                "    hotel h\n" +
                "where\n" +
                "    cs.active = 1 and\n" +
                "    cs.customer_id = cu.id and\n" +
                "    cs.service_id = s.id and\n" +
                "    cu.person_id = p.id and\n" +
                "    p.address_id = p_a1.id and\n" +
                "    p_a1.parent_id = p_a2.id and\n" +
                "    p_a2.parent_id = p_a3.id and\n" +
                "    p_a3.parent_id = p_a4.id and\n" +
                "    p.contact_id = p_co.id and\n" +
                "    s.hotel_id = h.id and\n" +
                "    h.address_id = h_a1.id and\n" +
                "    h_a1.parent_id = h_a2.id and\n" +
                "    h_a2.parent_id = h_a3.id and\n" +
                "    h_a3.parent_id = h_a4.id and\n" +
                "    h.contact_id = h_co.id;\n";
        try (Connection connection = DbHelper.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                customerServices.add(setCustomerService(resultSet));
            }
        }
        return customerServices;
    }

    private CustomerService setCustomerService(ResultSet resultSet) throws SQLException {
        CustomerService customerService = new CustomerService();
        customerService.setId(resultSet.getString("id"));
        customerService.setCustomerId(resultSet.getString("customer_id"));
        customerService.setServiceId(resultSet.getString("service_id"));
        customerService.setCreatedDate(resultSet.getDate("created_date"));
        customerService.setUpdatedDate(resultSet.getDate("updated_date"));
        customerService.setActive(resultSet.getInt("active"));

        Customer customer = new Customer();
        customer.setId(resultSet.getString("customer_id"));
        customer.setName(resultSet.getString("person_name"));
        customer.setSurname(resultSet.getString("person_surname"));
        customer.setDateOfBirth(resultSet.getDate("person_date_of_birth"));
        customer.setPassword(resultSet.getString("person_password"));
        customer.setGender(Gender.valueOf(resultSet.getString("person_gender")));
        customer.setImage(resultSet.getString("person_image"));
        customer.setAccountStatus(AccountStatus.valueOf(resultSet.getString("person_account_status")));
        customer.setAddressId(resultSet.getString("person_address_id"));
        customer.setAddress(DaoHelper.setAddress(resultSet,"person_"));
        customer.setContactId(resultSet.getString("person_contact_id"));
        customer.setContact(DaoHelper.setContact(resultSet,"person_"));
        customer.setCreatedDate(resultSet.getDate("person_created_date"));
        customer.setUpdatedDate(resultSet.getDate("person_updated_date"));
        customer.setActive(resultSet.getInt("person_active"));

        Service service = new Service();
        service.setId(resultSet.getString("service_id"));
        service.setHotelId(resultSet.getString("hotel_id"));
        service.setName(resultSet.getString("service_name"));
        service.setPrice(resultSet.getFloat("service_price"));
        service.setDescription(resultSet.getString("service_description"));
        service.setHotel(DaoHelper.setHotel(resultSet,""));
        service.setCreatedDate(resultSet.getDate("service_created_date"));
        service.setUpdatedDate(resultSet.getDate("service_updated_date"));
        service.setActive(resultSet.getInt("service_active"));
        return customerService;
    }

    @Override
    public CustomerService getById(String id) throws SQLException, IOException {
        return null;
    }

    @Override
    public void create(CustomerService entity) throws SQLException, IOException {

    }

    @Override
    public void update(CustomerService entity) throws SQLException, IOException {

    }

    @Override
    public void delete(String id) throws SQLException, IOException {

    }
}
