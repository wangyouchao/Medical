package microsoftTest;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int testCaseNum = s.nextInt();
		while(testCaseNum > 0){
			int len = s.nextInt();
			String str = s.next();
			if(str.length() < 3){
				System.out.println("NO");
				testCaseNum--;
				continue;
			}
			char pre = str.charAt(0);
			str = str.substring(1);
			int matchCount = count(pre,str);
			if(matchCount >= 3){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			testCaseNum--;
		}
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
	}
	
	private static int count(char pre ,String str){
		int len = str.length();
		if(len == 0) 
			return 1;
		char start = str.charAt(0);
		if(pre+1 == start){
			return 1+ count(start , str.substring(1));
		}
		if(pre >= start){
			return count(start , str.substring(1));
		}
		return 0 ;
	}
}
