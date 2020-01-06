package Hash;

import java.util.LinkedList;
/**
 * HashTable 구현 예제
 * @author define16
 *
 */
class HashTable {
	LinkedList<Node>[] data;
	
	public HashTable(int size) {
		this.data = new LinkedList[size];
	}
	
	/**
	 *  HashCode 생성
	 * @param key String key
	 * @return integer 형 hashCode가 반환
	 */
	int getHashCode(String key) {
		int hashCode = 0;
		// key 각 원소를 integer 형으로 변환
		for (char c : key.toCharArray()) {
			hashCode += c;
		}
		return hashCode;
	}
	
	/**
	 * hashCode를 data길이 만큼 mod 연산 한 뒤 반환(index)
	 * @param hashCode
	 * @return index(mod 연산) 값을 반환
	 */
	int convertToIndex(int hashCode) {
		return hashCode % data.length;
	}
	
	/**
	 * 저장된 list에서 해당 key를 갖는 Node를 반환
	 * @param list Node가 저장된 list
	 * @param key 찾고자하는 key
	 * @return  key를 갖는 Node를 반환
	 */
	Node searchKey(LinkedList<Node> list, String key) {
		if (list == null) return null; // list가 비어 있는 경우
		for (Node node : list) { // 순차적으로 list를 확인
			if (node.key.equals(key)) { // key가 있는 경우
				return node; // node를 반환
			}
		}
		return null; // 없는 경우 null 반환
	}
	
	/**
	 * 데이터를 입력 받으면 key의 HashCode를 받아온다. 
	 * 이 HashCode로 저장할 index를 계산한다.
	 * 중복이 있는 경우 갱신한다.
	 * @param key 저장할 key
	 * @param value 저장할 value
	 */
	void put(String key, String value) {
		int hashCode = getHashCode(key); // key의 hashCode
		int index = convertToIndex(hashCode); // 저장될 index 계산
		
		LinkedList<Node> list = data[index];
		
		// 해당 index 가 비어 있는 경우
		if(list == null) {
			list = new LinkedList<Node>(); // 생성
			data[index] = list; // data 리스트에 추가
		}
		
		Node node = searchKey(list, key); // 중복인지 아닌지 체크
		
		if(node == null) { // 중복이 아닌 경우 
			list.addLast(new Node(key, value)); // 새로 추가
		} else { // 중복인 경우
			node.setValue(value); // 갱신
		}
	}
	
	/**
	 * key에 해당하는 값이 있으면 value 반환 없으면, "Not Found"를 반환한다.
	 * @param key 찾을 key
	 * @return value 또는 "Not Found"
	 */
	public String get(String key) {
		int hashCode = getHashCode(key); // key의 hashCode 값 찾기
		int index = convertToIndex(hashCode); // 저장될 index 계산
		LinkedList<Node> list = data[index]; // data 리스트에 index 위치에 저장된 list 반환
		Node node = searchKey(list, key); // 저장 여부 체크
		
		return node == null ? "Not Found" : node.getValue();
	}
	
}

/**
 * String key, String value를 갖는 Node Class
 * @author define16
 */
class Node {
	String key;
	String value;
	
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}

public class HashTableEx {

	public static void main(String[] args) {
		HashTable ht = new HashTable(3);
		ht.put("test1", "first Test");
		ht.put("test2", "second Test");
		ht.put("test3", "third Test");
		
		System.out.println(ht.get("test1"));
		System.out.println(ht.get("test4")); // key가 없음
		System.out.println(ht.get("test2"));
		System.out.println(ht.get("test3"));
		
		/* 결과
		 * first Test
		 * Not Found
		 * second Test
		 * third Test
		 */		
	}

}
