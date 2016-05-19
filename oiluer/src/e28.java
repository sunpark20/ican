//spiral array

/**
 * Created by sun on 2016-04-29.
 */
public class e28 {
    public static void main(String args[]) {
        int arraySize=1001;
        int[][] array=new int[arraySize][arraySize];

        final int pushNum=arraySize;

        int num=arraySize*arraySize;
        int row=0, col=arraySize-1;
        int direction=0;
        // start
        while (true){
            if(num==0)
                break;
            if(direction==0 ){
                array[row][col]=num;
                col-=1;
                if(col==-1 || array[row][col]!=0){
                    direction=(direction+1)%4;
                    row+=1;
                    col+=1;
                }
            }else if(direction==1){
                array[row][col]=num;
                row+=1;
                if(row==arraySize || array[row][col]!=0){
                    direction=(direction+1)%4;
                    row-=1;
                    col+=1;
                }
            }else if(direction==2){
                array[row][col]=num;
                col+=1;
                if(col==arraySize || array[row][col]!=0){
                    direction=(direction+1)%4;
                    row-=1;
                    col-=1;
                }
            }else if(direction==3){
                array[row][col]=num;
                row-=1;
                if(row==-1 || array[row][col]!=0){
                    direction=(direction+1)%4;
                    row+=1;
                    col-=1;
                }
            }
            num-=1;
        }
        print(array);

        //add x shape
        int sum=0;
        //1
        row=0; col=0;
        while (true){
            if(array[row][col]==1)
                break;
            sum+=array[row++][col++];
        }
        //2
        row=0; col=arraySize-1;
        while (true){
            if(array[row][col]==1)
                break;
            sum+=array[row++][col--];
        }

        //3
        row=arraySize-1; col=0;
        while (true){
            if(array[row][col]==1)
                break;
            sum+=array[row--][col++];
        }

        //4
        row=arraySize-1; col=arraySize-1;
        while (true){
            if(array[row][col]==1)
                break;
            sum+=array[row--][col--];
        }
        sum+=1;
        System.out.println("");
        System.out.println(sum);

    }
    static void print(int[][] array){
        for(int[] a:array) {
            for (int b : a) {
                System.out.printf("%3d", b);
            }
            System.out.println("");
        }
    }
}
