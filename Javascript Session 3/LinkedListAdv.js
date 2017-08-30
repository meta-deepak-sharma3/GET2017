function Node(data) {
    this.data = data;
    this.next = null;
}
 
function LinkedList() {
    this._length = 0;
    this.head = null;
}
 
LinkedList.prototype.add = function(value) {
    var node = new Node(value),
        currentNode = this.head;
 
    // 1st use-case: an empty list
    if (!currentNode) {
        this.head = node;
        this._length++;
 
        return node;
    }
 
    // 2nd use-case: a non-empty list
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
 
    currentNode.next = node;
 
    this._length++;
     
    return node;
};
 
LinkedList.prototype.searchNodeAt = function(position) {
    var currentNode = this.head,
    length = this._length,
    count = 1,
    message = {failure: 'Failure: non-existent node in this list.'};
 
    // 1st use-case: an invalid position
    if (length === 0 || position < 1 || position > length) {
        throw new Error(message.failure);
    }
 
    // 2nd use-case: a valid position
    while (count < position) {
        currentNode = currentNode.next;
        count++;
    }
 
    return currentNode;
};
 
LinkedList.prototype.remove = function(position) {
    var currentNode = this.head,
    length = this._length,
    count = 0,
    message = {failure: 'Failure: non-existent node in this list.'},
	beforeNodeToDelete = null,
	nodeToDelete = null,
	deletedNode = null;
 
    // 1st use-case: an invalid position
    if (position < 0 || position > length) {
        throw new Error(message.failure);
    }
 
    // 2nd use-case: the first node is removed
    if (position === 1) {
        this.head = currentNode.next;
        deletedNode = currentNode;
        currentNode = null;
        this._length--;
         
        return deletedNode;
    }
 
    // 3rd use-case: any other node is removed
    while (currentNode.next!=null && count < position) {
        beforeNodeToDelete = currentNode;
        nodeToDelete = currentNode.next;
		currentNode = currentNode.next;
        count++;
    }
 
    beforeNodeToDelete.next = nodeToDelete.next;
    deletedNode = nodeToDelete;
    nodeToDelete = null;
    this._length--;
 
    return deletedNode;
};