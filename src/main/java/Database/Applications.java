package Database;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "applications")
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private int ApplicationID;

    @Column
    @ManyToOne
    private Collection<Candidates> candidate = new ArrayList<Candidates>();

    @Column
    @ManyToOne
    private Collection<Jobs> job = new ArrayList<Jobs>();

    public Applications(int JobID, Collection<Candidates> candidate){
        this.ApplicationID = JobID;
        this.candidate = candidate;
    }

    public Applications(){

    }

    public int getApplicationID() {
        return ApplicationID;
    }

    public Collection<Candidates> getCandidateID() {
        return candidate;
    }

    public Collection<Jobs> getJobID() {
        return job;
    }

    public void setJob(Collection<Jobs> job) {
        this.job = job;
    }

    public void setCandidate(Collection<Candidates> candidate) {
        this.candidate = candidate;
    }
}
