
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
 * @classDesc: ��������:(ǰ̨չʾ����)
 * @author: ��ʤ��
 * @createTime: 2017��9��14�� ����2:02:06
 * @version: v1.0
 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
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
		//��ѯ��������
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
