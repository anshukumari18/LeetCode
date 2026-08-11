class Solution {
    public int divide(int dividend, int divisor) {
        // System.out.println(-2147483648<<3);
        // System.out.println(Integer.toBinaryString(-1<<0));
        int quotient = 0;
        int sign = 1;
        int max = Integer.MAX_VALUE,  min = Integer.MIN_VALUE;
        if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)sign = -1;
        if(dividend > 0)dividend = -dividend;
        if(divisor > 0)divisor = -divisor;
        while(dividend <= divisor){
            int shift = 1;
            while((divisor<<shift) < divisor && dividend <= (divisor<<shift))shift++;
            quotient -= 1<<(shift-1);
            // System.out.println(quotient+"-"+shift);
            dividend -= divisor<<(shift-1);
        }
        if(sign == 1){
            if(quotient == min)return max;
            return -quotient;
        }else{
            return quotient;
        }
    }
}