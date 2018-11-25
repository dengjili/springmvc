package priv.dengjl.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload")
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping("/index")
	public ModelAndView jsrform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}
	
	@RequestMapping("/upload")
	public ModelAndView upload(@RequestParam("file") MultipartFile file) {
		try {
			file.transferTo(new File("c:\\sim\\lib\\" + file.getOriginalFilename()));
		} catch (IllegalStateException | IOException e) {
			logger.debug(e.getMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("upload");
		return mv;
	}
}
