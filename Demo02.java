
/**
 * Created by laoli on 16/3/23.
 */
public class Demo02 {
    private static int len;
    public static void max_heapify(int[]a,int i){
        int l=2*i;
        int r=2*i+1;
        int largest=i;
        int temp;
        if (l<=len)
        {
            if (a[l]>a[i]){

            largest=l;
            }
        }
        //l,r>a.length就不行?
//        if (r<=a.length-1&&a[r]>a[largest]){
//            largest=r;
//        }
        if (r<=len)
            //sort时不能一直等于length,所以需要heap_size!!!
        {
            if (a[r]>a[largest]){

                largest=r;
            }
        }
        if (largest!=i){
            temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            max_heapify(a,largest);
        }
    }
    public static void build_max_heap(int[]a){
        len=a.length-1;
        for (int i=(a.length-1)/2;i>=1;i--){
            max_heapify(a,i);
        }
    }
    public static void heapsort(int[]a){
        build_max_heap(a);
        int temp;
        for (int i=len;i>=2;i--){
            temp=a[1];
            a[1]=a[i];
            a[i]=temp;
            len--;
            max_heapify(a,1);
        }
    }
    //最大优先级队列要求
    public static void insert(int[]a,int x){
        //考虑heapsize和length的关系
        len=a.length-1;
        len++;
        int[]b=new int[a.length+5];
        for (int i:a){
            b[i]=a[i];
        }
        b[a.length]=x;
        heapsort(b);

    }
    public static int maximum(int[]a){
//        int [] b =new int[a.length];
//        for (int i:a){
//            b[i]=a[i];
//        }
        int []b=a;
        heapsort(b);
        return b[b.length-1];
    }
    public static int extract_max(int[]a){
        heapsort(a);
        int max;
        max=a[1];
        a[1]=a[a.length-1];
        //还需要heapsize--此处就不考虑了
        max_heapify(a,1);
        return max;
    }
    public static void increase_key(int[]a,int x,int k){
        //heapsort(a);
        //找到
        //heapsort(a);
        //x为下标的时候
        if (k<x){
            System.out.println("错了");
            return;
        }
        a[x]=k;
        //heapsort(a);
    }
    public static void main(String[]args){
        int []a={0,5,3,17,10,84,19,6,22,9};
        build_max_heap(a);
//        for (int i:a){
//            System.out.println(i);
//        }
        heapsort(a);
        for (int i:a){
            System.out.println(i);
        }
    }
}
