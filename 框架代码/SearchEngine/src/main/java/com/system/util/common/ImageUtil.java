package com.system.util.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageUtil {
	/**
	 * 
	 * @author liyuanguo
	 * @description file转byte
	 */
	public static byte[] File2byte(String filePath)
    {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return buffer;
    }
	 /**
     * 根据地址获得数据的字节流
     * 
     * @param strUrl
     *            网络连接地址
     * @return
     */
	 public static byte[] getImageFromNetByUrl(String strUrl) {
	        try {
	            URL url = new URL(strUrl);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setConnectTimeout(5 * 1000);
	            InputStream inStream = conn.getInputStream();// 通过输入流获取图片数据
	            byte[] btImg = readInputStream(inStream);// 得到图片的二进制数据
	            return btImg;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	 private static byte[] readInputStream(InputStream inStream) throws Exception {
	        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, len);
	        }
	        inStream.close();
	        return outStream.toByteArray();
	    }

}
