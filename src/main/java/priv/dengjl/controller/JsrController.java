package priv.dengjl.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.dengjl.bean.JsrBean;
import priv.dengjl.validate.CustValidate;

@Controller
@RequestMapping("/jsr")
public class JsrController {

	private static final Logger logger = LoggerFactory.getLogger(JsrController.class);

	@RequestMapping("/jsrform")
	public ModelAndView jsrform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsrform");
		return mv;
	}
	
	@RequestMapping("/validate")
	public ModelAndView validate(@Valid JsrBean jsrBean, Errors errors) {
		if (errors.hasErrors()) {
			List<FieldError> fieldErrors = errors.getFieldErrors();
			logger.debug("====================");
			for (FieldError fieldError : fieldErrors) {
				logger.debug("{} : {}", fieldError.getField(), fieldError.getDefaultMessage());
			}
			logger.debug("====================");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jsrform");
		return mv;
	}

	@InitBinder
	public void initBinder(DataBinder binder) {
		// 绑定一个校验类
		binder.setValidator(new CustValidate());
	}
}
