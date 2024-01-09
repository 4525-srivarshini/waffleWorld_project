package com.waffleWorld.dao;

import javax.servlet.http.HttpServletRequest;

public interface Authentication {
	public int registerUser(HttpServletRequest httpServletRequest);

	public String loginUser(HttpServletRequest httpServletRequest);
}
