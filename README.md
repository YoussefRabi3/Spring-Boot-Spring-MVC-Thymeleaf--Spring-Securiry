# Spring-Boot-Spring-MVC-Thymeleaf--Spring-Securiry
Spring Boot Spring MVC Thymeleaf Spring Data Intellij
 ## pour qu'on puisse afficher la partie patient du menu son voir le button nouveau visible en ajoute la commande suivant
 - "sec:authorize="hasRole('ADMIN')"" dans la valide <li>
 > ![sec1](https://user-images.githubusercontent.com/86606579/165190556-f3ffcf03-b312-4224-ab09-268d8f1f366a.PNG)
 
  
  
  ## et voilà le resultat de l'affichage et comme suit le button nouveau ne s'affiche pas   :
 
> ![new](https://user-images.githubusercontent.com/86606579/165191030-e4be3ac3-aaa0-4f9e-bdca-cf0eb056d589.PNG)
 
 
 
 ## Pendant l'affichage de notre pas à neauveau en voix que le css de la page ne marche pas 
 > ![index](https://user-images.githubusercontent.com/86606579/165352912-613b85f8-d5c9-4fb5-8b6c-b28497c515cd.PNG)
 
 ## donc pour régler ce problème là il faut autoriser les rossources statique comme suit :  http.authorizeRequests().antMatchers("/webjars/**").permitAll();
 
 > ![index1](https://user-images.githubusercontent.com/86606579/165353440-027b1d48-0103-44eb-ad40-2036485ee0b9.PNG)
 ## Maintenant le problème et résolu la page s'affiche correctement
 > ![index2](https://user-images.githubusercontent.com/86606579/165353716-d1157257-1af4-42ee-b81e-ebc23d9c7ba6.PNG)
 ## Içi dans la page home quand je essaye de se connecter avec l'admin il ne donne pas l'accès à manipuler sur mon application et il affiche un message d'erreur comme vous voyez :
 >![role](https://user-images.githubusercontent.com/86606579/165501923-465a1b98-8579-4bb0-85b1-ec67df35fd00.PNG)
 
 ## aprés j'ai essayé de changer l'expression hasRole avec hasAuthority dans tous le code le l'application 
 
> ![auth](https://user-images.githubusercontent.com/86606579/165502956-27144719-1e57-49da-85ef-437243dde69a.PNG)
 
## et voilà le résultat maintenant je suis un admin je peux chercher,ajouter,modifier et supprimer
 
 > ![res](https://user-images.githubusercontent.com/86606579/165503287-0bfa206e-5ea4-4bb1-a0b0-60977c420206.PNG)

 
# PART 3
## Spring Security
## Spring MVC

- Client HTTP
- Serveur Tomcat
- Spring Security Filter

## il faut ajouter la dependence springsecurity 
 
 ![sc](https://user-images.githubusercontent.com/86606579/165523754-6b46fab6-5b8f-4bee-97f9-060d93a3f837.PNG)
##  il va afficher la page suivant ça veut dire qu'il faut s'authentifier avant l'accès à notre application avec SprintSecurityFilter
![log](https://user-images.githubusercontent.com/86606579/165524195-20019ef5-1ccf-42b3-a63c-fc809304bbdd.PNG)
 et pour s'authentifier il faut entrer Username et Password que j'ai déja préciser dans mon application
 ![pss](https://user-images.githubusercontent.com/86606579/165525124-9b6ec613-3cdb-4388-a265-039d1cd39352.PNG)
 
Après que l'authentification passe avec succès je me dérige directement vers la page d'accueil 
 
![home](https://user-images.githubusercontent.com/86606579/165526186-2e8e8d04-a340-4d64-b809-0f42bc10226f.PNG)
donc là je peux voir la liste de tous les patients 
 ![allpa](https://user-images.githubusercontent.com/86606579/165526368-8dcd8c0c-b27e-4126-b94d-da048cdb7fef.PNG)
je peux aussi supprimer un patients en demandant de confirmer la suppression 
 
 ![deletee](https://user-images.githubusercontent.com/86606579/165526675-d7bead2a-d90c-4301-8cc1-3b0bc90709bd.PNG)
 ensuite l'admin à le droit de modifier un patients ms l'utilisateur n'a pas le droit de modifier
 ![mod](https://user-images.githubusercontent.com/86606579/165527011-ec80c72a-131e-442c-8b95-73b4add75dcc.PNG)
 l'admin à le droit aussi d'ajouter un patient mais l'utilisateur n'a pas le droit
![add](https://user-images.githubusercontent.com/86606579/165527283-2d4a5866-0a45-4b13-923c-dad6e45cf047.PNG)
 la recherche est accessible pour les deux admin et l'utilisateur on le droit de chercher un patient
 ![search](https://user-images.githubusercontent.com/86606579/165527946-69184a7f-d634-489c-97ea-5a3a30f93f6a.PNG)
 ## Quand je me connecte en tant que user il ne donne le droit de chercher uniquement sans :
 > - ajouter
 > - Modifier
 > - Supprimer
![user](https://user-images.githubusercontent.com/86606579/165549887-ab5cfec2-42e1-4bb9-ba0b-ba2439bae096.PNG)
 ![cher](https://user-images.githubusercontent.com/86606579/165550162-05a19258-7d31-464b-9d37-06eb4f7fa842.PNG)
 ## voilà la base de donnée MYSQL avec les tables qu'on a utiliser :
 
> ![mysql](https://user-images.githubusercontent.com/86606579/165551873-6d54ab78-00e0-4077-a1cc-4ceb2843ad97.PNG)



 
