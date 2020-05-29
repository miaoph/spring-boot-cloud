package com.miaoph.cn.mapper;

import com.miaoph.cn.entity.PhUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PhUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-28 17:38:38
 */

public interface PhUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PhUser queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PhUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param phUser 实例对象
     * @return 对象列表
     */
    List<PhUser> queryAll(PhUser phUser);

    /**
     * 新增数据
     *
     * @param phUser 实例对象
     * @return 影响行数
     */
    int insert(PhUser phUser);

    /**
     * 修改数据
     *
     * @param phUser 实例对象
     * @return 影响行数
     */
    int update(PhUser phUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);

}