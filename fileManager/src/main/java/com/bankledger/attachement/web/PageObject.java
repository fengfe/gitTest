package com.bankledger.attachement.web;

import java.io.Serializable;

public class PageObject implements Serializable{
	private static final long serialVersionUID = 6704960407651333757L;
		/**取下页的起始位置*/
		private int  startIndex;
		/**每页显示的数据*/
		private int pageSize;
		/**当前页*/
		private int pageCurrent=1;
		/**总记录数*/
		private int rowCounts;
		/**总页数*/
		private int pageCounts;
		public int getStartIndex() {
			return startIndex;
		}
		public void setStartIndex(int startIndex) {
			this.startIndex = startIndex;
		}
		public int getPageSize() {
			return pageSize;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
		public int getPageCurrent() {
			return pageCurrent;
		}
		public void setPageCurrent(int pageCurrent) {
			this.pageCurrent = pageCurrent;
		}
		public int getRowCounts() {
			return rowCounts;
		}
		public void setRowCounts(int rowCounts) {
			this.rowCounts = rowCounts;
		}
		public int getPageCounts() {
			return pageCounts;
		}
		public void setPageCounts(int pageCounts) {
			this.pageCounts = pageCounts;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
