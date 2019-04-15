package com.phoenixvideos.phoenixapp.service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class AmazonS3ClientService {
    private String awsS3Bucket;
    private AmazonS3 amazonS3;
    private String url;
    private static final Logger logger = LoggerFactory.getLogger(AmazonS3ClientService.class);

    @Autowired
    public AmazonS3ClientService(String awsS3Bucket, Region awsRegion, AWSCredentialsProvider awsCredentialsProvider) {
        this.awsS3Bucket = awsS3Bucket;
        this.amazonS3 = AmazonS3ClientBuilder.standard()
                .withCredentials(awsCredentialsProvider)
                .withRegion(awsRegion.getName()).build();
        this.url = null;
    }

    @Async
    public void uploadFileToS3Bucket(MultipartFile multipartFile, String uniqueFileName){
    }

    @Async
    public void deleteFileFromS3Bucket(String fileName) {

    }

    public String gertUrl() {
        return this.url;
    }
}
