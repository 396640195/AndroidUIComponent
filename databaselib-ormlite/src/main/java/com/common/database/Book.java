package com.common.database;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/15.
 */
@DatabaseTable(tableName = "tb_student_sample")//表名统一以 "tb_"开头
public class Book {

    //先统一用静态内部类 定义表的字段
    public static class BookTableFiled{
        public static final String COLUMN_BOOK_ID ="_id";
        public static final String COLUMN_BOOK_NAME ="_bookName";
        public static final String COLUMN_BOOK_WEIGHT ="_bookWeight";
        public static final String COLUMN_BOOK_DATE= "_date";
    }

    /**注: 数据库的字段统一以 "_"开头，以免与数据库中欲留字段冲突;**/

    /**字符类型-书的名字**/
    @DatabaseField(columnName = BookTableFiled.COLUMN_BOOK_NAME, defaultValue = "cwx354587")
    private String bookName;

    /**Integer类型-重量**/
    @DatabaseField(columnName =BookTableFiled.COLUMN_BOOK_WEIGHT, defaultValue = "10")
    private int bookWeight;

    /**时间类型-生产日期**/
    @DatabaseField(columnName = BookTableFiled.COLUMN_BOOK_DATE,dataType= DataType.DATE_STRING )
    private Date date;

    /**定义表的主键,自动创建id**/
    @DatabaseField(columnName = BookTableFiled.COLUMN_BOOK_ID , generatedId = true)
    private int id;

    /**
     * 这里的student 与 Student中定义的 ForeignCollection<Book> books　要配对;
     * 定义当前这本书是哪位学生的.
     * foreign = true:说明这是一个外部引用关系
     * foreignAutoRefresh = true：当对象被查询时，外部属性自动刷新（暂时我也没看懂其作用）
     */
    @DatabaseField(foreign = true,foreignAutoRefresh = true)
    private Student student;

    //////////////////------------getter()/setter()- alt+inster自动生成 getter/setter;
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookWeight(int bookWeight) {
        this.bookWeight = bookWeight;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {

        return bookName;
    }

    public int getBookWeight() {
        return bookWeight;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {

        return student;
    }
}
