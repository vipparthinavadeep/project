import java.util.*;

// College Class
class College {
    String name;
    String courses;
    double rating;

    College(String name, String courses, double rating) {
        this.name = name;
        this.courses = courses;
        this.rating = rating;
    }
}

public class PathFinderDSA {

    static Scanner sc = new Scanner(System.in);

    // LinkedList for Careers
    static LinkedList<String> careers = new LinkedList<>();

    // HashMap for Courses
    static HashMap<String, List<String>> courses = new HashMap<>();

    // ArrayList for Colleges
    static ArrayList<College> colleges = new ArrayList<>();


    public static void main(String[] args) {

        initializeData();

        while(true){

            System.out.println("\n==== PATHFINDER CAREER SYSTEM ====");
            System.out.println("1. View Career Options");
            System.out.println("2. View Courses");
            System.out.println("3. Search College by Name");
            System.out.println("4. Sort Colleges by Rating");
            System.out.println("5. Stack Demo (Recent Choices)");
            System.out.println("6. Queue Demo (Admission Queue)");
            System.out.println("7. Priority Queue (Top Colleges)");
            System.out.println("8. Search College by Course");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1: showCareers(); break;
                case 2: showCourses(); break;
                case 3: searchCollege(); break;
                case 4: sortColleges(); break;
                case 5: stackDemo(); break;
                case 6: queueDemo(); break;
                case 7: heapDemo(); break;
                case 8: searchByCourse(); break;
                case 0: System.exit(0);

                default: System.out.println("Invalid choice");
            }
        }
    }


    // INITIAL DATA
    static void initializeData(){

        // Career Options
        careers.add("Software Engineer");
        careers.add("Doctor");
        careers.add("Civil Engineer");
        careers.add("Chartered Accountant");
        careers.add("Lawyer");
        careers.add("Teacher");
        careers.add("Data Scientist");
        careers.add("Scientist");
        careers.add("Pilot");
        careers.add("Graphic Designer");
        careers.add("Game Developer");
        careers.add("App Developer");
        careers.add("Digital Marketer");
        careers.add("Psychologist");
        careers.add("Air Hostess");


        // Courses After 10th
        courses.put("After10", Arrays.asList(
                "Intermediate MPC",
                "Intermediate BiPC",
                "Intermediate CEC",
                "Intermediate MEC",
                "Polytechnic",
                "ITI",
                "Diploma Mechanical Engineering",
                "Diploma Civil Engineering",
                "Diploma Electrical Engineering",
                "Diploma Computer Engineering",
                "Diploma Automobile Engineering",
                "Diploma Electronics Engineering",
                "Hotel Management",
                "Agriculture",
                "Fashion Designing",
                "Animation"
        ));

        // Courses After 12th
        courses.put("After12", Arrays.asList(
                "B.Tech",
                "MBBS",
                "BDS",
                "B.Sc",
                "B.Pharmacy",
                "BCA",
                "B.Sc Agriculture",
                "B.Sc Biotechnology",
                "B.Sc Computer Science",
                "B.Sc Nursing",
                "B.Com",
                "BBA",
                "CA",
                "CS",
                "CMA",
                "BA",
                "BA Journalism",
                "BA Psychology",
                "BFA",
                "Hotel Management",
                "Fashion Designing"
        ));


        // Junior Colleges
        colleges.add(new College("Narayana Junior College", "MPC, BiPC", 9.0));
        colleges.add(new College("Sri Chaitanya Junior College", "MPC, BiPC", 9.2));
        colleges.add(new College("FIITJEE Junior College", "MPC (JEE Focus)", 9.5));
        colleges.add(new College("PAGE Junior College", "MPC, MEC", 8.8));
        colleges.add(new College("Little Flower Junior College", "MPC, MEC, CEC", 9.1));


        // B.Tech Colleges
        colleges.add(new College("KLH University (Bachupally Campus)", "B.Tech CSE, AI, Data Science, BBA", 9.3));
        colleges.add(new College("IIT Hyderabad", "B.Tech CSE, AI, Mechanical", 9.8));
        colleges.add(new College("NIT Warangal", "B.Tech All Streams", 9.6));
        colleges.add(new College("JNTU Hyderabad", "B.Tech, MBA, MCA", 9.0));
        colleges.add(new College("Mahindra University", "B.Tech, Law, Management", 9.1));
        colleges.add(new College("CBIT Hyderabad", "B.E CSE, IT, Mechanical", 8.9));
        colleges.add(new College("VNR VJIET Hyderabad", "B.Tech CSE, Auto, Mechanical", 8.8));
        colleges.add(new College("GRIET Hyderabad", "B.Tech Civil, CSE, Mechanical", 8.7));
        colleges.add(new College("CVR College of Engineering", "B.Tech CSE, ECE, EEE", 8.8));
        colleges.add(new College("MLR Institute of Technology", "B.Tech Aero, CSE, IT", 8.6));
    }


    // SHOW CAREERS
    static void showCareers(){

        System.out.println("\nCareer Options:");

        for(String c : careers)
            System.out.println("- " + c);
    }


    // SHOW COURSES
    static void showCourses(){

        System.out.println("1. After 10th");
        System.out.println("2. After 12th");

        int ch = sc.nextInt();

        if(ch == 1)
            System.out.println(courses.get("After10"));
        else
            System.out.println(courses.get("After12"));
    }


    // SEARCH COLLEGE BY NAME
    static void searchCollege(){

        sc.nextLine();

        System.out.print("Enter college name: ");
        String name = sc.nextLine().toLowerCase();

        for(College c : colleges){

            if(c.name.toLowerCase().contains(name)){

                System.out.println("\nCollege Found:");
                System.out.println("Name: " + c.name);
                System.out.println("Courses: " + c.courses);
                System.out.println("Rating: " + c.rating + "/10");

                return;
            }
        }

        System.out.println("College not found");
    }


    // SORT COLLEGES BY RATING
    static void sortColleges(){
        colleges.sort((a,b) -> Double.compare(b.rating,a.rating));
        System.out.println("\nColleges Sorted by Rating:");
        for(College c : colleges){
            System.out.println(c.name +
                    " | Courses: " + c.courses +
                    " | Rating: " + c.rating + "/10");
        }
    }


    // STACK DEMO
    static void stackDemo(){

        Stack<String> history = new Stack<>();

        history.push("Viewed Courses");
        history.push("Viewed Careers");
        history.push("Searched College");

        System.out.println("\nRecent Actions:");

        while(!history.isEmpty())
            System.out.println(history.pop());
    }


    // QUEUE DEMO
    static void queueDemo(){

        Queue<String> admissionQueue = new LinkedList<>();

        admissionQueue.add("Student A");
        admissionQueue.add("Student B");
        admissionQueue.add("Student C");

        System.out.println("\nServing Students:");

        while(!admissionQueue.isEmpty())
            System.out.println(admissionQueue.remove());
    }


    // PRIORITY QUEUE DEMO
    static void heapDemo(){

        PriorityQueue<College> pq =
                new PriorityQueue<>((a,b) -> Double.compare(b.rating,a.rating));

        pq.addAll(colleges);

        System.out.println("\nTop Colleges:");

        while(!pq.isEmpty()){

            College c = pq.poll();
            System.out.println(c.name + " | Rating: " + c.rating + "/10");
        }
    }


    // SEARCH COLLEGE BY COURSE
    static void searchByCourse(){
        sc.nextLine();
        System.out.print("Enter course (Example: B.Tech, MPC, BiPC): ");
        String course = sc.nextLine().toLowerCase();
        boolean found = false;
        for(College c : colleges){
            if(c.courses.toLowerCase().contains(course)){
                System.out.println("\nCollege: " + c.name);
                System.out.println("Courses: " + c.courses);
                System.out.println("Rating: " + c.rating + "/10");
                found = true;
            }
        }
        if(!found)
            System.out.println("No colleges found for this course.");
    }
}