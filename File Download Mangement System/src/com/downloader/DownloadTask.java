package com.downloader;
import java.util.concurrent.Callable;
import java.io.IOException;

public class DownloadTask implements Callable<String>{
	private String fileUrl;
	private String destinationDir;
	public DownloadTask(String fileUrl,String destinationDir){
		this.fileUrl=fileUrl;
		this.destinationDir=destinationDir;
	}
	@Override
	public String call(){
		try{
			System.out.println("Starting download from: "+fileUrl);
			DownloadUtils.verifyDirectory(destinationDir);
			String fileName=fileUrl.substring(fileUrl.lastIndexOf("/")+1);
			String fullPath=destinationDir+"\\"+fileName;
			DownloadUtils.downloadFile(fileUrl,fullPath);
			return "Download successful: "+fileName;
		}catch(IOException e){
			return "Download failed for "+fileUrl+" : "+e.getMessage();
		}
	}
}