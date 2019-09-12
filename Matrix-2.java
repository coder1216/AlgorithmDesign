//{}
//0
//0 0 
//0 0 0

class Solution{
    public int[][] Matrix(int n){
        for(int i = 0; i < n; i++){
            int[i] Matrix = new int[n]; 
        }
        return Matrix;
    }
}

//0 0 0
//0 0
//0
//{}

class Solution{
    public int[][] Matrix(int n){
        for(int i = 0; i < n; i++){
            int[i] Matrix = new int[n - i];
        }
    }
}

