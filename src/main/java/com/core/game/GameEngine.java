package com.core.game;

import org.apache.log4j.Logger;

import com.core.game.dao.CricketGameData;

public class GameEngine {
	final static Logger logger = Logger.getLogger(GameEngine.class);

	public CricketFieldPixel getFieldInfo(int id) {
		CricketGameData dao = new CricketGameData();
		CricketFieldPixel pixel = dao.getFieldPosition(id);
		logger.info(pixel);
		return pixel;
	}

}
