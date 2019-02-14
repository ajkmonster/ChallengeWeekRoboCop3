import java.util.ArrayList;

public class ResumeDatabase {
    private ArrayList<Resume> resumeList;
    public ResumeDatabase(ArrayList<Resume> resumeList) {
        this.resumeList = resumeList;
    }

    public ArrayList<Resume> getResumeList() {
        return resumeList;
    }

    public void setResumelist(ArrayList<Resume> resumeList) {
        this.resumeList = resumeList;
    }
}
