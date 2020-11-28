package Homework.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
public class Student {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone")
    private String phone;


    @OneToMany(mappedBy="student",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Pen> pens;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pen> getPens() {
        return pens;
    }

    public void setPens(List<Pen> pens) {
        this.pens = pens;
    }

    public Student() {

    }

    public Student(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return phone;
    }

    public void setEmail(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
                + ", instructorDetail=" + 0 + "]";
    }

    public void add(Pen tempPen) {

        if (pens == null) {
            pens = new ArrayList<>();
        }

        pens.add(tempPen);

        tempPen.setStudent(this);
    }

}











