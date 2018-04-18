package cn.qy.app03.entity;

public class Player {
    private Integer id;
    private String name;
    private Double sal;

    public Player() {
    }

    public Player(Integer id, String name, Double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
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

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}
