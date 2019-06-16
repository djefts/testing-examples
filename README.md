#Software Quality Assurance In-Class Testing Examples

##Black-Box Testing
* ####BBExample.java
  - `BBExample.java` is an example file for the merge-sort algorithm that works on a list of integers. By its nature,
    the merge sort algorithm requires a lot of boundary value checks to ensure everything is in the right order, along
    with equivalency checks to make sure that everything in the array is of the same type. 

* ####BlackBoxTests.java
  - `BlackBoxTests.java` is an example grading scale program that uses multiple boundary checks to determine the letter
    grade for the input grade number.

##White-Box Testing
* ####WBExample.java
  - `WBExample.java` is a date converter for calculating the numerical day of the year that a certain date takes place.
    It has multiple different paths to take, since it has to account for months with varied amounts of days, along with
    leap years that change the total number of days in a year.

* ####WhiteBoxTests.java
  - `WhiteBoxTests.java` is a brute-force password crunching program. It takes in the password requirements such as
    length and available characters, then generates every possible password combination. It is a short program that has
    multiple different loops in it creating a lot of different branching options for the program. There are many
    different ways to ensure that all of the statements are covered by White-Box Testing.

##Code-Review
* ####CRExample.java
  - `CRExample.java` is a Fibonacci Sequence program that outputs the first 20 numbers in the Fibonacci Sequence. There
    are two main places to plant defects: Line 22 and Line 25. Line 22 has a boundary value check who's sign can be 
    flipped to cause errors. Line 25 has multiple additions that can be changed to subtractions or multiplications, or 
    any other math symbol to radically change the result of the program. Both of these defects have been implemented, 
    the correct code is in the block comment at the top of the file.

* ####CodeReviewTests.java
  - `CodeReviewTests.java` is a volume calculator and averaging program. This example program will calculate the volume
    of multiple spheres based on a list of double-type diameters, then calculate the average volume of all of the
    spheres. There are many possible areas to plant defects: 
    - Line 30: `(4/3)`, defect because of integer division instead of decimal division. `4/3 = 1` while
      `4.0/3.0 = 1.3333`. This defect has been implemented.
    - Line 30: Volume is calculated with radius, not dividing the diameter by 2.0 would incorrectly calculate the volume
    - Line 18: Mistyping the value for Pi