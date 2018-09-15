#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

int solution(vector<vector<string>> clothes) {
	int answer = 1;

	unordered_map <string, int> attributes;
	for (int i = 0; i < clothes.size(); i++)
		attributes[clothes[i][1]]++;
	for (auto it = attributes.begin(); it != attributes.end(); it++) {
		cout << it->second << endl; // �ι�° �� ���� (int)
		cout << it->first << endl;; // ù��° �� ���� (string)
		answer *= (it->second + 1);
	}
	answer--;

	return answer;
}
