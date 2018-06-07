
package com.itmayiedu.service;

import java.util.List;
import java.util.Map;

import com.itmayiedu.entity.VideoInfo;

/**
 * 
 * @classDesc: 功能描述:(视频查询)
 * @author: 余胜军
 * @createTime: 2017年9月14日 上午10:46:16
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 * @QQ:644064779
 */
public interface VideoInfoService {

	public List<VideoInfo> getVideoInfo();

	public int addVideoInfo(VideoInfo record);
	
	public VideoInfo getVideoInfo(int id);
}
