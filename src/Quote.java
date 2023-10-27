
public class Quote {
	protected int quote_id;
 	protected String date;
    protected String num_trees;
    protected int price;
    protected String status;
    protected boolean completed;
    
    public Quote(int quote_id, String date, String num_trees, int price, String status, boolean completed) 
    {
    	this.quote_id = quote_id;
    	this.date = date;
    	this.num_trees = num_trees;
    	this.price = price;
    	this.status = status;
    	this.completed = completed;
        
    }
}
