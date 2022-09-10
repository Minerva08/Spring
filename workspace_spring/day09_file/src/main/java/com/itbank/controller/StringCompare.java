package com.itbank.controller;

import java.util.Scanner;

public class StringCompare {
	public static void main(String[] args) {	// char[], char* 
		
		Scanner sc = new Scanner(System.in);
		
		String word1 = "apple";				// 메모리에 "apple"이라는 상수를 만들고 그 주소를 word1에 저장
		String word2 = "apple";				// 이미 "apple"이라는 상수가 있으니, 그 주소를 똑같이 저장
		String word3 = new String("apple");
		System.out.print("apple 이라고 입력 : ");
		String word4 = sc.nextLine();		// 사용자가 apple이라고 입력한다는 보장이 없다
		
		System.out.println(word1 == word2);	// 참조변수끼리 == 는 바라보는 대상이 일치하는가를 비교한다
		System.out.println(word1 == word3);	// 내용이 일치하는지 확인하려면 word1.equals(word3)
		System.out.println(word1 == word4);	// 대소문자 구분없이 하려면 word1.equalsIgnoreCase(word4)
		
		// 1) 코드에서 만든 모든 데이터는 메모리 상에 존재한다
		// 2) 변수형태로 존재하거나, 상수(리터럴)형태로 존재할 수 있다
		// 3) 자바는 한번 사용한 상수가 있다면, 참조변수를 같은 값으로 넣어준다
		
		sc.close();
	}
}
