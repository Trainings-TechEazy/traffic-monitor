package com.techeazy.traffic.domain;
//A class to store image data send by a Drone for traffic monitoring	
public class TrafficImage {
	
	private String imageId;
	private String imageUrl;
	private String timestamp;

	public TrafficImage(String imageId, String imageUrl, String timestamp) {
		this.imageId = imageId;
		this.imageUrl = imageUrl;
		this.timestamp = timestamp;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "TrafficImage{" +
				"imageId='" + imageId + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", timestamp='" + timestamp + '\'' +
				'}';
	}	
	@Override	
	public int hashCode() {
		int result = 17;
		result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
		result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		return result;
		}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)

			return true;
			if (obj == null)
			return false;
			if (getClass() != obj.getClass())
			return false;
			TrafficImage other = (TrafficImage) obj;
			if (imageId == null) {
				if (other.imageId != null)
				return false;
			} else if (!imageId.equals(other.imageId))
				return false;
			if (imageUrl == null) {
				if (other.imageUrl != null)
				return false;
				} else if (!imageUrl.equals(other.imageUrl))
				return false;
			if (timestamp == null) {
				if (other.timestamp != null)
				return false;
			} else if (!timestamp.equals(other.timestamp))	
				return false;
			return true;
	}
	

}
