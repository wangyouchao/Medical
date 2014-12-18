package testOne;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int vNum;
	static int eNum ;
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		vNum = scanner.nextInt();
		eNum = scanner.nextInt();
		boolean[][] matrix = new boolean[vNum][vNum];
		
		//初始化边数组
		for(int i=0;i<eNum;i++){
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			matrix[start-1][end-1] = true;
		}
		
		ArrayList<Squ> list = new ArrayList<Squ>();
		for(int i = 0;i < vNum;i++){
			Squ s = new Squ(vNum+1);
			s = computCircle(matrix,vNum,i,s);
			if(!list.contains(s)){
				list.add(s);
			}
		}
		System.out.println(list.size());
	}
	
	private static Squ computCircle(boolean[][] matrix,int time,int startV,Squ squ){
		if(time <=0) return squ;
		for(int i=0;i<vNum;i++){
			if(matrix[startV][i]){
				if(squ.set(vNum-time,i)){
					computCircle(matrix, time-1, i, squ);
				}else{
					continue;
				}
			}
		}
		return null;
	}
}

class Squ{
	int[] l ;
	public Squ(int i){
		if(i <=0 ) throw new NullPointerException();
		l = new int[i];
	}
	public boolean set(int index,int value){
		for(int i=0;i<index-1;i++){
			if(l[i]== value) return false;
		}
		l[index] = value;
		return true;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Squ){
			Squ s = (Squ)obj;
			int[] sL =s.l;
			if(l.length != sL.length) return false;
			int count = 0;
			int d = 0;
			for(int i = 0 ;i< sL.length;i++){
				if(sL[i] == l[0]){
					d = i;
					break;
				}
			}
			for(int i = 0 ;i< sL.length;i++){
				if(l[i] == sL[(i+d)%sL.length]){
					count ++;
				}
			}
			if(count == sL.length){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
}
