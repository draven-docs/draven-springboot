package com.noxus.draven.plus.mapper;

import com.noxus.draven.plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author draven
 * @since 2020-01-11
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from User where id = 1 ")
    User selectOnes();
}
