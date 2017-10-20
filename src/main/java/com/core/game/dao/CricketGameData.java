package com.core.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.core.game.CricketFieldPixel;
import com.core.game.utils.DBUtils;

public class CricketGameData {
	final static Logger logger = Logger.getLogger(CricketGameData.class);

	public CricketFieldPixel getFieldPosition(int id) {

		String query = "select id,name from FieldingPositions where id=?";
		logger.info(query);
		CricketFieldPixel pixel = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			String name = rs.getString("name");
			pixel = new CricketFieldPixel();
			pixel.setId(id);
			pixel.setName(name);
		} catch (SQLException e) {
			logger.error("GameEngineDB", e);
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("GameEngineDB", e);
				}
			}
		}
		return pixel;

	}

	public List<CricketFieldPixel> getFieldPositions() {
		String query = "select id,name,csstop,cssleft from FieldingPositions";
		logger.info(query);
		List<CricketFieldPixel> allPos = new ArrayList<CricketFieldPixel>();
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				CricketFieldPixel pixel = new CricketFieldPixel();
				pixel.setId(rs.getInt(1));
				pixel.setName(rs.getString(2));
				pixel.setCssTop(rs.getInt(3));
				pixel.setCssLeft(rs.getInt(4));
				allPos.add(pixel);
			}
		} catch (SQLException e) {
			logger.error("GameEngineDB", e);
		}

		finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					logger.error("GameEngineDB", e);
				}
			}
		}
		return allPos;

	}

}
