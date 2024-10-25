#include <iostream>
using namespace std;
int getLowNum(const int[]);
    int checkEquality(const int[]);
    bool innerLoopStraight(const int[]);
    bool containsPair(const int[]);// post:  returns true if and only if there are one or more pairs in the hand.  Note that
    // this function returns false if there are more than two of the same card (and no other pairs).

    bool containsTwoPair(const int[]); // post: returns true if and only if there are two or more pairs in the hand.
    bool containsThreeOfaKind(const int[]); // post: returns true if and only if there are one or more three-of-a-kind's in the hand.
    bool containsStraight(const int[]); // post: returns true if there are 5 consecutive cards in the hand.
    bool containsFullHouse(const int[]); // post: returns true if there is are one or more pairs and one or more three-of-a-kind's in the hand.
    bool containsFourOfaKind(const int[]); // post: returns true if there are one or more four-of-a-kind's in the hand.
    const int NUMCARDS = 5;

int main()
{
   {
       int hand[] = {NUMCARDS};
       cout << "Enter 5 numeric cards, no face cards. Use 2 - 9." << endl;
       for(int i = 0; i < NUMCARDS; i++){
       cout << "Card " << i + 1 << ": ";
       cin >> hand[i];
       }
        if (containsStraight(hand)){
            cout << "contains a straight" << endl;
        }
       else if (containsFourOfaKind(hand)) {
                cout << "contains four of a kind" << endl;
        }
        else if(containsFullHouse(hand)){

            cout << "Full house!" << endl;
        }
        else if(containsThreeOfaKind(hand)){

             cout << "Three of a kind!" << endl;
        }
        else if(containsTwoPair(hand)){

           cout << "Two of a kind!" << endl;
        }
        else if(containsPair(hand)){
           cout << "Pair!" << endl;
        }
        else {
            cout << "High card!" << endl;
        }


   }
    return 0;
}
int getLowNum(const int hand[]){
    int low = hand[0];
    for(int index = 1; index < NUMCARDS; index++){
if(hand[index] < low){
low = hand[index];
}
}
return low;
}

int checkEquality(const int hand[], int index){
int temp = 0;
for(int i = index + 1; i < NUMCARDS; i++){
    if(hand[index] == hand[i]){
        temp++;
    }
}
return temp;
}
bool innerLoopStraight(const int hand[], int index){
int temp = 0;
for(int i = 0; i < NUMCARDS; i++){
    if(hand[i] == getLowNum(hand) + index) {
        return 1;
}
}
return temp;
}
bool containsPair(const int hand[]){
for(int index = 0; index < NUMCARDS; index++){
    if(checkEquality(hand, index) > 0){
        return true;
    }
}
return false;
}
bool containsTwoPair(const int hand[]){
int numPair = 0;
for(int index = 0; index < NUMCARDS; index++){
    if(checkEquality(hand,index) > 0){
        numPair++;
    }
}
return numPair / 2;
}
bool containsThreeOfaKind(const int hand[]){
for(int index = 0; index < NUMCARDS; index++){
    if(checkEquality(hand, index) == 2){
        return true;
    }
}
return false;
}
bool containsStraight(const int hand[]){
int stright = 0;
for(int index = 1; index < NUMCARDS; index++){
    stright += innerLoopStraight (hand, index);

}
return stright / 4;
}

bool containsFullHouse(const int hand[]){
return containsThreeOfaKind(hand) * containsPair(hand);

}
bool containsFourOfaKind(const int hand[]){

for(int index = 0; index < NUMCARDS; index ++){
    if(checkEquality(hand, index) == 3){

        return true;
    }
}
return false;
}
