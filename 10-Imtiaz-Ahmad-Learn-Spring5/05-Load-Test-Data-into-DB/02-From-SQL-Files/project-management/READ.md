Installed Modules
=================
- Spring Web
- Thymeleaf
- Spring Data JPA
- H2 Database
- Devtools


Covered Topics
==============
- Create HTML with Thymeleaf
    - Use Thymeleaf Layouts for repetitive HTML codes
    - Access properties with "${project.id}" and "*{id}"
    - Define URL with "@{"/projects"}"
    
- Controllers (Handle REST Requests)
    - Mapping HTTP Requests with @RequestMapper 
    - Mapping GET Request Data with @GetMapping
    - Bind Data into redirect HTML pages with Model Object    
    - Mapping POST Request Data with @PostMapping
    - Dependency Inject with @Autowire (Inject DAO Repositories)

- Entities (Automatically create require tables in DB)
    - Define ID field with @Id
    - Define ID Generation Strategy with @GeneratedValue(strategy = GenerationType.AUTO)
    - Map Relationships between Entities
        - First Entity Configurations 
            - @ManyToMany (Many Project associate with Many Employees)
                - "cascade" 
                    - How Main Entity changers effect on Dependent Entities
                - "fetch"
                    - How Data of Dependent Entities get loaded
            - @JoinTable (Associate Table between join Tables)
                - "name"
                    - Name of the Associate Table
                - "joinColumns"
                    - ID column which going to be the Foreign Key of Associate Table
                - "inverseJoinColumns"
                    - Other Entity ID column which going to be the Foreign Key of Associate Table
                    
        - Second Entity Configurations
            - @ManyToMany (Many Employees associate with Many Project)
                - "cascade" 
                    - How Main Entity changers effect on Dependent Entities
                - "fetch"
                    - How Data of Dependent Entities get loaded
            - @JoinTable (Associate Table between join Tables)
                - "name"
                    - Name of the Associate Table
                - "joinColumns"
                    - ID column which going to be the Foreign Key of Associate Table
                - "inverseJoinColumns"
                    - Other Entity ID column which going to be the Foreign Key of Associate Table
                
- DAO (Repositories for handel DB Operations)
    - Override Methods
        
- Populate Data 
    - Using SQL Scripts in "resources"
        - schema.sql: To create Table Structure in DB 
            - add "spring.jpa.hibernate.ddl-auto=none" into "application.properties"            
        - data.sql : To load Initial Data into DB
            - Change ID Generating Strategy as "@GeneratedValue(strategy = GenerationType.IDENTITY)".   
                - "Primary Key" generating process not depend on Hibernate.
                - "Primary Key" generating process depend on Table Column values.
            - If set Strategy as "@GeneratedValue(strategy = GenerationType.AUTO)", 
                - Hibernate will throw Duplicate "Primary Key" Error. 
                - "Primary Key" generating process depend on Hibernate.
                - "Primary Key" generating process not depend on Table Column values.
    
    
Application Configurations
==========================
- Configure H2 DB in application.properties


H2 DB Configurations
====================
- Access URL: http://localhost:8080/h2-console
- JDBC URL: jdbc: jdbc:h2:mem:testdb
- Username: sa
- Password: <empty>