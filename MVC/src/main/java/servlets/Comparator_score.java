package servlets;

import java.util.*;

import beans.Userscore;

public class Comparator_score implements Comparator{
	public int compare(Object arg0, Object arg1) {
		  Userscore user0=(Userscore)arg0;
		  Userscore user1=(Userscore)arg1;

		   

		  int flag=String.valueOf(user0.getScore()).compareTo(String.valueOf(user1.getScore()));
		  if(flag==0){
		   return (String.valueOf(user0.getId()).compareTo(String.valueOf(user1.getId())));
		  }else{
		   return flag;
		  }  
		 }

}
