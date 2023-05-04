package az.company.hotelreservation.model;

import java.util.Date;

public class Person extends Entity{
    private String addressId;
    private Address address;
    private String contactId;
    private Contact contact;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String password;
    private String image;
    private Gender gender;
    private AccountStatus accountStatus;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "addressId='" + addressId + '\'' +
                ", contactId='" + contactId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthOfDate=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                '}';
    }
}