package servlets;

import java.util.*;

import beans.Userscore;

public class Comparator_scoredown implements Comparator {
	public int compare(Object arg0, Object arg1) {
		  Userscore user0=(Userscore)arg0;
		  Userscore user1=(Userscore)arg1;

		   //首先比较年龄，如果年龄相同，则比较名字

		  int flag=-(String.valueOf(user0.getScore()).compareTo(String.valueOf(user1.getScore())));
		  if(flag==0){
		   return (String.valueOf(user0.getId()).compareTo(String.valueOf(user1.getId())));
		  }else{
		   return flag;
		  }  
		 }


}
