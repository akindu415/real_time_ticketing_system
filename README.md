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

How to run program:

Total Tickets: It is the total number of tickets that will be available for the entire system

Ticket Release rate : Defines the interval at which tickets are released by vendors into the ticketpool.

Tickets Per release : The number of tickets a vendor releases at a time

Customer retireval rate: Indicates the interval which cutsomers can buy tickets from the ticketpool

Max Ticket Capacity : The maximum number of tickets the ticketpool can hold at at a time

Number of vendors : The number of ticket sellers in the system

Number of customers: The number of customers in the system

Prepared configuration
    Total tickets : 50
    Ticket release rate : 1000ms
    Tickets per release : 5
    customer retireval rate : 500
    Max ticket capacity : 20
    Number of vendors : 2
    Number of customers : 3

