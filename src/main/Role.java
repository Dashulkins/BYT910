
public class Role  {
    private Employee employee;
    private String name;
    private static int authorities;
    private String description;
    
    public Role(String name, int authorities, String description) {
        this.name =name;
        this.authorities = authorities;
        this.description = description;
    }
    
    public String getName() {return name;}

    public static int getAuthorities() {return authorities;}

    public String getDescription(){return description;}

    public void setName(String name) {this.name = name;}

    public void setAuthorities(int authorities) {this.authorities = authorities;}

    public void setDescription(String description) {this.description = description;}
}
