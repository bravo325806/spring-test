package com.websystique.springmvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
	private static final String EXTERNAL_FILE_PATH="C:/mytemp/SpringMVCHibernateManyToManyCRUDExample.zip";
	

	@RequestMapping(value={"/","/welcome"}, method = RequestMethod.GET)
	public String getHomePage(ModelMap model) throws IOException {
		FileReader fr = new FileReader(getClass().getClassLoader().getResource("test.txt").getFile());
		BufferedReader br = new BufferedReader(fr);
		String result="";
		        while (br.ready()) {
		            result+=br.readLine();
		        }
		        fr.close();
		model.addAttribute("result",result );
		return "file_content";
	}

	@RequestMapping(value={"/test"}, method = RequestMethod.GET)
	public String getHomePage2(ModelMap model,@RequestParam("a")int a,@RequestParam("b")int b) {
		model.addAttribute("a",a+b);
		return "welcome2";
	}
}
