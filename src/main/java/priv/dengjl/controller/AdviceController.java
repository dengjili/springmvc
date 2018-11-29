package priv.dengjl.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;


// 控制器里的aop，拦截指定包
@ControllerAdvice(basePackages = { "priv.dengjl.controller" })
public class AdviceController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 运行为空
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
	}

	@ExceptionHandler(value = {Exception.class})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exception");
		return mv;
	}
}
