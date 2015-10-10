package SmartLight.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import SmartLight.db.DBConnect;
import SmartLight.dao.UserDao;
import SmartLight.vo.User;

public  class UserDaoImpl implements UserDao {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userinfo where username=?";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
  
        // ������������ݿ�ľ������   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
            pstmt = dbc.getConnection().prepareStatement(sql) ; 
            pstmt.setString(1,user.getUsername()) ;     
            // �������ݿ��ѯ����   
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){   
                // ��ѯ�����ݣ�֮�󽫲�ѯ�������ݸ�ֵ��person����   
                if(rs.getString("password").equals(user.getPassword())){
                	flag = 1;
              } 
            }   
            rs.close() ; 
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
		return flag;
	}

	public void registerNewUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO userinfo(username,password,address,mail_address,phone_number)values(?,?,?,?,?)"; 
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;   
   
        try{   
            // �������ݿ�   
            dbc = new DBConnect() ;   
           pstmt = dbc.getConnection().prepareStatement(sql) ; 
           pstmt.setString(1,user.getUsername()) ; 
           pstmt.setString(2,user.getPassword()) ; 
           pstmt.setString(3,user.getAddress()) ; 
           pstmt.setString(4,user.getE_mail()) ;
           pstmt.setString(5,user.getPhone()) ;
            // �������ݿ���²���   
            pstmt.executeUpdate();
           
          
            pstmt.close() ;   
        }catch (SQLException e){   
            System.out.println(e.getMessage());   
        }finally{   
            // �ر����ݿ�����   
            dbc.close() ;   
        }   
	
	}	
		 
  
     }
	

