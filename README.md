# Spring-Boot-Spring-MVC-Thymeleaf--Spring-Securiry
Spring Boot Spring MVC Thymeleaf Spring Data Intellij
pour qu'on puisse afficher la partie patient du menu son voir le button nouveau visible en ajoute la commande suivant "sec:authorize="hasRole('ADMIN')"" dans la valide <li>
![sec1](https://user-images.githubusercontent.com/86606579/165190556-f3ffcf03-b312-4224-ab09-268d8f1f366a.PNG)
 
  
  
  et voilà le resultat de l'affichage et comme suit le button nouveau patients ne s'affiche pas   :
 
![new](https://user-images.githubusercontent.com/86606579/165191030-e4be3ac3-aaa0-4f9e-bdca-cf0eb056d589.PNG)
 
 
 
 Pendant l'affichage de notre pas à neauveau en voix que le css de la page ne marche pas 
![index](https://user-images.githubusercontent.com/86606579/165352912-613b85f8-d5c9-4fb5-8b6c-b28497c515cd.PNG)
 
 donc pour régler ce problème là il faut autoriser les rossources statique comme suit :  http.authorizeRequests().antMatchers("/webjars/**").permitAll();
 
![index1](https://user-images.githubusercontent.com/86606579/165353440-027b1d48-0103-44eb-ad40-2036485ee0b9.PNG)
 maintenant le problème et résolu la page s'affiche correctement
 ![index2](https://user-images.githubusercontent.com/86606579/165353716-d1157257-1af4-42ee-b81e-ebc23d9c7ba6.PNG)
 
