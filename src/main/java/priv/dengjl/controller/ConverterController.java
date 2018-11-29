package priv.dengjl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import priv.dengjl.bean.BeanParam;

@Controller
public class ConverterController {
	// 指定返回的媒体为我们自定义的媒体类型application/x-wisely
	@RequestMapping(value = "/convert", produces = { "application/x-wisely" })
	public @ResponseBody BeanParam convert(@RequestBody BeanParam beanParam) {
		return beanParam;
	}
	
	@RequestMapping("/convertIndex")
	public ModelAndView convertIndex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convert");
		return mv;
	}
	
	// http://localhost:8080/springmvc/convertOne2One?beanParam=abc-ef
	@RequestMapping("/convertOne2One")
	public ModelAndView convertOne2One(BeanParam beanParam) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convert");
		return mv;
	}
	
	// 未能演示成功，当前无资料可查询
	// http://localhost:8080/springmvc/convertOne2Array?beanParams=abc-ef,tt-1234
	@RequestMapping("/convertOne2Array")
	@ResponseBody
	public ModelAndView convertOne2One(BeanParam[] beanParams) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("convert");
		return mv;
	}
	
}
