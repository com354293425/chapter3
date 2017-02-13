package org.smart4j.framework.controller;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.bean.Customer;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {
    @Inject
    private CustomerService customerService;

    /**
     * 进入客户列表界面
     */
    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    /**
     * 显示客户信息
     */
    @Action("get:/customer_show")
    public View show(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_show.jsp").addModel("customer", customer);
    }

    /**
     * 进入创建客户界面
     */
    @Action("get:customer_create")
    public View create(Param param) {
        return new View("customer_create.jsp");
    }

    /**
     * 处理创建客户请求
     */
    @Action("post:/customer_create")
    public Data create_Submit(Param param) {
        Map<String, Object> fieldMap=param.getMap();
        boolean result =customerService.createCustomer(fieldMap);
        return new Data(result);
    }

    /**
     * 编辑客户界面
     */
    @Action("get:/customer_edit")
    public View edit(Param param) {
        long id=param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        return new View("customer_edit.jsp").addModel("customer", customer);
    }

    /**
     * 处理编辑客户请求
     */
    @Action("put:/customer_edit")
    public Data editSubmit(Param param) {
        long id = param.getLong("id");
        Map<String, Object> fieldMap = param.getMap();
        boolean result = customerService.updateCustomer(id, fieldMap);
        return new Data(result);
    }

    /**
     * 处理删除客户请求
     */
    @Action("delete:/customer_edit")
    public Data delete(Param param) {
        Long id = param.getLong("id");
        boolean result = customerService.deleteCustomer(id);
        return new Data(result);
    }
}
