#Car Retail System:

Features
  Add New Cars: Add detailed information about new cars, including name, brand, license plate number, rent price per day, cost price, and color.
  Manage Customers: Add, view, and remove customers, including their personal details like name, age, license number, and national ID.
  Car Rentals: Rent cars to customers, specifying the rental duration and calculating the total rent price.
  View and Modify Car Details: Display detailed information about all cars in the system, view available cars for rent, and modify car details.
  Customer Rental History: View the rental history of each customer, including details of rented cars and rental duration.
  Clear Rental Information: Release cars from rent and clear associated rental information.
  Show All Rents: Display all ongoing rental information, including customer and car details.
  Classes and Methods
  Customer Class
  This class represents a customer in the system.

Attributes:
  customerId
  name
  age
  licenseNumber
  nationalIDNumber
  carsRented

Methods:
  Getters and setters for all attributes.
toString(): Returns a string representation of the customer.

Attributes:
  carId
  name
  brand
  numberPlate
  rentPricePerDay
  numberOfDays
  costPrice
  totalRentPrice
  color
  currentUser
  dateOfRent
  dateOfReturn
Methods:
  Getters and setters for all attributes.
  setTotalRentPrice(): Calculates the total rent price based on the number of days and rent price per day.
  toString(): Returns a string representation of the car.
  Controller Class
  This class manages the overall operations of the system.
  
Attributes:
  Lists to store all cars, all customers, rented cars, and available cars.
  Counters for car and customer IDs.
Methods:
  addNewCar(): Adds a new car to the system.
  addNewCustomer(): Adds a new customer to the system.
  findCar(): Finds a car by its license plate number.
  getCarsByName(): Displays cars by name.
  getCarsByBrand(): Displays cars by brand.
  findCustomer(): Finds a customer by their license number or national ID.
  displayAvailableCars(): Displays available cars for rent.
  displayTotalCars(): Displays all cars in the system.
  displayCustomers(): Displays all customers.
  getRentDetails(): Displays rental details of a customer.
  showCustomer(): Displays details of a customer.
  releaseCarFromRent(): Releases a car from rent.
  removeCustomer(): Removes a customer from the system.
  showAllRents(): Displays all ongoing rentals.
  removeCar(): Removes a car from the system.
  modifyCarDetails(): Modifies car details based on user input.
  checkIfCustomer(): Checks if a given license number belongs to a customer.
  showCar(): Displays details of a car.
  bindCarToCustomer(): Binds a car to a customer for rent.
  rentCars(): Rents cars to a customer based on user input.
Main Class
  This class contains the main method to run the application, providing a user interface to interact with the system. It displays a menu of available options for managing cars and customers and handles user inputs to perform various operations.

  Author-Aditya Katariya
