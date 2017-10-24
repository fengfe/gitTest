package com.bankledger.attachement.web;
/**通过此对象封装控制层返回的JSON结果，统一化*/
public class JsonResult {
	public static final int SUCCESS=1;
	public static final int ERROR=0;
	/**服务端响应状态*/
	private int state;
	/**用户提示*/
	private String message;
	/**具体业务*/
	private Object data;
	
	public JsonResult() {
		this.state=SUCCESS;
		this.message="OK";
	}
	public JsonResult(Object data) {
		this();
		this.data=data;
	}
	public JsonResult(Throwable e) {
		this.state=ERROR;
		this.message=e.getMessage();
	}
	public int getState() {
		return state;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Object getData() {
		return data;
	}
	
	
}
