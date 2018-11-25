package priv.dengjl.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/forward/")
public class ForwardController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@RequestMapping("/forward")
	public ModelAndView index() {
		logger.debug("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward");
		return mv;
	}
	
	@RequestMapping("/setRequest")
	public ModelAndView setRequest(HttpServletRequest request) {
		
		// 设置请求属性
		request.setAttribute("id", 1234);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward:./getRequestAttribute");
		return mv;
	}
	
	@RequestMapping("/getRequestAttribute")
	public ModelAndView getRequestAttribute(@RequestAttribute("id") int id) {
		logger.debug("{}", id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forward");
		return mv;
	}
	
}
