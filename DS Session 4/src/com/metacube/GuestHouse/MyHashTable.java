package com.metacube.GuestHouse;

public class MyHashTable<K, V> {

	private Node<K, V> room;
	private List<E> bucket;

	public MyHashTable() {
		// TODO Auto-generated constructor stub
		bucket = new ArrayList();
	}

	public void insertCustInfo(K key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException("Key or value is provided null");
		}
		int hashValue = getHash(key);
		int index = hashValue;
		room = new Node<K, V>();
		room.setKey(key);
		room.setValue(value);
		if (bucket[index] != null) {
			while (bucket[index] != null) {
				index = (index + 1) % bucket.length;
				if (index == hashValue) {
					break;
				}
			}
			if (index == hashValue) {
				System.out.println("Sorry There is no rooms available");
				return;
			}
		}
		bucket[index] = room;
	}

	private int getHash(K key) {
		int hash = key.hashCode() % bucket.length+1;
		return hash;
	}

	@SuppressWarnings("unchecked")
	public V getValue(K key) {
		int hashValue1 = getHash(key);
		int hashValue2 = getHash(((Node<K, V>) bucket[hashValue1]).getKey());
		int index = hashValue2;
		if (hashValue1 != hashValue2) {
			while (hashValue1 != hashValue2) {
				hashValue2 = getHash(((Node<K, V>) bucket[(hashValue2 + 1)
						% bucket.length]).getKey());
				if(index == hashValue2){
					break;
				}
			}
			if(index == hashValue2){
				System.out.println("Please Check your key again.");
				throw new IllegalArgumentException("Key is not right");
			}
		}
		V value = ((Node<K, V>) bucket[hashValue2]).getValue();
		return value;
	}
}
