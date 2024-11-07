package com.hms;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        //1234
        Scanner scan = new Scanner(System.in);
        for(int i = 0;i<3;i++){//0 to 2 times
            System.out.println("Enter the pin number: ");
            int pinNumber = scan.nextInt();
            if(pinNumber==1234){
                System.out.println("Welcome");
                break;
            }else{
                System.out.println("Invalid pin number");
            }
        }
    }
}
