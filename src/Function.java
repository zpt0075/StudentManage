import java.util.ArrayList;
import java.util.Scanner;

public class Function {
    Scanner sc = new Scanner(System.in);

    //储存学生数据
    ArrayList<Student> students = new ArrayList<>();

    //System.out.println("1.添加学生");
    public void addStudent() {
        Student student = new Student();
        System.out.println("===== 添加学生 =====");
        while (true) {
            System.out.println("请输入学生学号：");
            String number = sc.next();

            //判断学号是否重复
            boolean flag = checkNumber(number);
            if (!flag) {
                student.setNumber(number);//不重复则录入到列表中
            } else if (flag) {
                System.out.println("学号重复，请重新输入：");
                continue;
            }
            break;
        }


        System.out.println("请输入学生名字：");
        student.setName(sc.next());

        while (true) {
            System.out.println("请输入学生年龄：");
            Integer age = sc.nextInt();
            if (age < 0) {
                System.out.println("年龄为负数请重新输入！！！");
                continue;
            } else {
                student.setAge(age);
            }
            break;
        }

        while (true) {
            System.out.println("请输入学生成绩：");
            Double score = sc.nextDouble();
            if (score < 0 || score > 100) {
                System.out.println(
                        "成绩超出范围，请重新输入！！！"
                );
                continue;
            } else {
                student.setScore(score);
            }
            break;
        }
        System.out.println("===== 添加学生 =====");
        students.add(student);//将学生对象添加到列表当中
    }

    // System.out.println("2.查看所有学生");
    public void displayStudent() {
        System.out.println("===== 查看所有学生 =====");
        System.out.println("学号\t" + "姓名\t" + "年龄\t" + "成绩");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("===== 查看所有学生 =====");
        System.out.println(" ");
    }

    //System.out.println("3.按学号查找学生");
    public void lookStudent() {
            System.out.println("===== 按学号查找学生 =====");
            while (true) {
                boolean flag = false;//学号不存在就false
                System.out.println("请输入学号：");
                String num = sc.next();
                for (int i = 0; i < students.size(); i++) {
                   if (num.equals(students.get(i).getNumber())) {
                    //输入的学号在列表中存在，并且打印出来
                    System.out.println(students.get(i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("查询失败，请重新输入！！！");
                continue;
            }
            break;
        }

        System.out.println("===== 按学号查找学生 =====");
        System.out.println(" ");
    }

    //System.out.println("4.修改学生成绩");
    public void setStudents() {
        System.out.println("===== 修改成绩 =====");
        System.out.println("请输入要修改成绩学生的学号：");
        String num = sc.next();
        for (int i = 0; i < students.size(); i++) {
            if (num.equals(students.get(i).getNumber())) {
                System.out.println("请输入修改后的成绩：");
                students.get(i).setScore(sc.nextInt());
            }
        }
        System.out.println("===== 修改成绩 =====");
        System.out.println(" ");
    }

    //  System.out.println("5.删除学生");
    public void delStudents() {
        System.out.println("===== 删除学生 =====");
        System.out.println("请输入要删除学生的学号：");
        String num = sc.next();
        for (int i = 0; i < students.size(); i++) {
            if (num.equals(students.get(i).getNumber())) {
                students.remove(i);
            }
        }
        System.out.println("===== 删除学生 =====");
        System.out.println(" ");
    }

    //System.out.println("6.按成绩从高到低排序");
    public void sortStudents() {
        ArrayList<Student> students1 = new ArrayList<>();
        students1.addAll(students);
        System.out.println("===== 按成绩从高到低排序 =====");
        for (int i = 0; i < students1.size() - 1; i++) {
            for (int j = 0; j < students1.size() - 1 - i; j++) {
                if (students1.get(j).getScore() < students1.get(j + 1).getScore()) {
                    Student temp = students1.get(j);
                    students1.set(j, students1.get(j + 1));
                    students1.set(j + 1, temp);
                }
            }
        }
        System.out.println("排序成功！");
        System.out.println("学号\t" + "姓名\t" + "年龄\t" + "成绩");
        for (int i = 0; i < students1.size(); i++) {
            System.out.println(students1.get(i));
        }
        System.out.println("===== 按成绩从高到低排序 =====");
        System.out.println(" ");
    }

    //判读学号是否重复
    public boolean checkNumber(String number) {
        boolean flag = false; //学号不存在
        for (int i = 0; i < students.size(); i++) {
            if (number.equals(students.get(i).getNumber())) {
                flag = true; //学号已存在
            }
        }
        return flag;
    }


}
