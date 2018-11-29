package priv.dengjl.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import priv.dengjl.bean.GlobalParam;

@Controller
@RequestMapping("/global")
public class GlobalController {
	private final static Logger logger = LoggerFactory.getLogger(FormaterController.class);

	@RequestMapping("/global")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("global");
		return mv;
	}

	@RequestMapping(value = "/test", method = { RequestMethod.GET })
	public ModelAndView test(HttpServletRequest request, Model model) {
		// 从后台代码获取国际化信息
		RequestContext requestContext = new RequestContext(request);
		model.addAttribute("money", requestContext.getMessage("money"));
		model.addAttribute("date", requestContext.getMessage("date"));

		GlobalParam globalParam = new GlobalParam();

		globalParam.setMoney(12345.678);
		globalParam.setDate(new Date());
		ModelAndView mv = new ModelAndView();
		mv.addObject("globalParam", globalParam);
		mv.setViewName("global");
		return mv;
	}
}
