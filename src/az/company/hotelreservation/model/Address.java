package az.company.hotelreservation.model;

public class Address extends Entity{
    private String parentId;
    private Address parent;
    private String name;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Address getParent() {
        return parent;
    }

    public void setParent(Address parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Id='" + super.getId() + '\'' +
                "parentId='" + getParentId() + '\'' +
                "parentName='" + parent.getName() + '\'' +
                ", name='" + name + '\'' +
                "active='" + super.getActive() + '\'' +
                "dataDate='" + super.getDataDate() + '\'' +
                '}';
    }
}
