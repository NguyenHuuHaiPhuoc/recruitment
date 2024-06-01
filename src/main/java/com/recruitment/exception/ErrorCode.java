package com.recruitment.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
	OPJECT_EXISTS(400, "Đã tồn tại!"),
	CREATE_FAIL(403, "Thêm mới thất bại!"),
	UPDATE_FAIL(405, "Cập nhật thất bại!"),
	DELETE_FAIL(406, "Xóa thất bại!"),
	OPJECT_NOT_FOUND(404, "Không tìm thấy!");
	
	ErrorCode(int code, String message) {
		this.code = code;
        this.message = message;
	}
	private int code;
	private String message;
}
