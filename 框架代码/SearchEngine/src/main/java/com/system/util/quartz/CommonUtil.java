package com.system.util.quartz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.system.util.common.DateUtil;


public class CommonUtil {
	private static String rtn = "";
	private static ApplicationContext applicationContext = null;
	static String regEx = "[\u4e00-\u9fa5]";
	static Pattern pat = Pattern.compile(regEx);

	public static ApplicationContext getCurrentApplicationContext() {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		}
		return applicationContext;
	}

	public static String executeCmd(String cmd, long timeoutInSec) {
		boolean ret = false;
		try {
			final Process process = Runtime.getRuntime().exec(cmd);
			Callable processCall = new Callable() {

				@Override
				public Integer call() throws Exception {
					process.waitFor();
					InputStream is = process.getInputStream();
					InputStreamReader bi = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(bi);
					String message;
					rtn = br.readLine();
					return process.exitValue();
				}

			};

			ExecutorService service = Executors.newSingleThreadExecutor();
			Future processFuture = service.submit(processCall);
			service.shutdown();

			try {
				int exitValue = (int) processFuture.get(timeoutInSec, TimeUnit.SECONDS);
				if (exitValue == 0)
					ret = true;
			} catch (Exception e) {
				process.destroy();
				rtn = "timeOut";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rtn;
	}

	/**
	 * @param runnable
	 * @param timeOut
	 */
	public void executeThread(Runnable runnable, final long timeOut) {
		final Thread thread = new Thread(runnable);
		final Timer timer = new Timer();
		thread.start();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (thread.isAlive()) {
					thread.stop();
				}
			}
		}, timeOut);

	}

	public static String getResLocate(String res) {
		String rt = "";
		try {
			rt = getCurrentApplicationContext().getResource("classpath:" + res).getURI().toString();
		} catch (Exception e) {
		}
		return rt;
	}

	public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
		try {

			File file = new File(filepath);
			if (!file.isDirectory()) {
				System.out.println("文件");
				System.out.println("path=" + file.getPath());
				System.out.println("absolutepath=" + file.getAbsolutePath());
				System.out.println("name=" + file.getName());

			} else if (file.isDirectory()) {
				System.out.println("文件夹");
				String[] filelist = file.list();
				for (int i = 0; i < filelist.length; i++) {
					File readfile = new File(filepath + "\\" + filelist[i]);
					if (!readfile.isDirectory()) {
						System.out.println("path=" + readfile.getPath());
						System.out.println("absolutepath=" + readfile.getAbsolutePath());
						System.out.println("name=" + readfile.getName());

					} else if (readfile.isDirectory()) {
						readfile(filepath + "\\" + filelist[i]);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("readfile()   Exception:" + e.getMessage());
		}
		return true;
	}

	public static String getResPath(String path) {
		String classPath = System.getProperty("java.class.path");
		if (!classPath.contains(";") && classPath.endsWith(".jar")) {
			classPath = new File(classPath).getParent() + File.separator + "classes" + File.separator + path;
		} else {
			try {
				classPath = getCurrentApplicationContext().getResource("classpath:" + path).getFile().getAbsolutePath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return classPath;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static long chn2digit(String chnStr) {
		// init map
		java.util.Map<String, Integer> unitMap = new java.util.HashMap<String, Integer>();
		unitMap.put("十", 10);
		unitMap.put("百", 100);
		unitMap.put("千", 1000);
		unitMap.put("万", 10000);
		unitMap.put("亿", 100000000);

		java.util.Map<String, Integer> numMap = new java.util.HashMap<String, Integer>();
		numMap.put("零", 0);
		numMap.put("一", 1);
		numMap.put("二", 2);
		numMap.put("三", 3);
		numMap.put("四", 4);
		numMap.put("五", 5);
		numMap.put("六", 6);
		numMap.put("七", 7);
		numMap.put("八", 8);
		numMap.put("九", 9);

		// 队列
		List<Long> queue = new ArrayList<Long>();
		long tempNum = 0;
		for (int i = 0; i < chnStr.length(); i++) {
			char bit = chnStr.charAt(i);
			System.out.print(bit);
			// 数字
			if (numMap.containsKey(bit + "")) {

				tempNum = tempNum + numMap.get(bit + "");

				// 一位数、末位数、亿或万的前一位进队列
				if (chnStr.length() == 1 | i == chnStr.length() - 1
						| (i + 1 < chnStr.length() && (chnStr.charAt(i + 1) == '亿' | chnStr.charAt(i + 1) == '万'))) {
					queue.add(tempNum);
				}
			}
			// 单位
			else if (unitMap.containsKey(bit + "")) {

				// 遇到十 转换为一十、临时变量进队列
				if (bit == '十') {
					if (tempNum != 0) {
						tempNum = tempNum * unitMap.get(bit + "");
					} else {
						tempNum = 1 * unitMap.get(bit + "");
					}
					queue.add(tempNum);
					tempNum = 0;
				}

				// 遇到千、百 临时变量进队列
				if (bit == '千' | bit == '百') {
					if (tempNum != 0) {
						tempNum = tempNum * unitMap.get(bit + "");
					}
					queue.add(tempNum);
					tempNum = 0;
				}

				// 遇到亿、万 队列中各元素依次累加*单位值、清空队列、新结果值进队列
				if (bit == '亿' | bit == '万') {
					long tempSum = 0;
					if (queue.size() != 0) {
						for (int j = 0; j < queue.size(); j++) {
							tempSum += queue.get(j);
						}
					} else {
						tempSum = 1;
					}
					tempNum = tempSum * unitMap.get(bit + "");
					queue.clear();// 清空队列
					queue.add(tempNum);// 新结果值进队列
					tempNum = 0;
				}
			}
		}
		long sum = 0;
		for (Long i : queue) {
			sum += i;
		}
		return sum;
	}

	public static boolean isContainsChinese(String str) {
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}
	public synchronized static void writeException(Exception exception){
		String path="logs"+File.separator+DateUtil.formatDateTime(new Date(),"yyyy-MM-dd HH:mm:ss")+"_"+System.currentTimeMillis()+".log";
		File file =new File(path);
		if(!file.exists()){
			new File("logs").mkdirs();
		}
		try {
			FileWriter writer= new FileWriter(file,true);
			writer.write("msg:"+exception.getMessage());
			//writer.write("cause:"+exception.getCause().getMessage());
			StackTraceElement[] staks=exception.getStackTrace();
			for(int i=0;i<staks.length;i++){
				StackTraceElement element = staks[i];
				writer.write(element.getClassName()+":"+element.getMethodName()+"  line"+element.getLineNumber());
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
