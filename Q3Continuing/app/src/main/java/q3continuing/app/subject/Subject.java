package q3continuing.app.subject;

import java.util.Objects;

public class Subject {
    final private String name, imgFileName;
    private double units, grade;
	
    public Subject(String n, String i, double u, double g){
        name = n;
        imgFileName = i.replace(" ", "_");
        units = u;
        grade = g;
    }
    public String getName() {
        return this.name;
    }
    public String getImgFileName(){
        return this.imgFileName;
    }
    public double getUnits() {
        return this.units;
    }
    public void setUnits(double units) {
        this.units = units;
    }
    public double getGrade() {
        return this.grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Double.compare(subject.units, units) == 0 && Double.compare(subject.grade, grade) == 0 && name.equals(subject.name) && imgFileName.equals(subject.imgFileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imgFileName, units, grade);
    }
}
