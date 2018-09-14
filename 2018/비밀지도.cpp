#include <string>
#include <vector>
#include <bitset>
#include <iostream>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
	vector<string> answer;



	for (int i = 0; i < n; i++) {
		string road = "";
		int road1 = arr1[i]; //map1
		int road2 = arr2[i]; //map2
		int temp1_R = 0, temp2_R = 0;


		cout << road1 << ", " << road2 << endl;

		for (int j =0; j < n; j++) {

			temp1_R = road1 % 2;
			road1 = road1 / 2;
			cout << "road1 : " << temp1_R << endl;

			temp2_R = road2 % 2;
			road2 = road2 / 2;
			cout << "road2 : " << temp2_R << endl;
	

			if (temp1_R == 1 || temp2_R == 1) {
				road += "#";
			}
			else {
				road += " ";
	
			}
		}
		// reverse(road.begin(), road.end()); //Can not use in kakao (X)
		string reverse = "";
		for (int i = 0; i < n; i++)
			reverse += road.substr(n - i - 1, 1);




		answer.push_back(reverse);

	}

	for (int i = 0; i < n; i++) {
			cout << answer[i] << "," << endl;
	}
	
	return answer;
}





int main() {
	int n = 5;
	int ar1[] = {9, 20, 28, 18, 11};
	int ar2[] = { 30, 1, 21, 17, 28 };
	vector<int> arr1, arr2;

	for (int i = 0; i < n; i++) {
		arr1.push_back(ar1[i]);
		arr2.push_back(ar2[i]);

	}


	vector<string> answer = solution(n, arr1, arr2);
	for(int i = 0; i< answer.size(); i++)
		cout << answer[i] << " ";

	cout << endl;

	system("pause");
	return 0;
}