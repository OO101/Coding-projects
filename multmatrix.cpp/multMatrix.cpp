#include <iostream>

using namespace std;

int main(){
    int rows1, cols1, rows2, cols2, i, j, k;
    int one[50][50], two[50][50], product[50][50];

    cout <<"Enter Rows and Columns of First Matrix: \n" << endl;
    cin >> rows1 >> cols1;

    cout <<"Enter first Matrix of size: "<<rows1<<" X "<<cols1 << endl;

    for(i = 0; i < rows1; i++){
        for(j = 0; j < cols1; j++){
            cin >> one[i][j];
        }
    }

    cout <<"Enter Rows and Columns of Second Matrix: \n" << endl;
    cin >> rows2 >> cols2;

    if(cols1 != rows2){
        printf("Matrices cannot be multiplied\n");
        return 0;
 }

    cout <<"\nEnter second Matrix of size: "<<rows2<<" X "<<cols2 << endl;
    for(i = 0; i < rows2; i++){
        for(j = 0; j < cols2; j++){
            cin >> two[i][j];
        }
    }

    for(i = 0; i < rows1; i++) {
        for(j = 0; j < cols2; j++) {
            for(k = 0; k < cols1; k++) {
                product[i][j] += one[i][k]*two[k][j];
            }
        }
    }

    cout <<"Product Matrix: \n";
    for(i = 0; i < rows1; i++){
        for(j = 0; j < cols2; j++){
            cout << product[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
