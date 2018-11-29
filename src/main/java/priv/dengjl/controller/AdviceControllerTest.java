package priv.dengjl.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import priv.dengjl.bean.BeanParam;


@RequestMapping("/advice/")
@Controller
public class AdviceControllerTest {
	
	private final static Logger logger = LoggerFactory.getLogger(FormaterController.class);
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advice");
		return mv;
	}

	@RequestMapping("/format")
	public ModelAndView format(Date date, @NumberFormat(pattern = "#,###.00") Double amount) {
		logger.debug("date==> {}", date);
		logger.debug("amount==> {}", amount);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("formatter");
		return mv;
	}
	
	@RequestMapping("/testRedirect")
	public String testRedirect(RedirectAttributes ra) {
		BeanParam param = new BeanParam();
		param.setName("张三");
		param.setNote("test");
		
		// 数据域
		ra.addFlashAttribute("param", param);
		return "redirect:./showPojo";
	}

	// 处理数据模型，如果返回对象，则对象会保持在ModelAttribute
	// 需要使用@ModelAttribute来接收参数
	@RequestMapping("/showPojo")
	public ModelAndView showPojo(@ModelAttribute("param") BeanParam param ) {
		logger.debug("name: {}", param.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advice");
		return mv;
	}
	
	@RequestMapping("/testRequest")
	public ModelAndView testRequest(ModelAndView mv) {
		// 设置请求属性
		BeanParam param = new BeanParam();
		param.setName("张三");
		param.setNote("test");
		
		mv.addObject("beanParam", param);
		
		mv.setViewName("forward:./getRequestAttribute");
		return mv;
	}
	
	// 可以正常读取，也可以通过@ModelAttribute读取
	@RequestMapping("/getRequestAttribute")
	public ModelAndView getRequestAttribute(@RequestAttribute("beanParam") BeanParam param) {
		logger.debug("name: {}", param.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advice");
		return mv;
	}
	
    // 在进入控制器之前执行
	@ModelAttribute("beanParam")
	public BeanParam testRequest2() {
		// 设置请求属性
		BeanParam param = new BeanParam();
		param.setName("张三22");
		param.setNote("test22");
		return param;
	}
	
	// @ModelAttribute读取
	@RequestMapping("/getRequestAttribute2")
	public ModelAndView getRequestAttribute2(@ModelAttribute("beanParam") BeanParam param) {
		logger.debug("name: {}", param.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advice");
		return mv;
	}
	
	@RequestMapping("/getException")
	public ModelAndView getException() throws Exception {
		if (true) {
			throw new Exception("test");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("advice");
		return mv;
	}
}
