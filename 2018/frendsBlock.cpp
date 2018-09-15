#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include<algorithm>

using namespace std;


class ex1 {
public:
	int cnt;

	int getCnt() {
		return cnt;
	}

	void setCnt(int cnt) {
		this->cnt = cnt;
	}

	vector<string> removeBlock(int m, int n, vector<string> board, vector<string> board_pos) {
		int cnt = 0;
		for (int i = 0; i<m - 1; i++) {
			for (int j = 0; j < n - 1;j++) {
				if ((board[i][j] != ' ') && (board[i][j] == board[i][j + 1]) && (board[i][j] == board[i + 1][j]) && (board[i][j] == board[i + 1][j + 1])) {
					board_pos.push_back(to_string(i) + ' ' + to_string(j));
					board_pos.push_back(to_string(i) + ' ' + to_string(j + 1));
					board_pos.push_back(to_string(i + 1) + ' ' + to_string(j));
					board_pos.push_back(to_string(i + 1) + ' ' + to_string(j + 1));
					cnt++;
				}
			}
		}
		setCnt(cnt);
		return board_pos;
	}

	vector<string> resetBlock(int m, int n, vector<string> board, vector<string> board_pos) {

		for (int i = 0; i < board_pos.size();i++) {
			vector<string> temp = split(board_pos[i]);
			// cout << temp[0] << "  " << temp[1] << endl;
			int a = atoi(temp[0].c_str());
			int b = atoi(temp[1].c_str());

			board[a][b] = ' ';
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m - 1; j++) {
				if (board[j][i] != ' ' && board[j + 1][i] == ' ') {
					board[j + 1][i] = board[j][i];
					board[j][i] = ' ';
				}
			}
		}

		return board;
	}

	vector<string> split(string str) {
		string buf;
		stringstream ss(str);
		vector<string> result;

		while (ss >> buf) {
			result.push_back(buf);
		}
		return result;
	}

	vector<string> check_overlap(vector<string> v) {
		sort(v.begin(), v.end());
		v.erase(unique(v.begin(), v.end()), v.end());

		return v;
	}
};



int solution(int m, int n, vector <string> board)
{
	int answer = 0;
	vector<string> board_pos;
	ex1 ex;

	ex.setCnt(1);

	do {
		board_pos = ex.removeBlock(m, n, board, board_pos);

		ex.check_overlap(board_pos);

		// for(int i = 0; i<board_pos.size();i++)
		//     cout << board_pos[i] << "   ";

		answer += board_pos.size();

		board = ex.resetBlock(m, n, board, board_pos);

		// for(int i=0; i<m; i++){
		//     for(int j = 0; j < n ;j++){
		//             cout << board[i][j];
		// }
		//     cout << endl;
		// }

		board_pos.clear();
	} while (ex.getCnt() != 0);

	return answer;
}
/*
int main() {
	int m = 4;	int n = 5;	vector<string> board;
	string board1[] = { "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA", "AAAAAAAAAAAAAAA" };
	for (int i = 0; i < (board1->length()-1); i++)
		board.push_back(board1[i]);
		//cout << i << " : " << board1[i] << endl;

	int answer = solution(m,n,board);

	return answer;
}
*/