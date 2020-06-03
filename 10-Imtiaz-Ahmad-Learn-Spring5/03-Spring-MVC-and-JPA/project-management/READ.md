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
        - Main Entity Configurations 
            - @OneToMany (One Project has Many Employees)
            - "mappedBy" 
                - Main Entity Name
        - Dependent Entity Configurations
            - @ManyToOne (Many Employees work in One Project)
                - "cascade" 
                    - How Main Entity changers effect on Dependent Entities
                - "fetch"
                    - How Data of Dependent Entities get loaded
            - @JoinColumn
                - "name" 
                    - ID Column Name of the Main Entity 
                    - This Column going to be the Foreign Key of the Dependent Entity Table 

- DAO (Repositories for handel DB Operations)
    - Override Methods


Application Configurations
==========================
- Configure H2 DB in application.properties


H2 DB Configurations
====================
- Access URL: http://localhost:8080/h2-console
- JDBC URL: jdbc: jdbc:h2:mem:testdb
- Username: sa
- Password: <empty>