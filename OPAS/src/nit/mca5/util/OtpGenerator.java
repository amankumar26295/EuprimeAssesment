package nit.mca5.util;

import java.util.Random;

public class OtpGenerator {

	public OtpGenerator() {
		// TODO Auto-generated constructor stub
	}
	
	public static int generateOtp(){
		
		Random rand = new Random();
		int num=rand.nextInt(100000)+1000;
		
		return num;
	}
}
