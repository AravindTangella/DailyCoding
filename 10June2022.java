Problem 1: Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. 
            You can assume b can only be 1 or 0.
Solution : 
            import java.util.Scanner;

            public class BitManupulation {
                public static void main(String[] args) {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Enter x");
                    int x = sc.nextInt();

                    System.out.println("Enter y");
                    int y = sc.nextInt();

                    System.out.println("Enter b");
                    int b = sc.nextInt();

                    System.out.print("Result : ");
                    if((b&1) == 1) //Checking if the 0th bit is 1 or 0, if it is 1 then it returns x else y.
                        System.out.println(x);
                    else
                        System.out.println(y);
                }
            }
