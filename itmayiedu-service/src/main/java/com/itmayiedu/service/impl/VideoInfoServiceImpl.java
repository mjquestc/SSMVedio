
package com.itmayiedu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itmayiedu.dao.VideoInfoMapper;
import com.itmayiedu.entity.VideoInfo;
import com.itmayiedu.service.VideoInfoService;

@Service
public class VideoInfoServiceImpl implements VideoInfoService {
	@Autowired
	private VideoInfoMapper videoInfoMapper;

	public List<VideoInfo> getVideoInfo() {
		return videoInfoMapper.selectAll();

	}

	public int addVideoInfo(VideoInfo record) {
		return videoInfoMapper.insert(record);

	}

	public VideoInfo getVideoInfo(int id) {
		return videoInfoMapper.selectByPrimaryKey(id);

	}

}
