package kz.kolesa;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.IOUtils;

public class S3Uploader {

		private String bucketName="kolesa-images1";
		private AmazonS3 s3client = null;
		
		public S3Uploader() {
			this.bucketName ="kolesa-images1";
			s3client = new AmazonS3Client(new ProfileCredentialsProvider().getCredentials());
		}
		
		public void uploadFile(String keyName, InputStream inputStream) {
			ObjectMetadata metadata = new ObjectMetadata();
			Long contentLength=0L;
			try {
				contentLength = Long.valueOf(inputStream.available());
			} catch (IOException e) {
				e.printStackTrace();
			}
			metadata.setContentLength(contentLength);
			this.s3client.putObject(new PutObjectRequest(this.bucketName, keyName, inputStream, metadata));
		}
		
		public File getFile(String keyName) {
			File image = null;
			this.s3client.getObject(new GetObjectRequest(this.bucketName, keyName), image);
			return image;
		}
	
}
