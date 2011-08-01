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
	
	public List getProverbs(boolean approved){
		int intApproved =0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List lstBeans = new ArrayList();
		if(approved)
		intApproved =1;
		
		String sql = "SELECT * FROM PROVERB  " +
					"WHERE APPROVED = ?";
		try{
		 conn = DBUtil.getConnection();
		 ps = conn.prepareStatement(sql);
		ps.setInt(1, intApproved);
		rs = ps.executeQuery();
		if(rs!= null){
			while(rs.next()){
				Proverb pBean = new Proverb();
				pBean.setProverbID(Integer.parseInt(rs.getString("Proverb_id")));
				pBean.setProverb(rs.getString("proverb"));
				pBean.setDescription(rs.getString("description"));
				pBean.setSubmittedBy(rs.getString("submitter"));
				pBean.setSubmitterPlace(rs.getString("submitter_place"));
				pBean.setLanguage("language");
				lstBeans.add(pBean);
			}
		}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return lstBeans;
	}
	
	public boolean saveProverb(Proverb pBean){
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String proverbSQL = "";
		boolean status = false;
		int intApproved =0;
		if(pBean.isApproved())
			intApproved=1;
		if(pBean.getProverbID()> 0){
			proverbSQL ="UPDATE PROVERB SET PROVERB = '"+pBean.getProverb()+"',DESCRIPTION ='"+pBean.getDescription()+"',APPROVED="+intApproved +" WHERE PROVERB_ID ="+pBean.getProverbID();
		}else{
			proverbSQL ="INSERT INTO PROVERB(PROVERB, DESCRIPTION, APPROVED, SUBMITTER,  SUBMITTER_PLACE,language) VALUES ('"+pBean.getProverb()+"','"+pBean.getDescription()+"',"+intApproved +",'"+pBean.getSubmittedBy()+"','"+pBean.getSubmitterPlace()+"','"+pBean.getLanguage()+"')";
		}
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(proverbSQL);
			int i=0;
			i = ps.executeUpdate();
//			if(i >0 ){
//				user_id = this.getID(userIDSQL, conn);
//				if(!(user_id >0)){
//					i=0;
//					i =ps.executeUpdate(userSQL);
//				}
//				user_id = this.getID(userIDSQL, conn);
//				proverb_id = this.getID(proverbIDSQL, conn);
//				if(user_id>0 && proverb_id>0 && i>0){
//						i=0;
//						String userProverbSQL = "INSERT INTO PROVERB_SUBMITTER_MAP(USER_ID, PROVERB_ID)VALUES("+user_id+","+proverb_id+")";
//						i = ps.executeUpdate(userProverbSQL);
//				}
//			}
			if(i>0){
				status = true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
	return status;	
	}
	
	
	public boolean login(String userName, String passwd){
		boolean status = false;
		String sql = "SELECT COUNT(*) AS C FROM USER WHERE NAME = ? AND PASSWORD = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2, passwd);
			rs = ps.executeQuery();
			if(rs!= null){
				while(rs.next()){
					String s = rs.getString("c");
					if(s!= null && !s.trim().equals("")){
						if(Integer.parseInt(s)>0){
							status = true;
						}
					}
				}
			}
		}catch(Exception ex){
			
		}finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return status;
	}
	
	
	public boolean deleteProverb(int proverbID){
		String sql = "DELETE FROM PROVERB WHERE PROVERB_ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int i=0;
		try{
			 conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, proverbID);
			 i= ps.executeUpdate();
			 if(i>0){
				 return true;
			 }else{
				 return false;
			 }
		}catch(Exception ex){
			return false;
		}
		finally{
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
			
		}
	}
	
	
	public boolean approveProverb(int proverbID){
		String sql = "UPDATE PROVERB SET APPROVED = 1 WHERE PROVERB_ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int i=0;
		try{
			 conn = DBUtil.getConnection();
			 ps = conn.prepareCall(sql);
			 ps.setInt(1, proverbID);
			 i= ps.executeUpdate();
			 if(i>0){
				 return true;
			 }else{
				 return false;
			 }
		}catch(Exception ex){
			return false;
		}
		finally{
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
			
		}
	}
	
	
	public Proverb getProverb(int proverbID){

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proverb pBean = new Proverb();
		String value = null;
		
//		String sql = "SELECT P.PROVERB_ID, P.PROVERB, P.DESCRIPTION,U.NAME, U.PLACE FROM PROVERB P " +
//					"LEFT OUTER JOIN PROVERB_SUBMITTER_MAP PM ON P.PROVERB_ID = PM.PROVERB_ID " +
//					"LEFT OUTER JOIN USER U ON PM.USER_ID = U.USER_ID WHERE P.PROVERB_ID = ?";
		String sql = "SELECT PROVERB_ID, PROVERB, DESCRIPTION,submitter, submitter_place,language FROM PROVERB  " + "WHERE PROVERB_ID = ?";
		try{
		 conn = DBUtil.getConnection();
		 ps = conn.prepareCall(sql);
		 ps.setInt(1, proverbID);
  		 rs = ps.executeQuery();
		 if(rs!= null){
			while(rs.next()){
				
				pBean.setProverbID(Integer.parseInt(rs.getString("Proverb_id")));
				pBean.setProverb(rs.getString("proverb"));
				pBean.setDescription(rs.getString("description"));
				pBean.setSubmittedBy(rs.getString("submitter"));
				pBean.setSubmitterPlace(rs.getString("submitter_place"));
				pBean.setLanguage(rs.getString("language"));
			}
		 }
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		finally{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(ps);
			DBUtil.closeConnection(conn);
		}
		return pBean;
	}	
	
	
	private int getID(String sql,Connection conn) throws SQLException{
		int i=0;
		java.sql.PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				i= rs.getInt("ID");
			}
		}
		DBUtil.closeResultSet(rs);
		DBUtil.closeStatement(ps);
		return i;
	}
	public static final String utf8Convert(String utf8String) throws
	java.io.UnsupportedEncodingException {
	byte[] bytes = new byte[utf8String.length()];
	for (int i = 0; i < utf8String.length(); i++) {
	bytes[i] = (byte) utf8String.charAt(i);
	}
	return new String(bytes, "UTF-8");
	}
}
