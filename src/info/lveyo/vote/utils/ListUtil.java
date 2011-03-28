package info.lveyo.vote.utils;

import info.lveyo.vote.beans.VoteResult;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {
	
	public static List<VoteResult> parseVoteResultList(List<VoteResult> vrList){
		List<VoteResult> toList = new ArrayList<VoteResult>(3);
		for(int i=0; i<3; i++){
			toList.add(new VoteResult(i+1, getVoteCount(vrList, i+1)));
		}
		return toList;
	}
	
	public static int getVoteCount(List<VoteResult> vrList, int voteValue){
		for(VoteResult vr : vrList){
			if(vr.getVoteValue()==voteValue)
				return vr.getVoteCount();
		}
		return 0;
	}

}
