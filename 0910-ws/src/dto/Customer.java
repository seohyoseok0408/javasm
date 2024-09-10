package dto;

import java.util.Date;

public class Customer {
    private int id;
    private String password;
    private String name;
    private Date joinDate;

    public Customer() {}
    public Customer(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.joinDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }
}
