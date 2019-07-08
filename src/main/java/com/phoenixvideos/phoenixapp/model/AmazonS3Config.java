package com.phoenixvideos.phoenixapp.model;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonS3Config {

    @Value("${aws.access.key.id}")
    private String awsKeyID;

    @Value("${aws.access.key.secret}")
    private String awsKeySecret;

    @Value("${aws.region}")
    private String awsRegion;

    @Value("${aws.s3.bucket}")
    private String awsS3Bucket;

    @Bean(name = "awsKeyID")
    public String getAwsKeyID() {
        return awsKeyID;
    }

    @Bean(name = "awsKeySecret")
    public String getAwsKeySecret() {
        return awsKeySecret;
    }

    @Bean(name = "awaRegion")
    public Region getAwsRegion() {
        return Region.getRegion(Regions.fromName(awsRegion));
    }

    @Bean(name = "awsS3Bucket")
    public String getAwsS3Bucket() {
        return awsS3Bucket;
    }

    @Bean(name = "awsCredentialsProvider")
    public AWSCredentialsProvider getAWSCredentials() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(this.awsKeyID, this.awsKeySecret);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }
}
