package com.vivek.entity;

import lombok.Data;

@Data
public class EmailDtls {
	private String to;
	private String msg;
	private String subject;
	private String attachment;

}
