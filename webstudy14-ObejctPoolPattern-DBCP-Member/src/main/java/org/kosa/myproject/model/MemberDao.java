package org.kosa.myproject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MemberDao {
	private static MemberDao instance = new MemberDao();
	
	// Database Connection Pool 객체의 표준 인터페이스 DataSource
	private DataSource dataSource;
	private MemberDao() {
		this.dataSource = (DataSource) DataSourceManager.getInstance().getDataSource();
	}
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	public int getTotalMemberCount() throws SQLException {
		int totalCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = this.dataSource.getConnection();	// dbcp로부터 connection을 빌려온다.
			String sql = "SELECT COUNT(*) FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return totalCount;
	}
	
	public MemberVo findMemberById(String memberId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberVo vo = null;
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id, password, name, address FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} 
					
		} finally {
			closeAll(rs, pstmt, con);
		} 
		return vo;
	}
	
	public ArrayList<MemberVo> findMemberByAddress(String address) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id, password, name, address FROM member WHERE address = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new MemberVo(rs.getString(1), null, rs.getString("name"), rs.getString(4)));
			}
			
		} finally {
			closeAll(rs, pstmt, con);
		}
		
		return list;
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null) 
			pstmt.close();
		if (con != null)
			con.close();
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if (pstmt != null) 
			pstmt.close();
		if (con != null)
			con.close();	// 커넥션을 소멸시키는 것이 아니라 dbcp에 커넥션을 반납
		
	}
}
