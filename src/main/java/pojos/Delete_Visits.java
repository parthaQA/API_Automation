package pojos;

public class Delete_Visits {

    private String siteId;
    private String startDate;
    private String endDate;
    private String comment;
    private String user;

    public String getComment() {
        return comment;
    }

    public String getUser() {
        return user;
    }


    public void setSiteId(String siteId){
        this.siteId = siteId;
    }

    public void setStartDate(String startDate)
    {
        this.startDate=startDate;
    }
    public void setEndDate(String endDate)
    {
        this.endDate=endDate;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public String getSiteId()
    {
        return  siteId;
    }
    public String getStartDate()
    {
        return  startDate;
    }
    public String getEndDate()
    {
        return endDate;
    }
}
