package com.petshop.entity;

import java.time.LocalDateTime;


public class Activity {
		private String activity_id;
		private String activity;
		private LocalDateTime activityTime;
		private String modifiedBy;
		public String getActivity_id() {
			return activity_id;
		}
		public void setActivity_id(String activity_id) {
			this.activity_id = activity_id;
		}
		public String getActivity() {
			return activity;
		}
		public void setActivity(String activity) {
			this.activity = activity;
		}
		public LocalDateTime getActivityTime() {
			return activityTime;
		}
		public void setActivityTime(LocalDateTime activityTime) {
			this.activityTime = activityTime;
		}
		public Activity(String activity_id, String activity, LocalDateTime activityTime,String modifiedBy) {
			super();
			this.activity_id = activity_id;
			this.activity = activity;
			this.activityTime = activityTime;
			this.activityTime = activityTime;
			this.modifiedBy = modifiedBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public Activity() {
			super();
		}
		
		
}
