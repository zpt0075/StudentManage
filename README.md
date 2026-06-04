# 学生管理系统 — 项目文档

> 一个 Java 命令行学生管理系统  
> 开发语言：Java  
> 开发环境：IntelliJ IDEA  
> 作者：自学中

---

## 一、项目概述

命令行交互的学生管理系统，用 ArrayList 存储数据，实现学生的增删改查和排序功能。

适合 Java 初学者练习：类与对象、集合框架、循环、条件判断、Scanner 输入。

---

## 二、项目结构

`
Student/
├── src/
│   ├── App.java              # 入口，启动程序
│   ├── StudentManager.java   # 菜单显示 + 用户交互
│   ├── Function.java         # 七个功能的实现
│   └── Student.java          # 学生类定义
├── README.md                 # 项目文档
└── Student.iml               # IntelliJ 项目文件
`

---

## 三、各文件说明

### 1. App.java — 入口

`
public class App {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.display();
    }
}
`

只做一件事：创建 StudentManager 对象，调用 display() 启动菜单。

### 2. StudentManager.java — 菜单管理

`
public void display()
`

- 用 while(true) 循环显示菜单
- 用 switch 读取用户输入，调用 Function 里的对应方法
- 选 7 退出时 
eturn 结束程序

### 3. Student.java — 学生类

| 属性 | 类型 | 说明 |
|------|------|------|
| number | String | 学号 |
| name | String | 姓名 |
| age | int | 年龄 |
| score | double | 成绩 |

包含：构造方法（空参 + 全参）、getter / setter、toString()

### 4. Function.java — 功能实现

| 方法 | 功能 |
|------|------|
| addStudent() | 添加学生 |
| displayStudent() | 查看所有学生 |
| lookStudent() | 按学号查找 |
| setStudents() | 修改成绩 |
| delStudents() | 删除学生 |
| sortStudents() | 按成绩排序 |

所有数据存在 ArrayList<Student> students 里。  
每个方法内部自己用 Scanner 读用户输入，自己操作 ArrayList。

---

## 四、七个功能详解

### 1. 添加学生

`
输入：学号、姓名、年龄、成绩
逻辑：new Student() → set值 → students.add(对象)
`

### 2. 查看所有学生

`
逻辑：for-each 遍历 ArrayList，调用 toString() 打印
输出格式：学号  姓名  年龄  成绩（制表符对齐）
`

### 3. 按学号查找

`
输入：学号
逻辑：遍历列表，用 equals() 比对学号，匹配就打印
`

### 4. 修改成绩

`
输入：学号 + 新成绩
逻辑：遍历列表，匹配学号 → setScore(新成绩)
`

### 5. 删除学生

`
输入：学号
逻辑：遍历列表，匹配学号 → ArrayList.remove(i)
`

### 6. 按成绩排序

`
逻辑：冒泡排序，按成绩从高到低排
特点：排序在新列表 students1 上进行，不影响原数据
`

### 7. 退出

`
return 直接结束 main 方法
`

---

## 五、运行方式

### 方式一：IntelliJ IDEA

打开项目 → 找到 App.java → 右键 Run

### 方式二：命令行

`ash
cd src
javac *.java
java App
`

---

## 六、可以改进的地方

| 问题 | 现状 | 改进建议 |
|------|------|----------|
| 学号重复 | 添加时没检查 | 加个判断，提示学号已存在 |
| 输入校验 | 没做 | 年龄不能负数、成绩 0-100 限制 |
| 学号不存在 | 修改/删除/查找时没提示 | 加 flag 标记，找不到就提示 |
| 数据持久化 | 关程序就没了 | 用文件存，下次启动自动加载 |
| 界面美观 | 纯文字 | 加分隔线、颜色区分 |

---

## 七、开发过程

按以下顺序分步完成，每一步都能独立测试：

`
1. Student 类 → 2. 菜单循环 → 3. 添加 → 4. 查看
→ 5. 查找 → 6. 修改 → 7. 删除 → 8. 排序
`

---
