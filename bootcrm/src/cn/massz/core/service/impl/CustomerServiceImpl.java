package cn.massz.core.service.impl;

import cn.massz.common.utils.Page;
import cn.massz.core.dao.CustomerDao;
import cn.massz.core.po.Customer;
import cn.massz.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    //注入Dao属性
    @Autowired
    private CustomerDao customerDao;
    //客户列表
    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel) {
        //创建客户对象
        Customer customer = new Customer();
        //判断客户名称
        if (StringUtils.isNoneBlank(custName)){
            customer.setCust_name(custName);
        }
        //判断客户信息来源
        if(StringUtils.isNoneBlank(custSource)){
            customer.setCust_source(custSource);
        }
        //判断客户所属行业
        if(StringUtils.isNoneBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        //判断客户级别
        if (StringUtils.isNoneBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        //当前页
        customer.setStart((page-1) * rows);
        //每页数
        customer.setRows(rows);
        //查询客户列表
        List<Customer> customers = customerDao.selectCustomerList(customer);
        //查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        //创建page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    /**
     * 创建客户
     * @param customer
     * @return
     */
    @Override
    public Integer createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    /**
     * 通过id获取客户信息
     * @param id
     * @return
     */
    @Override
    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    /**
     * 更新客户信息
     * @param customer
     * @return
     */
    @Override
    public Integer updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    /**
     * 删除客户信息
     * @param id
     * @return
     */
    @Override
    public Integer customerDelete(Integer id) {
        return customerDao.deleteCustomer(id);
    }

}
