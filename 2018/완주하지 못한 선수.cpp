#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	string answer = "";
	bool flag = true;
	sort(completion.begin(), completion.end());
	sort(participant.begin(), participant.end());
	for (int i = 0; i < completion.size(); i++) {
		if (completion[i].compare(participant[i]) != 0) {
			answer = participant[i];
			flag = false;
			break;
		}
	}

	if (flag) {
		answer = participant[completion.size()];
	}


	return answer;
}