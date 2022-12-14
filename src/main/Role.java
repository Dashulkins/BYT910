public class Role {
    private String name;
    private static int authorities;
    private String description;
    
    public Role(String name, int authorities, String description) {
        this.name = name;
        this.authorities = authorities;
        this.description = description;
    }
    
    public String getName() {return name;}

    public static int getAuthorities() {return authorities;}

    public String getDescription(){return description;}
}
