
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

class Customer implements Serializable {

    private int customerId;
    private String name;
    private int age;
    private String licenseNumber;
    private String nationalIDNumber;
    private List<Car> carsRented;

    public Customer(int customerId, String name, int age, String licenseNumber, String nationalIDNumber) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.licenseNumber = licenseNumber;
        this.nationalIDNumber = nationalIDNumber;
        carsRented = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getNationalIDNumber() {
        return nationalIDNumber;
    }

    public void setNationalIDNumber(String nationalIDNumber) {
        this.nationalIDNumber = nationalIDNumber;
    }

    public List<Car> getCarsRented() {
        return carsRented;
    }

    @Override
    public String toString() {
        return "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", nationalIDNumber='" + nationalIDNumber + '\'';
    }
}

class Car implements Serializable {

    private int carId;
    private String name;
    private String brand;
    private String numberPlate;
    private int rentPricePerDay;
    private int numberOfDays;
    private int costPrice;
    private int totalRentPrice;
    private String color;
    private Customer currentUser;
    private Date dateOfRent;
    private Date dateOfReturn;

    public Car(int carId, String name, String brand, String numberPlate, int rentPricePerDay, int costPrice,
            String color) {
        this.carId = carId;
        this.name = name;
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.rentPricePerDay = rentPricePerDay;
        this.costPrice = costPrice;
        this.color = color;
        numberOfDays = 0;
        totalRentPrice = 0;
    }

