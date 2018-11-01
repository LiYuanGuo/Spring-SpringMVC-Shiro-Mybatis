package com.system.util.generate;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @title MyMapper.java
 * @author liyuanguo
 * @description 继承自己的MyMapper
 * @version V1.0
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
