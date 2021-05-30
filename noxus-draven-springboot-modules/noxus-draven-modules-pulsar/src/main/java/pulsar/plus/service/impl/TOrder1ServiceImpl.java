package pulsar.plus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pulsar.plus.entity.TOrder1;
import pulsar.plus.mapper.TOrder1Mapper;
import pulsar.plus.service.TOrder1Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author draven
 * @since 2021-05-29
 */
@Service
@DS("mysql1")
public class TOrder1ServiceImpl extends ServiceImpl<TOrder1Mapper, TOrder1> implements TOrder1Service {

}
