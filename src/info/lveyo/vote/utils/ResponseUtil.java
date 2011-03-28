package info.lveyo.vote.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class ResponseUtil {
	
	public static void writeJsonResponseNoCache(HttpServletResponse response,JSONObject jsonObject ) throws JSONException,IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("cache-control", "No-Cache");
		response.addHeader("Pragma", "No-Cache");
		response.addHeader("Expires", "0");
		response.setHeader("Charset","UTF-8'");
		response.getWriter().print(jsonObject.toString());
	}
	
	public static void writeJsonResponseNoCache(HttpServletResponse response,String jsonString ) throws JSONException,IOException {
		response.setContentType("application/json;charset=utf-8");
		response.addHeader("cache-control", "No-Cache");
		response.addHeader("Pragma", "No-Cache");
		response.addHeader("Expires", "0");
		response.setHeader("Charset","UTF-8'");
		response.getWriter().print(jsonString);
	}

}
