This is the repository i keep for my oop coursework
Ticket class
    -This class represents an individual ticket in the system
    - Uses AtomicInteger to prevent multiple thread readin at the same time
    - IncrementAndGet increases automatically ticket id by 1

Ticketpool class: 
    - manages the ticket storage with synchronization.
    -using queues to manage tasks in a first in first out manner because 
        tickets are often processed in the way they are released.
    -using linkedlist for effective insertion and removal at both ends to support fifo operations
  addtickets() : add al the tickets from provided list to the end of tickequeve
                if the current number of tickets in ticket queue and tickets vendor wants to add exceeds the max capacity
                then the thread should wait

