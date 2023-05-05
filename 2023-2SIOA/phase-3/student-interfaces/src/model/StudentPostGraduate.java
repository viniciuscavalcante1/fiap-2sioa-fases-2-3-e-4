package model;

public class StudentPostGraduate extends Student{
    private String school;
    public StudentPostGraduate(){
        super();
    }

    public StudentPostGraduate(Integer rm, String name, String school) {
        super(rm, name);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
