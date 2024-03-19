# NirujanBalakrishnan-A3_COMP3005
This project implements a PostgreSQL database using a provided schema and writing an application in java that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations.


Compile Instructions:
    Intialize the Database in the query by adding this:
        CREATE TABLE students (
            student_id SERIAL PRIMARY KEY,
            first_name TEXT NOT NULL,
            last_name TEXT NOT NULL,
            email TEXT NOT NULL UNIQUE,
            enrollment_date DATE
        );

        INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
        ('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
        ('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
        ('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

    Then run the java file

Youtube Video: https://www.youtube.com/watch?v=EqlXyfqxynk&ab_channel=BB
