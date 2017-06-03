package com.common.database.db.dao;

import android.content.Context;

import com.huawei.ormlite.sample.Book;
import com.huawei.ormlite.sample.db.dao.base.AbstractDataProvider;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/4/16.
 */

public class BookProvider extends AbstractDataProvider<Book> {
    public BookProvider(Context context) {
        super(context);
        try {
            mDao = mDatabaseOpenHelper.getDao(Book.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
