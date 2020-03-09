package com.cos.shop.model;

public class PageMaker {

	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int page = 1;
	private int perPageNum = 10;
	//페이징넘버 
	private int displayPageNum = 10;
	
	

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		//페이징계산 메소드
		calcData();
	}
	
	private void calcData() {
		//					소수점이하 올림		23
		endPage = (int)(Math.ceil(page/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		int totalEndPage = (int)(Math.ceil(totalCount)/(double)perPageNum);
		
		if(endPage>totalEndPage) endPage=totalEndPage;
		
		prev = startPage == 1 ? false:true;
		
		next = endPage == totalEndPage ? false:true; 
//		next = endPage*criteria.getPerPageNum()>=totalCount ? false:true; 
	}
	

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}


	public boolean isPrev() {
		return prev;
	}


	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}



	
}
