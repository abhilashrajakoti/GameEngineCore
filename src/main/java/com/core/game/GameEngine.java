package com.core.game;

import java.util.List;

import org.apache.log4j.Logger;

import com.core.game.dao.CricketGameData;

public class GameEngine {
	final static Logger logger = Logger.getLogger(GameEngine.class);

	public CricketFieldPixel getFieldPostionsInfo(int id) {
		CricketGameData dao = new CricketGameData();
		CricketFieldPixel pixel = dao.getFieldPosition(id);
		logger.info(pixel.getName());
		return pixel;
	}

	public List<CricketFieldPixel> getAllFieldPostions() {
		CricketGameData dao = new CricketGameData();
		List<CricketFieldPixel> allPosList = dao.getFieldPositions();
		for (CricketFieldPixel pixel : allPosList) {
			logger.info(pixel.getId() + ":: " + pixel.getName());
		}
		return allPosList;
	}

}
