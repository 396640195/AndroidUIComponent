package com.common.database.db.dao;

import android.content.Context;

import com.huawei.ormlite.sample.Student;
import com.huawei.ormlite.sample.db.dao.base.AbstractDataProvider;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/4/16.
 */

public class StudentProvider extends AbstractDataProvider<Student> {
    public StudentProvider(Context context) {
        super(context);
        try {
            mDao = mDatabaseOpenHelper.getDao(Student.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
