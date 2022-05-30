# Account-Service
It is basic Account Service in which we can monitor each transaction of a user and can monitor saving of that user.

# Endpoints of the Application and there features are given below:
1. @GetMapping("/current/{username}")           --->    It will retrieve all expenses and incomes and savings of a user.
2. @GetMapping("/current/{username}/saving")    --->    It will retrieve savings of a user.
4. @GetMapping("/current/{username}/expenses")  --->    It will retrieve all expenses of a user.
5. @GetMapping("/current/{username}/incomes")   --->    It will retrieve all incomes of a user.
6. @PostMapping("/current/{username}/expenses") --->    It will add an expense to the user account and simultaneously savings of the user will also gets updated.
7. @PostMapping("/current/{username}/incomes")  --->    It will add an income to the user account and simultaneously savings of the user will also gets updated.
8. @PostMapping("/current")                     --->    It will create a user Account.
9. @DeleteMapping("/current/{username}")        --->    It will delete a user Account.
