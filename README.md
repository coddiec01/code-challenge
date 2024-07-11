![image](https://github.com/coddiec01/code-challenge/assets/160797879/1584e681-3f69-4e36-9f4d-428c72b9cc5c)

# Code Challenge Application
Application to register and sign in a user on Imgur using an Imgur API

This application uses various Spring Framework components. For a detailed list of work cited references, please see the [Work Cited References](docs/work_cited.md) document.

## The application considers the following in it's development: 

Create a Spring Boot REST app that exposes endpoints to -->

• Register a User with basic information, username, and password
• Upload, view and delete images after authorizing the username/password.
• Associate the updated list of images with the user profile
• View the User Basic Information and the Images

Furthermore, it integrates with Imgur API to upload, view, and delete the images.

### Additonal Considerations

• Aplpication incorporates the use of H2 (In-memory database) and JPA through added dependencies and within the User and Image repository for database retrieval of 
  the user's username and password to authenticate the user.

• Integrated the Imgur's API to enable uploading, viewing, and deleting of user's images extracted through the user's Id. 

• Although UI was not implemented, HTML and CSS files can be incorporated through the Controller layer as this is the layer that communicates with the HTTP client-side, 
  by returning the HTML and CSS "forms" within the Controller layer to deliver uppon request.
  
• Test cases were implemented and attempted with all layers of the architecture (Controller, Service, and Repository) in consideration.

### Bonus
• Securing the API via oAuth2 was attempted.
