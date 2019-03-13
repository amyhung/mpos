package com.tgl.mpos.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.tgl.mpos.dao.model.CodeItemDef;

public interface CodeItemDefMapper {
	
	//@Select("select * from code_item_def where item_code =#{code}")
	CodeItemDef getByCode(@Param("code") String code);

}
