class Solution {
public:

int trailingZeroes(int n) {
    if(n==0){
        return 0;
    }
    long k=5;
    int res=0;
    
    while(n/k && k<=n){
    res+=n/k;
    k*=5;
    }
    return res;
}
};
