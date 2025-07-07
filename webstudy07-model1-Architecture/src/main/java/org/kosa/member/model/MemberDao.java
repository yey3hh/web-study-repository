package org.kosa.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import common.DbConfig;

// Dao : Data Access Object 데이터 제어 로직을 담당하는 객체
public class MemberDao {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	MemberVo vo = null;
	
	// 생성자
	public MemberDao() throws ClassNotFoundException {
		Class.forName(DbConfig.DRIVER);
	}
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	public int getAllMemberCount() throws SQLException {
		try{
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PWD);
			String sql = "SELECT COUNT(*) FROM member";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} finally {
			if (rs != null) {
				rs.close();
			} if (pstmt != null){
				pstmt.close();
			} if (con != null){
				con.close();
			}
		}
	}
	
	/*
	 * 	method() throws SQLException {
	 * 	connection
	 * preparedStatement
	 * resultSet
	 * try {
	 * 
	 * } finally {
	 * 	close
	 * } 
	 * return memberVO();
	 * }
	 */
	
	public MemberVo findMemberById(String memberId) throws SQLException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		MemberVO vo = null;
		
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PWD);
			String sql = "SELECT id, password, name, address FROM member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			} 
					
		} finally {
			if (rs != null) {
				rs.close();
			} if (pstmt != null){
				pstmt.close();
			} if (con != null){
				con.close();
			}
		} 
		return vo;
	}

	public void register(MemberVo memberVO) throws SQLException {
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PWD);
			
			String sql = "INSERT INTO member(id, password, name, address) VALUES(?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getAddress());
			
			int result = 0;
			result = pstmt.executeUpdate();
			System.out.println("insert cnt : " + result);
			
		} finally {
			if (rs != null) {
				rs.close();
			} if (pstmt != null){
				pstmt.close();
			} if (con != null){
				con.close();
			}
		}
		
	}

	public ArrayList<MemberVo> findMemberByAddress(String address) throws SQLException {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		
		try {
			con = DriverManager.getConnection(DbConfig.URL, DbConfig.USER, DbConfig.PWD);
			String sql = "SELECT id, password, name, address FROM member WHERE address = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, address);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new MemberVo(rs.getString(1), null, rs.getString("name"), rs.getString(4));
				list.add(vo);
			}
			
		} finally {
			if (rs != null) 
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			
		}
		
		return list;
	}
}
