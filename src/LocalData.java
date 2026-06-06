import java.io.*;
import java.util.ArrayList;

public class LocalData  {
    //保存数据到本地
    public void saveData(ArrayList<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("student.data")
            );
            oos.writeObject(students); //把整个ArrayList 写成文件
            oos.close();
        }catch (Exception e) {
            System.out.println("保存失败："+e.getMessage());
        }
    }

    //从文件加载数据
    public ArrayList<Student> loadData() {
        File file = new File("student.data");
        if (!file.exists()) {
            return new ArrayList<>(); //没有存档，返回空列表
        }
        try{
            ObjectInputStream ois =new ObjectInputStream(
                    new FileInputStream(file)
            );
            ArrayList<Student> list = (ArrayList<Student>) ois.readObject(); //读回来
            ois.close();
            return list;
        }catch (Exception e) {
            System.out.println("加载失败：" +e.getMessage());
            return new ArrayList<>();
        }
    }
}
