# compositePattern
**Lab Assignment 8: New Era University Hierarchy with the Composite Pattern**

This project demonstrates the application of the **Composite Design Pattern** in a university management system. The system models New Era University as a hierarchical structure of educational units, where a college can contain departments, teachers, students, and even other colleges.

## Problem Statement

New Era University is composed of various organizational units. These units can be either individual entities or compositions of other entities. The system must represent the following structure:

- **Colleges**: High-level organizational units that can contain departments, teachers, students, and other colleges.
- **Departments**: Subdivisions within a college that can contain teachers and students.
- **Teachers**: Individual entities with a name, subject, and salary.
- **Students**: Individual entities with a name, student ID, and tuition fee.

This design solves the problem by using the Composite Pattern, allowing both simple objects and grouped objects to be treated uniformly through a shared abstraction.

## Requirements

The system must be able to:

- Model the hierarchical part-whole relationship between colleges, departments, teachers, and students
- Calculate the total number of students within any college, including nested colleges and departments
- Display the details of any educational unit in a clear and organized manner
- Calculate the total budget of a college, where:
  - A college budget is the sum of all contained units
  - A department budget is the sum of its teachers and students
  - A teacher's budget is their salary
  - A student's budget is the negative value of their tuition fee

## Project Structure

```
/compositePattern/
├── README.md
└── src/labAssignment8/
	├── College.java         # Composite: represents a college that can contain other educational units
	├── Department.java      # Composite: represents a department that can contain teachers and students
	├── EducationalUnit.java # Component: common interface for all educational units
	├── Student.java         # Leaf: represents an individual student
	├── Teacher.java         # Leaf: represents an individual teacher
	└── UniversityApp.java   # Client: builds and displays the university hierarchy
```

## Composite Pattern Implementation

### 1. `EducationalUnit` Interface
Defines the common behavior for all educational units in the system.

**Key Methods:**
- `displayDetails(String indent)`: Displays the details of the unit with indentation for hierarchy formatting
- `getStudentCount()`: Returns the number of students represented by the unit
- `getBudget()`: Returns the financial contribution of the unit

### 2. Composite Classes
The composite classes store collections of other `EducationalUnit` objects and delegate work recursively.

#### `College`
- Represents a high-level organizational unit
- Can contain departments, teachers, students, and other colleges
- Recursively aggregates student count and budget from all child units

#### `Department`
- Represents a subdivision within a college
- Can contain teachers and students
- Recursively aggregates student count and budget from its children

### 3. Leaf Classes
Leaf classes implement the shared interface but do not contain other educational units.

#### `Teacher`
- Properties: `name`, `subject`, `salary`
- `displayDetails()` prints the teacher's information
- `getStudentCount()` returns `0`
- `getBudget()` returns the teacher's salary

#### `Student`
- Properties: `name`, `studentId`, `tuitionFee`
- `displayDetails()` prints the student's information
- `getStudentCount()` returns `1`
- `getBudget()` returns the negative tuition fee

### 4. `UniversityApp` Client
The client program builds the hierarchy and demonstrates the required functionality by:

- Creating teachers and students
- Organizing them into departments
- Organizing departments into colleges
- Nesting colleges inside a main university composite
- Displaying the university structure
- Calculating student counts and budgets

## Execution Flow

1. Create teacher and student objects
2. Create department composites and add leaf objects to them
3. Create college composites and add departments or other colleges
4. Create the main university structure as the top-level composite
5. Display the full hierarchy using recursive traversal
6. Compute the total number of students recursively
7. Compute the total budget recursively

## Sample Output

```
==================================================
		  NEW ERA UNIVERSITY HIERARCHY
==================================================

[College] New Era University - Main Campus
	[College] College of Computing and Information Sciences
		[Department] Department of Computer Science
			Teacher: Alice Smith | Subject: Data Structures | Salary: $60000.0
			Teacher: Bob Jones | Subject: Machine Learning | Salary: $75000.0
			Student: David Doe | ID: ID001 | Tuition: -$5000.0
			Student: Eve Adams | ID: ID002 | Tuition: -$5000.0
		Student: Hank Pym | ID: ID005 | Tuition: -$6000.0
	[College] College of Business Administration
		[Department] Department of Accountancy
			Teacher: Carol White | Subject: Accounting | Salary: $55000.0
			Student: Frank Castle | ID: ID003 | Tuition: -$4500.0
			Student: Grace Lee | ID: ID004 | Tuition: -$4500.0

==================================================
				 UNIVERSITY METRICS
==================================================

Total Students in University: 5
Total Students in College of Computing: 3

Total Budget (Net Cost) for University: $165000.0
Total Budget for Computer Science Dept: $125000.0
```

## Benefits of the Composite Pattern

✅ Treats individual units and grouped units through the same interface
✅ Makes the hierarchy easy to extend with new educational unit types
✅ Supports recursive calculation of student counts and budgets
✅ Keeps the client code simple by hiding tree traversal details
✅ Models real-world university structures naturally

## How to Run

Compile and run the main class:

```bash
cd /path/to/compositePattern/src
javac labAssignment8/*.java
java labAssignment8.UniversityApp
```

Or use your preferred Java IDE to execute `UniversityApp.java`.

## Learning Objectives

This assignment demonstrates:

- The Composite design pattern in Java
- How to build recursive part-whole object structures
- How to treat leaf and composite objects uniformly
- How to compute aggregate values recursively
- How to design a flexible and extensible object model for hierarchical systems

## UML Diagram
![alt text](https://github.com/ramdcrz/compositePattern/blob/main/compositePattern_UML.png)
