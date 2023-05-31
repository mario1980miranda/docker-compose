# Exécution de MongoDB dans un Container

1. Accèder le site Docker Hub
2. Rechercher une image "mongo"
3. Docker pull et exécuter Container MongoDB

```
docker pull mongo:latest
```
```
docker run -d -p 28000:27017 --name mongodb-container-un mongo:latest
```
>*Note : -d -> run mongodb dans un container en mode detache*

>*Note : -p -> exposer un port*

4. Construire une image de notre application

```
docker build -t springboot-avec-mongodb:v1 .
```

5. Tagger l'image pour faire un push sur le docker hub

```
docker tag springboot-avec-mongodb:v1 mariochan15/springboot-avec-mongodb:v1
```

6. Push image vers le docker hub

```
docker push mariochan15/springboot-avec-mongodb:v1
```

7. Execution du container Springboot avec lien vers le container de MongoDB

```
docker run -p 8090:8081 --name springboot-avec-mongodb-container-un --link mongodb-container-un:mongo -d mariochan15/springboot-avec-mongodb:v1
```

8. 

```
docker logs springboot-avec-mongodb-container-un
```
