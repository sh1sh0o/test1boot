import java.util.Scanner;

public class sin {
    public static void main(String[] args) {


    Scanner s=new Scanner(System.in);
    String name=s.nextLine();
    Long id=s.nextLong();
    int tens=(int)(id%100)/10;
    int ones=(int)(id%10);
    int devider=10;
    for(int i=0;i<tens;i++){
        devider*=10;
    }
    Long id2=id;
    id2/=devider;
    id%=devider;
        System.out.println("name:"+name+" id:"+id2+ones+id);

}
 }