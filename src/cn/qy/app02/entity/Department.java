package cn.qy.app02.entity;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Integer id;
    private String name;
    private List<Staff> staffList = new ArrayList<Staff>();

    public Department() {
    }

    public Department(Integer id, String name, List<Staff> list) {
        this.id = id;
        this.name = name;
        this.staffList = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Staff> getList() {
        return staffList;
    }

    public void setList(List<Staff> list) {
        this.staffList = list;
    }
}
