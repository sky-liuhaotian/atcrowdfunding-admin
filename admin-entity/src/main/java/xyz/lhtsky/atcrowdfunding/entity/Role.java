package xyz.lhtsky.atcrowdfunding.entity;

public class Role {

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
        // TODO Auto-generated constructor stub
    }
}