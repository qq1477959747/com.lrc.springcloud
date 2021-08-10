package springcloud.dao;

import com.lrc.hystrix.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @USER luo
 * @Date 2021/7/30 22:52
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    int updateById(Payment payment);
}
