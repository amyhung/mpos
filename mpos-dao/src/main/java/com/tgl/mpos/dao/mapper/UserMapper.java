package com.tgl.mpos.dao.mapper;

import java.util.List;

import com.tgl.mpos.dao.model.UserEntity;

public interface UserMapper {

	List<UserEntity> getAll();

	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}
