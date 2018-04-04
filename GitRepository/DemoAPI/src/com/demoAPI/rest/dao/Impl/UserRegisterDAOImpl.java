package com.demoAPI.rest.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demoAPI.rest.dao.HibernateDao;
import com.demoAPI.rest.dao.UserRegisterDAO;
import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.UserEntity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.demoAPI.rest.util.Helper;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Repository()
public class UserRegisterDAOImpl extends HttpServlet implements UserRegisterDAO{

	
	
	private static final Logger logger = Logger.getLogger(UserRegisterDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	Helper hepler;
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	@RequestMapping("/registerUser")
	public ResponseDTO saveUserreg(RequestDTO userReg) {
		
		HttpServletRequest request=null;
		String fname=request.getParameter("fname");
		String lname=request.getParameter("fname");
		String dob=request.getParameter("fname");
		String address=request.getParameter("fname");
		String emailId=request.getParameter("fname");
		String mobileNo=request.getParameter("fname");
		String pwd=request.getParameter("fname");
		String state=request.getParameter("fname");
		String country=request.getParameter("fname");
		String gender=request.getParameter("fname");
		
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		ResponseDTO response= new ResponseDTO();
		Session session  = sessionFactory.getCurrentSession();
		UserEntity user = new UserEntity();
		Criteria crc = session.createCriteria(UserEntity.class);
		user.setFname(fname);
		user.setLname(lname);
		user.setDob(userReg.getDob());
		user.setAddress(address);
		user.setEmailId(emailId);
		//user.setDob("");
		//user.setName(userReg.getName());
		user.setMobileNo(mobileNo);
		//user.setAddress(userReg.getAddress());
    	user.setPwd(pwd);
		user.setState(state);
		user.setCountry(country);
		
		user.setGender("Male");
		
		user.setDate(new Date());
	//	user.setPwd(hepler.getPasswordEncoded(userReg.getPwd(),userReg.getMobileNo()));
		//user.setLoginStatus("N");
		session.save(user);
		System.out.println("Saved");
		returnMag = "Congratulations!!"+user.getName() +" Registration successfull";
		
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public String getpwd(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getpwd**************");
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
		crc.add(Restrictions.eq("mobileNo",userReg.getMobileNo()))
		.setProjection(Projections.property("pwd"));
		String pwd = (String) crc.uniqueResult();
		return pwd;
	}
	
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkMobileNo(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.checkMobileNo**************");
		// TODO Auto-generated method stub
		Session session  = sessionFactory.getCurrentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
		crc.add(Restrictions.eq("mobileNo",userReg.getMobileNo())).setProjection(Projections.rowCount());
		int count = (int)((long)crc.uniqueResult());
		if(count>0){
			return true;
		}
		return false;
	}

	
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public List<UserEntity> getUserList(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Session session = sessionFactory.getCurrentSession();
		Criteria crc= session.createCriteria(UserEntity.class);
		try{
			userList = crc.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean modifyUser(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.modifyUser**************");
		// TODO Auto-generated method stub
		boolean modifyUser = true;
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));
		UserEntity userUpdate;
		userUpdate =(UserEntity)crit.uniqueResult();
		List list = crit.list();
		if(list.isEmpty()){
			System.out.println("No data found");
			modifyUser = false;
		}
		else{
			Criteria crit1 = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
			crit1.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));	
			UserEntity entity = (UserEntity)crit1.uniqueResult();
		//	entity.setName(userReg.getName());
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
		return modifyUser;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void deleteUser(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.deleteUser**************");
		// TODO Auto-generated method stub
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo", userReg.getMobileNo()));
		UserEntity delentity = (UserEntity)crit.uniqueResult();
		sessionFactory.getCurrentSession().delete(delentity);
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void updateLoginStatusY(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.updateLoginStatus**************");
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));	
		UserEntity entity = (UserEntity)crit.uniqueResult();
		//entity.setLoginStatus("Y");
		//entity.setLastlogin(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void updateLoginStatusN(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.updateLoginStatusN**************");
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));	
		UserEntity entity = (UserEntity)crit.uniqueResult();
	//	entity.setLoginStatus("N");
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
}
