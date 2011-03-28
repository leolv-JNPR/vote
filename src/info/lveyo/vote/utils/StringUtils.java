package info.lveyo.vote.utils;

import info.lveyo.vote.beans.Topic;
import info.lveyo.vote.beans.TopicResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class StringUtils {
	
	public static String convertListToString(List<Topic> topicList, String hyphen){
		
		StringBuffer sb = new StringBuffer();
		if(topicList!=null && topicList.size()>0){
			for(Topic t:topicList){
				sb.append(t.getId()).append(hyphen);
			}
		}
		return sb.toString();
		
	}
	
	
	public static String convertResListToString(List<TopicResult> topicList, String hyphen){
		
		StringBuffer sb = new StringBuffer();
		if(topicList!=null && topicList.size()>0){
			for(Topic t:topicList){
				sb.append(t.getId()).append(hyphen);
			}
		}
		return sb.toString();
		
	}
	
	public static String getDate(){
		Date date = new Date();
		String strFormat = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		return sdf.format(date);
	}

}
