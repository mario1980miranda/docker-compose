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

8. Voir les logs à "l'intérieur" du container SpringBoot

```
docker logs springboot-avec-mongodb-container-un
```

9. Acceder le bash d'un Container et commandes mongodb

```
docker exec -it mongodb-container-un bash
```

```
mongosh
```

```
use item-service-db

...
switched to db item-service-db
```

```
show collections

...
Item
ItemCategoryModel
```

```
db.Item.find().pretty()

...
[
  {
    _id: ObjectId("6479f91ce6d54a1e48f5be4c"),
    name: 'moby dick',
    description: "roman d'aventure",
    price: 50,
    _class: 'in.obify.obitemservice.model.ItemModel'
  }
]
```

```
db.ItemCategoryModel.find().pretty()

...
[
  {
    _id: ObjectId("6477a135e6d54a1e48f5be4b"),
    name: 'education',
    _class: 'in.obify.obitemservice.model.ItemCategoryModel'
  }
]
```

```
item-service-db> exit
```

```
root@b370dbe2a786:/# exit
```

# Doocker Compose

## Créer un fichier dans le repertoire resources du projet

> docker-compose.yml

## Exécuter avec Docker Compose

Aller dans le repertoire resources

```
cd src/main/resources
```

```
docker-compose up
```

## Pour excécuter

http://localhost:8090/api/v1/bienvenue
