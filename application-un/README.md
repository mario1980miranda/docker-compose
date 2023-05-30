# Docker
* Créer le fichier Dockerfile
* Utiliser une image Java

```
FROM openjdk:17
```

* Demander au container d'exposer le port 8080

```
EXPOSE 8080
```

* Optionel : ajouter dans le pom.xml la balise :

```xml
	...
		</plugins>
		<finalName>app</finalName>
	</build>
```

* Ajouter dans Dockerfile l'instruction :

```
ADD target/app.jar app.jar
```

> copier dans l'image app.jar

* Instruction entrypoint

```
ENTRYPOINT ["java","-jar","app.jar"]
```

* Commandes CMD :

```
docker login
docker build -t application-un-img .
docker images
```

* Tag l'image et envoyer vers dockerhub/azure/aws...

```
docker tag application-un-img mariochan15/application-un-img
```
```
docker images
```