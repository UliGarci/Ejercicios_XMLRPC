package server;

import java.util.Arrays;

public class Methods {
    public Object resultados(double num1, double num2, double num3, double num4){
            double prod=num1*num2*num3*num4;
            double sum=num1+num2+num3+num4;
            double prom=sum/4;
            Object[] result={prod,sum,prom};
        return result;
    }
//ULISES DANIEL GARCÍA MÉNDEZ
    public int sum(int num1, int num2){
        int tot=0;
        while(num1<num2){
            num1++;
            if(num1!=num2){
                tot+=num1;
            }
        }
        return tot;
    }

    public Object[] arreglo(Object[] num){
        Arrays.sort(num);
        return num;
    }
}
