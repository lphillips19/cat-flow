package Database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int JobID;

    @Column
    @ManyToOne
    private Collection<Companies> company = new ArrayList<Companies>();

    @Column
    private String Name;

    @Column
    private String jobDescription;

    public Jobs(Collection<Companies> company, String Name, String jobDescription) {
        this.company = company;
        this.Name = Name;
        this.jobDescription = jobDescription;
    }

    public Jobs() {

    }

    public Collection<Companies> getCompany() {
        return company;
    }

    public void setCompany(Collection<Companies> company) {
        this.company = company;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getJobID(){
        return JobID;
    }
}
