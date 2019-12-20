package app;

import java.util.Scanner;

public class RD_compiler {
    
    static StringBuilder input;
    static char LA;
    static int pointer = 0;
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);
        input = new StringBuilder(s.nextLine());
        input.append('$');
        // System.out.println(input);
        
        SCAN();
        A();
        
        if(LA == '$'){
            System.out.println("ACCEPT");
        }
        else{
            System.out.println("FAIL");
        }

        s.close();

    }

    public static void SCAN(){

        LA = input.charAt(pointer++);
        // System.out.println(LA + String.valueOf(pointer));

    }

    public static void CHECK(char token){
        
        if(LA == token){
            SCAN();
        }
        else{
            System.out.println("FAIL");
            System.exit(0);
        }

    }

    public static void A(){

    }

    public static void E(){
        
    }

    public static void T(){
        
    }

    public static void F(){
        
    }

    public static void C(){
        
    }

    public static void V(){
        
    }

}