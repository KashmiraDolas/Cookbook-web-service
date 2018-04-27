# Cookbook-web-service
A web service (SOAP architecture) that helps you look up recipes.



## INTRODUCTION
The CookBook_handler web service developed from scratch to help users find recipes using search criterion. From the given list of recipes, using UID, the client can get more detailed information for one of the recipes. More information corresponds to health quotient or the nutritional facts of the food dish and a description that gives the detail cooking directions for that recipe.
The database is obtained from https://www.kaggle.com/hugodarwood/epirecipes/data. Has 2 files epi_r.csv and full_format_recipes.jason. The file epi_r.csv has 20051 samples and over 200 columns. This file was cleaned to exclude unnecessary data. The file full_format_recipes.jason has 20129 children each containing 11 attributes. The files were manually and programmatically cleaned (using python, .py file is attached in submission)
The two files were then copied into the database and manipulated into one table with all the relevant information required for CookBook_handler (sql query is attached in the submission). The final table was used by all the service operations to query and retrieve relevant information. This application is developed using JAVA using NETBEANS IDE.
Glassfish server 4.1.1 is used for server side.
A client side application “CookBook_client” is also developed to consume the web service and to verify the correct operation flow. The readme file provides detailed steps to recreate the project. The application design is discussed in the design section.

## DESIGN

The web service ‘CookBook_Handler’ is created as follows:
1. Database: Postgres
   Database name – CookBook_DB Table name – recipe_table
   With 30 attributes.
   Import attributes – Recipe_id, title, calories, fats, proteins, sodium, directions and 23 attributes that specify igredients.
2. Web service operations:
  
    1. FindRecipesMainIngredient – used to obtain a list of top 10 rated recipe titles with their unique id (UID). Parameter required – String Ingredient
       Return type: List<RecipeName(complex datatype)>
       Class object of RecipeName store 2 variables.
         - recipeID
         - recipeTitle
   
     2. FindRecipesHealthQuotient – used to obtained information about the input UID, such as no. of calories, fats, proteins and sodium can be extracted.
       Parameter required – String UID (from the list obtained using 1st operation) Return type: RecipeHealthQuotient
       Class object of RecipeHealthQuotient store 5 variables.
        - recipeID
        - calories
        - fat
        - protein
        - sodium
    
      3. FindRecipesDirections - used to obtained detailed cooking directions for the input UID.
         Return type: RecipeDirections
         Class object of RecipeDirections store 2 variables.
         - recipeID
         - directions

  3. SOAP message handler - 
  Create on client side and server side for improving the service consumption.
  The Server side message handler is used to logs operation invocation. A seesionId is generated at every service invocation from client side and is stored in a database. This helps establish the coordination protocol at server side to ensure correct flow of operations and to avoid exceptions.


## IMPLEMENTATION & OUTPUT
The flow of the web service is descripted in the design phase.  ![alt text][logo]



According to which, the 1st operation should always occur before 2nd or 3rd.

Correct flow output:
1. When you run the client project, it prompts you to select from the following 4 options.
2. We select 1st operation, i.e. to get the list of recipes with the desired ingredients
3. You are prompted to enter any main ingredient you want to cook with. We enter pasta.
4. A service request is sent to the web service to retrieve top rate 10 recipes with the search criteria provided.
5. Now you have an option to request for 2nd operation or 3rd operation or you can select option 4 to quit.
6. We select option 2, to get the nutrition facts for the selected recipe. Enter the UID from the list of recipes previously
obtained.
7. This service retrieves the nutrition facts for the UID.
8. Now, you either select 1st or 4th option according to the coordination protocol.
9. Repeat the same process if you wish to see the recipe description or the cooking directions
10. Enter4toexit.

#### BUILD OUTPUT DESCRIPTION


This is a readme file:

Cleaning the data.

1. Dataset is taken from https://www.kaggle.com/hugodarwood/epirecipes/data

2. Download the files, upzip and add the files to python workspace

3. Run receipe.py to process the csv and jason files.

4. Extract the output files to you working folder


Setting up database:

1. create a database on postres server with name CookBook_DB

2. Run the data.sql script to create necessary tables and manipulation operations perforemed on 2 data files (.csv format) to merge into one table ("receipe_table")


Follow the instructions to set the proeject running.

1.
	You will find 2 zip files with the name "CookBook_Handler.zip" and "CookBook_Client.zip"

2. 
	Open Netbeans
	Go to Files> Import Project> From ZIp..
	Browse to "zip_file" 
	select zip_file> open> Import

3. 
	You will see that the projects are extracted and ready

4.
	Clean and build the projects 

5.  
	Deploy CookBook_Handler

6. 
	Run the CookBook_Client

7. 
	Flow the instructions during execution
	
	
[logo]: https://github.com/KashmiraDolas/Cookbook-web-service/blob/master/images/design.png 
	



