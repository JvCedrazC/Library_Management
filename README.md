# Library_Management
Library Management software in JAVA
___________________________________________________________________________________________________________________________________________________________________________________
First PHASE: 
create UML Diagram
  Cases of Use Diagram:https://lucid.app/lucidchart/224f06ed-1b1f-4881-bc8f-efcea2774628/edit?viewport_loc=-3071%2C-2511%2C2436%2C1056%2C0_0&invitationId=inv_ca305c44-03d1-4897-b083-8e98e205fe96
  Class Diagram:https://lucid.app/lucidchart/33f8b220-d61d-4837-94d0-79c37b64c9bb/edit?view_items=VWqAVzyE9U-9&invitationId=inv_9dee1ccb-57ca-402c-9719-860d5ac80600
___________________________________________________________________________________________________________________________________________________________________________________
Second PHASE:
Implementing DAO and MODEL
___________________________________________________________________________________________________________________________________________________________________________________
Requirements:
Library Management System Requirements

Book Registration: 
  The system should allow for the registration of new books in the system, including information such as title, author, publisher, ISBN, year of publication, and category.
Book Search Users should be able to search for books by title, author, ISBN, or category, in order to find information about availability, location, and other relevant information.

Loan and Return:
  The system should allow for the registration of loans of books to library users. This includes the ability to register the loan date, the expected return date, and the identification of the user who made the loan. Additionally, the system should allow for the registration of the return of books and the update of the book's availability.
Book Reservation Users should have the option to reserve books that are loaned by other users. The system should register the reservation in order of request.

Loan Renewal:
  The system should allow for the renewal of book loans, as long as there are no other reservations for the same book and the renewal limit has not been reached.

User Management:
  The system should allow for the registration of new users, with information such as name, address, phone number, and identification number. Additionally, it should be possible to block an account, preventing the user from making loans and renewals.

Reports and Statistics:
  The system should be able to generate reports and statistics, such as the number of books loaned, overdue, and reserved; the loan history of a specific user; and the most popular books.

Fine Management:
  The system should be able to calculate and record fines for late book returns. The user should be fined double the number of days overdue.
Collection Management The system should allow for the management of the library's collection, including the addition, removal, and updating of information about books, as well as 
inventory control.

System Operator Management:
  The system should allow for the registration of new operators, with information such as name, identification number, position, and access password. Positions can be of the type Administrator or Librarian. The Librarian will only have access to functionalities #1, #2, and #3.
___________________________________________________________________________________________________________________________________________________________________________________
Discussions in PBL sections:



