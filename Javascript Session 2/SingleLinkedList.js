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
    // case for an empty list
    if (!currentNode) {
        this.head = node;
        this._length++;
 
        return node;
    }
    // case for a non-empty list
    while (currentNode.next) {
        currentNode = currentNode.next;
    }
    currentNode.next = node;
    this._length++;
    return node;
};
