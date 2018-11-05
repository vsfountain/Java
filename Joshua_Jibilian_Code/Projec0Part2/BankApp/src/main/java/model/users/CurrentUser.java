package model.users;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentUser.
 */
public class CurrentUser {
	
	/** The single instance. */
	// static variable single_instance of type CurrentUser 
    private static CurrentUser single_instance = null; 
  
    /** The s. */
    // The current user will be stored here
    public User s; 
  
    /**
     * Instantiates a new current user.
     */
    // Creates the singleton
    private CurrentUser() 
    { 
        s = null;
    } 
  
    /**
     * Gets the single instance of CurrentUser.
     *
     * @return single instance of CurrentUser
     */
    // static method to create instance of Singleton class 
    public static CurrentUser getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new CurrentUser(); 
  
        return single_instance; 
    } 
    
    /**
     * Update user.
     *
     * @param s the s
     */
    public void updateUser(User s) {
    	this.s = s;
    }
    
    /**
     * Gets the current user.
     *
     * @return the current user
     */
    public User getCurrentUser() {
    	return s;
    }
    /**
     * Removes the active user.
     */
    public void removeActiveUser() {
    	s = null;
    }
}
