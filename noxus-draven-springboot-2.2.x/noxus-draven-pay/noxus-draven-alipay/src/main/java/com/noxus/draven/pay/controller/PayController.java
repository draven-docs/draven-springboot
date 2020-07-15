package com.noxus.draven.pay.controller;

import com.alipay.api.AlipayApiException;
import com.noxus.draven.pay.config.AlipayTemplate;
import com.noxus.draven.pay.dovo.PayAsyncVo;
import com.noxus.draven.pay.dovo.PayVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiangli
 * @since 2020/2/1 12:28
 */
@RestController
@RequestMapping("pay")
public class PayController {
//	@Autowired
//	private AmqpTemplate amqpTemplate;

    @Autowired
    private AlipayTemplate alipayTemplate;

    /**
     * 支付宝支付回调
     */
    @PostMapping("alipay_callback")
    public void alipayCallback(PayAsyncVo payAsyncVo) {
        System.out.println("回掉成功");

        if ("TRADE_SUCCESS".equals(payAsyncVo.getTrade_status())) {
            System.out.println("回掉成功");
            // 发送消息,更新订单状态
            //amqpTemplate.convertSendAndReceive("GMALL-ORDER-EXCHANGE", "pay.success", payAsyncVo.getOut_trade_no());
        }
    }


    /**
     * 支付宝支付
     */
    @GetMapping("alipay_pay")
    public Object payAlipay() {
        PayVo payVo = new PayVo();
        payVo.setBody("这手机不错");
        String pay = "";
        try {
            pay = alipayTemplate.pay(payVo);
        } catch (AlipayApiException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return pay;
    }


}
