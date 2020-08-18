package com.cheerios.awsimageupload.bucket;

public enum BucketName {
	PROFILE_IMAGE("buchi-image-upload-123");
	
	private final String bucketName;

	private BucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getBucketName() {
		return bucketName;
	}
	
	
}
