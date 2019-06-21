package cn.massz.core.dao;

import cn.massz.core.po.BaseDict;

import java.util.List;

/**
 * 数据字典接口
 */
public interface BaseDictDao {
    //根据类别代码查询数据字典
    List<BaseDict> selectBaseDictByTypeCode(String typecode);
}
