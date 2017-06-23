<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<jsp:directive.page import="com.helloweenvsfei.servlet.upload.UploadStatus"/>
<jsp:directive.page import="com.helloweenvsfei.servlet.upload.UploadListener"/>
<%
	// 自定义的 UploadStatus 对象
	UploadStatus status = new UploadStatus();
	// 自定义的 UploadListener 对象
	UploadListener listener = new UploadListener(status);
	
	// 把 UploadStatus 对象放到 session 里
	session.putValue("uploadStatus", status);

	// Apache 上传工具
	ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
	// 设置 listener
	upload.setProgressListener(listener);
	
	List itemList = upload.parseRequest(request);
	
	for(Iterator it=itemList.iterator(); it.hasNext(); ){
		FileItem item = (FileItem) it.next();
		if(item.isFormField()){
			System.out.println("FormField: " + item.getFieldName() + " = " + item.getString());
		}
		else{
			System.out.println("File: " + item.getName());
			
			// 统一 Linux 与 windows 的路径分隔符
			String fileName = item.getName().replace("/", "\\");
			fileName = fileName.substring(fileName.lastIndexOf("\\"));
			
			File saved = new File("C:\\upload_test", fileName);
			saved.getParentFile().mkdirs();
			
			InputStream ins = item.getInputStream();
			OutputStream ous = new FileOutputStream(saved);
			
			byte[] tmp = new byte[1024];
			int len = -1;
			
			while((len = ins.read(tmp)) != -1){
				ous.write(tmp, 0, len);
			}
			
			ous.close();
			ins.close();
			
			out.println("已保存文件：" + saved);
		}
	}
%>