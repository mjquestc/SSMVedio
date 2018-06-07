
package com.itmayiedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itmayiedu.dao.VideoTypeMapper;
import com.itmayiedu.entity.VideoType;
import com.itmayiedu.service.VideoTypeService;

@Service
public class VideoTypeServiceImpl implements VideoTypeService {
	@Autowired
	private VideoTypeMapper videoTypeMapper;

	public List<VideoType> showVideoType(VideoType record) {
		return videoTypeMapper.selectList(record);
	}
}
