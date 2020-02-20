package com.cos.shop.model.hate;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hate {
	private int id;
	private int userId;
	private int producId;
	private Date createDate;

}
