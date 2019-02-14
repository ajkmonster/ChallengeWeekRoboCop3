public class Skills extends Person {
    //zero or more skills - each with a Competency Proficiency rating (Fundamental, Novice, Intermediate, Advanced, Expert)
    private String skill;
    private String rating;

    public Skills(String skill, String rating) {
        this.skill = skill;
        this.rating = rating;
    }

    public Skills() {
        skill="";
        rating="";
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    @Override
    public String toString() {
        return skill +", "+rating;
    }
}
