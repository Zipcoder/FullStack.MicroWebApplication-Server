package zipcode.group3.showboat.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class S3StorageService {

    private final static String AKID = System.getenv("AWS_ACCESS_KEY_ID");
    private final static String SAK = System.getenv("AWS_SECRET_ACCESS_KEY_ID");
    private final static String bucketName = "showboatvideos";

    public static String upload(File file) {
        System.out.print(AKID);
        PutObjectRequest request = new PutObjectRequest(bucketName, file.getName(), file);
        AmazonS3 s3client = getS3();
        s3client.putObject(request);
        //replace this with metadata
        return file.getName();
    }

    private static AmazonS3 getS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(AKID, SAK)))
                .build();
    }
}
