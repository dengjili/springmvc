package priv.dengjl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import priv.dengjl.bean.BeanParam;

@Controller
@RequestMapping("/attribute/")
@SessionAttributes(value = {"beanParam"}, types = {BeanParam.class})
public class AttributeController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@RequestMapping("/attribute")
	public ModelAndView index() {
		logger.debug("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("attribute");
		return mv;
	}
	
	@RequestMapping("/setSession")
	public ModelAndView Session(Long id) {
		BeanParam beanParam = new BeanParam();
		beanParam.setName("zhagnan");
		beanParam.setNote("test张国");
		
		// 设置请求属性
		ModelAndView mv = new ModelAndView();
		mv.addObject("beanParam", beanParam);
		mv.setViewName("attribute");
		return mv;
	}
	
	@RequestMapping("/getSession")
	public ModelAndView getSession(@SessionAttribute("beanParam") BeanParam beanParam) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(beanParam);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	@RequestMapping("/getCookie")
	public ModelAndView getCookie(@CookieValue(value = "JSESSIONID", defaultValue = "mmp") String jsessionId) {
		logger.debug("jsessionId: {}", jsessionId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("attribute");
		return mv;
	}
	/** 
	 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,
	 * Accept-Encoding: gzip, deflate, br
	 * Accept-Language: zh-CN,zh;q=0.9
	 * Connection: keep-alive
	 * Cookie: JSESSIONID=064DBEF12310AD0EA33D35A9A410F38C
	 * Host: localhost:8080
	 * Referer: http://localhost:8080/springmvc/attribute/setSession
	 * Upgrade-Insecure-Requests: 1
	 * User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 
	 */
	@RequestMapping("/getRequestHeader")
	public ModelAndView getRequestHeader(@RequestHeader(value = "Accept-Encoding") String acceptEncoding) {
		logger.debug("Accept-Encoding: {}", acceptEncoding);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("attribute");
		return mv;
	}
	
}
