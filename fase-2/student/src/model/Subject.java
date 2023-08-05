package model;

public class Subject {
    Integer id;
    Integer workload;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkload() {
        return workload;
    }

    public void setWorkload(Integer workload) {
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
