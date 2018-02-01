package com.hexin.practice.chapter2.service;

import com.hexin.practice.chapter2.helper.DatabaseHelper;
import com.hexin.practice.chapter2.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * created on 2018/1/30
 *
 * @author hexin
 */
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
            //在sql中使用*是不对的，简化起见
            String sql = "SELECT * FROM customer";
            List<Customer> customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
//            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery();
//            List<Customer> customerList = new ArrayList<>();
//            while (rs.next()) {
//                Customer customer = new Customer();
//                customer.setId(rs.getLong("id"));
//                customer.setName(rs.getString("name"));
//                customer.setContact(rs.getString("contact"));
//                customer.setTelephone(rs.getString("telephone"));
//                customer.setEmail(rs.getString("email"));
//                customer.setRemark(rs.getString("remark"));
//                customerList.add(customer);
//            }
            return customerList;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id) {
        String sql = "SELECT * FROM customer WHERE id=?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
