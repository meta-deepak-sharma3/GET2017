package com.metacube.GuestHouse;

/**
 * Hashtable creation class for making bucket for rooms
 * aiding in nsert of new guests in guest room.
 * 
 */
public class MyHashTable<K, V> {
	private static int MAXSIZE = 16;
	private Node<K, V> room;
	private Object[] bucket;
	
	/**
	 * Constructor called with parameters.
	 */
	public MyHashTable(int size) {
		bucket = new Object[size];
	}
	
	/**
	 * Default Constructor with default bucket size.
	 * 
	 */
	public MyHashTable() {
		// TODO Auto-generated constructor stub
		bucket = new Object[MAXSIZE];
	}
	
	/**
	 * method to map guest with 
	 * @param1: unique key
	 * @param2: value to be stored in bucket
	 */
	public void insertValue(K key, V value) {
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
		int hash = key.hashCode() % bucket.length;
		return hash;
	}
	
	/**
	 * method to get value for each key.
	 * @param key: integer value
	 */
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
	
	/**
	 * method to get room number of guest
	 * @param: key
	 */
	@SuppressWarnings("unchecked")
	public int getKey(K key) {
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
		return hashValue2+1;
	}
	
	public int getSize() {
		return bucket.length;
	}
}
