package com.common.database.db.dao.base;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * 最基本通用的增册改查操作接口的定义:
 * 如果下面的接口不满足需求，请在具体实现类中增加接口 或者 联系 cwx453587新增接口;
 */

public  class DataProvider<T> implements IDataProvider<T> {
    protected DatabaseOpenHelper mDatabaseOpenHelper;
    protected Dao<T,Integer> mDao;
    public DataProvider(Context context){
        mDatabaseOpenHelper = DatabaseOpenHelper.getInstance(context);
   }

    public DataProvider initDao(Class clazz){
        try {
            mDao = mDatabaseOpenHelper.getDao(clazz);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public List<T> queryForAll() {
        if(mDao != null){
            try {
              return  mDao.queryForAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean delete(T t) {
        if(mDao != null && t != null){
            try {
               return mDao.delete(t) == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Collection<T> datas) {
        if(mDao != null && datas!= null && datas.size() >0){
            try {
               return mDao.delete(datas) == datas.size();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean deleteIds(Collection<Integer> datas) {
        if(mDao != null && datas != null && datas.size() >0 ){
            try {
                return mDao.deleteIds(datas) == datas.size();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public T findById(int id) {
        if(mDao != null){
            try {
                return  mDao.queryForId(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean insert(T t) {
        if(mDao != null){
            try {
                return  mDao.create(t)== 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void insert(final List<T> list) {
        if(mDao != null && list != null){
            try {
                mDao.callBatchTasks(new Callable<Void>() {
                    public Void call() throws SQLException {
                        for (T t : list) {
                            mDao.create(t);
                        }
                        return null;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean update(T t) {
        if(mDao != null){
            try {
                return  mDao.update(t) == 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<T> queryForEq(String fieldName, Object value) {
        if(mDao != null){
            try {
                return  mDao.queryForEq(fieldName,value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<T> queryForFieldValues(Map<String, Object> fieldValues) {
        if(mDao != null && fieldValues != null && fieldValues.size() > 0){
            try {
                return  mDao.queryForFieldValues(fieldValues);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<T> queryForMatching(T matchObj) {
        if(mDao != null && matchObj != null){
            try {
                return  mDao.queryForMatching(matchObj);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<T> queryForMatchingArgs(T matchObj) {
        if(mDao != null && matchObj != null){
            try {
                return  mDao.queryForMatchingArgs(matchObj);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public long countOf() {
        try {
            if(mDao != null)
            {
                return mDao.countOf();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0l;
    }

    @Override
    public int refresh(T data) {
        try {
            if(mDao != null)
            {
                return mDao.refresh(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    @Override
    public void release() {
        if(mDatabaseOpenHelper != null || mDatabaseOpenHelper.isOpen()){
            mDatabaseOpenHelper.close();
        }
    }
}
