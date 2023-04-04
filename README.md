# IMT_assesment
HOW TO RUN THE CODE:-
To run a Spring Boot project on your computer, you need to have a few things installed. You need to have Java installed, which is the program that Spring Boot needs to run. You also need to have an IDE installed, which is a program where you write and run your code. I recommend using IntelliJ IDEA or Eclipse. Finally, you need to have either Maven or Gradle installed, which are programs that help you build and run your Spring Boot project. Once you have all of these things installed, you can download the Spring Boot project code, import it into your IDE, and run it from there. Run it in Postmen.


ABOUT THE CODE:-
 The classes have the necessary annotations to indicate that they are JPA entities and map to tables in a database. The InsurancePolicy class has a ManyToOne relationship with the Client class and a OneToMany relationship with the Claim class. The Claim class has a ManyToOne relationship with the InsurancePolicy class.
you have two tables: "Claim" and "InsurancePolicy". Each claim belongs to a policy, and each policy can have multiple claims. To show this relationship in your Java code, you use the "@ManyToOne" annotation in the Claim and InsurancePolicy classes. This tells Java that there's a many-to-one relationship between the tables.

H2 console available at 'http://localhost:8082/h2-console' -then put 'jdbc:h2:mem:testdb' in JDBC URL and you will be connected to Db.

Dummy sql to run :-

---to populate Clients
INSERT INTO Clients(address, CONTACT_INFORMATION, DATE_OF_BIRTH, name) VALUES
('123 Main St, Bengaluru, Karnataka', 'rajeshkumar@gmail.com', '1990-01-01', 'Rajesh Kumar'),
('456 Second St, Mumbai, Maharashtra', 'priyasingh@yahoo.com', '1992-05-15', 'Priya Singh'),
('789 Third St, Ahmedabad, Gujarat', 'amitpatel@hotmail.com', '1985-12-31', 'Amit Patel'),
('321 Fourth St, New Delhi, Delhi', 'meerasharma@gmail.com', '1999-06-22', 'Meera Sharma'),
('555 Fifth St, Chennai, Tamil Nadu', 'sanjaygupta@yahoo.com', '1978-09-18', 'Sanjay Gupta'),
('777 Sixth St, Hyderabad, Telangana', 'sarahwilliams@hotmail.com', '1982-03-11', 'Sarah Williams'),
('999 Seventh St, Kolkata, West Bengal', 'davidbrown@gmail.com', '1995-11-27', 'David Brown'),
('888 Eighth St, Pune, Maharashtra', 'karendavis@yahoo.com', '1991-07-09', 'Karen Davis'),
('111 Ninth St, Jaipur, Rajasthan', 'jasonwhite@hotmail.com', '1987-02-14', 'Jason White'),
('222 Tenth St, Bengaluru, Karnataka', 'melissagreen@gmail.com', '1994-10-03', 'Melissa Green');

---to populate CLAIMS
INSERT INTO CLAIMS (CLAIM_DATE, CLAIM_NUMBER, CLAIM_STATUS, DESCRIPTION, POLICY_ID)
VALUES
    ('2022-01-01', 'CLAIM001', 'PENDING', 'Claim for medical expenses incurred due to an injury sustained during exercise.', 1),
    ('2022-02-01', 'CLAIM002', 'IN_PROGRESS', 'Claim for treatment of a chronic health condition.', 2),
    ('2022-03-01', 'CLAIM003', 'SETTLED', 'Claim for hospitalization due to an acute illness.', 3),
    ('2022-04-01', 'CLAIM004', 'DENIED', 'Claim for elective cosmetic surgery that is not covered under the policy.', 4),
    ('2022-05-01', 'CLAIM005', 'PENDING', 'Claim for diagnostic tests to investigate a potential health issue.', 5),
    ('2022-06-01', 'CLAIM006', 'IN_PROGRESS', 'Claim for physical therapy following a sports-related injury.', 6),
    ('2022-07-01', 'CLAIM007', 'SETTLED', 'Claim for emergency medical treatment received while traveling abroad.', 7),
    ('2022-08-01', 'CLAIM008', 'DENIED', 'Claim for alternative medicine treatment that is not covered under the policy.', 8),
    ('2022-09-01', 'CLAIM009', 'PENDING', 'Claim for mental health counseling sessions.', 9),
    ('2022-10-01', 'CLAIM010', 'IN_PROGRESS', 'Claim for prescription medication for a chronic health condition.', 10);
    
