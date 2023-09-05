# Deque

This project is a double ended queue(deque)

Background:
Queues are a great tool for maintaining chronological order, but a simple queue is limited by certain runtimes. For example, to add something to the front of the queue the entire array must be moved over to the right so that the new entry can be added. A deque is a more efficient queue that allows for adding to the front in much less time.

Implementation:
The midpoint of the array is used as the first input, with the logical front to the left and logical back to the right. By using front and back pointers,  logical order from front to back is maintained while adding and removing entries, including for resizing. Resizing occurs when the logical front and back meet.

Analysis:

Deque:

-Adding to front or back O(1)

-Removing from front or back O(1)

Simple Queue:

-Adding to back O(1)

-Adding to front O(n)

-Removing from front O(n)

-Removing from back O(1)


By using the midpoint of the array as the first entry, rather then the front, shifting is pushed off until its time to resize the array, heavily reducing runtime.  
