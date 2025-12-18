package com.downloader;
import java.io.*;
import java.net.*;
import java.nio.file.*;

public class DownloadUtils{
	public static boolean isValidUrl(String urlString){
		try{
			URL url=new URL(urlString);
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			con.connect();
			int code=con.getResponseCode();
			return code>=200 && code<400;
		}catch(Exception e){
			System.err.println("Invalid URL: "+urlString);
			return false;
		}
	}
	public static void downloadFile(String fileUrl,String destination) throws IOException{
		URL url=new URL(fileUrl);
		HttpURLConnection con=(HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setInstanceFollowRedirects(true);
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);
		con.setRequestProperty(
			"User-Agent",
			"Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
		);
		int responseCode = con.getResponseCode();
		if (responseCode != HttpURLConnection.HTTP_OK) {
			throw new IOException("Server returned HTTP " + responseCode);
		}
		try(InputStream in=con.getInputStream();
			FileOutputStream out=new FileOutputStream(destination)){
			byte[] buffer=new byte[8192];
			int bytesRead;
			while((bytesRead=in.read(buffer))!=-1){
				out.write(buffer,0,bytesRead);
			}
		}
	}
	public static boolean verifyDirectory(String dir){
		Path path=Paths.get(dir);
		try{
			if(!Files.exists(path)){
				Files.createDirectories(path);
			}
			return true;
		}catch(IOException e){
			return false;
		}
	}		
}