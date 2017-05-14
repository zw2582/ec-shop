package com.example.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.example.models.UserInfo;

@Service
public class UserService {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public List<UserInfo> query() {
		String sql = "select * from user";
		
		List<UserInfo>	userinfos = jdbctemplate.query(sql, new RowMapper<UserInfo>() {

				public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
					UserInfo user = new UserInfo();
					user.setId(resultSet.getInt("id"));	
					user.setName(resultSet.getString("name"));	
					user.setSex(resultSet.getString("id"));	
					user.setCreate_time(resultSet.getString("create_time"));	
					user.setUpdate_time(resultSet.getString("update_time"));
					user.setStatus(resultSet.getInt("status"));
					return user;
				}	
			});
		
		return userinfos;
	}

}
