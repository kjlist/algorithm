/**
 * Created by laoli on 16/3/29.
 */
public class Demo04 {
    public static int[] count_sort(int[]a,int k){
        //a中的所有的值介于都是0-k的整数
        int[]c=new int[k+1];
        //new出来的等于0?是的哦
        int[]b=new int[a.length];
        for (int i=1;i<a.length;i++){
            c[a[i]]++;
        }
        //
        for (int i=1;i<=k;i++){
            c[i]=c[i]+c[i-1];
        }
        //c[i]存的值是小于等于i的数目
        for(int i=a.length-1;i>=1;i--){
            b[c[a[i]]]=a[i];
            c[a[i]]--;
            //???
        }
        return b;
    }
    //基数排序   下次再写
//    public static void radix_sort(int[]a,int d){
//        for (int i=1;i<=d;i++){
//            int value=10^(i-1);
//        }
//    }
    //桶排序

    //选择排序??冒泡排序?
    public static void select_sort(int []a){
        int temp;
        for (int i=0;i<a.length-1;i++){
            for (int j=i;j<=a.length-1;j++){
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }


    public static void main(String[]args){
//        int []a={0,2,5,3,0,2,3,0,3};
//        int []b=count_sort(a,5);
//        for (int i :
//                b) {
//            System.out.println(i);
//        }
        int []a={0,2,5,3,0,2,3,0,3};
        select_sort(a);
        for (int i :
                a) {
            System.out.println(i);
        }
    }
}
