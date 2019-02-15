public class Experience extends Person {
    //zero or more experiences each contains a company, title, date and description,
    private String company;
    private String title;
    private String date;
    private String description;

    public Experience(String company, String title, String date, String description) {
        this.company = company;
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public Experience() {
        company = "";
        title = "";
        date = "";
        description = "";
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + "\n" +
                company + ", " + date + "\n" +
                description + "\n";
    }
}
