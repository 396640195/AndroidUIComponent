package com.common.database.db.dao.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 最基本通用的增册改查操作接口的定义:
 * 如果下面的接口不满足需求，请在具体实现类中增加接口 或者 联系 cwx453587 新增接口;
 */
public interface IDataProvider<T> {

    /**
     * 查询所有数据数量.
     * Returns the value returned from a SELECT COUNT(*) query which is the number
     * of rows in the table. Depending on the database and the size of the table, this
     * could be expensive.
     * @return
     */
    long countOf();

    /**
     * Query for all of the items in the object table and return a list of them. For
     * medium sized or large tables, this may load a lot of objects into memory so you
     * should consider using the iterator method instead.
     * @return
     */
    List<T> queryForAll();
    /**多字段匹配查询**/
    List<T> queryForFieldValues(Map<String, Object> fieldValues);
    /**
     * 给定对象，根据非空字段进行匹配查询;
     * Any fields in the matching object that are not the default value
     * (null, false, 0, 0.0, etc.) are used as the matching parameters with AND,
     *  If you are worried about SQL quote escaping, you should use queryForMatchingArgs.
     * */
    List<T> queryForMatching(T matchObj);

    /**根据给定对象字段进行匹配查询,注意与上述方法的差别.**/
    List<T> queryForMatchingArgs(T matchObj);

    boolean delete(T t);
    boolean delete(Collection<T> data);
    boolean deleteIds(Collection<Integer> data);

    T findById(int id);

    boolean insert(T t);
    void insert(List<T> list);
    boolean update(T t);
    int refresh(T data);
    /**
     * 查询某个字段等于某个值的所有数据
     * Query for the items in the object table that match a simple where with a single
     * field = value type of WHERE clause. This is a convenience method for calling
     * queryBuilder().where().eq(fieldName, value).query().
     * @param fieldName
     * @param value
     * @return
     */
    List<T> queryForEq(String fieldName, Object value);
}
