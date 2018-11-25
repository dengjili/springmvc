package priv.dengjl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import priv.dengjl.bean.BeanParam;

@Controller
@RequestMapping("/model")
public class ModelController {

	private static final Logger logger = LoggerFactory.getLogger(ModelController.class);

	@RequestMapping("/model")
	public ModelAndView jsrform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("model");
		return mv;
	}
	
	@RequestMapping("/modelMap")
	public ModelAndView modelMap(ModelMap modelMap) {
		ModelAndView mv = new ModelAndView();
		BeanParam beanParam = new BeanParam();
		beanParam.setName("测试1");
		beanParam.setNote("test1");
		modelMap.addAttribute("beanParam", beanParam);
		
		mv.setViewName("forward:./showModel");
		return mv;
	}

	@RequestMapping("/modelData")
	public ModelAndView modelData(Model model) {
		ModelAndView mv = new ModelAndView();
		BeanParam beanParam = new BeanParam();
		beanParam.setName("测试2");
		beanParam.setNote("test2");
		model.addAttribute("beanParam", beanParam);
		
		mv.setViewName("forward:./showModel");
		return mv;
	}
	
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView(ModelAndView mv) {
		BeanParam beanParam = new BeanParam();
		beanParam.setName("测试3");
		beanParam.setNote("test3");
		mv.addObject("beanParam", beanParam);
		
		mv.setViewName("forward:./showModel");
		return mv;
	}
	
	@RequestMapping("/modelAndView2")
	public ModelAndView modelAndView2() {
		ModelAndView mv = new ModelAndView();
		BeanParam beanParam = new BeanParam();
		beanParam.setName("测试3");
		beanParam.setNote("test3");
		mv.addObject("beanParam", beanParam);
		
		mv.setViewName("forward:./showModel");
		return mv;
	}
	
	@RequestMapping("/showModel")
	public ModelAndView showModel(@RequestAttribute("beanParam") BeanParam beanParam) {
		logger.debug("==> {}", beanParam);
		ModelAndView mv = new ModelAndView();
		mv.addObject(beanParam);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
