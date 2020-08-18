package com.cheerios.awsimageupload.filestore;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;

@Service
public class FileStore {

	private final AmazonS3 s3;

	@Autowired
	public FileStore(AmazonS3 s3) {
		this.s3 = s3;
	}


	public void save(String path, String fileName, Optional<Map<String, String>> optionalMetadata, InputStream inputStream) {
		ObjectMetadata objectMetadata = new ObjectMetadata();
		optionalMetadata.ifPresent(map -> {
			if(!map.isEmpty()) {
				map.forEach(objectMetadata::addUserMetadata);
			}
		});

		try {
			s3.putObject(path, fileName, inputStream, objectMetadata);
		}catch(AmazonServiceException exception) {
			throw new IllegalStateException("Failed to store file to s3", exception);
		}
	}


	public byte[] download(String path, String key) {
		try {
			com.amazonaws.services.s3.model.S3Object obj = s3.getObject(path, key);
			return IOUtils.toByteArray(obj.getObjectContent());
		}catch(AmazonServiceException | IOException exception) {
			throw new IllegalArgumentException("cannot download file");
		}
	}

}
