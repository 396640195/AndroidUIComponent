package com.common.database.db.dao.base;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.common.database.Book;
import com.common.database.Student;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/4/16.
 */

public class DatabaseOpenHelper extends OrmLiteSqliteOpenHelper {

    private static DatabaseOpenHelper sDatabaseOpenHelper;

    public synchronized  static DatabaseOpenHelper getInstance(Context context){
            if(sDatabaseOpenHelper == null){
                sDatabaseOpenHelper = new DatabaseOpenHelper(context instanceof Activity ? context.getApplicationContext() : context);
            }
            return  sDatabaseOpenHelper;
    }
    /** 数据库名称**/
    private static final String DATABASE_NAME = "imanager.db";
    /** 数据库版本**/
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource,Book.class);
            TableUtils.createTable(connectionSource, Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            /**
             * 注: 每个版本的数据库表的字段变化，需要升级数据库版本，用户升级后才不会因为数据库报错崩溃;
             */
            /**删掉旧版本的数据**/
            TableUtils.dropTable(connectionSource, Book.class, true);
            TableUtils.dropTable(connectionSource, Student.class, true);
            /**创建一个新的版本**/
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
