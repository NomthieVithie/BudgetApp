Budget App

This Android app is a personal finance tracker designed to help users manage their daily expenses.
It allows users to input details about their spending, including date, morning and afternoon amounts, and notes.
The app stores this information and calculates the average daily spending.
This feature enables users to analyze their spending habits, identify areas for potential savings, and make informed financial decisions.


Pseudocode:

Declare a mutable list named SpendingDate to store daily spending records.

// Input Screen
Display input fields for:
    - Date
    - Morning Spending
    - Afternoon Spending
    - Notes

On "Save" button click:
    - Validate input fields (ensure morning and afternoon spending are numeric)
    - Create a new SpendingRecord object with the input values
    - Add the new record to the SpendingDate list
    - Clear input fields

On "Clear" button click:
    - Clear all input fields

On "Show Data" button click:
    - Navigate to a new screen
    - Display all records from the SpendingDate list in a formatted table

On "Calculate Average" button click:
    - Initialize variables: totalSpending = 0, count = 0
    - For each record in SpendingDate:
        - Convert morning and afternoon spending to numbers
        - Add the total spending
        - Increment the count
    - Calculate the average: averageSpending = totalSpending / count
    - Display the average spending






![Screenshot (9)](https://github.com/user-attachments/assets/5f90a185-7335-4951-be9b-5e07c064d585)
![Screenshot (10)](https://github.com/user-attachments/assets/054882e5-62b2-45fa-9ceb-64ea41a977fe)
![Screenshot 2024-12-09 161433](https://github.com/user-attachments/assets/84787fd8-fd9e-457e-b38b-c0538ec62f69)

