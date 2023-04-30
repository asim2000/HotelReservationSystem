package az.company.hotelreservation.model;

import java.util.Date;

public class Entity {
    private String id;
    private Date createdDate;
    private Date updatedDate;
    private Integer active;

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", active=" + active +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
}
