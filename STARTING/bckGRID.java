public class bckGRID {

    public static int gridWays(int i,int j,int n,int m){
        //base case
        if(i==n-1 && j==m-1){// cond for lat cell
            return 1;
        }else if(i==n || j==n ){// boundry cross condition
            return 0;
        }
        int w1=gridWays(i+1, j, n, m);
        int w2=gridWays(i, j+1, n, m);
        return w1+w2;
    }
    public static void main(String[] args) {
        int n = 3;
         int m =3;
        System.out.println(gridWays(0, 0, n, m));

    }
    //this problem can be solved in linear time c omplexity
    // permuataion can be used (n-1+m-1)!/(n-1)!(m-1)! 
}
