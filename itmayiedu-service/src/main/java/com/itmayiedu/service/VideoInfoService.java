
package com.itmayiedu.service;

import java.util.List;
import java.util.Map;

import com.itmayiedu.entity.VideoInfo;

/**
 * 
 * @classDesc: ��������:(��Ƶ��ѯ)
 * @author: ��ʤ��
 * @createTime: 2017��9��14�� ����10:46:16
 * @version: v1.0
 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
 * @QQ:644064779
 */
public interface VideoInfoService {

	public List<VideoInfo> getVideoInfo();

	public int addVideoInfo(VideoInfo record);
	
	public VideoInfo getVideoInfo(int id);
}
