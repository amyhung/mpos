package com.tgl.mpos.dao.jdbc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tgl.mpos.dao.jdbc.UsersDao;
import com.tgl.mpos.dao.model.UserEntity;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserEntity getUser(int id) {
		return jdbcTemplate.queryForObject("select * from users where id = ?", new Object[] { id }, new BeanPropertyRowMapper<UserEntity>(UserEntity.class));
	}

}
