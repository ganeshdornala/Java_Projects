package com.downloader;

import java.io.*;
import java.net.*;
import java.nio.file.*;

public class DownloadUtils {
    public static boolean isValidUrl(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("HEAD");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            return con.getResponseCode() == HttpURLConnection.HTTP_OK;
        } catch (Exception e) {
            System.err.println("Invalid URL: " + urlString);
            return false;
        }
    }
    public static void downloadFile(String fileUrl, String destination) throws IOException {
        URL url = new URL(fileUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        try (InputStream in = con.getInputStream();
             FileOutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
    public static boolean verifyDirectory(String dir) {
        Path path = Paths.get(dir);
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
