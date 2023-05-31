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

## Commandes Docker :

### Login au Docker Hub

```
docker login
```

### Creation d'une image Docker

```
docker build -t <nom-image>:<version> .
```
>*Note : le point (.) signifie que le Dockerfile se trouve dans le repertoire courrent.*

### Lister toutes les images Docker

```
docker images
```

* Tag l'image et envoyer vers dockerhub/azure/aws...

```
docker tag application-un-img mariochan15/application-un-img
```

```
docker images
```

* Tag avec une version :

```
docker tag application-un-img:latest mariochan15/application-un-img:v2
```

ou

```
docker tag application-un-img mariochan15/application-un-img:v3
```

## Push d'une image vers Docker Hub

```
docker push mariochan15/application-un-img:latest
```

### Supprimer des images Docker

```
docker rmi application-un-img mariochan15/application-un-img
```

```
docker rmi mariochan15/application-un-img:v2
```

```
docker rmi mariochan15/application-un-img:v3
```

### Pull et exécution d'un container

```
docker run -p 8090:8080 mariochan15/application-un-img:latest
```

>*Note : Le Port 8090 est le port surlequel on accède à l'application depouis le localhost le Port 8080 est le port exposé dans le container*

### Lister tous les containers en cours d'exécution

```
docker ps
```

### Arrêter un conteneur

```
docker kill <CONTAINER_ID>
```

### Exécution de plusieurs Container Docker
Il faut demarrer le même conteneur dans un autre port : 

```
docker run -p 8091:8080 mariochan15/application-un-img
```

## Exécution du Container Spring Boot et le lien avec le Container MongoDB

 