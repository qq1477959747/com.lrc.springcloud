package springcloud.service.impl;

import com.lrc.hystrix.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

/**
 * @USER luo
 * @Date 2021/7/30 22:51
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Payment updateById(Payment payment) {
        if (null != payment.getId()) {
            Payment oldPayment = this.getPaymentById(payment.getId());
            if (null != oldPayment) {
                paymentDao.updateById(payment);
                return payment;
            }
        }
        return null;
    }


}
