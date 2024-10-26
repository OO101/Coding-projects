#include <iostream>
#include <iomanip>
#include <string>
#include <cmath>
using namespace std;

//Establish a recursive call with two integer inputs.
int recur_exc(int m, int n)
{
    //Initalize the total.
    int total;

    //Check if m is equal to 0 and if n is greater than 0.
    if(m == 0 && n > 0){
    //Assign the total to the product of 1 + n.
        total = n + 1;
    }

    //Check if n is equal to 0 and if m is greater than 0
        if(n == 0 && m > 0)
        {
    //If it is then assign total to the product of m + 1.
            total = m + 1;
        }

    //Check if m is greater than 0 and if n is greater than 0.
        if(m > 0 && n > 0)
        {
        //If it is then assign total to the recursive calls.
            total=recur_exc(m-1,n)+recur_exc(m,n-1);
        }

    //Return the total when the program is finished.
        return total;
}
int main()
{
    //Initalize the two varibles m & n.
    int m,n;

    //Ask the user to input two numbers.
    cout << "Enter two numbers: ";
    cin >> m >> n;
    //Then output the finished multiplied numbers from the recursive call.
    cout << "F(" << m << " " << n << ")" << "=" << recur_exc(m,n) << endl;
    return 0;
}
