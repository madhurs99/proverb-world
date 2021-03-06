package com.proverbworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.proverbworld.beans.Proverb;
import com.proverbworld.common.DBUtil;

public class ProverbDAO {

	public static List getProverbs(boolean approved, String language) {
		int intApproved = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List lstBeans = new ArrayList();
		if (approved)
			intApproved = 1;

		String sql = "SELECT * FROM proverb  "
				+ "WHERE approved = ? and (language =?)";
		try {
			
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, intApproved);
			if(language == null || language.trim().equals("")){
				language="en";
			}
			ps.setString(2, language);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Proverb pBean = new Proverb();
					pBean.setProverbID(Integer.parseInt(rs
							.getString("Proverb_id")));
					pBean.setProverb(rs.getString("proverb"));
					pBean.setDescription(rs.getString("description"));
					pBean.setSubmittedBy(rs.getString("submitter"));
					pBean.setSubmitterPlace(rs.getString("submitter_place"));
					pBean.setLanguage("language");
					lstBeans.add(pBean);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			DBUtil.getInstance().closeResultSet(rs);
			DBUtil.getInstance().closeStatement(ps);

		}
		return lstBeans;
	}

	public static List getProverbs(boolean approved) {
		int intApproved = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List lstBeans = new ArrayList();
		if (approved)
			intApproved = 1;

		String sql = "SELECT * FROM proverb  " + "WHERE approved = ?";
		try {
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, intApproved);

			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Proverb pBean = new Proverb();
					pBean.setProverbID(Integer.parseInt(rs
							.getString("Proverb_id")));
					pBean.setProverb(rs.getString("proverb"));
					pBean.setDescription(rs.getString("description"));
					pBean.setSubmittedBy(rs.getString("submitter"));
					pBean.setSubmitterPlace(rs.getString("submitter_place"));
					pBean.setLanguage("language");
					lstBeans.add(pBean);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			DBUtil.getInstance().closeResultSet(rs);
			DBUtil.getInstance().closeStatement(ps);

		}
		return lstBeans;
	}

	public static boolean saveProverb(Proverb pBean) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String proverbSQL = "";
		boolean status = false;
		int intApproved = 0;
		if (pBean.isApproved())
			intApproved = 1;
		try {
			conn = DBUtil.getInstance().getConnection();
			
			if (pBean.getProverbID() > 0) {
				proverbSQL = "UPDATE proverb SET proverb = ?, description =?,approved=? WHERE proverb_id =?";
				ps = conn.prepareStatement(proverbSQL);
				ps.setString(1, pBean.getProverb());
				ps.setString(2, pBean.getDescription());
				ps.setInt(3, intApproved);
				ps.setInt(4, pBean.getProverbID());
			} else {
				proverbSQL = "INSERT INTO proverb(proverb, description, approved, submitter,  submitter_place,language) VALUES (?,?,?,?,?,?)";
				ps = conn.prepareStatement(proverbSQL);
				ps.setString(1, pBean.getProverb());
				ps.setString(2, pBean.getDescription());
				ps.setInt(3, intApproved);
				ps.setString(4, pBean.getSubmittedBy());
				ps.setString(5, pBean.getSubmitterPlace());
				ps.setString(6, pBean.getLanguage());
			}
			
	

			
			int i = 0;
			i = ps.executeUpdate();
			// if(i >0 ){
			// user_id = this.getID(userIDSQL, conn);
			// if(!(user_id >0)){
			// i=0;
			// i =ps.executeUpdate(userSQL);
			// }
			// user_id = this.getID(userIDSQL, conn);
			// proverb_id = this.getID(proverbIDSQL, conn);
			// if(user_id>0 && proverb_id>0 && i>0){
			// i=0;
			// String userProverbSQL =
			// "INSERT INTO PROVERB_SUBMITTER_MAP(USER_ID, PROVERB_ID)VALUES("+user_id+","+proverb_id+")";
			// i = ps.executeUpdate(userProverbSQL);
			// }
			// }
			if (i > 0) {
				status = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.getInstance().closeResultSet(rs);
			DBUtil.getInstance().closeStatement(ps);

		}
		return status;
	}

	public static boolean login(String userName, String passwd) {
		boolean status = false;
		String sql = "SELECT COUNT(*) AS C FROM user WHERE name = ? AND password = ?";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					String s = rs.getString("c");
					if (s != null && !s.trim().equals("")) {
						if (Integer.parseInt(s) > 0) {
							status = true;
						}
					}
				}
			}
		} catch (Exception ex) {

		} finally {
			DBUtil.getInstance().closeResultSet(rs);
			DBUtil.getInstance().closeStatement(ps);

		}
		return status;
	}

	public static boolean deleteProverb(String proverbIDList) {
		String sql = "DELETE FROM proverb WHERE proverb_id in ("+proverbIDList+")";
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			DBUtil.getInstance().closeStatement(ps);

		}
	}
	public static boolean approveProverb(String proverbIDList) {
		String sql = "UPDATE proverb SET approved = 1 WHERE proverb_id in ("+proverbIDList+")";
		Connection conn = null;
		PreparedStatement ps = null;
		int i = 0;
		try {
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareCall(sql);
			i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		} finally {
			DBUtil.getInstance().closeStatement(ps);

		}
	}

	public static Proverb getProverb(int proverbID) {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proverb pBean = new Proverb();
		String value = null;

		// String sql =
		// "SELECT P.PROVERB_ID, P.PROVERB, P.DESCRIPTION,U.NAME, U.PLACE FROM PROVERB P "
		// +
		// "LEFT OUTER JOIN PROVERB_SUBMITTER_MAP PM ON P.PROVERB_ID = PM.PROVERB_ID "
		// +
		// "LEFT OUTER JOIN USER U ON PM.USER_ID = U.USER_ID WHERE P.PROVERB_ID = ?";
		String sql = "SELECT proverb_id, proverb, description,submitter, submitter_place,language FROM proverb  "
				+ "WHERE proverb_id = ?";
		try {
			conn = DBUtil.getInstance().getConnection();
			ps = conn.prepareCall(sql);
			ps.setInt(1, proverbID);
			rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {

					pBean.setProverbID(Integer.parseInt(rs
							.getString("Proverb_id")));
					pBean.setProverb(rs.getString("proverb"));
					pBean.setDescription(rs.getString("description"));
					pBean.setSubmittedBy(rs.getString("submitter"));
					pBean.setSubmitterPlace(rs.getString("submitter_place"));
					pBean.setLanguage(rs.getString("language"));
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			DBUtil.getInstance().closeResultSet(rs);
			DBUtil.getInstance().closeStatement(ps);

		}
		return pBean;
	}

	private static int getID(String sql, Connection conn) throws SQLException {
		int i = 0;
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				i = rs.getInt("id");
			}
		}
		DBUtil.getInstance().closeResultSet(rs);
		return i;
	}

	public static final String utf8Convert(String utf8String)
			throws java.io.UnsupportedEncodingException {
		byte[] bytes = new byte[utf8String.length()];
		for (int i = 0; i < utf8String.length(); i++) {
			bytes[i] = (byte) utf8String.charAt(i);
		}
		return new String(bytes, "UTF-8");
	}
}
