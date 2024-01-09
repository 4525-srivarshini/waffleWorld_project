package com.waffleWorld.dao;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AuthenticationDaoImpl implements Authentication {

	private JdbcTemplate jdbcTemplate;
	public AuthenticationDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public static final String registerQuery = "INSERT INTO Users  (name, userEmail, phone_number, userPassword, userConfirmPass)\n" +
			"VALUES(?,?,?,?,?)";
	public static final String loginQuery = "SELECT userEmail FROM Users WHERE userEmail=? AND phone_number=?";


	@Override
	public int registerUser(HttpServletRequest httpServletRequest) {
		String name = httpServletRequest.getParameter("name");
		String userEmail = httpServletRequest.getParameter("emailId");
		String phone_number = httpServletRequest.getParameter("mobileNo");
		String userPassword = httpServletRequest.getParameter("password");
		String userConfirmPass = httpServletRequest.getParameter("repassword");
		try {
			int counter = jdbcTemplate.update(registerQuery, name, userEmail, phone_number, userPassword, userConfirmPass);
			return counter;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public String loginUser(HttpServletRequest httpServletRequest) {
		String email_id = httpServletRequest.getParameter("userId");
		String pwd = httpServletRequest.getParameter("password");
		try {
			String userId = jdbcTemplate.queryForObject(loginQuery, new Object[] {email_id, pwd }, String.class);
			return userId;
		} catch (Exception e) {
			return null;
		}
	}
}
