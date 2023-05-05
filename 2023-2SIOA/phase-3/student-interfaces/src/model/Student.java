package model;

public abstract class Student implements Comparable<Student> {
    public Integer getRm() {
        return rm;
    }

    public void setRm(Integer rm) {
        this.rm = rm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer rm;
    private String name;

    public Student(){}

    public Student(Integer rm, String name) {
        this.rm = rm;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rm=" + rm +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.rm.compareTo(o.rm);
    }

}
