#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
using namespace std;
int recur_exc(int m, int n)
{
    int total;
    if(m==0&&n>0){
        total=n+1;
    }
        if(n == 0 && m >0)
        {
            total = m + 1;
        }
        if(m>0&&n>0)
        {
            total=recur_exc(m-1,n)+recur_exc(m,n-1);
        }
        return total;
}
int main()
{
    int m,n;
    cout << "Enter two numbers: ";
    cin >> m >> n;
    cout << "F(" << m << " " << n << ")" << "=" << recur_exc(m,n) << endl;
    return 0;
}
