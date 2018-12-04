package dao;

import java.sql.*;
import java.util.*;

import beans.User;
import beans.Userscore;

public class UserDAO {
	
	public static final String DRIVER="org.gjt.mm.mysql.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/db1";
	public static final String DBUSER="root";
	public static final String DBPASS="cc111";
	private Connection conn=null;
	private PreparedStatement pStat=null;
	private ResultSet rs=null;
	public Connection getConnectionn(){
	try{
	Class.forName(DRIVER).newInstance();
	return DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	}
	catch(Exception e){
	   return null;
	}
	
	}
	
	public void close(){
		try{
		if( rs!=null ) rs.close();
		if( pStat!=null ) pStat.close();
		if( conn!=null ) conn.close();
		}catch(Exception e){ e.printStackTrace(); }
		} //end close
		public boolean isUsernameExists(String username) {
		conn=getConnectionn();
		try {
		pStat =conn.prepareStatement("select * from users where username=?");
		pStat.setString(1, username);
		rs=pStat.executeQuery();
		if( rs.next() ) return true;
		else return false;
		}catch (Exception e) { return false; }
		finally{ close(); }
	} //end isUsernameExists
	
		public boolean findUser(String username, String password){      //student
			conn=getConnectionn();
			try {
			pStat =conn.prepareStatement("select * from users where username=? and password=?");
			pStat.setString(1, username);
			pStat.setString(2, password);
			rs=pStat.executeQuery();
			if( rs.next() ) return true;
			else return false;
			}
			catch (Exception e) { return false; }
			finally{
			close();
			}
		} //end findUser
		
		
		public boolean findUser1(int id){      
			conn=getConnectionn();
			try {
			pStat =conn.prepareStatement("select * from scores where id=?");
			pStat.setInt(1, id);
			rs=pStat.executeQuery();
			if( rs.next() ) return true;
			else return false;
			}
			catch (Exception e) { return false; }
			finally{
			close();
			}
		} //end findUser
		
		
		
		public boolean findUser_tec(String username, String password){
			conn=getConnectionn();
			try {
			pStat =conn.prepareStatement("select * from teachers where username=? and password=?");
			pStat.setString(1, username);
			pStat.setString(2, password);
			rs=pStat.executeQuery();
			if( rs.next() ) return true;
			else return false;
			}
			catch (Exception e) { return false; }
			finally{
			close();
			}
		} //end findUser
		
