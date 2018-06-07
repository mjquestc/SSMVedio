package com.itmayiedu.dao;

import java.util.List;

import com.itmayiedu.entity.VideoType;

public interface VideoTypeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(VideoType record);

	int insertSelective(VideoType record);

	VideoType selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(VideoType record);

	int updateByPrimaryKey(VideoType record);

	List<VideoType> selectList(VideoType record);
}