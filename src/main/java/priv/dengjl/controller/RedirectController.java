package priv.dengjl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import priv.dengjl.bean.BeanParam;

@Controller
@RequestMapping("/redirect/")
public class RedirectController {
	
	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@RequestMapping("/redirect")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect");
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add() {
		// 数据域
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "1");
		mv.addObject("name", "12");
		mv.addObject("age", "135");
		mv.setViewName("redirect:./show");
		return mv;
	}

	@RequestMapping("/add2")
	public String add2(Model m) {
		// 数据域
		m.addAttribute("id", "1");
		m.addAttribute("name", "12");
		m.addAttribute("age", "135");
		return "redirect:./show";
	}
	
	// 重定向页面，无法获取到值，ModelAndView必须使用向后传递方式，如add方法
	@RequestMapping("/add3")
	public String add3(ModelAndView mv) {
		// 数据域
		mv.addObject("id", "1");
		mv.addObject("name", "12");
		mv.addObject("age", "135");
		return "redirect:./show";
	}
	
	// 正常情况是无法传递pojo对象的，只能传递简单的参数
	@RequestMapping("/add4")
	public String add4(Model m) {
		BeanParam param = new BeanParam();
		param.setName("张三");
		param.setNote("test");
		
		// 数据域
		m.addAttribute("param", param);
		return "redirect:./showPojo";
	}
	
	// 正常情况是无法传递pojo对象的，只能传递简单的参数
	@RequestMapping("/add5")
	public String add5(RedirectAttributes ra) {
		BeanParam param = new BeanParam();
		param.setName("张三");
		param.setNote("test");
		
		// 数据域
		ra.addFlashAttribute("param", param);
		return "redirect:./showPojo2";
	}
	
	@RequestMapping("/show")
	public ModelAndView show(String id, String name, String age) {
		logger.debug("id: {}", id);
		logger.debug("name: {}", name);
		logger.debug("age: {}", age);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect");
		return mv;
	}
	
	@RequestMapping("/showPojo")
	public ModelAndView showPojo(BeanParam param ) {
		logger.debug("name: {}", param.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect");
		return mv;
	}
	
	// 需要使用@ModelAttribute来接收参数
	@RequestMapping("/showPojo2")
	public ModelAndView showPojo2(@ModelAttribute("param") BeanParam param ) {
		logger.debug("name: {}", param.getName());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect");
		return mv;
	}
}
