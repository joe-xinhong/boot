package com.test.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;

@SpringBootTest
class BootApplicationTests {

	@Autowired
	WebApplicationContext applicationContext;

	@Test
	void contextLoads() {
		//List<String> urls = new ArrayList<String>();
		RequestMappingHandlerMapping mapping = applicationContext
				.getBean(RequestMappingHandlerMapping.class);
		// 获取url与类和方法的对应信息
		Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
			Map<String, String> map1 = new HashMap<String, String>();
			RequestMappingInfo info = m.getKey();
			HandlerMethod method = m.getValue();
			PatternsRequestCondition p = info.getPatternsCondition();
			String name = info.getName();
			if (name!=null){
				String[] split = name.split("#");
				if (split!=null&& split.length>0){
					for (int i=0,len=split.length;i<len;i++){
						map1.put("name"+i,split[i]);
					}
				}
			}
			for (String url : p.getPatterns()) {
				map1.put("url", url);
			}
			map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
			map1.put("method", method.getMethod().getName()); // 方法名
			RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
			for (RequestMethod requestMethod : methodsCondition.getMethods()) {
				map1.put("type", requestMethod.toString());
			}
			if (!map1.get("url").equals("/error")){
				list.add(map1);
			}

		}
		System.out.println(list);

	}

}
