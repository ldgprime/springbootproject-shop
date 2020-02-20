package com.cos.shop.model.user;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private String address;
	private Date createDate;
	
	@Builder
	public User(int id, String username, String password, String email, String phone, String address,
			Date createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.createDate = createDate;
	}

	
	
}
