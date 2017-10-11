package com.core.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.core.game.CricketFieldPixel;
import com.core.game.utils.DBUtils;

public class CricketGameData {
	final static Logger logger=Logger.getLogger(CricketGameData.class);
	
	public CricketFieldPixel getFieldPosition(int id) {
		
		String query="select id,name from FieldingPositions where id=?";
		logger.info(query);
		CricketFieldPixel pixel=null;
		Connection conn=null;
		try {
			conn=DBUtils.getConnection();
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1,id);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			String name=rs.getString("name");
			pixel=new CricketFieldPixel();
			pixel.setId(id);
			pixel.setName(name);
		} catch (SQLException e) {
			logger.error("GameEngineDB", e);
		}
		
		finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pixel;
		
	}

}
