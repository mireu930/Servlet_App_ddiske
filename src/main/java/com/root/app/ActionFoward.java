package com.root.app;

public class ActionFoward {
	//true foward, false redirect
	private boolean flag;
	//foward시 jsp의 경로 또는 redirect시 url 경로
	private String path;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
