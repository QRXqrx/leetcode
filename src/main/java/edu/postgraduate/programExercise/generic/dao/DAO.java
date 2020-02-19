package edu.postgraduate.programExercise.generic.dao;

import java.util.List;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-19
 *
 * 泛型的使用实例
 * DAO: Data(Base) Access Object 数据访问层
 *
 */
public class DAO<T> { // 表的共性操作 - 增删改查

    // 增
    public void add(T t){

    }
    // 删
    public boolean remove(int index) {
        return false;
    }
    // 改
    public boolean update(int index, T t) {
        return false;
    }
    // 查
    public List<T> search(int index) {
        return null;
    }

    // 特殊定制方法:获取表中有多少条数据？获取最大生日？获取最大收入？
    public <E> E getValue() {
        return null;
    }
}
