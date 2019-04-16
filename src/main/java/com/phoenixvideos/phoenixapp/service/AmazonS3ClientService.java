package com.phoenixvideos.phoenixapp.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

        try {
            //creating the file in the server (temporarily)
            File file = new File(uniqueFileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();

            TransferManager tm = TransferManagerBuilder.standard()
                    .withS3Client(this.amazonS3)
                    .build();

            PutObjectRequest putObjectRequest = new PutObjectRequest(this.awsS3Bucket, uniqueFileName, file);

            putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);

            this.amazonS3.putObject(putObjectRequest);

            // To receive notifications when bytes are transferred, add a
            // ProgressListener to your request.
            putObjectRequest.setGeneralProgressListener(progressEvent -> System.out.println("Transferred bytes: " + progressEvent.getBytesTransferred()));
            // TransferManager processes all transfers asynchronously,
            // so this call returns immediately.
            Upload upload = tm.upload(putObjectRequest);

            // Optionally, you can wait for the upload to finish before continuing.
            upload.waitForCompletion();
            this.url = amazonS3.getUrl(this.awsS3Bucket, uniqueFileName).toString();
            //removing the file created in the server
            file.delete();

        } catch (IOException | AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while uploading [" + uniqueFileName + "] ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async
    public void deleteFileFromS3Bucket(String fileName) {
        try {
            amazonS3.deleteObject(new DeleteObjectRequest(awsS3Bucket, fileName));
        } catch (AmazonServiceException ex) {
            logger.error("error [" + ex.getMessage() + "] occurred while removing [" + fileName + "] ");
        }
    }

    public String gertUrl() {
        return this.url;
    }
}
