package com.helloweenvsfei.struts2.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = -60950803930068947L;

	private File picture;

	private String pictureContentType;

	private String pictureFileName;

	public String execute() {
		return "input";
	}

	public String upload() throws Exception {

		System.out.println("Context: "
				+ ServletActionContext.getServletContext()
						.getRealPath("upload"));

		System.out.println("File: " + picture);

		System.out.println("FileName: " + pictureFileName);

		File saved = new File(ServletActionContext.getServletContext()
				.getRealPath("upload"), pictureFileName);

		InputStream ins = null;
		OutputStream ous = null;

		try {
			saved.getParentFile().mkdirs();

			ins = new FileInputStream(picture);
			ous = new FileOutputStream(saved);

			byte[] b = new byte[1024];
			int len = 0;

			while ((len = ins.read(b)) != -1) {
				ous.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ous != null)
				ous.close();
			if (ins != null)
				ins.close();
		}

		return "list";
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File file) {
		this.picture = file;
	}

	public String getPictureContentType() {
		return pictureContentType;
	}

	public void setPictureContentType(String fileContentType) {
		this.pictureContentType = fileContentType;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureFileName(String fileFileName) {
		this.pictureFileName = fileFileName;
	}

}
