package az.company.hotelreservation.model;

public class CustomerService extends Entity{
    private String customerId;
    private Customer customer;
    private String serviceId;
    private Service service;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "CustomerService{" +
                "customerId='" + customerId + '\'' +
                ", customer=" + customer +
                ", serviceId='" + serviceId + '\'' +
                ", service=" + service +
                '}';
    }
}
