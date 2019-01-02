/*
订单管理模块
 */
package edu.bupt.secp;

import edu.bupt.secp.model.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;
import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrdersRepository ordersRepository;

    // 提交订单
    // 给商家发送提醒
    // 返回用户订单号
    @RequestMapping(value = "submit")
    public String submit( @RequestParam Integer restaurant_id,
                          @RequestParam String meaus,
                          @RequestParam String time){
        return "order";
    }

    // 确认收款
    // 将钱从用户转移到商家
    @RequestMapping(value = "confirm")
    public String confirm(){
        return "付款成功";
    }

    // 查询订单，返回订单信息
    @RequestMapping(value = "query")
    public String query(@RequestParam Integer order_id){
        return "订单信息";
    }
}
