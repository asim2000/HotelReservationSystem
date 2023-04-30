package az.company.hotelreservation.model;

public class Employee extends Person{
    private String personId;
    private Person person;
    private String parentId;
    private Employee parent;
    private String hotelId;
    private Hotel hotel;
    private Position position;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Employee getParent() {
        return parent;
    }

    public void setParent(Employee parent) {
        this.parent = parent;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "personId='" + personId + '\'' +
                ", person=" + person +
                ", parentId='" + parentId + '\'' +
                ", parent=" + parent +
                ", hotelId='" + hotelId + '\'' +
                ", hotel=" + hotel +
                ", position=" + position +
                '}';
    }
}