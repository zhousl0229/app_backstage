package com.cop.backge09.service.impl;


import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cop.backge09.model.Cpxdaily;
import com.cop.backge09.utils.orm.hibernate.EntityManager;
import com.cop.backge09.utils.orm.hibernate.HibernateDao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Logger;


/** 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author ty 
* @date 2018-4-12 上午10:42:21 
*  
*/
@Service()
@Transactional
public class CpxdailyServiceImpl extends EntityManager<Cpxdaily, Long> {
	
	private HibernateDao<Cpxdaily, Long> cpxdailyDao;
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		cpxdailyDao = new HibernateDao<Cpxdaily, Long>(sessionFactory, Cpxdaily.class);
	}
	
	@Override
	protected HibernateDao<Cpxdaily, Long> getEntityDao() {
		return cpxdailyDao;
	}
	
	public Long count(){
			String sql = "from c_cpxdaily";
		    Long sum=((BigInteger)cpxdailyDao.createSqlQuery("select count(actives) a "+sql, null).uniqueResult()).longValue();//获得总条数
		return sum;
	}
	public BigDecimal sum(){
    	try {
			String sql = "from c_cpxdaily";
			String sum = (String) cpxdailyDao.createSqlQuery("select sum(sales) a " + sql, null).uniqueResult().toString();//金额汇总
			return new BigDecimal(sum);
    	}catch (Exception e){
    		logger.debug("sum=null");
		}
		return new BigDecimal(0);
	}
	


}
