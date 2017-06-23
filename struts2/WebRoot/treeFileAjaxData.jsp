<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="com.googlecode.jsonplugin.JSONUtil"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	out.clear();

	// action=getChildren&data={"node":{"widgetId":"E:\\batik-1.7","objectId":"E:\\batik-1.7","index":0,"isFolder":true},"tree":{"widgetId":"appFiles","objectId":""}}&dojo.preventCache=1211169459250
	//System.out.println("queryString: " + URLDecoder.decode(request.getQueryString(), "UTF-8"));
	// {"node":{"widgetId":"E:\\batik-1.7","objectId":"E:\\batik-1.7","index":0,"isFolder":true},"tree":{"widgetId":"appFiles","objectId":""}}
	//System.out.println("data: " + request.getParameter("data"));
	
	@SuppressWarnings("all")
	Map<String, Object> map = (Map<String, Object>)JSONUtil.deserialize(request.getParameter("data"));

	@SuppressWarnings("all")
	String objectId = (String)((Map<String, Object>)map.get("node")).get("objectId");
	
	File file = new File(objectId);
	
	File[] children = file.listFiles();
	
	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

	for(int i=0; children != null && i<children.length; i++){
		
		if(children[i].isFile())	continue;
		
		Map<String, Object> entry = new HashMap<String, Object>();
		entry.put("title", children[i].getName());
		entry.put("isFolder", children[i].isDirectory());
		entry.put("id", children[i].getName());
		entry.put("objectId", children[i].getAbsolutePath());
		
		result.add(entry);
	}
	
	for(int i=0; children != null && i<children.length; i++){

		if(children[i].isDirectory())	continue;
		
		Map<String, Object> entry = new HashMap<String, Object>();
		entry.put("title", children[i].getName());
		entry.put("isFolder", children[i].isDirectory());
		entry.put("id", children[i].getName());
		entry.put("objectId", children[i].getAbsolutePath());
		
		result.add(entry);
	}
	
	out.print(JSONUtil.serialize(result));
	
	System.out.println();
	System.out.println(JSONUtil.serialize(result));
	System.out.println();
	
%>