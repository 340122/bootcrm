package cn.massz.core.dao;

import cn.massz.core.po.Customer;

import java.util.List;

/**
 * 客户Customer接口
 */
public interface CustomerDao {
    //客户列表
    List<Customer> selectCustomerList(Customer customer);
    //客户数
    Integer selectCustomerListCount(Customer customer);
    //创建客户
    Integer createCustomer(Customer customer);
    //通过id获取客户信息
    Customer getCustomerById(Integer id);
    //更新客户信息
    Integer updateCustomer(Customer customer);
    //删除客户信息
    Integer deleteCustomer(Integer id);
}
