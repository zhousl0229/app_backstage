package com.cop.backge09.service.impl;


import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cop.backge09.model.User;
import com.cop.backge09.util.AddressUtils;
import com.cop.backge09.utils.exception.DaoException;
import com.cop.backge09.utils.exception.ServiceException;
import com.cop.backge09.utils.exception.SystemException;
import com.cop.backge09.utils.orm.hibernate.EntityManager;
import com.cop.backge09.utils.orm.hibernate.HibernateDao;
import com.cop.backge09.utils.orm.hibernate.Parameter;

/**
 * 用户管理  Service层实现类
 * @ClassName: UserServiceImpl
 * @author ty
 * @date 2017-7-19 上午09:45:46
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends EntityManager<User, Integer> {
	
	private HibernateDao<User, Integer> userDao;
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		userDao = new HibernateDao<User, Integer>(sessionFactory, User.class);
	}
	
	@Override
	protected HibernateDao<User, Integer> getEntityDao() {
		return userDao;
	}
	
	/** 
	* <p>Description:登录 </p> 
	* @param loginName  
	* @param password
	* @return
	* @throws DaoException
	* @throws SystemException
	* @throws ServiceException 
	 * @throws IOException 
	*/
	
    public User login(HttpServletRequest re,String loginName, String password) throws DaoException,SystemException,ServiceException {
        Parameter parameter = new Parameter(loginName, password, 0);
        List<User> list = getEntityDao().find(
                "from User u where u.account = :p1 and u.password = :p2 and u.status = :p3", parameter);
        User user = null;
        if(!list.isEmpty())
        {
        	user=list.get(0);
        	user.setLoginCount(user.getLoginCount()+1);
        	user.setLastIp(user.getIp());
        	user.setLastTime(user.getAtTime());
        	user.setAtTime(new Date());
        	String realId="";
			try {
				realId = AddressUtils.getIpAddress(re);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				realId = "unknown";
			}//获得真实IP
        	user.setIp(realId);
        }
        return user;
    }
	/** 
	* <p>Title:根据登录名查找用户 </p> 
	* <p>Description: </p> 
	* @param account
	* @return  User
	*/
	public User getUserByLoginName(String account) {
        Parameter parameter = new Parameter(account);
        List<User> list = userDao.find("from User u where u.account = :p1 ",parameter);
		return list.isEmpty() ? null:list.get(0);
	}
	

}
