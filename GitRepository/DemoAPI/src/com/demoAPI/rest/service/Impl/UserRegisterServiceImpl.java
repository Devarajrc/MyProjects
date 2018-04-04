package com.demoAPI.rest.service.Impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demoAPI.rest.entity.UserEntity;
import com.demoAPI.rest.dao.UserRegisterDAO;
import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.service.UserRegisterService;
import com.demoAPI.rest.util.Helper;
import com.itextpdf.text.log.SysoCounter;



@Service()
@Transactional(readOnly = false,value="transactionManager", rollbackFor=Exception.class)
public class UserRegisterServiceImpl implements UserRegisterService{

	private static final Logger logger = Logger.getLogger(UserRegisterServiceImpl.class);
	@Autowired
	Helper heapler;
	@Autowired
	UserRegisterDAO userRegisterDao;
	
	@Override
	public ResponseDTO getUserRegist(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUserReg**************");
		ResponseDTO userRegRes = new ResponseDTO();
		System.out.println("Server: "+userReg.getFname());
	
		if(!userReg.getMobileNo().isEmpty() && userReg.getMobileNo()!= null){
			boolean result = userRegisterDao.checkMobileNo(userReg);
			if(result){
				//userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("This Mobile Number Already Registered with DEMOAPI");
			}else{
			//heapler.sendEmail(userReg.getEmailId(), userReg.getName());
			userRegRes=userRegisterDao.saveUserreg(userReg);
			}
		}else{ 	
			//userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("You are not entered Mobile No");
		}
		return userRegRes;
	}

	@Override
	public ResponseDTO getLogin(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		ResponseDTO userRegRes = new ResponseDTO();
		boolean result = userRegisterDao.checkMobileNo(userReg);
		if(result){
		String pwd= userRegisterDao.getpwd(userReg);
		System.out.println(": "+pwd);
		System.out.println(": "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getMobileNo()));
			if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getMobileNo()))){	
				userRegisterDao.updateLoginStatusY(userReg);
				//userRegRes.setReturnCode(0);
				userRegRes.setMessageReturn("Login successfully");
			}else{
				//userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("Invalid MobileNo/Password");
			}
		}else{
			//userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("Invalid MobileNo/Password");
		}
		return userRegRes;
	}
	
	@Override
	public ResponseDTO getUsersList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		ResponseDTO response=new ResponseDTO();
		List<UserEntity> userList= userRegisterDao.getUserList(userReg);
		if(userList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
		//response.setReturnCode(0);
	//	response.setUserEntity(userList);
		}
		return response;
	}

	@Override
	public ResponseDTO modifyUser(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.modifyUser**************");
		ResponseDTO response=new ResponseDTO();
		boolean result = userRegisterDao.modifyUser(userReg);
		if(result){
			//response.setReturnCode(0);
			response.setMessageReturn("User emailId modified successfully");
		}else{
			//response.setReturnCode(0);
			response.setMessageReturn("No user found for particular MobileNo");
		}
		return response;
	}

	@Override
	public ResponseDTO deleteUser(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.deleteUser**************");
		ResponseDTO response=new ResponseDTO();
		UserEntity user=new UserEntity();
		boolean result = userRegisterDao.checkMobileNo(userReg);
		if(result){
			userRegisterDao.deleteUser(userReg);
			//response.setReturnCode(0);
			response.setMessageReturn(user.getName()+" user deleted successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("No user found for particular MobileNo");
		}
		return response;
	}

	@Override
	public ResponseDTO logoutUser(RequestDTO userReg) {
		logger.info("******UserRegisterServiceImpl.logoutUser**************");
		// TODO Auto-generated method stub
		ResponseDTO response=new ResponseDTO();
		boolean result = userRegisterDao.checkMobileNo(userReg);
		if(result){
			userRegisterDao.updateLoginStatusN(userReg);
			//response.setReturnCode(0);
			response.setMessageReturn("Logout successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("Something went wrong");
		}
		return response;
	}
}
