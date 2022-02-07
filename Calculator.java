package com.company.Day5;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int a, b=0;

        System.out.println("Welcome to calculator!");
        System.out.println("Please chose what operation you wish to do:1)Addition 2)Subtraction 3) Multiplication 4) Division");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();

            switch(input){
                case 1:
                    System.out.println("Addition");
                    break;
                case 2:
                    System.out.println("Subtraction");
                    break;
                case 3:
                    System.out.println("Multiplication");
                    break;
                case 4:
                    System.out.println("Division");
                    break;


            }
            if(input==1){
                System.out.println("You chose Addition");
                System.out.println("Please input first number \n ");
                a= scanner.nextInt();
                System.out.println("Please enter second number \n");
                 b= scanner.nextInt();
                 int c= a+b;
                System.out.println("Result: "+ c);
            }else if(input==2){
                System.out.println("You chose Subtraction");
                System.out.println("Please input first number \n ");
                a= scanner.nextInt();
                System.out.println("Please enter second number \n");
                b= scanner.nextInt();
                int c= a-b;
                System.out.println("Result: "+ c);
            }else if(input==3){
                System.out.println("You chose Multiplication");
                System.out.println("Please input first number \n ");
                a= scanner.nextInt();
                System.out.println("Please enter second number \n");
                b= scanner.nextInt();
                int c= a*b;
                System.out.println("Result: "+ c);
            }else if(input==4){
                System.out.println("You chose Division");
                System.out.println("Please input first number \n ");
                a= scanner.nextInt();
                System.out.println("Please enter second number \n");
                b= scanner.nextInt();
                int c= a/b;
                System.out.println("Result: "+ c);
            }

        }

}
