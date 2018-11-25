package priv.dengjl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/my")
public class MyController {

	private static final Logger logger = LoggerFactory.getLogger(MyController.class);

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}

	// 获取请求参数，不建议，不要直接依赖于Servlet容器提供的api
	// http://localhost:8080/springmvc/my/index2?id=12347
	@RequestMapping("/index2")
	public ModelAndView index2(HttpSession session, HttpServletRequest request) {
		String parameter = request.getParameter("id");
		if (logger.isDebugEnabled()) {
			Object attribute = session.getAttribute("id");
			if (attribute != null) {
				logger.debug("session id : {}", attribute);
			}

			session.setAttribute("id", parameter);
			logger.debug("request id : {}", parameter);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index2");
		return mv;
	}

	// @RequestParam("id2") -> http请求的参数id2，映射为int中的id
	// http://localhost:8080/springmvc/my/index3?id2=1234
	// 默认不允许为空required=false,但是参数不能为基本类型，null赋值会报错
	@RequestMapping("/index3")
	public ModelAndView index3(@RequestParam(value="id2", required=false, defaultValue="23") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// 其他作用域取值，同理
	// @RequestAttribute
	// @SessionAttribute
	
	@RequestMapping("/indexTotal")
	public ModelAndView indexTotal(@RequestParam("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("indexTotal");
		// 数据域
		mv.addObject("id", id);
		mv.addObject("name", "mmp,测试组2222");
		return mv;
	}

	// model 与 view 分离
	@RequestMapping("/indexTotal2")
	public String indexTotal2(@RequestParam("id") Integer id, Model model) {
		// 数据域
		model.addAttribute("id", id);
		model.addAttribute("name", "mmp,测试组");
		return "indexTotal";
	}
	
	@RequestMapping("/indexJson")
	public ModelAndView indexJson() {
		// 数据域
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		map.put("id", "1");
		map.put("name", "12");
		map.put("age", "135");
		mv.addObject("fuck", map);
		
		mv.setView(new MappingJackson2JsonView());
		return mv;
	}
}
