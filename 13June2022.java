Problem : Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
  
Solution : class Solution {
              public int divide(int dividend, int divisor) { 
                  long a = dividend, b = divisor;
                  int sign = 0;//It indicates the sign of the quotient

                  if(a < 0 ^ b < 0)
                      sign = 1;

                  a = Math.abs(a);
                  b = Math.abs(b);

                  long divided = 0;//It is the value that has been divided from dividend by divisor
                  long quotient = 0;//It is the quotient that the (divided) value is divided by.

                  for(int i = 31; i >= 0; i--) {
                      //We check if (b*2^i) is less than 'a' which then can be divided.
                      if(divided+(b<<i) <= a) {
                          divided += (b<<i);
                          quotient += ((long)1<<i);
                      }
                  }

                  if(sign == 1)//1 indicates one of divisor and dividend is negative so quotient will be negative
                      quotient = -quotient;

                  if(quotient > Integer.MAX_VALUE)
                      return Integer.MAX_VALUE;

                  if(quotient < Integer.MIN_VALUE)
                      return Integer.MIN_VALUE;

                  return (int)quotient;
              }
          }
