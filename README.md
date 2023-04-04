# IMT_assesment
To run a Spring Boot project on your computer, you need to have a few things installed. You need to have Java installed, which is the program that Spring Boot needs to run. You also need to have an IDE installed, which is a program where you write and run your code. I recommend using IntelliJ IDEA or Eclipse. Finally, you need to have either Maven or Gradle installed, which are programs that help you build and run your Spring Boot project. Once you have all of these things installed, you can download the Spring Boot project code, import it into your IDE, and run it from there.




you have two tables: "Claim" and "InsurancePolicy". Each claim belongs to a policy, and each policy can have multiple claims. To show this relationship in your Java code, you use the "@ManyToOne" annotation in the Claim and InsurancePolicy classes. This tells Java that there's a many-to-one relationship between the tables.
