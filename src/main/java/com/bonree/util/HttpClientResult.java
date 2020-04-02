package com.bonree.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class HttpClientResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9071269217577837351L;

	public HttpClientResult(int code, String content) {
		super();
		this.code = code;
		this.content = content;
	}

	public HttpClientResult(int code) {
		super();
		this.code = code;
	}

	/**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;
}

