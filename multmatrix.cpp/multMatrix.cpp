#include <iostream>

using namespace std;

int main(){
    //Initialize variables.
    int rows1, cols1, rows2, cols2, i, j, k;

    //Initalize the sets of the matrix we're multiplying.
    int one[50][50], two[50][50], product[50][50];

    //Print out for the user to enter in the first row & columns for the first Matrix.
    cout <<"Enter Rows and Columns of First Matrix: " << endl;
    cin >> rows1 >> cols1;

    //Output the first size of the matrix.
    cout <<"Enter elements of first Matrix of size: "<<rows1<<" X "<<cols1 << endl;

    //Iterate with two for-loops to input the elements within the matrix.
    for(i = 0; i < rows1; i++){
        for(j = 0; j < cols1; j++){
            cin >> one[i][j];
        }
    }

    //Ask the ueser to enter in the rows and columns in the second matrix.
    cout <<"Enter Rows and Columns of Second Matrix: \n" << endl;
    cin >> rows2 >> cols2;

    //Check if the columns 1 does not equal to rows2.
    if(cols1 != rows2){
    //If it does not then output that the Matricies cannot be multiplied and end the program.
        printf("Matrices cannot be multiplied\n");
        return 0;
 }

    //Ask the user to input the elements to the second matrix.
    cout <<"\nEnter elements of second Matrix of size: "<<rows2<<" X "<<cols2 << endl;
    //Use the similar for-loop to input the elements within the second matrix.
    for(i = 0; i < rows2; i++){
        for(j = 0; j < cols2; j++){
            cin >> two[i][j];
        }
    }

    //Then calculate the product of the two matrix's.
    for(i = 0; i < rows1; i++) {
        for(j = 0; j < cols2; j++) {
            for(k = 0; k < cols1; k++) {
                product[i][j] += one[i][k]*two[k][j];
            }
        }
    }

    //Output the product of the two Matrix's.
    cout <<"Product Matrix: \n";
    for(i = 0; i < rows1; i++){
        for(j = 0; j < cols2; j++){
            cout << product[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}
