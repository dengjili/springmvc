package priv.dengjl.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/format")
public class FormaterController {

	private final static Logger logger = LoggerFactory.getLogger(FormaterController.class);

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("formatter");
		return mv;
	}

	/**
	 * public ModelAndView format(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @NumberFormat(pattern = "#,###.00") Double amount) {
	 * 
	 * @See priv.dengjl.controller.AdviceController.initBinder
	 */ 
	@RequestMapping("/format")
	public ModelAndView format(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @NumberFormat(pattern = "#,###.00") Double amount) {
		logger.debug("date==> {}", date);
		logger.debug("amount==> {}", amount);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("formatter");
		return mv;
	}

}
