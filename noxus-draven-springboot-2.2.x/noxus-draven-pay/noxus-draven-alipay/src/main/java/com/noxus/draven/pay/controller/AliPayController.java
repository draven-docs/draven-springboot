package com.noxus.draven.pay.controller;

import cn.dm.common.Constants;
import cn.dm.service.DmTradeService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.noxus.draven.pay.config.AliPayConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping("/api/alipay")
public class AliPayController {
    @Resource
    private AliPayConfig aliPayConfig;

    @Resource
    private DmTradeService dmTradeService;

    /**
     * 向支付宝发起统一下单的请求
     * @param WIDout_trade_no
     * @param WIDtotal_amount
     * @param WIDsubject
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/pay", method = RequestMethod.POST)
    public void pay(
            @RequestParam String WIDout_trade_no,
            @RequestParam String WIDtotal_amount,
            @RequestParam String WIDsubject,
            HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                aliPayConfig.getUrl(),
                aliPayConfig.getAppId(),
                aliPayConfig.getAppPrivateKey(),
                "json",
                aliPayConfig.getCharSet(),
                aliPayConfig.getAlipayPublicKey(),
                aliPayConfig.getSignType());

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(aliPayConfig.getReturnUrl());
        alipayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        // form表单生产
        String form = "";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
            response.setContentType("text/html;charset=" + aliPayConfig.getCharSet());
            response.getWriter().write(form);//直接将完整的表单html输出到页面
            response.getWriter().flush();
            response.getWriter().close();
        } catch (AlipayApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 接收异步通知结果
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    public void tradePayment(HttpServletRequest request,
                             HttpServletResponse response) throws Exception{
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String, String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(
                params,
                aliPayConfig.getAlipayPublicKey(),
                aliPayConfig.getCharSet(),
                aliPayConfig.getSignType()); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——

	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
        if(signVerified) {//验证成功
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            //进行自身业务的实现
//                1.插入交易记录到数据库
//                2.修改订单状态同时修改订单对应的排期座位的状态
            response.getWriter().write("success");

        }else {//验证失败
            response.getWriter().write("fail");

            //调试用，写文本函数记录程序运行情况是否正常
            //String sWord = AlipaySignature.getSignCheckContentV1(params);
            //AlipayConfig.logResult(sWord);
        }
    }

    /**
     * 同步通知消息接收
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/return", method = RequestMethod.GET)
    public void payCallBack(HttpServletRequest request,
                            HttpServletResponse response) throws Exception{
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params,
                aliPayConfig.getAlipayPublicKey(),
                aliPayConfig.getCharSet(),
                aliPayConfig.getSignType()); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            //进行自身业务的实现
//            1.插入交易记录到数据库
//            2.修改订单状态和排期座位的状态
            if(!dmTradeService.processed(out_trade_no, Constants.PayMethod.ZHIFUBAO)){
                dmTradeService.insertTrade(out_trade_no, trade_no, Constants.PayMethod.ZHIFUBAO);
            }

            System.out.println("进行自身业务处理");
            response.getWriter().write("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
            response.sendRedirect(String.format(aliPayConfig.getPaymentSuccessUrl(), out_trade_no));
        }else {
            response.getWriter().write("验签失败");
            response.sendRedirect(aliPayConfig.getPaymentFailUrl());
        }
    }
}
