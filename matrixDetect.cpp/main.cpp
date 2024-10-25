#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;

string userFile, line, temp;
int row = 0;
int col = 0;
int num;
//int arr[row * col];

int main()
{
	cout << "Enter file name: ";
	getline(cin, userFile);
	cout << "Now reading " << userFile << "..." << endl;

	ifstream inputFile;
	inputFile.open(userFile);



	while(getline(inputFile, line))
	{
		row++;
		if (row == 1)
		{
			stringstream ss(line);
			while(ss >> temp){
				col++;
			}
		}
	}




	cout << "Matrix size: " << row << "x" << col << endl;


}
