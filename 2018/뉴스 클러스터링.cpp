#include <string>
#include <iostream>
#include <vector>
#include <cctype>
#include <algorithm>

using namespace std;


int solution1(string str1, string str2) {
	int answer = 65536;
	int sum_cnt = 0;
	int intersection_cnt = 0;

	//cout << str1 << endl;
	//cout << str2 << endl;

	vector<string> s1;
	vector<string> s2;
	vector<string> intersection_v;


	for (int i = 0; i < (str1.length() - 1); i++) {
		if ((char)toupper(str1.at(i)) == ' ' || (char)toupper(str1.at(i + 1)) == ' ' ||
			!(toupper(str1.at(i)) > 64 && toupper(str1.at(i)) < 91) || !(toupper(str1.at(i + 1)) > 64 && toupper(str1.at(i + 1)) < 91)) continue;

		char temp[2] = { (char)toupper(str1.at(i)), (char)toupper(str1.at(i + 1)) };
		string temp_str = "";
		for (int j = 0; j < 2; j++)
			temp_str += temp[j];
		s1.push_back(temp_str);
	}



	for (int i = 0; i < (str2.length() - 1); i++) {
		if ((char)toupper(str2.at(i)) == ' ' || (char)toupper(str2.at(i + 1)) == ' ' ||
			!(toupper(str2.at(i)) > 64 && toupper(str2.at(i)) < 91) || !(toupper(str2.at(i + 1)) > 64 && toupper(str2.at(i + 1)) < 91)) continue;

		char temp[2] = { (char)toupper(str2.at(i)), (char)toupper(str2.at(i + 1)) };
		string temp_str = "";
		for (int j = 0; j < 2; j++)
			temp_str += temp[j];
		s2.push_back(temp_str);
	}


	sum_cnt = s1.size() + s2.size();

	for (int i = 0; i < s1.size(); i++) {
		for (int j = 0; j < s2.size(); j++) {
			if (s1[i].compare(s2[j]) == 0) {
				intersection_v.push_back(s2[j]);
				s2.erase(s2.begin() + j);
				break;
			}

		}
	}

	intersection_cnt = intersection_v.size();



	cout << "교집합 : " << intersection_cnt << " 합집합 : " << (sum_cnt - intersection_cnt) << endl;


	if (intersection_cnt > 0 && sum_cnt > 0) {
		answer = (float)intersection_cnt / (float)(sum_cnt - intersection_cnt) * 65536;
		if (answer < 1)
			return 65536;
	}
		


	return answer;
}


//int main() {
//	string str1 = "aa1+aa2a3afaccafgwerwqwer";
//	string str2 = "AAAA12fbsfdokreinagorqwerwerqe";
//	int answer = solution(str1, str2);
//
//	cout << answer << endl;
//	system("pause");
//
//	return 0;
//}