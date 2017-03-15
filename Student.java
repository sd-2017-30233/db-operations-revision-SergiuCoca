/**
 * Created by Sergiu Coca on 3/13/2017.
 */

import java.util.*;

public class Student {
    private int ID;
    private String name;
    private Date birthDate=new Date();
    private String address;

    public Student(int ID, String name, Date birthDate, String address) {
        this.ID = ID;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
    }
    public Student(){}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", adress='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (ID != student.ID) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (birthDate != null ? !birthDate.equals(student.birthDate) : student.birthDate != null) return false;
        return address != null ? address.equals(student.address) : student.address == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
