import java.util.ArrayList;

public class Resume extends Person{
    private Person person;
    private ArrayList<Education> educationList;
    private ArrayList<Experience> experienceList;
    private ArrayList<Skills> skillsList;

    public Resume(Person person, ArrayList<Education> educationList, ArrayList<Experience> experienceList, ArrayList<Skills> skillsList) {
        this.person = person;
        this.educationList = educationList;
        this.experienceList = experienceList;
        this.skillsList = skillsList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public ArrayList<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(ArrayList<Education> educationList) {
        this.educationList = educationList;
    }

    public ArrayList<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(ArrayList<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public ArrayList<Skills> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(ArrayList<Skills> skillsList) {
        this.skillsList = skillsList;
    }

    public String toString() {
        return person.toString();
    }
}
