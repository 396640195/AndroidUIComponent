package com.common.database;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/4/15.
 */
@DatabaseTable(tableName = "tb_user_sample")//表名统一以 "tb_"开头
public class Student {

    //先统一用静态内部类 定义表的字段
    public static class StuTableFiled{
        public static final String COLUMN_ST_ID ="_id";
        public static final String COLUMN_ST_NAME ="_stuName";
        public static final String COLUMN_ST_AGE ="_stuAge";
        public static final String COLUMN_ST_ADDR = "_stuAddr";
    }

    /**注: 数据库的字段统一以 "_"开头，以免与数据库中欲留字段冲突;**/
    @DatabaseField(columnName = StuTableFiled.COLUMN_ST_NAME, defaultValue = "cwx354587")
    private String name;

    /**Integer类型-年纪**/
    @DatabaseField(columnName = StuTableFiled.COLUMN_ST_AGE, defaultValue = "10")
    private int age;

    /**String类型-地址**/
    @DatabaseField(columnName = StuTableFiled.COLUMN_ST_ADDR,defaultValue = "")
    private String addr;

    /**定义表的主键,自动创建id**/
    @DatabaseField( columnName= StuTableFiled.COLUMN_ST_ID,generatedId = true)
    private int id;

    /**
     * OneToMany 一对多关联关系设计: 一个学生对多本书
     * 这里需要注意的是：属性类型只能是ForeignCollection<T>或者Collection<T>
     * 如果需要懒加载（延迟加载）可以在@ForeignCollectionField加上参数 eager=false
     *
     * orderColumnName:The name of the column in the foreign object that we should order the collection by.
     * maxEagerLevel:层级１，层级太多，查询会很慢;
     * **/
    @ForeignCollectionField(eager = true,orderColumnName = "_bookName",orderAscending = true , maxEagerLevel = 1)
    private ForeignCollection<Book> books;


    /**
     * OneToOne:一对一关系设计
     * 该学生的女朋友或男朋友：情侣
     * */
    @DatabaseField(foreign = true)
    Student lovers;

    public String getName() {
        return name;
    }

    //////////////////------------getter()/setter()- alt+inster自动生成 getter/setter;
    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }

    public int getId() {
        return id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ForeignCollection<Book> getBooks() {
        return books;
    }

    public void setBooks(ForeignCollection<Book> books) {
        this.books = books;
    }

    public Student getLovers() {
        return lovers;
    }

    public void setLovers(Student lovers) {
        this.lovers = lovers;
    }
}
