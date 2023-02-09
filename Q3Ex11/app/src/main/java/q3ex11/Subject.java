package q3ex11;

class Subject {
    private String name, imgFileName;
    private double units, grade;
	
    public Subject(String n, String i, double u, double g){
        name = n;
        imgFileName = i;
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
}
