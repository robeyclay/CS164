/**
 * This class basically traverses or "crawls" the data pulling out the gender data
 * It is a good starting point to see how structured data can simplify calculations later. 
 * 
 * @author Albert Lionelle <br> 
 *         lionelle@colostate.edu <br> 
 *         Computer Science Department <br> 
 *         Colorado State University
 * @version 202010
 */
public class CollegeStats {
    UniversityData data;
    
    
    public CollegeStats(UniversityData data) {
        this.data = data;
    }

    /**
     * This is a complicated series of nested loops but basically, looks
     * at each term, then through all colleges, and then departments and majors in that department
     * posts the stats. 
     */
    public void run() {
        for(TermPair pair : data.getTerms()) {
            Logger.console("\t\t================ Term: %d ================\n", pair.term);
            for(College cl : pair.list.getColleges()) {
                Logger.console("%s%n", cl.getName());
                for(Department dep : cl.getDepartments()) {
                    for(Major major : dep.getMajors()) {
                        Logger.console("%34s:", major.getName());
                        for(Pair pr : major.getPercents()) {
                            Logger.console("%10s: %6.2f%%", pr.name, pr.value);
                        }
                        Logger.console("\n");
                    }
                }
                Logger.console("\n");
            }
        }
        Logger.console("\n\n");
    }
}
