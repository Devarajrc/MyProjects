package com.demoAPI.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.service.RestURLS;
import com.demoAPI.rest.service.UserRegisterService;

@Controller
@RequestMapping(RestURLS.DEMO_REST_CONTEXT)

public class UserRegisterController {

	
	
	
	
	
	
	
	
	
	
	
	private static final Logger logger = Logger.getLogger(UserRegisterController.class);
	
	@Autowired
	UserRegisterService registrationService;
	
	@RequestMapping(value = RestURLS.DEMO_REST_REGISTERUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getUserReg(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUserReg**************");
		return registrationService.getUserRegist(userReg);
	}
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGIN, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getLogin(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getLogin**************");
		return registrationService.getLogin(userReg);
	}
	
	@RequestMapping(value = RestURLS.DEMO_REST_GETUSERS, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO getUsersList(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.getUsersList**************");
		return registrationService.getUsersList(userReg); 
	}
	
	@RequestMapping(value = RestURLS.DEMO_REST_MODIFYUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO modifyUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.modifyUser**************");
		return registrationService.modifyUser(userReg);	
	}
	
	@RequestMapping(value = RestURLS.DEMO_REST_DELETEUSER, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO deleteUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.deleteUser**************");
		return registrationService.deleteUser(userReg);
	}
	
	@RequestMapping(value = RestURLS.DEMO_REST_LOGOUT, method = RequestMethod.POST)
	public @ResponseBody ResponseDTO logoutUser(@RequestBody RequestDTO userReg) {
		logger.info("******UserRegistrationController.logoutUser**************");
		return registrationService.logoutUser(userReg);
	}
}
