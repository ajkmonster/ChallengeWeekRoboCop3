public class Recruiter {
    private Skills skills;

    public Recruiter(Skills skills) {
        this.skills = skills;
    }

    public Recruiter() {
        skills = new Skills();
    }

    public Skills getSkills() {
        return skills;
    }

    public void setSkills(Skills skills) {
        this.skills = skills;
    }
}
