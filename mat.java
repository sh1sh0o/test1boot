public class mat {
    public static boolean isContained(int[][] a, int[][] b){
        boolean flag=false;
        for(int i=0;i<a.length&&flag==false;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==b[0][0]&&i<=30&&j<=30){
                    if(isContained(i,j,a,b))
                        flag=true;
                }
            }
        }
        return flag;
    }

    private static boolean isContained(int i,int j,int[][]a,int[][]b){
        boolean flag=true;
        for (int h=0;flag==true&&i<a.length&&j<a[0].length;h++,i++){
            for (int k=0;flag==true&&i<a.length&&j<a[0].length;k++,j++){
                if(a[i][j]!=b[i][j])
                    flag=false;
            }
        }
        return flag;
    }

}
