
package com.itmayiedu.controller.backstage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itmayiedu.entity.VideoType;
import com.itmayiedu.service.VideoTypeService;

/**
 * 
 * @classDesc: ��������:(����TestController)
 * @author: ��ʤ��
 * @createTime: 2017��9��13�� ����9:01:42
 * @version: v1.0
 * @copyright:�Ϻ�ÿ�ؽ����Ƽ����޹�˾
 * @QQ:644064779
 */
@Controller
public class TestController {
	private static final String TEST = "test";
	@Autowired
	private VideoTypeService videoTypeService;
	private static Logger log = Logger.getLogger(TestController.class);

	@RequestMapping("/test")
	public String test() {
		return TEST;
	}

	@ResponseBody
	@RequestMapping("/getViideType")
	public List<VideoType> getViideType() {
		log.info("###getViideType() start()###");
		List<VideoType> listVideoType = videoTypeService.showVideoType(null);
		log.info("###getViideType() end()###");
		return listVideoType;
	}
}
