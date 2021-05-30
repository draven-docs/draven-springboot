package pulsar.plus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pulsar.plus.entity.TOrder0;
import pulsar.plus.mapper.TOrder0Mapper;
import pulsar.plus.service.TOrder0Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author draven
 * @since 2021-05-29
 */
@Service
@DS("mysql0")
public class TOrder0ServiceImpl extends ServiceImpl<TOrder0Mapper, TOrder0> implements TOrder0Service {

}
