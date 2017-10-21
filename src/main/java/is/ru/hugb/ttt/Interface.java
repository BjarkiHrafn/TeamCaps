package is.ru.hugb.ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Interface{
	
	// Test
	public static String helloWorld(){
		return "Hello world!";
	}
	
	public static  void main(String[] args){
		int age = 0;

	
		Scanner in = new Scanner(System.in);
        System.out.println("Enter Age:" );  
        age = in.nextInt();
        System.out.println("Age accepted " + age);
	}
}