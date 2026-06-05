import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

    Scanner sc = new Scanner(System.in);

    //显示界面
    public void display() {
        Function function = new Function();
        while (true) {
            System.out.println(
                    "===== 学生管理系统 =====\n" +
                            "1. 添加学生\n" +
                            "2. 查看所有学生\n" +
                            "3. 按学号查找学生\n" +
                            "4. 修改学生成绩\n" +
                            "5. 删除学生\n" +
                            "6. 按成绩从高到低排序\n" +
                            "7. 退出\n" +
                            "========================");


            switch (sc.nextLine()) {
                case "1" -> {
                    function.addStudent();
                }
                case "2" -> {
                    function.displayStudent();
                }
                case "3" -> {
                    function.lookStudent();
                }
                case "4" -> {
                    function.setStudents();
                }
                case "5" -> {
                    function.delStudents();
                }
                case "6" -> {
                    function.sortStudents();
                }
                case "7" -> {
                    System.out.println("感谢使用，再见！");
                    return;
                }
            }
            System.out.println(" ");
        }
    }
}
