package com.downloader;
import java.util.concurrent.Callable;

public class DownloadTask implements Callable<String> {
    private String fileUrl;
    private String destination;
    public DownloadTask(String fileUrl, String destination) {
        this.fileUrl = fileUrl;
        this.destination = destination;
    }
    @Override
    public String call() {
        System.out.println("Starting download from: " + fileUrl);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Download interrupted for " + fileUrl;
        }
        System.out.println("Download completed for: " + fileUrl);
        return "Download successful for " + fileUrl;
    }
}
