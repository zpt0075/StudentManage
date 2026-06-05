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
│   ├── Function.java         # 七功能 + 校验 + 数据持久化
│   └── Student.java          # 学生类（可序列化）
├── student.data              # 数据文件（自动生成）
├── push-to-github.bat
└── README.md
```

---

## 三、数据持久化

数据存在 `student.data` 文件中，程序启动时自动加载，关闭时不会丢失。

| 操作 | 自动触发 |
|------|---------|
| 启动程序 | loadData() → 读取 student.data |
| 添加学生 | saveData() → 写入文件 |
| 修改成绩 | saveData() → 写入文件 |
| 删除学生 | saveData() → 写入文件 |

---

## 四、输入校验

| 输入 | 规则 |
|------|------|
| 学号 | 不能重复 |
| 年龄 | 不能为负数 |
| 成绩 | 0-100 之间 |

校验失败会提示并循环，直到输入正确。

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

- 修改/删除时学号不存在无提示
- 无空输入校验

