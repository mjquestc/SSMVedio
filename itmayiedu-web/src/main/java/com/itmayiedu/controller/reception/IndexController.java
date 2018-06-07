
package com.itmayiedu.controller.reception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itmayiedu.entity.VideoInfo;
import com.itmayiedu.entity.VideoType;
import com.itmayiedu.service.VideoInfoService;
import com.itmayiedu.service.VideoTypeService;

/**
 * 
 * @classDesc: 功能描述:(前台展示数据)
 * @author: 余胜军
 * @createTime: 2017年9月14日 下午2:02:06
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 * @QQ:644064779
 */
@Controller("/")
public class IndexController {
	private static final String INDEX = "index";
	private static final String INDEXVIDEODETAILS = "indexVideoDetails";
	@Autowired
	private VideoTypeService videoTypeService;
	@Autowired
	private VideoInfoService videoInfoService;

	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		//查询所有类型
		List<VideoType> listShowVideoType = videoTypeService.showVideoType(null);
		request.setAttribute("listShowVideoType", listShowVideoType);
		List<VideoInfo> listVideoInfo = videoInfoService.getVideoInfo();
		request.setAttribute("listVideoInfo", listVideoInfo);
		return INDEX;
	}
	
	@RequestMapping("/indexVideoDetails")
	public String indexVideoDetails(HttpServletRequest request,int id){
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return INDEXVIDEODETAILS;
	}
}
