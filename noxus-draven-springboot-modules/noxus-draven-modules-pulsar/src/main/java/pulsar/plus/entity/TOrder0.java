package pulsar.plus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author draven
 * @since 2021-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_order_0")
public class TOrder0 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long orderId;

    private Integer userId;

    private String failed;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId(Long orderId) {
        return this.orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId(Integer userId) {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }
}
