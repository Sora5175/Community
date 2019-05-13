package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class pythonUtil {
	public static Map<String,String> getValue(String host) {
		Map<String,String> value = new HashMap<String,String>();
		String cookie;
		String viewstate;
		try {
			URL url = new URL(host);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置请求超时时间
			conn.setReadTimeout(1000);
			if (conn.getResponseCode() != 200) {
				System.out.println("error");
				return null;
			}
			// 获取Set-Cookie
			String str = conn.getHeaderField("Set-Cookie");
			int begin = str.indexOf("ASP.NET_SessionId");
			int end = str.indexOf(';', begin);
			cookie = str.substring(begin, end);
			value.put("cookie", cookie);
			BufferedReader read = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			//读取整个网页的源码
			StringBuffer buffer = new StringBuffer();
			while ((str = read.readLine()) != null) {
				buffer.append(str);
			}
			read.close();
			begin = buffer.indexOf("__VIEWSTATE\"");
			begin = buffer.indexOf("value=\"", begin + 1);
			begin = buffer.indexOf("\"", begin + 1);
			end = buffer.indexOf("\"", begin + 1);
			viewstate = buffer.substring(begin + 1, end);
			value.put("viewstate", viewstate);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static InputStream getCodeImg(String host,String cookie) {
		try {
			/**
			 * img变量的值为http://202.119.160.5/CheckCode.aspx
			 * 也就是上面图片中，验证码的网址，在浏览器中，右键验证码 即可选择复制图片网址
			 */
			URL url = new URL(host+"CheckCode.aspx");
			HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
			openConnection.setRequestMethod("GET");
			openConnection.setReadTimeout(5000);
			// cookie一同提交(ASP.NET_SessionId=4kusfii0urpbrazkhxvuas45,只需要等号后面的一串数据)
			openConnection.setRequestProperty("Cookie", cookie);
			InputStream codeImg = openConnection.getInputStream();
			return codeImg;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String loginUrl(String host,Map<String, String> value,String username,String password,String check) throws IOException {
		//拼接请求字符串
		String str = "__VIEWSTATE=" + URLEncoder.encode(value.get("viewstate"), "GB2312") + "&txtUserName=" + username + "&TextBox2="
				+ password + "&txtSecretCode=" + check + "&RadioButtonList1=" + URLEncoder.encode("学生", "GB2312")
				+ "&Button1=&lbLanguage=&hidPdrs=&hidsc=";
		//登录提交的网址
		URL url = new URL(host+"default2.aspx");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//Post提交
		conn.setInstanceFollowRedirects(false);   
		conn.setRequestMethod("POST");
		conn.setReadTimeout(5000);
		conn.setUseCaches(false);
		//禁止程序自己跳转到目标网址，必须设置，不然程序会自己响应
		conn.setInstanceFollowRedirects(false);
		// 写入cookie
		conn.setRequestProperty("Cookie", value.get("cookie"));
		conn.setDoOutput(true);
		OutputStream out = conn.getOutputStream();
		//写入参数
		out.write(str.getBytes());
		out.close();
		return conn.getHeaderField("Location");
	}
	public static String getNameByUrl(String host,String loginUrl,String cookie) {
		try {
			URL Url = new URL(host+loginUrl);
			HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
			conn.setRequestMethod("GET");
			conn.setReadTimeout(2000);
			conn.setRequestProperty("Cookie", cookie);
			InputStreamReader input = new InputStreamReader(conn.getInputStream(), "GB2312");
			BufferedReader read = new BufferedReader(input);
			StringBuffer sb = new StringBuffer();
			String temp;
			while ((temp = read.readLine()) != null) {
				sb.append(temp);
			}
			Pattern pattern = Pattern.compile("xm=..");
			Matcher matcher = pattern.matcher(sb.toString());
			matcher.find();
			String name = sb.substring(matcher.start() + 3, matcher.end());
			return name;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取课表
	 */
	public static String lessonList(String host,String cookie,String username,String name) throws Exception {
		String url = host+"xskbcx.aspx?xh=" + username + "&xm="
				+ URLEncoder.encode(name, "GB2312") + "&gnmkdm=N121603";
		URL Url;
		try {
			Url = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) Url.openConnection();
	 
			conn.setRequestMethod("GET");
			conn.setReadTimeout(2000);
			conn.setRequestProperty("Cookie", cookie);
			conn.setRequestProperty("Referer",
					host+"/xs_main.aspx?xh=13150227");
			conn.setInstanceFollowRedirects(false);
			conn.setDoOutput(true);
			InputStreamReader input = new InputStreamReader(conn.getInputStream(), "GB2312");
			BufferedReader read = new BufferedReader(input);
			StringBuffer sb = new StringBuffer();
			String temp;
			while ((temp = read.readLine()) != null) {
				sb.append(temp);
			}
	        return sb.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String get(String host,Map<String, String> value,String username,String password,String check) {
		try {
			String loginUrl = loginUrl(host, value, username, password,check);
			String name = getNameByUrl(host,loginUrl, value.get("cookie"));
			return lessonList(host, value.get("cookie"), username, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}