package Model;

public class Subject {

    private String subjectID;
    private String name;
    private int credits;

    public Subject() {
    }

    public Subject(String subjectID, String name, int credits) {
        this.subjectID = subjectID;
        this.name = name;
        this.credits = credits;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subject) {
            Subject s = (Subject) obj;
            if (this.getCredits() == s.getCredits()
                    && this.getSubjectID().equals(s.getSubjectID())
                    && this.getName().equals(s.getName())) {
                return true;
            }
        }
        return false;
    }

}