---to populate INSURANCE_POLICIES
INSERT INTO INSURANCE_POLICIES (COVERAGE_AMOUNT, END_DATE, POLICY_NUMBER, PREMIUM, START_DATE, TYPE, CLIENT_ID)
VALUES
(100000, '2024-03-31', 'POL001', 500, '2023-03-31', 'Auto', 1),
(200000, '2024-04-30', 'POL002', 750, '2023-04-30', 'Home', 2),
(300000, '2024-05-31', 'POL003', 1000, '2023-05-31', 'Life', 3),
(500000, '2024-07-31', 'POL005', 1500, '2023-07-31', 'Auto', 5),
(600000, '2024-08-31', 'POL006', 1750, '2023-08-31', 'Home', 6),
(700000, '2024-09-30', 'POL007', 2000, '2023-09-30', 'Life', 7),
(900000, '2024-11-30', 'POL009', 2500, '2023-11-30', 'Auto', 9),
(1000000, '2024-12-31', 'POL010', 2750, '2023-12-31', 'Home', 10),
(100000, '2024-03-31', 'POL001', 500, '2023-03-31', 'Health', 1),
(200000, '2024-04-30', 'POL002', 750, '2023-04-30', 'Health', 2),
(300000, '2024-05-31', 'POL003', 1000, '2023-05-31', 'Health', 3),
(400000, '2024-06-30', 'POL004', 1250, '2023-06-30', 'Health', 4),
(500000, '2024-07-31', 'POL005', 1500, '2023-07-31', 'Health', 5),
(600000, '2024-08-31', 'POL006', 1750, '2023-08-31', 'Health', 6),
(700000, '2024-09-30', 'POL007', 2000, '2023-09-30', 'Health', 7),
(800000, '2024-10-31', 'POL008', 2250, '2023-10-31', 'Health', 8),
(900000, '2024-11-30', 'POL009', 2500, '2023-11-30', 'Health', 9),
(1000000, '2024-12-31', 'POL010', 2750, '2023-12-31', 'Health', 10),
(50000, '2024-03-31', 'POL011', 250, '2023-03-31', 'Property', 1),
(100000, '2024-04-30', 'POL012', 375, '2023-04-30', 'Property', 2),
(150000, '2024-05-31', 'POL013', 500, '2023-05-31', 'Property', 3),
(200000, '2024-06-30', 'POL014', 625, '2023-06-30', 'Property', 4),
(250000, '2024-07-31', 'POL015', 750, '2023-07-31', 'Property', 5),
(300000, '2024-08-31', 'POL016', 875, '2023-08-31', 'Property', 6),
(350000, '2024-09-30', 'POL017', 1000, '2023-09-30', 'Property', 7),
(400000, '2024-10-31', 'POL018', 1125, '2023-10-31', 'Property', 8),
(450000, '2024-11-30', 'POL019', 1250, '2023-11-30', 'Property', 9),
(500000, '2024-12-31', 'POL020', 1375, '2023-12-31', 'Property', 10);



URLS:-
GET ALL DATA
all clients:-
http://localhost:8082/Imp/clients
all policies-
http://localhost:8082/api/policies
all claims-
http://localhost:8082/api/claims
GET DATA BY ID
get 1 clients:-
http://localhost:8082/Imp/clients/1
get 1 policies-
http://localhost:8082/api/policies/1
get 1 claims-
http://localhost:8082/api/claims/1
POST -UPDATE OR ADD DATA
http://localhost:8082/Imp/clients
http://localhost:8082/api/policies
http://localhost:8082/api/claims
PUT -UPDATE DATA BY ID
http://localhost:8082/Imp/clients/1
http://localhost:8082/api/policies/1
http://localhost:8082/api/claims/1
DELETE -DELETE DATA BY ID
http://localhost:8082/Imp/clients/1
http://localhost:8082/api/policies/1
http://localhost:8082/api/claims/1
