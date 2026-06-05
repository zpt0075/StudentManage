public class Student {
    //学生信息
    private  String number;//学号
    private String name ;//姓名
    private int age;//年龄
    private double score;//成绩

    public Student() {
    }

    public Student(String number, String name, int age, double score) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public String toString(){
        return number+"\t"+name+"\t"+age+"\t"+score;
    }


}
