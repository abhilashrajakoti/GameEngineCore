package com.core.game;

import org.apache.log4j.Logger;

import com.core.game.dao.CricketGameData;
import com.core.game.utils.PropertyFileReader;

public class GameTest {
	final static Logger logger=Logger.getLogger(GameTest.class);
	public static void main(String s[]) {
		try {
		int testid=2;
		CricketGameData dao=new CricketGameData();
		CricketFieldPixel pixel=dao.getFieldPosition(testid);
		logger.info(pixel.getId()+"::"+pixel.getName());
		System.out.println(PropertyFileReader.getPropFileReader().getValue("DB.JDBCDRIVER"));
		}
		catch(Exception e) {
			logger.error("GameTestError", e);
		}
		
	}

}
