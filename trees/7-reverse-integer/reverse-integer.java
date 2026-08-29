class Solution {
    public int reverse(int x) {
    int num=x;
    long rev=0;
    while(num!=0)
    {int rem=num%10;
        rev=rev*10+rem;
        num/=10;
    }
    if(rev>Integer.MAX_VALUE||rev<Integer.MIN_VALUE)return 0;
    return (int)rev;
    }
}