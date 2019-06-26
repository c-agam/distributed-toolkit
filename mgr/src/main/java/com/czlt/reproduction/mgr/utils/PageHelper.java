package com.czlt.reproduction.mgr.utils;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
public class PageHelper<T> implements Serializable {
	private static final long serialVersionUID = 2908866063322048072L;
	private int pageNumber;
	private int pageSize;
	private int pageCount;
	private List<T> entries;

	public PageHelper() {
		this.pageCount = 0;
		this.pageNumber = 1;
		this.entries = Collections.emptyList();
	}
}
