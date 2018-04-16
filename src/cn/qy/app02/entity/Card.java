package cn.qy.app02.entity;

public class Card {
    private Integer code;
    private String address;
    private Students students;
    public Card(){

    }

    public Card(Integer code, String address) {
        this.code = code;
        this.address = address;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
