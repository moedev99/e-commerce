package com.moedev99.ecommerce.service;

import com.moedev99.ecommerce.exception.FileValidityException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class S3ServiceImpl implements S3Service{
    private final S3Client s3Client;
    @Value("${aws.bucket.name}")
    private String bucketName;
    @Value("${aws.s3.region}")
    private String region;


    @Override
    public String uploadImage(MultipartFile image) {
        try{
            var key = UUID.randomUUID() + "-" + image.getOriginalFilename();
            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .contentType(image.getContentType())
                    .build();
            RequestBody requestBody = RequestBody.fromBytes(image.getBytes());

            s3Client.putObject(objectRequest, requestBody);
            String imageUrl = String.format("https://%s.s3.%s.amazonaws.com/%s",
                    bucketName, region, key);
            return imageUrl;
        }catch (IOException e){
            throw new FileValidityException("Error while getting uploading to s3");
        }
    }

    @Override
    public String updateImage(MultipartFile image, String url) {
        String newUrl = uploadImage(image);
        if (newUrl != null){
            deleteOldImage(url);
        }
        return newUrl;
    }

    private void deleteOldImage(String url) {
//        extract the name key of the object
        String delimiter = "amazonaws.com/";
        String key = url.substring(url.indexOf(delimiter) + delimiter.length());

        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.deleteObject(deleteObjectRequest);
        log.info("old url {} has been deleted successfully! ", url);
    }
}
