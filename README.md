# JavaCovid19App
Buiding a covid 19 app 

Building an application "Covid-19 information management" including 2 systems with different functions following capabilities:
1 Covid Management System 
  1.1 Login, initialization 
    ✓ When the program starts, it is required to log in. Depends on the stool account permissions that open the screen with the appropriate functions. 
    ✓ If the system initializes for the first time, it is necessary to allow the creation of an admin account. 
    ✓ If it is the account of the Managed Person already in the system but not yet Every time you log in, you will be asked for a password.
  1.2 Management Module Administrators can use the following functions: 
     1.2.1 Manage the list of people related to Covid-19 
      ✓ Persons related to Covid-19 include the following basic information: 
          o Full name 
          o ID number / Citizen's identity card 
          o Year of birth 
          o Address of residence (Province/City, District/District and Ward/Commune) 
          o Current Status (F0/F1/F2/F3) o Place of treatment / isolation (treatment / isolation facility) 
          o Related to any Covid-19 Related Person. o Managed process history (state change, control transfer) treatment,…). 
       ✓ Show list 
       ✓ View detailed information of related people including contact list zone. 
       ✓ Search 
       ✓ Sort by multiple criteria. 
     1.2.2 Add people related to Covid-19 into the system 
       ✓ Additional form with all necessary information.
       ✓ Has full validation.
     1.2.3 Change the status of people related to Covid-19
       ✓ Switch the necessary state such as: F2 -> F1, F2 -> F0,… with appropriate information case (the person concerned must change the status according to).
       ✓ Transfer of treatment / isolation places (capacity constraints).
     1.2.4 Management of Necessary Packages
       ✓ The Essentials Package includes the following basic information:
            o Package name
            o Limits per person
            o Time limit (day, week, month)
            o Unit price
       ✓ Show list
       ✓ Search
       ✓ Sort, filter
       ✓ Add, delete, edit
    1.2.5 Statistics of information
      ✓ Statistics of the number of people in each state over time.
      ✓ Statistics of possible information such as number of state transitions, recovery from illness, etc.
      ✓ Statistics of consumption of Necessary packages
      ✓ Statistics of outstanding balance
  1.3 Administration module (Admin)
      1.3.1 Create an account
        ✓ Create a manager account with proper storage password handling (no saving store plaintext passwords in the database).
        ✓ Just username, password and authorization information.
      1.3.2 Manage manager account information
        ✓ Lock your account.
        ✓ View account activity history.
      1.3.3 Treatment/isolation site management
        ✓ Add new, adjust.
        ✓ Treatment / isolation location only needs information of Name, Capacity and Number of Recipients (current).
  1.4 User module (managed person)
      1.4.1 View personal information
        ✓ Basic information
        ✓ Managed history
        ✓ Consumption history of packages Like essentials
        ✓ View outstanding balance
        ✓ Payment history
      1.4.2 Choose to buy a package of Essentials
        ✓ See list of Necessary packages
        ✓ Search, sort, filter
        ✓ Choose to buy the Essentials package (check constraints).
      1.4.3 Payment of expenses
        ✓ Pay the outstanding balance according to the minimum limit (temporarily disregarding the balance of the account in the payment system)
2 Payment Management System
       2.1 System initialization
          ➢ Initialized system with 1 main account to receive payment from the Receiver.
        2.2 Accounts
          ➢ Account only includes ID and current balance.
        2.3 Functions
          ➢ Design the database so that the system can perform the payment function (transfer) from the Managed accounts to the main account.
          ➢ The function of adding an account is required for new Managers (respectively when introduced into the regulatory system) with a balance large enough (to ignore problem of insufficient payment balance).
          ➢ A solution is needed to verify payment transactions.
          
3. Link Management and Payment system
          ➢ Use a local network connection (for simplicity)
          ➢ A secure data transmission solution is required.
4 Notes:
          ✓ Need to have at least 5 Provinces available, each Province has at least 5 Districts/Districts,
          Each District / District has at least 5 Wards / Communes (names do not need to be exact
          economic).
          ✓ At least 5 treatment/isolation sites should be available.
          ✓ Complete only the required functions.
          ✓ Strictly follow the submission requirements (specific announcement will be made).
