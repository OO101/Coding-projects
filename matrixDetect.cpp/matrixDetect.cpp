//Omar Onate
//12/15/2022
#include <iostream>
#include <fstream>
#include <iomanip>
using namespace std;
//Initalize the varibles.
string userFile, line, temp;
int row = 0;
int col = 0;
int num;

int main()
{
	//Ask user to input file name (HW15_1.txt).
	cout << "Enter file name: ";
	getline(cin, userFile);
	cout << "Now reading " << userFile << "..." << endl;

	//Initalize inputFile varible to take in & open the userFile.
	ifstream inputFile;
	inputFile.open(userFile);

	
//Keep iterating while there is still lines to get within the file.
	while(getline(inputFile, line))
	{
	//Increment the amount of rows within the file.
		row++;

	//Check if row is equal to 1.
		if (row == 1)
		{
	//If it is then initalize ss to take in the line.
			stringstream ss(line);
	//Keep iterating while ss keeps shifting the bits to temp.
			while(ss >> temp)
		//Increment the columns within the file.
				col++;
		}
	}




	cout << "Matrix size: " << row << "x" << col << endl;

	
}
