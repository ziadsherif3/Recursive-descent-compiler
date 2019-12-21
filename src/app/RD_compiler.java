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

        if(V() == 0){
            System.out.print("FAIL");
            System.exit(0);
        }
        CHECK('=');
        E();
        System.out.print("STORE ");

    }

    public static void E(){

        if(LA == '-'){
            SCAN();
            T();
            System.out.print("NEG ");
        }
        else{
            T();
        }

        while(LA == '+' || LA == '-'){
            if(LA == '+'){
                SCAN();
                T();
                System.out.print("ADD ");
            }
            else{
                SCAN();
                T();
                System.out.print("SUB ");
            }
        }

    }

    public static void T(){
        
        F();

        while(LA == '*' || LA == '/'){
            if(LA == '*'){
                SCAN();
                F();
                System.out.print("MUL ");
            }
            else{
                SCAN();
                F();
                System.out.print("DIV ");
            }
        }

    }

    public static void F(){
        
        if(LA == '('){
            SCAN();
            E();
            CHECK(')');
        }
        else{
            if(C() == 0){
                if(V() == 1){
                    System.out.print("LOAD ");
                }
                else{
                    System.out.print("FAIL");
                    System.exit(0);
                }
            }
        }

    }

    public static int C(){
        
        if(LA >= '0' && LA <= '9'){
            System.out.print("LIT " + LA + " ");
            SCAN();
            return 1;
        }
        else{
            return 0;
        }

    }

    public static int V(){

        if(LA >= 'A' && LA <= 'Z'){
            System.out.print("LIT " + LA + " ");
            SCAN();
            return 1;
        }
        else{
            return 0;
        }

    }

}