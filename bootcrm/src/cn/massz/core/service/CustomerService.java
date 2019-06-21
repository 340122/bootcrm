package cn.massz.core.service;

import cn.massz.common.utils.Page;
import cn.massz.core.po.BaseDict;
import cn.massz.core.po.Customer;

import java.util.List;

/**
 * 数据字典Service接口
 */
public interface CustomerService {
    //根据客户列表
    Page<Customer> findCustomerList(Integer page,Integer rows,String custName,String custSource,String custIndustry,String custLevel);
    //创建客户
    Integer createCustomer(Customer customer);

    Customer getCustomerById(Integer id);

    Integer updateCustomer(Customer customer);

    Integer customerDelete(Integer id);
}
