#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
	string answer = "";
	bool flag = true;
	//1. 참가자 완주자 명단을 정렬
	sort(completion.begin(), completion.end());
	sort(participant.begin(), participant.end());

	for (int i = 0; i < completion.size(); i++) {
		if (completion[i].compare(participant[i]) != 0) {	//같은 이름이 발견되지 않을때
			answer = participant[i];
			flag = false;
			break;
		}
	}

	if (flag) {	// 맨 마지막 사람이 완주를 못했을때
		answer = participant[completion.size()];
	}


	return answer;
}
