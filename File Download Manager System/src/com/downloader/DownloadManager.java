package com.downloader;

import java.util.concurrent.*;
import java.util.*;

public class DownloadManager {
    private static final int THREAD_COUNT = 4;
    private ExecutorService executor;
    public DownloadManager() {
        executor = Executors.newFixedThreadPool(THREAD_COUNT);
    }
    public void startDownload(String[] urls, String destination) {
        List<Callable<String>> tasks = new ArrayList<>();
        for (String url : urls) {
            tasks.add(new DownloadTask(url, destination));
        }
        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            for (Future<String> result : results) {
                System.out.println(result.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
    public static void main(String[] args) {

        String[] fileUrls = {
            "http://example.com/file1.zip",
            "http://example.com/file2.zip",
            "http://example.com/file3.zip"
        };
        String destination = "downloads";
        DownloadManager manager = new DownloadManager();
        manager.startDownload(fileUrls, destination);
    }
}
