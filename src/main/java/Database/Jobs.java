package Database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "jobs")
@Table
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int JobID;

    @Column
    private int CompanyID;

    @Column
    private String Name;

    @Column
    private String jobDescription;

    public Jobs(int companyID, String Name, String jobDescription) {
        this.CompanyID = companyID;
        this.Name = Name;
        this.jobDescription = jobDescription;
    }

    public Jobs() {

    }

    public int getCompany() {
        return CompanyID;
    }

    public void setCompany(int companyID) {
        this.CompanyID = companyID;
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
