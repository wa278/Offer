/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution11 {
    public double Power(double base, int exponent) {
        if(exponent < 0){
            return  1 / multi(base,-exponent);
        }
        else if (exponent ==0){
            return  1;
        }
        else {
            return multi(base,exponent);
        }
    }
    public double multi(double base,int exponent){
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return  base;
        }
        if((exponent & 1) == 0){
            double result = multi(base,exponent >>1) ;
            return result*result;
        }
        else {
            double result = multi(base,exponent>>1);
            return result*result*base;
        }
    }
}
