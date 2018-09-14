#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string to_answer(int m) {
	string answer = "";

	int hour = m / 60;
	int min = m % 60;

	if (hour < 10) {
		answer = "0" + to_string(hour);
	}
	else {
		answer = to_string(hour);
	}

	if (min < 10) {
		answer = answer + ":0" + to_string(min);
	}
	else {
		answer = answer + ":" + to_string(min);
	}
	return answer;
}

vector<int> casting_int(vector<string> timetable) {
	vector<int> timetable_min;
	for (int i = 0; i < timetable.size(); i++) {
		int hour = atoi(timetable[i].substr(0, 2).c_str());
		int min = atoi(timetable[i].substr(3).c_str());
		int time = hour * 60 + min;

		timetable_min.push_back(time);
		
	}
	return timetable_min;
}

string solution(int n, int t, int m, vector<string> timetable) {
	string answer = "";
	int answer_temp = 0;
	vector<int> timetable_min;
	bool enough = false;
	int bus_time = 540;
	int get_on = 0;
	int seat = 0;
	// 1. 시간순으로 정렬
	sort(timetable.begin(), timetable.end());
	timetable_min = casting_int(timetable);
	
	//9시 제외
	for (int i = 0; i < n; i++) {
		seat = m;

		int j = 0;
		// 2. 버스에 사람태우기
		while (j < timetable_min.size()) {
			if (timetable_min[j] <= bus_time) {
				seat--; // 좌석수
				get_on++; // 버스를 탑승한 사람수
				if (seat == 0) break;
			}
			j++;
		}
		//cout << i << endl;
		//cout << bus_time << "분에 버스 탄 사람 수 : " << get_on << endl;
		//마지막 차 
		if (i == n - 1) {
			if (seat == 0) 
					answer_temp = timetable_min[get_on - 1] - 1;
			else if(seat > 0)
				answer_temp = bus_time;
			break;
		}
		
		bus_time += t;
		if (bus_time > 24 * 60 - 1) {
			answer_temp = bus_time - t;
			break;
		}
	}

	answer = to_answer(answer_temp);

	return answer;
}

int main() {
	int n = 10;
	int t = 60;
	int m = 45;
	vector<string> timetable;
	//"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" 
	string temp[] = { "09:10", "09:09", "08:00"};

	for (int i = 0; i < 3; i++) {
		timetable.push_back(temp[i]);
	}

	string answer = solution(n, t, m, timetable);
	cout << "answer : " << answer << " a" << endl;
	system("pause");
	return 0;
}