		public boolean addUser(User user) {
			conn=getConnectionn();
			try {
			pStat=conn.prepareStatement("insert into users values(null,?,?)");
			pStat.setString(1, user.getUsername());
			pStat.setString(2, user.getPassword());
			int cnt=pStat.executeUpdate();
			if(cnt>0) return true;
			else return false;
			}
			catch (Exception e) { return false; }
			finally{
			close();
			}
		} //end add
		
		
		public List<User> getAllUsers() {
			List<User> tmp_list = new ArrayList<User>();    // 结果集存放在List集合中
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("select * from users");
				rs = pStat.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String username = rs.getString("username");
					String password = rs.getString("password");
					tmp_list.add(new User(id, username, password));
				}
				return tmp_list;
			} catch (Exception e) {
				return null;
			} finally {
				close();
			}
		}
		
		
		
		public boolean delUserById(int id) {
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("delete from users where id=?");
				pStat.setInt(1, id);
				int cnt= pStat.executeUpdate();	
				PreparedStatement pStat1 = conn.prepareStatement("delete from scores where id=?");
				pStat1.setInt(1, id);
				int cnt1= pStat1.executeUpdate();
				
				if(cnt>0&&cnt1>0) 
					return true;
				else 
					return false;
			} catch (Exception e) {
				return false;
			} finally {
				close();
			}
		}
		
		
		public User getUserById(int id) {
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("select * from users where id=?");
				pStat.setInt(1, id);
				rs= pStat.executeQuery();	
				if(rs.next()) {
					User user=new User(
							rs.getInt("id"),
							rs.getString("username"),
							rs.getString("password")
							);				
					return user;
				}
				else 
					return null;
			} catch (Exception e) {
				return null;
			} finally {
				close();
			}
		}
		
		public User getUserBynameandpass(String name,String password) {
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("select * from users where username=? and password=?");
				pStat.setString(1, name);
				pStat.setString(2, password);
				rs= pStat.executeQuery();	
				if(rs.next()) {
					User user=new User(
							rs.getInt("id"),
							rs.getString("username"),
							rs.getString("password")
							);				
					return user;
				}
				else 
					return null;
			} catch (Exception e) {
				return null;
			} finally {
				close();
			}
		}
		
		
		
		public List<Userscore> getUserByUsername(String username1) {
			List<Userscore> tmp_list = new ArrayList<Userscore>();    // 结果集存放在List集合中
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("select id from users where username=?");
				pStat.setString(1, username1);
				rs = pStat.executeQuery();
				int id1 = 0;
				while (rs.next()) {id1 = rs.getInt("id");
				
				PreparedStatement pStat1 = conn.prepareStatement("select * from scores where id=?");
				pStat1.setInt(1, id1);
				ResultSet rs1 = pStat1.executeQuery();
				while (rs1.next()) {
					int id = rs1.getInt("id");
					String username = username1;
					//String password = rs1.getString("password");
					int sc = rs1.getInt("score");
					tmp_list.add(new Userscore(id, username, sc));
				}
				
				}
				return tmp_list;
			} catch (Exception e) {
				return null;
			} finally {
				close();
			}
		}
		
		
		public List<Userscore> getUserByScore(int score1,int score2) {
			List<Userscore> tmp_list = new ArrayList<Userscore>();    // 结果集存放在List集合中
			conn = getConnectionn();
			try {
				pStat = conn.prepareStatement("select * from scores where score >=? and score <=?");
				pStat.setInt(1, score1);
				pStat.setInt(2, score2);
				rs = pStat.executeQuery();
				
				int id1 = 0;
				int sco = 0;
				while (rs.next()) {
					id1 = rs.getInt("id");
					sco = rs.getInt("score");
				    //name1 = rs.getString("username");
				PreparedStatement pStat1 = conn.prepareStatement("select username from users where id=?");
				pStat1.setInt(1, id1);
				ResultSet rs1 = pStat1.executeQuery();
				while (rs1.next()) {
					//int id = id1;
					String username = rs1.getString("username");
					//String password = rs1.getString("password");
					//int sc = sco;
					tmp_list.add(new Userscore(id1, username, sco));
				}
				
				}
				return tmp_list;
			} catch (Exception e) {
				return null;
			} finally {
				close();
			}
				
		}
		
		
		public boolean UpdateUser(User user) {
			conn = getConnectionn();
			try {
			pStat = conn.prepareStatement("Update users set username=?,password=? where id=?");
				pStat.setString(1, user.getUsername());
				pStat.setString(2, user.getPassword());
				pStat.setInt(3, user.getId());			
				int cnt= pStat.executeUpdate();	
				if(cnt>0)
					return true;
				else 
					return false;
			} catch (Exception e) {
				return false;
			} finally {
				close();
			}
		}
		
		public boolean Updatescore(int id,int score) {
			conn = getConnectionn();
			
			try {
				
			    pStat = conn.prepareStatement("Update scores set score=? where id=?");
			    pStat.setInt(1,score);	
				pStat.setInt(2,id);		
			    int cnt= pStat.executeUpdate();																	
				
				if(cnt>0)
					return true;
				else 
					return false;
			} catch (Exception e) {
				return false;
			} finally {
				close();
			}
		}
		
		
		public boolean Insertscore(int id,int score) {
			conn = getConnectionn();			
			try {
			    pStat = conn.prepareStatement("insert into scores values (?,?)");
			    pStat.setInt(1,id);	
				pStat.setInt(2,score);		
			    int cnt= pStat.executeUpdate();																				
				if(cnt>0)
					return true;
				else 
					return false;
			} catch (Exception e) {
				return false;
			} finally {
				close();
			}
		}
		
		
		
} //end class


