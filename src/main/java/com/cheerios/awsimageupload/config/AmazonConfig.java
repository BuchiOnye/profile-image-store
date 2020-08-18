package com.cheerios.awsimageupload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonConfig {

	@Bean
	public AmazonS3 s3() {
		AWSCredentials credentials = new BasicAWSCredentials("AKIAJD3TIQOTJRA3S6SA", "UcmCBRbAjLr8UdlknvQ+FlMU4M0zW3xmDRpRpDqs");
		return AmazonS3ClientBuilder
				.standard()
				.withCredentials(new AWSStaticCredentialsProvider(credentials))
				.withRegion(Regions.US_EAST_2)
				.build();
		
	}
}
