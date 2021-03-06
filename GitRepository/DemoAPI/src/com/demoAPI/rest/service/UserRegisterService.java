package com.demoAPI.rest.service;

import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;

public interface UserRegisterService  {

	ResponseDTO getUserRegist(RequestDTO userReg);
	ResponseDTO getLogin(RequestDTO userReg);
	ResponseDTO getUsersList(RequestDTO userReg);
	ResponseDTO modifyUser(RequestDTO userReg);
	ResponseDTO deleteUser(RequestDTO userReg);
	ResponseDTO logoutUser(RequestDTO userReg);
}
