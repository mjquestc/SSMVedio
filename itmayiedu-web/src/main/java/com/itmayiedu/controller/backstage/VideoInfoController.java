
package com.itmayiedu.controller.backstage;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itmayiedu.entity.VideoInfo;
import com.itmayiedu.entity.VideoType;
import com.itmayiedu.service.VideoInfoService;
import com.itmayiedu.service.VideoTypeService;

/**
 * git测试
 * @classDesc: 功能描述:(查询视频)
 * @author: 余胜军
 * @createTime: 2017年9月14日 上午10:51:56
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 * @QQ:644064779
 */
@Controller()
public class VideoInfoController {
	private static Logger log = Logger.getLogger(VideoInfoController.class);
	@Autowired
	private VideoInfoService videoInfoService;
	@Autowired
	private VideoTypeService videoTypeService;
	private static final String BASE = "backstage/";
	// 视频管理页面
	private static final String VIDEOMANAG = BASE + "videoManag";
	private static final String LOCAVIDEO = BASE + "addVideo";
	private static final String VIDEODETAILS = BASE + "videoDetails";

	/**
	 * 
	 * @methodDesc: 功能描述:(视频首页)
	 * @author: 余胜军
	 * @param: @param
	 *             request
	 * @param: @return
	 * @createTime:2017年9月14日 下午5:03:46
	 * @returnType:@param request
	 * @returnType:@return String
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	@RequestMapping("/videoManag")
	public String videoManag(HttpServletRequest request) {
		List<VideoInfo> listVideoInfo =  videoInfoService.getVideoInfo();
		request.setAttribute("listVideoInfo", listVideoInfo);
		return VIDEOMANAG;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(添加视频)
	 * @author: 余胜军
	 * @param: @param
	 *             request
	 * @param: @return
	 * @createTime:2017年9月14日 下午5:04:03
	 * @returnType:@param request
	 * @returnType:@return String
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	@RequestMapping("/locaAddVideo")
	public String locaVideo(HttpServletRequest request) {
		List<VideoType> listVideoType = videoTypeService.showVideoType(null);
		request.setAttribute("listVideoType", listVideoType);
		return LOCAVIDEO;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(视频详情)
	 * @author: 余胜军
	 * @param: @param
	 *             id
	 * @param: @param
	 *             request
	 * @param: @return
	 * @createTime:2017年9月14日 下午5:10:18
	 * @returnType:@param id
	 * @returnType:@param request
	 * @returnType:@return String
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	@RequestMapping("/videoDetails")
	public String videoDetails(int id, HttpServletRequest request) {
		VideoInfo videoInfo = videoInfoService.getVideoInfo(id);
		request.setAttribute("videoInfo", videoInfo);
		return VIDEODETAILS;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(添加视频元素)
	 * @author: 余胜军
	 * @param: @return
	 * @createTime:2017年9月14日 上午11:43:56
	 * @returnType:@return Map<String,Object>
	 * @copyright:上海每特教育科技有限公司
	 * @QQ:644064779
	 */
	@RequestMapping("/addVideo")
	public String addVideo(@RequestParam(value = "file", required = false) MultipartFile file, VideoInfo videoInfo,
			HttpServletRequest req, HttpServletResponse res) {
		try {
			// 获取当前上下文
			String path = req.getSession().getServletContext().getRealPath("/static/imgs");
			// 文件名称
			String newName = System.currentTimeMillis() + ".png";
			File targetFile = new File(path, newName);
			// 文件夹不存在,则创建文件夹
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 保存
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				log.error(e);
			}
			videoInfo.setVideoUrl(newName);
			videoInfoService.addVideoInfo(videoInfo);
			req.setAttribute("result", "封面上传成功!");
			return "redirect:/videoManag";
		} catch (Exception e) {
			log.error(e);
			req.setAttribute("result", "上传失败!");
			return LOCAVIDEO;
		}

	}

	@ResponseBody
	@RequestMapping("/getVideoInfoList")
	public List<VideoInfo> getVideoInfoList() {
		return videoInfoService.getVideoInfo();
	}

	public Map<String, Object> setRuest(int code, String msg) {
		Map<String, Object> resutMap = new HashMap<String, Object>();
		resutMap.put("code", "200");
		resutMap.put("msg", "添加元素成功!");
		return resutMap;
	}
}
