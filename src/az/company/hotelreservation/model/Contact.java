package az.company.hotelreservation.model;

public class Contact extends Entity{
    private String phone;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
