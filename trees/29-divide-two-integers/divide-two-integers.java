class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor ==-1)return Integer.MAX_VALUE;
        if(divisor==1)return dividend;
        long num1=Math.abs((long)dividend);
        long num2=Math.abs((long)divisor);
        long quotient=0;
        while(num1>=num2)
        {
            long temp=num2;
            long multiply=1;
            while(num1>=(temp<<1))
            {
                temp<<=1;
                multiply<<=1;
            }
            num1-=temp;
            quotient+=multiply;
        }
        if(quotient>Integer.MAX_VALUE)return Integer.MAX_VALUE;
        if(quotient<Integer.MIN_VALUE)return Integer.MIN_VALUE;
        return (dividend<0^divisor<0)?-((int)quotient):(int)quotient;


        
    }
}