    public Date getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(Date dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public int getTotalRentPrice() {
        return totalRentPrice;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public void setTotalRentPrice() {
        this.totalRentPrice = this.rentPricePerDay * this.numberOfDays;
    }

    public Date getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(Date dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getRentPricePerDay() {
        return rentPricePerDay;
    }

    public void setRentPricePerDay(int rentPricePerDay) {
        this.rentPricePerDay = rentPricePerDay;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Customer getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Customer currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return "carId=" + carId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", numberPlate='" + numberPlate + '\'' +
                ", rentPricePerDay=" + rentPricePerDay +
                ", costPrice=" + costPrice +
                ", color='" + color + '\'';
    }
}

class Controller implements Serializable {

    // Attributes/fields declaration
    private final List<Car> allCars;
    private final List<Customer> allCustomers;
    private final List<Car> rentedCars;
    private final List<Car> availableCars;
    private int carId;
    private int customerId;

    // Controller's constructor
    public Controller() {
        allCars = new ArrayList<>();
        allCustomers = new ArrayList<>();
        rentedCars = new ArrayList<>();
        availableCars = new ArrayList<>();
        carId = 1;
        customerId = 1;
    }

    // Method to add a new car to the system
    public void addNewCar(String name, String brand, String numberPlate, int rentPricePerDay, int costPrice,
            String color) {
        Car car = new Car(carId++, name, brand, numberPlate, rentPricePerDay, costPrice, color);
        allCars.add(car);
        availableCars.add(car);
    }

    // Method to add a new customer to the system
    public void addNewCustomer(String name, int age, String licenseNumber, String nationalIDNumber) {
        Customer customer = new Customer(customerId++, name, age, licenseNumber, nationalIDNumber);
        allCustomers.add(customer);
    }

    // Method to find a particular car using it's license plate number, hence
    // checking if it exists or not
    public Car findCar(String licensePlateNumber) {
        Car car = null;
        for (Car carX : allCars) {
            if (carX.getNumberPlate().equals(licensePlateNumber)) {
                car = carX;
                break;
            }
        }
        return car;
    }

    // Method to get cars by name
    public void getCarsByName() {
        String name;
        int count = 0;
        boolean test = false;
        System.out.print("Enter name: ");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        for (Car car : allCars) {
            if (car.getName().equals(name)) {
                test = true;
                count++;
                System.out.println(car);
            }
        }
        if (!test) {
            System.out.println("Sorry no car available with name: " + name);
        } else {
            System.out.println("Number of cars with name " + name + ": " + count);
        }
    }

    // Method to get cars by category/brand
    public void getCarsByBrand() {
        String brand;
        int count = 0;
        boolean test = false;
        System.out.print("Enter brand: ");
        Scanner scan = new Scanner(System.in);
        brand = scan.nextLine();
        for (Car car : allCars) {
            if (car.getBrand().equals(brand)) {
                test = true;
                count++;
                System.out.println(car);
            }
        }
        if (!test) {
            System.out.println("Sorry no car available with brand: " + brand);
        } else {
            System.out.println("Number of cars with brand " + brand + ": " + count);
        }
    }

    // Method to find a particular customer using the customer's license number,
    // hence checking if the customer exists or not
    public Customer findCustomer(String licenseNumber, String nationalID) {
        Customer customer = null;
        for (Customer customerX : allCustomers) {
            if (customerX.getLicenseNumber().equals(licenseNumber)
                    || customerX.getNationalIDNumber().equals(nationalID)) {
                customer = customerX;
                break;
            }
        }
        return customer;
    }

    // Method to return a particular customer - Overloading
    public Customer findCustomer(String licenseNumber) {
        Customer customer = null;
        for (Customer customerX : allCustomers) {
            if (customerX.getLicenseNumber().equals(licenseNumber)) {
                customer = customerX;
                break;
            }
        }
        return customer;
    }

    // Method to check if there are any cars within the system or available for rent
    // based on the parameter it receives
    private void check(List<Car> availableCars) {
        if (availableCars.size() == 0) {
            System.out.println("There are no cars/No cars available");
            return;
        }
        for (int i = 1; i <= availableCars.size(); i++) {
            System.out.println(i + ". " + availableCars.get(i - 1));
        }
    }

    // Method to check available cars for rent
    public void displayAvailableCars() {
        check(availableCars);
    }

    // Method to display all the cars within the system
    public void displayTotalCars() {
        check(allCars);
    }

    // Display all customers
    public void displayCustomers() {
        if (allCustomers.size() == 0) {
            System.out.println("There are no customers");
            return;
        }
        for (int i = 1; i <= allCustomers.size(); i++) {
            System.out.println(i + ". " + allCustomers.get(i - 1));
        }
    }

    // Get a customer's rent details
    public void getRentDetails(String licenseNumber) {
        Customer customer = findCustomer(licenseNumber);
        if (customer == null)
            System.out.println("Sorry no customer with license number " + licenseNumber);
        else {
            if (customer.getCarsRented().size() == 0)
                System.out.println("Sorry no car has been rented yet by this customer");
            else
                System.out.println(customer.getCarsRented());
        }
    }

    // Method to display details of a customer
    public void showCustomer(String licenseNumber) {
        Customer customer = findCustomer(licenseNumber);
        if (customer == null)
            System.out.println("No customer found with license number " + licenseNumber);
        else
            System.out.println(customer);
    }

    // Method to release car from rent
    public void releaseCarFromRent(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if (car == null) {
            System.out.println("Sorry no car with license plate number: " + licensePlateNumber);
        } else {
            if (rentedCars.contains(car)) {
                rentedCars.remove(car);
                availableCars.add(car);
                car.getCurrentUser().getCarsRented().remove(car);
                car.setCurrentUser(null);
                System.out.println("Successfully cleared rent details for " + car);
            } else {
                System.out.println("Car is available, not yet given out for rent");
            }
        }
    }

    // Method to remove a customer from the system
    public Customer removeCustomer(String licenseNumber) {
        Customer toBeRemoved = findCustomer(licenseNumber);
        if (toBeRemoved == null)
            return null;
        allCustomers.remove(toBeRemoved);
        return toBeRemoved;
    }

    // Method to show all rents
    public void showAllRents() {
        if (rentedCars.size() == 0)
            System.out.println("No car rented out yet...");
        else {
            for (Car car : rentedCars) {
                System.out.println("Customer License Number :: " + car.getCurrentUser().getLicenseNumber());
                System.out.println("Car License Plate Number :: " + car.getNumberPlate());
                System.out.println("Date Of Rent :: " + car.getDateOfRent());
                System.out.println("Number Of Days :: " + car.getNumberOfDays());
                System.out.println("Total Price To Be Paid :: " + car.getTotalRentPrice());
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    // Method to remove a car from the system
    public Car removeCar(String licensePlateNumber) {
        Car toBeRemoved = findCar(licensePlateNumber);
        if (toBeRemoved == null)
            System.out.println("Sorry no car available with license number: " + licensePlateNumber);
        else if (rentedCars.contains(toBeRemoved))
            System.out
                    .println("Sorry can not delete a rented car... Try clearing the customers rent first - OPTION 12");
        else {
            allCars.remove(toBeRemoved);
            availableCars.remove(toBeRemoved);
            System.out.println("CAR DETAILS: " + toBeRemoved + "\n SUCCESSFULLY REMOVED");
            return toBeRemoved;
        }
        return null;
    }

    // Method to modify a car's details based upon choice selection
    public void modifyCarDetails(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if (car == null) {
            System.out.println("Sorry no car found with license plate number: " + licensePlateNumber);
        } else {
            Scanner sc = new Scanner(System.in);
            int choice;
            System.out.println();
            System.out.println("1. Color");
            System.out.println("2. Price");
            System.out.println("3. RentPerDay");
            System.out.println("4. LicenseNumberPlate");
            System.out.println("5. Color and Price");
            System.out.println("6. Price and RentPerDay");
            System.out.println("7. Color and RentPerDay");
            System.out.println("8. Color and licensePlateNumber");
            System.out.println("9. LicensePlateNumber and RentPerDay");
            System.out.println("10. Color, LicensePlateNumber and RentPerDay");
            System.out.println("11. All car properties [Excluding name and brand properties]");
            System.out.println("\nWhat do you want to edit? ");
            choice = sc.nextInt();

            String numberPlate, color;
            int rentPricePerDay, costPrice;

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.println("Successfully Updated.");
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Enter new cost");
                    costPrice = sc.nextInt();
                    sc.nextLine();
                    car.setCostPrice(costPrice);
                    System.out.println("Successfully Updated.");
                    break;

                case 3:
                    System.out.println();
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    sc.nextLine();
                    car.setRentPricePerDay(rentPricePerDay);
                    System.out.println("Successfully Updated.");
                    break;

                case 4:
                    System.out.println();
                    System.out.print("Enter new NumberPlate :: ");
                    numberPlate = sc.nextLine();
                    car.setNumberPlate(numberPlate);
                    System.out.println("Successfully Updated.");
                    break;

                case 5:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.println("Enter new cost");
                    costPrice = sc.nextInt();
                    car.setCostPrice(costPrice);
                    sc.nextLine();
                    System.out.println("Successfully Updated.");
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Enter new cost");
                    costPrice = sc.nextInt();
                    car.setCostPrice(costPrice);
                    sc.nextLine();
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    car.setRentPricePerDay(rentPricePerDay);
                    sc.nextLine();
                    System.out.println("Successfully Updated.");
                    break;

                case 7:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    car.setRentPricePerDay(rentPricePerDay);
                    sc.nextLine();
                    System.out.println("Successfully Updated.");
                    break;

                case 8:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.print("Enter new NumberPlate :: ");
                    licensePlateNumber = sc.nextLine();
                    car.setNumberPlate(licensePlateNumber);
                    System.out.println("Successfully Updated.");
                    break;

                case 9:
                    System.out.println();
                    System.out.print("Enter new NumberPlate :: ");
                    licensePlateNumber = sc.nextLine();
                    car.setNumberPlate(licensePlateNumber);
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    car.setRentPricePerDay(rentPricePerDay);
                    sc.nextLine();
                    System.out.println("Successfully Updated.");
                    break;
                case 10:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    sc.nextLine();
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    car.setRentPricePerDay(rentPricePerDay);
                    sc.nextLine();
                    System.out.print("Enter new NumberPlate :: ");
                    licensePlateNumber = sc.nextLine();
                    car.setNumberPlate(licensePlateNumber);
                    System.out.println("Successfully Updated.");
                    break;
                case 11:
                    System.out.println();
                    System.out.print("Enter new Color :: ");
                    color = sc.nextLine();
                    car.setColor(color);
                    System.out.print("Enter new Rent Price :: ");
                    rentPricePerDay = sc.nextInt();
                    car.setRentPricePerDay(rentPricePerDay);
                    sc.nextLine();
                    System.out.print("Enter new NumberPlate :: ");
                    licensePlateNumber = sc.nextLine();
                    System.out.println("Enter new cost");
                    costPrice = sc.nextInt();
                    car.setCostPrice(costPrice);
                    car.setNumberPlate(licensePlateNumber);
                    sc.nextLine();
                    System.out.println("Successfully Updated.");
                    break;
                default:
                    System.out.println("Sorry Invalid Input...");
            }
        }
    }

    // Method to check if a given license number belongs to a customer within the
    // system
    public boolean checkIfCustomer(String licenseNumber) {
        for (Customer customer : allCustomers) {
            if (customer.getLicenseNumber().equals(licenseNumber))
                return true;
        }
        return false;
    }

    // Show a car's details
    public void showCar(String licensePlateNumber) {
        Car car = findCar(licensePlateNumber);
        if (car == null)
            System.out.println("No car found having that license plate number " + licensePlateNumber);
        else
            System.out.println(car);
    }

    // Method to bind a car to a customer
    public void bindCarToCustomer(Customer customer, Car car) {
        customer.getCarsRented().add(car);
        car.setCurrentUser(customer);
        rentedCars.add(car);
        availableCars.remove(car);
    }

    // Method to rent a car(s) to a customer
    public void rentCars(Scanner sc) {
        System.out.print("Input customer's license number: ");
        String licenseNumber = sc.nextLine();
        if (!checkIfCustomer(licenseNumber)) {
            System.out.println("Sorry, not a customer.");
            return;
        }
        System.out.print("Number of cars to be rented: ");
        int numberOfCars = sc.nextInt();
        sc.nextLine();
        System.out.print("Number of days: ");
        int numberOfDays = sc.nextInt();
        sc.nextLine();
        if (numberOfCars == 1)
            System.out.print("Enter the license plate number of the chosen car: ");
        else
            System.out.println("Enter the license plate number of the chosen cars one after the other below:");
        for (int i = 0; i < numberOfCars; i++) {
            String licensePlateNumber = sc.nextLine();
            if (findCar(licensePlateNumber) != null && availableCars.contains(findCar(licensePlateNumber))) {
                Customer customer = findCustomer(licenseNumber);
                Car car = findCar(licensePlateNumber);
                bindCarToCustomer(customer, car);
                Date date = new Date();
                car.setDateOfRent(date);
                car.setNumberOfDays(numberOfDays);
                car.setTotalRentPrice();
                System.out.println("Successfully stored rent details.");
            } else {
                System.out.println("Car is not available.");
            }
        }
    }

    public class Main {
        public static void main(String[] args) {

            Controller controller = new Controller();

            controller.addNewCar("Creta", "Hyundai", "GJ01UK8067", 1200, 1600000, "white");
            controller.addNewCar("Verna", "Hyundai", "GJ01WN3787", 1500, 1500000, "Blue");
            controller.addNewCar("Thar", "Mahindra", "GJ01AB8555", 1400, 1600000, "Black");
            controller.addNewCar("Swift", "Suzuki", "GJ01DU5669", 1100, 1400000, "Grey");

            System.out.println();
            System.out.println("***************************************************************************");
            System.out.println("***************************************************************************");
            System.out.println("**                                                                       **");
            System.out.println("**   WELCOME TO CARDEKHO CAR/CUSTOMER MANAGEMENT AND CAR RENTAL SYSTEM   **");
            System.out.println("**                                                                       **");
            System.out.println("***************************************************************************");
            System.out.println("***************************************************************************");

            System.out.println();

            int option;
            Scanner in = new Scanner(System.in);
            do {

                // Displaying a list of available operations/system manipulations.
                System.out.println("\nAvailable Options");
                System.out.println("-----------------");

                System.out.println("\nMANAGE CARS\n");

                System.out.println("  1. Add a new car");
                System.out.println("  2. View all cars within the system");
                System.out.println("  3. Display available cars for rent");
                System.out.println("  4. Delete a car");
                System.out.println("  5. Modify a car's details");
                System.out.println("  6. Rent car(s)");
                System.out.println("  7. Show a car's details");
                System.out.println("  8. Display cars by category");
                System.out.println("  9. Get total number of cars by name");

                System.out.println("\nMANAGE CUSTOMERS\n");

                System.out.println("10. Add a new customer");
                System.out.println("11. View all customers");
                System.out.println("12. View a customer's rent details");
                System.out.println("13. Clear a customer's rent");
                System.out.println("14. Remove customer from system");
                System.out.println("15. Show all rents");
                System.out.println("16. Show a customer's details");
                System.out.println("0. Terminate/Exit System");

                System.out.println();

                System.out.print("Choose a command option: ");
                option = in.nextInt();
                in.nextLine();

                // Action to be done - determined by the 'option' the user selects.
                switch (option) {
                    case 1:
                        System.out.println("\nEnter car details:");
                        System.out.print("Name: ");
                        String name = in.nextLine();
                        System.out.print("Brand: ");
                        String brand = in.nextLine();
                        System.out.print("License plate number: ");
                        String plateNumber = in.nextLine();
                        System.out.print("Rent price per day: ");
                        int pricePerDay = in.nextInt();
                        in.nextLine();
                        System.out.print("Cost price: ");
                        int costPrice = in.nextInt();
                        in.nextLine();
                        System.out.print("Color: ");
                        String color = in.nextLine();
                        Car car_check = controller.findCar(plateNumber);
                        if (car_check == null) {
                            controller.addNewCar(name, brand, plateNumber, pricePerDay, costPrice, color);
                            System.out.println("\nSuccessfully added new car");
                        } else {
                            System.out.println("\nSorry car already exist with license plate number " + plateNumber);
                        }
                        break;
                    case 2:
                        System.out.println();
                        controller.displayTotalCars();
                        break;
                    case 3:
                        System.out.println();
                        controller.displayAvailableCars();
                        break;
                    case 4:
                        System.out.println();
                        System.out.print("Input car's license plate number of car to be: ");
                        String licensePlateNumber = in.nextLine();
                        controller.removeCar(licensePlateNumber);
                        break;
                    case 5:
                        System.out.println();
                        System.out.print("Enter the car's license plate number: ");
                        String licensePlateNumber2 = in.nextLine();
                        controller.modifyCarDetails(licensePlateNumber2);
                        break;
                    case 6:
                        System.out.println();
                        controller.rentCars(in);
                        break;
                    case 7:
                        System.out.println();
                        System.out.print("Input car's license plate number: ");
                        controller.showCar(in.nextLine());
                        break;
                    case 8:
                        System.out.println();
                        controller.getCarsByBrand();
                        break;
                    case 9:
                        System.out.println();
                        controller.getCarsByName();
                        break;
                    case 10:
                        System.out.println("Enter customer details:");
                        System.out.print("Name: ");
                        String customerName = in.nextLine();
                        System.out.print("Age: ");
                        int customerAge = in.nextInt();
                        in.nextLine();
                        System.out.print("License number: ");
                        String licenseNumber = in.nextLine();
                        System.out.print("National identification(N_ID) number: ");
                        String nationalIDNumber = in.nextLine();
                        Customer customer_check = controller.findCustomer(licenseNumber, nationalIDNumber);
                        if (customer_check == null) {
                            controller.addNewCustomer(customerName, customerAge, licenseNumber, nationalIDNumber);
                            System.out.println("\nSuccessfully added new customer");
                        } else {
                            System.out.println("\nSorry customer already exist with license number " + licenseNumber);
                        }
                        break;
                    case 11:
                        System.out.println();
                        controller.displayCustomers();
                        break;
                    case 12:
                        System.out.print("Input customer's license number: ");
                        System.out.println();
                        controller.getRentDetails(in.nextLine());
                        break;
                    case 13:
                        System.out.println();
                        System.out.println("Enter the license plate number of the car: ");
                        controller.releaseCarFromRent(in.nextLine());
                        break;
                    case 14:
                        System.out.print("Input customer's license number: ");
                        String rLicenseNumber = in.nextLine();
                        Customer customer = controller.removeCustomer(rLicenseNumber);
                        if (customer == null)
                            System.out.println("Sorry no customer available with license number: " + rLicenseNumber);
                        else
                            System.out.println("CUSTOMER DETAILS: " + customer + " SUCCESSFULLY REMOVED");
                        break;
                    case 15:
                        System.out.println();
                        controller.showAllRents();
                        break;
                    case 16:
                        System.out.print("Input customer's license number: ");
                        controller.showCustomer(in.nextLine());
                        break;
                    case 0:
                        System.out.println();
                        System.out.println("Thank you for using Cardekho Car Rental System!");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Invalid Option... Please select a valid operation from the list provided!");
                        System.out.println();
                }
            } while (option != 0);
        }
    }
}
