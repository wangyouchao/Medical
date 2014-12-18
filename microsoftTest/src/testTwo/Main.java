package testTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Main {
	private static int cacheSize;
	private static LinkedList<String> cache = new LinkedList<String>();
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int pageNum = scanner.nextInt();
		ArrayList<String> inputs = new ArrayList<String>(pageNum);
		cacheSize = scanner.nextInt();
		
		
		for(int i = pageNum;i>0;i--){
			inputs.add(scanner.next());
		}
		
		for(int i = 0;i<pageNum;i++){
			String url = inputs.get(i);
			if(isFound(url)){
				System.out.println("Cache");
			}else{
				System.out.println("Internet");
			}
		}
	}
	
	private static boolean isFound(String url){
		int size = cache.size();
		if(cache.contains(url)){
			if(cache.remove(url)){
				cache.add(size-1, url);
			}
			return true;
		}else{
			if(size < cacheSize){
				cache.add(url);
			}
			if(size == cacheSize){
				if(cache.removeFirst() != null){
					cache.add(url);
				}
			}
			return false;
		}
	}
	
}
