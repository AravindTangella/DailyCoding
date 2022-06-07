Problem 1: Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.
 
          For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
  
Solution : public class DataFile {
              String data = "Breaking Bad is the best ever web series I have watched.";
              int head = 0; //Points to an index from which the current reading starts
              int lengthOfData = data.length();

              public String read7() {
                  String s = "";// Stores the current set of characters.

                  if(head >= lengthOfData)
                      return s;
                  //Starting from head if data has 7 or more characters then return 7 characters else return existing characters
                  s = data.substring(head, Math.min(head+7, lengthOfData));
                  //Pointing head to (head+7)th index after reading head+7 characters or existing characters if 7 characters are not present.
                  head += 7;

                  return s;
              }
          }

          import java.util.Scanner;

          public class FileReader {
              public static String readN(int n) {
                  String ans = "";//Stores n characters those are read.

                  DataFile dataFile = new DataFile();

                  int noOfCharsRead = 0;

                  while(noOfCharsRead+7 < n) {
                      ans += dataFile.read7();
                      noOfCharsRead += 7;
                  }

                  if(noOfCharsRead < n) {
                      String s = dataFile.read7();
                      ans += s.substring(0, n-noOfCharsRead);
                  }

                  return ans;
              }

              public static void main(String[] args) {
                  Scanner sc = new Scanner(System.in);
                  while (true) {
                      System.out.println("Choose\n\t1. Read characters from the file\n\t2. Exit");
                      int choice = sc.nextInt();
                      if(choice == 1) {
                          System.out.println("Enter no.of characters you want to read");
                          int n = sc.nextInt();
                          System.out.println(readN(n));
                      }
                      else
                          System.exit(0);
                  }
              }
          }

