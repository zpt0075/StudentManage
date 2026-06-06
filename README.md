# 学生管理系统 — 项目文档

> 一个 Java 命令行学生管理系统
> 开发语言：Java
> 开发环境：IntelliJ IDEA

---

## 一、功能列表

```
1. 添加学生
2. 查看所有学生
3. 按学号查找学生
4. 修改学生成绩
5. 删除学生
6. 按成绩从高到低排序
7. 退出
```

---

## 二、项目结构

```
Student/
├── src/
│   ├── App.java              # 入口
│   ├── StudentManager.java   # 菜单循环
│   ├── Function.java         # 七功能 + 校验
│   ├── LocalData.java        # 数据持久化（工具类）
│   └── Student.java          # 学生类（可序列化）
├── student.data              # 数据文件（自动生成）
└── README.md
```

---

## 三、数据持久化

数据存在 `student.data` 文件中，通过 `LocalData` 工具类存取。

- loadData() 返回 ArrayList，启动时赋值给 students
- saveData(students) 接收 ArrayList 参数，写入文件
- LocalData 不继承任何类，只做数据读写

| 操作 | 触发 |
|------|------|
| 启动程序 | localData.loadData() → 返回数据 → 赋值给 students |
| 添加学生 | localData.saveData(students) |
| 修改成绩 | localData.saveData(students) |
| 删除学生 | localData.saveData(students) |

---

## 四、输入校验

| 输入 | 规则 |
|------|------|
| 学号 | 不能重复（checkNumber() 判断）|
| 年龄 | 不能为负数 |
| 成绩 | 0-100 之间 |

校验失败会提示并循环，直到输入正确。

---

## 五、文件说明

### App.java
入口，创建 StudentManager 并启动。

### StudentManager.java
循环显示菜单，`switch` 根据输入调用对应方法，输入 7 退出。

### Student.java
`implements Serializable`，含学号/姓名/年龄/成绩四个属性。

### Function.java
七功能 + 校验 + 学号查重。构造方法中调 localData.loadData()。

### LocalData.java
数据读写工具类。`saveData(students)` 存，`loadData()` 读并返回列表。

---

## 六、运行方式

### IntelliJ IDEA

打开项目 → src/App.java → 右键 Run

### 命令行

```bash
cd D:\Dev\Java\Student\src
javac -encoding utf-8 *.java
java App
```

---

## 七、已知缺陷

- 修改/删除时学号不存在无提示
- 无空输入校验
- 查找时没有输入提示