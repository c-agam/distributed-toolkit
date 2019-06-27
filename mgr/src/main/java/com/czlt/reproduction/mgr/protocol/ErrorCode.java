package com.czlt.reproduction.mgr.protocol;

public enum ErrorCode {
	success("0000", "成功"),
	server_error("0004", "服务器错误"),
	fail("9999", "失败"),
	user_not_exist("4001", "用户不存在"),
	password_error("4004", "密码错误"),
	user_prohibition("4005", "用户封禁"),
	user_exist("4006", "用户已存在"),
	no_password("4007", "缺少密码"),
	old_password_error("4008", "旧密码错误"),
	old_password_equal_new("4009", "新密码不能和旧密码相同"),
	do_success("1000", "操作成功"),
	upload_fail("1001", "上传失败"),
	all_success("1002", "全部成功"),
	part_success("1003", "部分成功"),
	not_have_record("1004", "无记录"),
	params_error("1005", "参数错误"),
	login_expire("1006", "登陆超时"),
	;
	private String value;

	private String memo;
	
	ErrorCode(String value, String memo) {
		this.value = value;
		this.memo = memo;
	}

	public String getValue() {
		return value;
	}

	public String getMemo() {
		return memo;
	}
}
