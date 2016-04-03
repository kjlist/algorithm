/**
 * Created by laoli on 16/3/22.
 *
 */
public class Demo01 {
        private static boolean flag=false;
    private static boolean haveSumIsX(int [] s,int x){
        //先对s进行归并排序
        merge_sort(s,0,s.length-1);
        for (int i = 0; i < s.length; i++) {
            halfFind(s,x-s[i],0,s.length-1);
        }
        //再进行折半查找
        return flag;
    }


    private static void merge_sort(int [] s,int p,int r){
        if (p<r){
            int q=(p+r)/2;
            merge_sort(s,p,q);
            merge_sort(s,q+1,r);
            merge(s,p,q,r);
        }
    }

    private static void merge(int[]s,int p,int q,int r) {
        int n1=q-p+1;
        int n2=r-q;
        int []L=new int[n1+2];
        int []R=new int[n2+2];
        int i=1;
        int j=1;
        for (i=1;i<=n1;i++)
        {
            L[i]=s[p+i-1];
        }
        L[n1+1]=9999;//正无穷怎么表示
        for (j=1;j<=n2;j++){
            R[j]=s[q+j];
        }
        R[n2+1]=9999;
        j=i=1;
        for (int k=p;k<=r;k++){
            if (L[i]<R[j]){
                s[k]=L[i];
                i++;
            }
            else {
                s[k]=R[j];
                j++;
            }
        }

    }


    private static void halfFind(int[] s, int x,int low,int high) {
        int middle;
        if (low<high){
            middle=(low+high)/2;
            if (s[middle]<x){
                low=middle+1;
                halfFind(s,x,low,high);
            }
            else if (s[middle]>x){
                high=middle-1;
                halfFind(s,x,low,high);
            }
            else {
                flag=true;
            }
        }
    }
    public static void main(String []args){
        int []s=new int[]{8,9,6,4,3,2,1};
        merge_sort(s,0,s.length-1);
        for(int i:s){
        System.out.print(i);
        }
        System.out.println();
        System.out.println(haveSumIsX(s,17));
    }
}
