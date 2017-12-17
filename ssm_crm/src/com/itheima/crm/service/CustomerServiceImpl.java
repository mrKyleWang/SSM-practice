package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * 客户管理
 * 
 * @author wking
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	// 通过条件 查询分页对象
	@Override
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		// 每页数
		page.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			// 判断当前页
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			}
			// 判断条件参数
			if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			}
			if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
				vo.setCustSource(vo.getCustSource().trim());
			}
			if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
				vo.setCustLevel(vo.getCustLevel().trim());
			}

			// 查询并设置总条数
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			// 查询并设置结果集
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;
	}
	
	
	//通过id查询客户
	public Customer selectCustomerById(Integer id) {
		return customerDao.selectCustomerById(id);
	}


	@Override
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}


	@Override
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
		
	}

}
