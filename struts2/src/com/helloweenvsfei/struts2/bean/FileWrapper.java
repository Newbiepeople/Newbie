package com.helloweenvsfei.struts2.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileWrapper {

	private File file;

	private List<FileWrapper> children = new ArrayList<FileWrapper>();

	public FileWrapper(File file) {

		this.file = file;

		File[] files = this.file.listFiles();

		for (int i = 0; files != null && i < files.length; i++) {
			FileWrapper wrapper = new FileWrapper(files[i]);
			children.add(wrapper);
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<FileWrapper> getChildren() {
		return children;
	}

	public void setChildren(List<FileWrapper> children) {
		this.children = children;
	}

}
