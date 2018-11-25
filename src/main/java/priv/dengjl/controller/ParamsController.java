package priv.dengjl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import priv.dengjl.bean.BeanParam;
import priv.dengjl.bean.ComplexParam;
import priv.dengjl.bean.PageParam;

@Controller
@RequestMapping("/param")
public class ParamsController {
	private static final Logger logger = LoggerFactory.getLogger(ParamsController.class);

	// 逻辑视图
	@RequestMapping("/form")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("form");
		return mv;
	}

	// http://localhost:8080/springmvc/param/normalParam?name=%张三&note=mmp
	// 如果参数名称与url中保持一致，则无需注解，自动映射
	// 适用于参数个数较少
	@RequestMapping("/normalParam")
	public ModelAndView normalParam(String name, String note) {
		logger.debug("name: {}", name);
		logger.debug("note: {}", note);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	// http://localhost:8080/springmvc/param/beanParam?name=abc&note=mmp
	// pojo中的属性与url中保持一致，则无需注解，自动映射
	// 适用于参数个数较多，封装成bean对象
	@RequestMapping("/beanParam")
	public ModelAndView beanParam(BeanParam beanParam) {
		logger.debug("name: {}", beanParam.getName());
		logger.debug("note: {}", beanParam.getNote());

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	// http://localhost:8080/springmvc/param/requestParam?pre_name=ab&pre_note=ha
	// url和参数名称不一致，使用@RequestParam进行参数转换
	// boolean required() default true;
	@RequestMapping("/requestParam")
	public ModelAndView requestParam(@RequestParam("pre_name") String name, @RequestParam("pre_note") String note) {
		logger.debug("name: {}", name);
		logger.debug("note: {}", note);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// http://localhost:8080/springmvc/param/get/1236787/张三
	// restful风格 关键字：@RequestMapping， @PathVariable
	@RequestMapping(value = "/get/{id}/{name}", method = RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") String id, @PathVariable("name") String name) {
		logger.debug("name: {}", id);
		logger.debug("name: {}", name);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// 逻辑视图
	@RequestMapping("/jquery")
	public ModelAndView jquery() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jquery");
		return mv;
	}
	
	// json数据传输
	@RequestMapping(value = "/requestBody", method = RequestMethod.POST)
	public ModelAndView requestBody(@RequestBody ComplexParam complexParam) {
		// 数据域
		ModelAndView mv = new ModelAndView();
		mv.addObject(complexParam);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	// list Array数据传输
	@RequestMapping(value = "/listArray", method = RequestMethod.POST)
	public ModelAndView listArray(@RequestBody List<Long> array) {
		// 数据域
		ModelAndView mv = new ModelAndView();
		mv.addObject(array);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	// list Array数据传输
	@RequestMapping(value = "/listCust", method = RequestMethod.POST)
	public ModelAndView listCust(@RequestBody List<PageParam> array) {
		// 数据域
		ModelAndView mv = new ModelAndView();
		mv.addObject(array);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
	
	// http://localhost:8080/springmvc/param/serialize?name=baidu&note=mmp
	// $("#form").serialize() 显示给出?name=baidu&note=mmp
	@RequestMapping(value = "/serialize", method = RequestMethod.GET)
	public ModelAndView serialize(BeanParam beanParm) {
		// 数据域
		ModelAndView mv = new ModelAndView();
		mv.addObject(beanParm);
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
