# 学生管理系统 — 项目文档

> 一个 Java 命令行学生管理系统
> 开发语言：Java
> 开发环境：IntelliJ IDEA

---

## 一、项目概述

命令行交互的学生管理系统，用 ArrayList 存储数据，实现增删改查、排序、输入校验、学号查重功能。

适合 Java 初学者练习：类与对象、集合框架、循环、条件判断、Scanner 输入。

---

## 二、项目结构

```
Student/
├── src/
│   ├── App.java              # 入口
│   ├── StudentManager.java   # 菜单循环
│   ├── Function.java         # 七功能 + 校验
│   └── Student.java          # 学生类
├── push-to-github.bat
└── README.md                 # 项目文档
```

---

## 三、文件说明

### App.java — 入口

```java
public static void main(String[] args) {
    StudentManager sm = new StudentManager();
    sm.display();
}
```

### StudentManager.java — 菜单管理

`while(true)` 循环显示菜单，`switch` 读取输入调用 Function 里的对应方法。每次执行完打印一个空行。

| 输入 | 执行 |
|------|------|
| 1 | addStudent() |
| 2 | displayStudent() |
| 3 | lookStudent() |
| 4 | setStudents() |
| 5 | delStudents() |
| 6 | sortStudents() |
| 7 | 退出 |

### Student.java — 学生类

| 属性 | 类型 |
|------|------|
| number | String |
| name | String |
| age | int |
| score | double |

### Function.java — 功能实现

| 方法 | 功能 |
|------|------|
| addStudent() | 添加学生（含校验） |
| displayStudent() | 查看所有学生 |
| lookStudent() | 按学号查找 |
| setStudents() | 修改成绩 |
| delStudents() | 删除学生 |
| sortStudents() | 按成绩排序 |
| checkNumber() | 判断学号重复 |

---

## 四、七个功能详解

### 1. 添加学生

输入学号、姓名、年龄、成绩。校验规则：
- 学号不能重复（调 checkNumber()）
- 年龄不能为负数
- 成绩必须在 0-100

每项校验在 `while(true)` 里，输入正确才跳出。

### 2. 查看所有学生

遍历 ArrayList，打印所有学生。格式：学号 + 姓名 + 年龄 + 成绩。

### 3. 按学号查找

输入学号，遍历列表查找。找到则打印，找不到提示"查询失败，请重新输入"并继续循环。

### 4. 修改成绩

输入学号，找到对应学生后输入新成绩。学号不存在时无提示。

### 5. 删除学生

输入学号，找到对应学生后删除。学号不存在时无提示。

### 6. 按成绩排序

复制新列表，做冒泡排序（从高到低），打印结果。不影响原数据顺序。

### 7. 退出

打印"感谢使用，再见！"后结束程序。

---

## 五、运行方式

### IntelliJ IDEA

打开项目 → `src/App.java` → 右键 Run

### 命令行

```bash
cd D:\Dev\Java\Student\src
javac *.java
java App
```

---

## 六、已知缺陷

- 修改/删除时学号不存在 → 无提示
- 数据不持久化 → 关程序数据丢失
- 无空输入校验 → 按 Enter 可能跳过

---

## 七、可改进方向

- 修改/删除时学号不存在加提示
- 数据持久化（文件 / SQLite）
- UI 美化（颜色 / 对齐）
