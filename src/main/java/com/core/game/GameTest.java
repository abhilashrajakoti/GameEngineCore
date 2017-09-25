package com.core.game;

import com.core.game.dao.CricketGameData;
import com.google.gson.Gson;

public class GameTest {
	
	public static void main(String s[]) {
		int testid=20;
		CricketGameData dao=new CricketGameData();
		CricketFieldPixel pixel=dao.getFieldPosition(testid);
		Gson gson=new Gson();
		String jsonString=gson.toJson(pixel);
		System.out.println(jsonString);
	}

}
