package com.xworkz.birthdayMailSchedular.service;

import com.xworkz.birthdayMailSchedular.dto.LoginDTO;

public interface LoginService {

	public boolean generateOTP();
	
	public String genarateRandomOTP();

	public boolean validateAndLogin(LoginDTO dto);

}
