import java.util.Scanner;

public class coun {
    public  static double f(){
        Scanner scan=new Scanner(System.in);
        double x=scan.nextDouble();
        double n=scan.nextDouble();
        boolean flag=true;
        int pow=2;
        int num=0;
        for(int i=1;i<=n;i++){
            if(flag){
                num+=(Math.pow(x,pow))/foo(i);
                flag=false;

            }
            else{
                num-=(Math.pow(x,pow))/foo(i);
                flag=true;
            }
            pow+=2;
        }
return num;
    }

    public static double foo(int i){

        double num=1;
        for(int j=1;j<=i;j++){
            num*=j;
        }
        return num;
    }
}
