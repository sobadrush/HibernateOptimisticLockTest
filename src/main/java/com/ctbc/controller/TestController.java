package com.ctbc.controller;

import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/TestController")
public class TestController {

	@RequestMapping(value = "/testPost", method = RequestMethod.POST)
	private String testPost(HttpServletRequest req) {
		System.out.println("=========== testPost ===========");

		Enumeration<String> paramsEnum = req.getParameterNames();
		while (paramsEnum.hasMoreElements()) {
			String p_key = (String) paramsEnum.nextElement();
			String p_value = req.getParameter(p_key);
			System.out.println(" >>> " + p_key + " = " + p_value);
		}

		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/testAjaxPost", method = RequestMethod.POST, 
		consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE },  // consumes的例子（方法僅處理request Content-Type 為 "application/json" 類型的請求）
		produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }   // produces: 指定返回的内容类型，僅當 request-header 中的(Accept)類型中包含該指定類型才返回；
	)
	private String testAjaxPost(@RequestBody Map<String, Object> inputJson) {
		System.out.println("=========== testAjaxPost ===========");
		System.out.println(">>> inputJson >>> " + inputJson);
		
		Set<Entry<String, Object>> eSet = inputJson.entrySet();
		for (Entry<String, Object> entry : eSet) {
			System.out.println(" @@ " + entry.getKey() + " <===> " + entry.getValue());
		}
		
		return "{ \"rtnMsg\" : \"幹你娘\" }";
	}
	
	
	class DeptVO {
		int deptId;
		String deptName;
		public DeptVO(int deptId, String deptName) {
			this.deptId = deptId;
			this.deptName = deptName;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/testAjaxPostReturnDeptVO", method = RequestMethod.POST, 
		consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE },  // consumes的例子（方法僅處理request Content-Type 為 "application/json" 類型的請求）
		produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }   // produces: 指定返回的内容类型，僅當 request-header 中的(Accept)類型中包含該指定類型才返回；
	)
	private DeptVO testAjaxPostReturnDeptVO(@RequestBody Map<String, Object> inputJson) {
		System.out.println("=========== testAjaxPost ===========");
		System.out.println(">>> inputJson >>> " + inputJson);
		
		Set<Entry<String, Object>> eSet = inputJson.entrySet();
		for (Entry<String, Object> entry : eSet) {
			System.out.println(" @@ " + entry.getKey() + " <===> " + entry.getValue());
		}
		
		return new DeptVO(9487 , "數金部");
	}

}
