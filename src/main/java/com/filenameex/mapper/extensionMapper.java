package com.filenameex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.filenameex.models.ExtensionVO;
import com.filenameex.models.FileVO;

public interface extensionMapper {

	@Select("select * from extension_tb")
	public List<ExtensionVO> extension_List();

	@Select("select * from extension_tb where type=#{type}")
	public List<ExtensionVO> extension_typeList(ExtensionVO extensionVO);

	@Select("select count(*) c from extension_tb where type=#{type}")
	public int extension_typeCount(ExtensionVO extensionVO);

	@Insert("insert into extension_tb(name,type,status) values(#{name},#{type},'ACTIVE')")
	public int extension_add(ExtensionVO extensionVO);

	@Delete("delete from extension_tb where e_tb_id=#{e_tb_id}")
	public int extension_delete(ExtensionVO extensionVO);

	@Select("select count(*) c from extension_tb where name=#{name}")
	public int extension_name_check(String name);
	
	@Select("select count(*) c from extension_tb where name=#{name} and status='ACTIVE'")
	public int extension_name_check_active(String name); 

	@Update("update extension_tb set status=#{status} where e_tb_id=#{e_tb_id}")
	public int extension_fixed_update(ExtensionVO extensionVO);

	@Insert("insert into files(original_name,file_name,wdate) values(#{original_name},#{file_name},now())")
	public int file_add(FileVO fileVO);
}
