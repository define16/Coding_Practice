#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(vector<string> phone_book) {
	bool answer = true;
	string short_num = "";
	int min = 1000000;
	for (int i = 0; i < phone_book.size(); i++) {
		if (min > phone_book[i].length())
		{
			min = phone_book[i].length();
			short_num = phone_book[i];
		}
	}
	for (int i = 0; i < phone_book.size(); i++) {
		size_t temp = phone_book[i].find(short_num);
		if (temp == 0 && short_num.compare(phone_book[i]) != 0) {
			answer = false;
			break;
		}
	}

	return answer;
}