package priv.dengjl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import priv.dengjl.view.ExcelView;

@Controller
@RequestMapping("/excel/")
public class ExcelController {

	@RequestMapping("/getExcel")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setView(new ExcelView());
		return mv;
	}

}
