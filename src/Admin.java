import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends Person {
    static Scanner input = new Scanner(System.in);
    static Scanner DescriptionInput = new Scanner(System.in);
    public static String eventDetails = null;
    String eventName;
    String eventDate;
    String eventLocation;

    public Admin(String eventName, String eventDate, String eventLocation) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        eventDetails = eventName + "  " + eventDate + "  " + eventLocation;
    }

    public static void login() throws IOException {
        DescriptionInput.useDelimiter("\n");
        System.out.println("-------------------------------------------");
        System.out.println(" 1-Add Course");
        System.out.println(" 2-Update Course");
        System.out.println(" 3-Delete Course");
        System.out.println(" 4-View instructors information");
        System.out.println(" 5-View students information");
        System.out.println(" 6-View courses information");
        System.out.println(" 7-assign instructor to course");
        System.out.println(" 8-Drop Instructor");
        System.out.println(" 9-Drop Student");
        System.out.println(" 10-Add Event");
        System.out.println(" 11-Delete Event");
        System.out.println(" 12-Logout");
        System.out.println(" 13-Exit");
        System.out.println("-------------------------------------------");
        int choice = 0;
        choice = input.nextInt();
        switch (choice) {
            case 1:
                String courseCodeAdd;
                String courseTitleAdd;
                int creditsAdd = -1;
                String departmentAdd;
                String descriptionAdd;
                String[] sessionDatesAdd = new String[2];
                System.out.println("Course Code: ");
                courseCodeAdd = input.next();
                System.out.println("Course Title: ");
                courseTitleAdd = DescriptionInput.next();
                System.out.println("Credits: ");
                boolean read11 = false;
                do {
                    try {
                        creditsAdd = input.nextInt();
                        read11 = true;
                    } catch (InputMismatchException excption) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read11);
                System.out.println("Department: ");
                departmentAdd = input.next();
                System.out.println("Description: ");
                descriptionAdd = DescriptionInput.next();
                System.out.println("Session 1 date: ");
                sessionDatesAdd[0] = input.next();
                System.out.println("Session 2 date: ");
                sessionDatesAdd[1] = input.next();
                addCourse(courseCodeAdd, courseTitleAdd, creditsAdd, departmentAdd, descriptionAdd, sessionDatesAdd);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice1 = -1;
                boolean read12 = false;
                do {
                    try {
                        moreOperationsChoice1 = input.nextInt();
                        read12 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read12);
                if (moreOperationsChoice1 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 2:
                String courseCodeUpdate;
                String newCourseCodeUpdate;
                String newCourseTitleUpdate;
                int newCreditsUpdate = -1;
                String newDepartmentUpdate;
                String newDescriptionUpdate;
                String[] newSessionDatesUpdate = new String[2];
                System.out.println("Input code of the course you want to update: ");
                courseCodeUpdate = input.next();
                System.out.println("New Course Code: ");
                newCourseCodeUpdate = input.next();
                System.out.println("Course Title: ");
                newCourseTitleUpdate = DescriptionInput.next();
                System.out.println("Credits: ");
                boolean read21 = false;
                do {
                    try {
                        newCreditsUpdate = input.nextInt();
                        read21 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read21);

                System.out.println("Department: ");
                newDepartmentUpdate = input.next();
                System.out.println("Description: ");
                newDescriptionUpdate = DescriptionInput.next();
                System.out.println("Session 1 date: ");
                newSessionDatesUpdate[0] = input.next();
                System.out.println("Session 2 date: ");
                newSessionDatesUpdate[1] = input.next();

                updateCourse(courseCodeUpdate, newCourseCodeUpdate, newCourseTitleUpdate, newCreditsUpdate,
                        newDepartmentUpdate, newDescriptionUpdate, newSessionDatesUpdate);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice2 = -1;
                boolean read22 = false;
                do {
                    try {
                        moreOperationsChoice2 = input.nextInt();
                        read22 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read22);
                if (moreOperationsChoice2 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 3:
                System.out.println("Code of the course you want to delete: ");
                String courseCodeDelete;
                courseCodeDelete = input.next();
                deleteCourse(courseCodeDelete);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice3 = -1;
                boolean read31 = false;
                do {
                    try {
                        moreOperationsChoice3 = input.nextInt();
                        read31 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read31);
                if (moreOperationsChoice3 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 4:
                showInstructorsInformation();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice4 = -1;
                boolean read41 = false;
                do {
                    try {
                        moreOperationsChoice4 = input.nextInt();
                        read41 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read41);
                if (moreOperationsChoice4 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 5:
                showStudentsInformation();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice5 = -1;
                boolean read51 = false;
                do {
                    try {
                        moreOperationsChoice5 = input.nextInt();
                        read51 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read51);
                if (moreOperationsChoice5 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 6:
                showCoursesInformation();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice6 = -1;
                boolean read61 = false;
                do {
                    try {
                        moreOperationsChoice6 = input.nextInt();
                        read61 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read61);
                if (moreOperationsChoice6 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 7:
                int instructorIdAssign;
                String courseCodeAssign;
                System.out.println("Instructor ID: ");
                instructorIdAssign = input.nextInt();
                System.out.println("Course Code: ");
                courseCodeAssign = input.next();
                isInstructorFreeAndTheCourseEmpty(instructorIdAssign, courseCodeAssign);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice7 = -1;
                boolean read71 = false;
                do {
                    try {
                        moreOperationsChoice7 = input.nextInt();
                        read71 = true;
                    } catch (InputMismatchException excep) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read71);
                if (moreOperationsChoice7 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 8:
                int instructorIdDrop = -1;
                System.out.println("ID of instructor yow want to drop: ");
                boolean read81 = false;
                do {
                    try {
                        instructorIdDrop = input.nextInt();
                        read81 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read81);
                dropInstructor(instructorIdDrop);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice8 = -1;
                boolean read82 = false;
                do {
                    try {
                        moreOperationsChoice8 = input.nextInt();
                        read82 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read82);
                if (moreOperationsChoice8 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 9:
                dropStudent();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice9 = -1;
                boolean read91 = false;
                do {
                    try {
                        moreOperationsChoice9 = input.nextInt();
                        read91 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read91);
                if (moreOperationsChoice9 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 10:
                String eventName;
                String eventDate;
                String eventLocation;
                System.out.println("Event Name: ");
                eventName = input.next();
                System.out.println("Event Date: ");
                eventDate = input.next();
                System.out.println("Event Location: ");
                eventLocation = input.next();
                addEvent(eventName, eventDate, eventLocation);
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice10 = -1;
                boolean read10 = false;
                do {
                    try {
                        moreOperationsChoice10 = input.nextInt();
                        read10 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read10);
                if (moreOperationsChoice10 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 11:
                deleteEvent();
                System.out.println("Do you want more operations?");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice11 = -1;
                boolean read111 = false;
                do {
                    try {
                        moreOperationsChoice11 = input.nextInt();
                        read111 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read111);
                if (moreOperationsChoice11 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
                break;
            case 12:
                Main.main(null);
                break;
            case 13:
                break;
            default:
                System.out.println("Invalid choice");
                System.out.println("Do you want to try again? ");
                System.out.println("1-yes");
                System.out.println("2-No");
                int moreOperationsChoice777 = -1;
                boolean read131 = false;
                do {
                    try {
                        moreOperationsChoice777 = input.nextInt();
                        read131 = true;
                    } catch (InputMismatchException exception) {
                        System.out.println("---------------------------------------");
                        System.out.println("Invalid! Please enter numeric value: ");
                        System.out.println("---------------------------------------");
                        input.next();
                    }
                } while (!read131);
                if (moreOperationsChoice777 == 1) {
                    login();
                } else {
                    Main.main(null);
                }
        }

    }

    public static void showInstructorsInformation() {
        int counter = 1;
        if (Main.instructors.isEmpty()) {
            System.out.println("---------------------------------------");
            System.out.println("No instructors to display");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("---------------------------------------");
            for (Instructor instructor : Main.instructors) {
                System.out.println(counter + " : ");
                instructor.display();
                System.out.println();
                counter = counter + 1;
            }
            System.out.println("---------------------------------------");
        }
    }

    public static void showStudentsInformation() {
        int counter = 1;
        if (Main.students.isEmpty()) {
            System.out.println("---------------------------------------");
            System.out.println("No Students to display");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("---------------------------------------");
            for (Student student : Main.students) {
                System.out.println(counter + " : ");
                student.DisplayForAdminClass();
                System.out.println();
                counter = counter + 1;
            }
            System.out.println("---------------------------------------");
        }
    }

    public static void showCoursesInformation() {
        int counter = 1;
        if (Main.courses.isEmpty()) {
            System.out.println("---------------------------------------");
            System.out.println("No Courses to display");
            System.out.println("---------------------------------------");
        } else {
            System.out.println("---------------------------------------");
            for (Course course : Main.courses) {
                System.out.println(counter + " : ");
                course.displayInfo();
                System.out.println();
                counter = counter + 1;
            }
            System.out.println("---------------------------------------");
        }

    }

    public static void addCourse(String courseCode, String courseTitle, int credits, String department,
                                 String description, String[] sessionDates)  //>>pass these parameters from main
    {
        Course course = new Course(courseCode, courseTitle, credits, department, description, sessionDates);
        Main.courses.add(course);
    }

    public static void updateCourse(String courseCode, String newCourseCode, String newCourseTitle,
                                    int newCredits, String newDepartment, String newDescription, String[] newSessionDtes) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDtes);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.set(courseIndex, course);
            }
        }
        updateUpdatedCourseInInstructor(courseCode, newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDtes);
    }

    public static void updateUpdatedCourseInInstructor(String courseCode, String newCourseCode, String newCourseTitle,
                                                       int newCredits, String newDepartment, String newDescription,
                                                       String[] newSessionDates) {
        Course course = new Course(newCourseCode, newCourseTitle, newCredits, newDepartment, newDescription, newSessionDates);
        try {
            for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                if ((!Main.instructors.get(instrcutorIndex).course.isEmpty()) && (Main.instructors.get(instrcutorIndex).course.get(0).getCourseCode().equals(courseCode))) {
                    Main.instructors.get(instrcutorIndex).course.set(0, course);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Take Care, NullPointerException!!");
        }
    }

    public static void deleteCourse(String courseCode) {
        deleteCourseFromInstructor(courseCode);
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                Main.courses.remove(courseIndex);
            }
        }
    }

    public static void deleteCourseFromInstructor(String courseCode) {
        try {
            for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                if ((!Main.instructors.get(instrcutorIndex).course.isEmpty()) && (Main.instructors.get(instrcutorIndex).course.get(0).getCourseCode().equals(courseCode))) {
                    Main.instructors.get(instrcutorIndex).course.remove(0);
                }
            }
        } catch (NullPointerException ex) {
            System.out.println("Take Care, Null Pointer Exception!!");
        }
    }


    //once admin choose to assign instructor to course, we just call  isInstructorFree()
    public static void isInstructorFreeAndTheCourseEmpty(int instructorID, String courseCode) {
        boolean instructorExist = false;
        boolean courseExist = false;
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                instructorExist = true;
                if (!(Main.instructors.get(instrcutorIndex).course.isEmpty())) {
                    System.out.println("-----------------------------------------------");
                    System.out.println("Dr." + Main.instructors.get(instrcutorIndex).getFname() + " " +
                            Main.instructors.get(instrcutorIndex).getLname() +
                            " already has a course! ");
                    System.out.println("-----------------------------------------------");
                } else {
                    for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                        if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                            courseExist = true;
                            if (!(Main.courses.get(courseIndex).assignedInstructor.isEmpty())) {
                                System.out.println("-------------------------------------------");
                                System.out.println(Main.courses.get(courseIndex).courseTitle +
                                        " Course already has an instructor!");
                                System.out.println("--------------------------------------------");

                            } else {
                                assignCoursesToInstructors(courseCode, instructorID);
                                assignInstructorsToCourses(courseCode, instructorID);
                                System.out.println("******************");
                                System.out.println("Done Successfully.");
                                System.out.println("******************");
                                break;
                            }
                        }
                    }
                }
            }
        }
        if ((!instructorExist) || (!courseExist)) {
            System.out.println("--------------------------------------------");
            System.out.println(" Instructor ID or Course Code is not Exist ");
            System.out.println("--------------------------------------------");
        }


    }

    public static void assignCoursesToInstructors(String courseCode, int instructorID) {
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                    if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                        Main.instructors.get(instrcutorIndex).course.add(Main.courses.get(courseIndex));
                    }
                }
            }
        }
    }

    public static void assignInstructorsToCourses(String courseCode, int instructorID) {
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            if (Main.courses.get(courseIndex).getCourseCode().equals(courseCode)) {
                for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
                    if (Main.instructors.get(instrcutorIndex).getID() == instructorID) {
                        Main.courses.get(courseIndex).assignedInstructor.add(Main.instructors.get(instrcutorIndex));
                    }
                }

            }
        }

    }

    public static void dropInstructor(int instructorId) {
        deleteDeletedInstructorFromTheCourse(instructorId);
        for (int instrcutorIndex = 0; instrcutorIndex < Main.instructors.size(); instrcutorIndex++) {
            if (Main.instructors.get(instrcutorIndex).getID() == instructorId) {
                Main.instructors.remove(instrcutorIndex);
            }
        }

    }

    public static void deleteDeletedInstructorFromTheCourse(int instructorId) {
        for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
            try {
                if ((!Main.courses.get(courseIndex).assignedInstructor.isEmpty()) && (Main.courses.get(courseIndex).assignedInstructor.get(0).getID() == instructorId)) {
                    Main.courses.get(courseIndex).assignedInstructor.remove(0);
                }
            } catch (IndexOutOfBoundsException IdxOOFB) {
                System.out.println("--------------------------------------");
                System.out.println("Take Care, IndexOutOfBoundsException");
                System.out.println("--------------------------------------");
            }
        }
    }

    public static void dropStudent() {
        int flag = 0;
        ArrayList<Integer> studentsId = new ArrayList<>();
        ArrayList<Integer> enrolledStudentsIdArray = new ArrayList<>();
        for (int studentIndex1 = 0; studentIndex1 < Main.students.size(); studentIndex1++) {
            if (Main.students.get(studentIndex1).isGpaDrop()) {

                for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                    for (int enrolledStudentsIndex = 0; enrolledStudentsIndex < Main.courses.get(courseIndex).enrolledStudents.size();
                         enrolledStudentsIndex++) {
                        if (Main.courses.get(courseIndex).enrolledStudents.get(enrolledStudentsIndex).getID() ==
                                Main.students.get(studentIndex1).getID()) {
                            enrolledStudentsIdArray.add(Main.students.get(studentIndex1).getID());
                        }
                    }


                    studentsId.add(Main.students.get(studentIndex1).getID());

                }
            }
        }
        for (int studentsIdIndex = 0; studentsIdIndex < studentsId.size(); studentsIdIndex++) {
            for (int studentIndex2 = 0; studentIndex2 < Main.students.size(); studentIndex2++) {
                if (studentsId.get(studentsIdIndex) == Main.students.get(studentIndex2).getID()) {
                    Main.students.remove(studentIndex2);
                    flag = 1;
                    break;
                }
            }
        }
        for (int enrolledStudentsIDIndex = 0; enrolledStudentsIDIndex < enrolledStudentsIdArray.size(); enrolledStudentsIDIndex++) {
            for (int courseIndex = 0; courseIndex < Main.courses.size(); courseIndex++) {
                for (int courseEnrolledStudentsIndex = 0; courseEnrolledStudentsIndex <
                        Main.courses.get(courseIndex).enrolledStudents.size(); courseEnrolledStudentsIndex++) {
                    if (enrolledStudentsIdArray.get(enrolledStudentsIDIndex) == Main.courses.get(courseIndex).
                            enrolledStudents.get(courseEnrolledStudentsIndex).getID()) {
                        Main.courses.get(courseIndex).enrolledStudents.remove(courseEnrolledStudentsIndex);
                        break;
                    }
                }
            }

        }
        if (flag == 0) {
            System.out.println("---------------------");
            System.out.println("No Students to drop");
            System.out.println("----------------------");
        }

    }

    public static void addEvent(String eventName, String eventDate, String eventLocation)  //from main when admin choose to add event
    {
        eventDetails = eventName + "  " + eventDate + "  " + eventLocation;
        Admin event = new Admin(eventName, eventDate, eventLocation);
        Main.eventDetails.add(event);
    }

    public static void deleteEvent() {
        Main.eventDetails.remove(0);
    }

    public String toString() {
        return eventName + "," + eventDate + "," + eventLocation;
    }

}