
package com.itmayiedu.service;

import java.util.List;

import com.itmayiedu.entity.VideoType;

/**
 * 
 * @classDesc: 功能描述:(视频类型Service)
 * @author: 余胜军
 * @createTime: 2017年9月13日 下午10:24:30
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 * @QQ:644064779
 */
public interface VideoTypeService {
	/**
	 * 
	 * @methodDesc: 功能描述:(查询视频类型)
	 * @author: 余胜军
	 * @param: @return
	 * @createTime:2017年9月13日 下午10:25:34
	 * @returnType:@return List<VideoType>
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	public List<VideoType> showVideoType(VideoType record);

}
