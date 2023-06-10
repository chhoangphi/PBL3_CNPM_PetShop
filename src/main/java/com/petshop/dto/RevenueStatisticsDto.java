package com.petshop.dto;

public class RevenueStatisticsDto {
		private String monthOfOrder;
		private long totalPriceOfMonth;
		private String totalOrderOfMonth;
		public String getMonthOfOrder() {
			return monthOfOrder;
		}
		public void setMonthOfOrder(String monthOfOrder) {
			this.monthOfOrder = monthOfOrder;
		}
		public long getTotalPriceOfMonth() {
			return totalPriceOfMonth;
		}
		public void setTotalPriceOfMonth(long totalPriceOfMonth) {
			this.totalPriceOfMonth = totalPriceOfMonth;
		}
		public String getTotalOrderOfMonth() {
			return totalOrderOfMonth;
		}
		public void setTotalOrderOfMonth(String totalOrderOfMonth) {
			this.totalOrderOfMonth = totalOrderOfMonth;
		}
		
}
