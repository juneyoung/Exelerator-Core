package org.owls.excelerator.formula.math;

//ROUNDDOWN
//ROUNDUP
//SUM
//SUMIF
//TRUNC
//CEILING
//COUNTIF
//EVEN
//FLOOR
//INT
//MROUND
//ODD
//POWER
//QUOTIENT
//RAND
//RANDBETWEEN
//SQRT
//SUBTOTAL
//SUMPRODUCT
//SUMSQ
//SUMX2MY2
//SUMX2PY2
//SUMXMY2
//ACOS
//ACOSH
//ASIN
//ASINH
//ATAN
//ATAN2
//ATANH
//COMBIN
//COS
//COSH
//DEGREES
//EXP
//FACT
//FACTDOUBLE
//GCD
//LCM
//LN
//LOG
//LOG10
//MDETERM
//MINVERSE
//MMULT
//MULTINOMIAL
//RADIANS
//ROMAN
//SIGN
//SIN
//SINH
//SQRTPI
//TAN
//TANH
//SERIESSUM
public class MathFormula {
	
	//ABS
	public static double abs(double dbl){return Math.abs(dbl);}
	
	//MOD
	public static int mod(int dividend, int divisor){return dividend % divisor;}
	
	//PI
	public static double pi(){return Math.PI;}
	
	//PRODUCT
	public static double product(double ... params){
		double ret = 1;
		for(int i = 0; i < params.length; i++){ ret = ret*params[i]; }
		return ret;
	}
	
	//ROUND
	public static double round(double num, int num_digits){
		double inter = Math.pow(10, num_digits + 1);
		inter = Math.floor(inter * num);
		inter = inter/10;
		long inter_long = Math.round(inter);
		return inter_long / Math.pow(10, num_digits);
	}

};