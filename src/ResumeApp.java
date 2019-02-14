import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResumeApp {
    private static ArrayList<Resume> list;
    private static Resume resume;
    private static Person person;
    private static Education education;
    private static ArrayList<Education> educationList;
    private static Experience experience;
    private static ArrayList<Experience> experienceList;
    private static Skills skills;
    private static ArrayList<Skills> skillsList;
    private static boolean isValid;
    private static String newEdu;
    private static String newExp;
    private static String addNew;
    private static String newSkl;
    public static ResumeDatabase resumeList;
    public static void main(String[] args) {
        list = new ArrayList<>();
        resumeList = new ResumeDatabase(list);
        educationList =new ArrayList<>();
        experienceList = new ArrayList<>();
        skillsList = new ArrayList<>();

        do {
            resume =new Resume( new Person(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
            person = new Person();
            System.out.println("Here we will be asking about you.");
            System.out.print("Please enter your first name: ");
            Scanner key = new Scanner(System.in);
            String firstName = key.nextLine().toLowerCase();
            firstName =returnUpper(firstName);
            System.out.print("Please enter your last name: ");
            String lastName = key.nextLine().toLowerCase();
            lastName =returnUpper(lastName);
            String name = firstName+" "+lastName;
            person.setName(name);
            System.out.print("Please enter your telephone: ");
            String phone = key.nextLine();
            isValid=isPhoneNumberValid(phone);
            if (isValid == true){
                person.setTelephone(phone);
            } else {
                System.out.println("Invalid phone number. Try again.");
                break;
            }
            System.out.print("Please enter your email: ");
            String email = key.nextLine();
            isValid=isEmailValid(email);
            if (isValid == true) {
                person.setEmail(email);
            } else {
                System.out.println("Invalid email. Try again.");
                break;
            }
            resume.setPerson(person);
            System.out.print("Here we will be asking about your education.");
            System.out.print("Do you have any education? (Y/N): ");
            String eduAns = key.nextLine();
            do {
                education = new Education();
                if (eduAns.equalsIgnoreCase("y")) {
                    System.out.print("Please enter your degree: ");
                    String degree = key.nextLine();
                    education.setDegree(degree);
                    System.out.print("Please enter your major: ");
                    String major = key.nextLine();
                    education.setMajor(major);
                    System.out.print("Please enter your school: ");
                    String school = key.nextLine();
                    education.setSchool(school);
                    System.out.print("Please enter the year you graduated: ");
                    String year = key.nextLine();
                    education.setYear(year);
                    educationList.add(education);
                    resume.setEducationList(educationList);
                    System.out.print("Do you want to add another education? (Y/N): ");
                    newEdu = key.nextLine();
                } else {
                    break;
                }
            } while (newEdu.equalsIgnoreCase("Y"));
            System.out.print("Here we will be asking about your experience.");
            System.out.print("Do you have any experience? (Y/N): ");
            String expAns = key.nextLine();
            do {
                experience = new Experience();
                if(expAns.equalsIgnoreCase("Y")) {
                    System.out.print("Please enter your company: ");
                    String company = key.nextLine();
                    experience.setCompany(company);
                    System.out.print("Please enter your title: ");
                    String title = key.nextLine();
                    experience.setTitle(title);
                    System.out.print("Please enter the dates you worked from: ");
                    String date = key.nextLine();
                    experience.setDate(date);
                    System.out.print("Please enter your description: ");
                    String description = key.nextLine();
                    experience.setDescription(description);
                    experienceList.add(experience);
                    resume.setExperienceList(experienceList);
                    System.out.print("Do you want to add another experience? (Y/N): ");
                    newExp = key.nextLine();

                }else {
                    break;
                }
            } while (newExp.equalsIgnoreCase("Y"));

            System.out.print("Here we will be asking about your skills.");
            System.out.print("Do you have any skills? (Y/N): ");
            String sklAns = key.nextLine();
            do {
                skills = new Skills();
                if(sklAns.equalsIgnoreCase("Y")) {
                    System.out.print("Please enter your skill: ");
                    String skill = key.nextLine();
                    skills.setSkill(skill);
                    System.out.print("Please enter your proficiency (Fundamental, Novice, Intermediate, Advanced, Expert): ");
                    String rating = key.nextLine();
                    skills.setRating(rating);
                    skillsList.add(skills);
                    resume.setSkillsList(skillsList);
                    System.out.print("Do you want to add another skill? (Y/N): ");
                    newSkl = key.nextLine();
                }else {
                    break;
                }
            }while (newSkl.equalsIgnoreCase("y"));
            list.add(resume);
            resumeList.setResumelist(list);
            System.out.print("Would you like to see your resume list so far? (Y/N)");
            String print = key.nextLine();
            if (print.equalsIgnoreCase("y")){
                int y =1;
                for (Resume printer:resumeList.getResumeList()){
                    System.out.println("\n"+"Resume "+y +"\n");
                    System.out.println(printer.toString() +"\n");
                    System.out.println("Education");
                    for(Education printer1: printer.getEducationList()){
                        System.out.println(printer1.toString());
                    }
                    System.out.println("\n"+"Experience");
                    for(Experience printer2: printer.getExperienceList()){
                        System.out.println(printer2.toString());
                    }
                    System.out.println("\n"+"Skills");
                    for(Skills printer3: printer.getSkillsList()){
                        System.out.println(printer3.toString());
                    }
                    y+=1;
                }
            }
            System.out.print("\n" + "Do you want to add another Resume? (Y/N): ");
            addNew = key.nextLine();
        } while (addNew.equalsIgnoreCase("y"));
    }
    private static boolean isEmailValid(String email){
        isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    private static boolean isPhoneNumberValid(String phoneNumber){
        isValid = false;

        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }
    public static String returnUpper(String upper) {
        upper = upper.substring(0, 1).toUpperCase() + upper.substring(1).toLowerCase();
        return upper;
    }
}
