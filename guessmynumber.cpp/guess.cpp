#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

int main()
{
	//Initalize int varibles.
	int num, guess, tries = 0;

	//Initialize srand and time for number genration.
	srand(time(0));

	//Assign num to the random number being made when the program starts.
	num = rand() % 20 + 1;

	Present game title.
	cout << "Guess My Number Game\n\n";

	//Enter a do-while loop.
	do
	{
		//Print out the beginning of the program & ask user to input number.
		cout << "Enter a guess between 1 and 20 : ";
		cin >> guess;

		//Keep track of how many times they're trying to guess.
		tries++;

		//Check if guess is greater than num.
		if (guess > num)
		//If it is then say it is too high.
			cout << "Too high!\n\n";

		//Check if the guess also is too low.
		else if (guess < num)
		//If it is then output that its too low.
			cout << "Too low!\n\n";

		//If does not meet previous conditions then enter in else statement.
		else
		//If the user gets the right guess then output that they got it right and show how many times it took them to guess it.
			cout << "\nCorrect! You got it in " << tries << " guesses!\n";

		//Keep going through the program while the guess does not euqal to num.
	} while (guess != num);

	return 0;
}
