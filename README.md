# 学生管理系统 — 项目文档

> 一个 Java 命令行学生管理系统  
> 开发语言：Java  
> 开发环境：IntelliJ IDEA

---

## 一、项目概述

命令行交互的学生管理系统，用 ArrayList 存储数据，实现学生的增删改查、排序和输入校验功能。

适合 Java 初学者练习：类与对象、集合框架、循环、条件判断、Scanner 输入。

---

## 二、项目结构

`
Student/
├── src/
│   ├── App.java              # 入口，启动程序
│   ├── StudentManager.java   # 菜单循环 + 用户交互
│   ├── Function.java         # 七个功能 + 校验方法
│   └── Student.java          # 学生类定义
└── README.md                 # 项目文档
`

---

## 三、各文件说明

### 1. App.java — 入口

只做一件事：创建 StudentManager 对象，调用 display() 启动菜单。

`java
public static void main(String[] args) {
    StudentManager sm = new StudentManager();
    sm.display();
}
`

### 2. StudentManager.java — 菜单管理

用 while(true) 循环反复显示菜单，switch 读用户输入调用对应方法，每次执行完打印一个空行方便看。

| 输入 | 执行 |
|------|------|
| 1 | function.addStudent() |
| 2 | function.displayStudent() |
| 3 | function.lookStudent() |
| 4 | function.setStudents() |
| 5 | function.delStudents() |
| 6 | function.sortStudents() |
| 7 | 打印"感谢使用" → return 结束 |

### 3. Student.java — 学生类

| 属性 | 类型 | 说明 |
|------|------|------|
| number | String | 学号 |
| name | String | 姓名 |
| age | int | 年龄 |
| score | double | 成绩 |

包含：空参构造、全参构造、getter/setter、toString()。

### 4. Function.java — 功能实现

数据存在 ArrayList<Student> students 里。

| 方法 | 功能 |
|------|------|
| addStudent() | 添加学生（含输入校验） |
| displayStudent() | 查看所有学生 |
| lookStudent() | 按学号查找 |
| setStudents() | 修改成绩 |
| delStudents() | 删除学生 |
| sortStudents() | 按成绩排序 |
| checkNumber() | 判断学号是否重复（被 addStudent 调用） |

---

## 四、七个功能详解

### 1. 添加学生

`
输入：学号、姓名、年龄、成绩
校验：学号不能重复（调 checkNumber 判断）
      年龄不能为负数
      成绩必须在 0-100 之间
      不满足条件就重新输入
`

校验失败会提示并循环直到输入正确。

### 2. 查看所有学生

`
逻辑：for-each 遍历 ArrayList，调 toString() 打印
输出格式：学号  姓名  年龄  成绩
`

### 3. 按学号查找

`
输入：学号
逻辑：遍历列表用 equals() 比对，找到就打印
      找不到就提示"学号不存在，查询失败"
`

### 4. 修改成绩

`
输入：学号 + 新成绩
逻辑：遍历列表匹配学号 → setScore(新成绩)
`

### 5. 删除学生

`
输入：学号
逻辑：遍历列表匹配学号 → ArrayList.remove(i)
`

### 6. 按成绩排序

`
逻辑：复制一个新列表 students1
      对新列表做冒泡排序（从高到低）
      打印排序结果
特点：不影响原列表的数据顺序
`

### 7. 退出

`
打印"感谢使用" → return 结束
`

---

## 五、校验逻辑

| 输入 | 规则 | 提示 |
|------|------|------|
| 学号 | 不能和已存在的学号重复 | "学号重复，请重新输入" |
| 年龄 | 不能为负数 | "年龄为负数请重新输入" |
| 成绩 | 0-100 之间 | "成绩超出范围，请重新输入" |

所有校验都在 while(true) 循环里，输入正确才跳出。

---

## 六、运行方式

### 方式一：IntelliJ IDEA

打开 D:\Dev\Java\Student 项目 → 找到 App.java → 右键 Run

### 方式二：命令行

`ash
cd D:\Dev\Java\Student\src
javac *.java
java App
`

---

## 七、版本对比

| 版本 | 变化 |
|------|------|
| v1 | 基础七功能，无校验 |
| v2（当前） | 加学号重复检查、年龄/成绩校验、查找失败提示 |

---

## 八、可以继续改进

- **修改/删除时找不学号**：现在没有提示，可以加 flag 标记
- **数据持久化**：关程序数据就没了，可以用文件或数据库存
- **界面美化**：纯文字，可以加颜色或者用表格对齐
