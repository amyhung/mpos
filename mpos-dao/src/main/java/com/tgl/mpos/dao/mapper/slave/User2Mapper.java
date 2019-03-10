package com.tgl.mpos.dao.mapper.slave;

import java.util.List;

import com.tgl.mpos.dao.entities.UserEntity;

public interface User2Mapper {

	List<UserEntity> getAll();

	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);

}
