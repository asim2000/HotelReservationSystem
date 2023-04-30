package az.company.hotelreservation.model;

public class Customer extends Person{
    private String personId;
    private Person person;
    private CustomerType customerType;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "personId='" + personId + '\'' +
                ", person=" + person +
                ", customerType=" + customerType +
                '}';
    }
}