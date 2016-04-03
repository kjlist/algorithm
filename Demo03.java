import java.util.Random;

/**
 * Created by laoli on 16/3/23.
 */
public class Demo03 {
    public static void quickSort(int a[],int p,int r){
        if (p<r){
            int q=partition(a,p,r);
            //两个递归容易写错
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int key=a[r];
        int i=p-1;
        int temp;
        for (int j=p;j<r;j++){
            if (a[j]<=key){
                i++;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        //忘记交换了!
        temp=a[r];
        a[r]=a[i+1];
        a[i+1]=temp;
        return i+1;
    }
//    Random rand = new Random();
//int index = rand.nextInt(length) + start;
public static void rquickSort(int a[],int p,int r){
    int q;
    if (p<r){
        q=rpartition(a,p,r);
        //两个递归容易写错
        rquickSort(a,p,q-1);
        rquickSort(a,q+1,r);
    }
}

    public static int rpartition(int[] a, int p, int r) {
        //
        Random random=new Random();
        int index=random.nextInt(a.length-2)+1;
        //是因为index完全随机?
        int temp1;
        temp1=a[index];
        a[index]=a[r];
        a[r]=temp1;
//        int key=a[r];
//        int i=p-1;
//        for (int j=p;j<r;j++){
//            if (a[j]<=key){
//                i++;
//                temp=a[i];
//                a[i]=a[j];
//                a[j]=temp;
//            }
//        }
        //忘记交换了!
//        temp=a[r];
//        a[r]=a[i+1];
//        a[i+1]=temp;
//        return i+1;
        return partition(a,p,r);
    }
    public static void main(String[]args){
        int []a={0,5,3,17,10,84,19,6,22,9};
//        quickSort(a,1,a.length-1);
//        //很多时候要从下标1开始
//        for (int i:a){
//            System.out.println(i);
//        }
        quickSort(a,1,a.length-1);
        for (int i:a){
            System.out.println(i);
        }
    }
}


