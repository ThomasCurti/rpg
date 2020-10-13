#RPG
Cette api vous permet de vous aider à gérer vos parties de donjons et dragons.
Vous pourrez ajouter des comptes de joueurs et associer ces comptes à des personnages

Ces personnages ont une classe, des compétences, des items, des familiers et des montures

Vous pourrez mettre à jour les informations du personnage à la fin de la partie.

## Requirements
Have a mysql/mariadb started on port 3306 and run the file schema.sql (you can find it in the root of this project)

## Nouveau joueur
##### D'abord, il faut créer un compte pour le joueur
Méthode: **PUT**
```
localhost:8085/account/
{
    "name": "Thomas"
}
```
Cela va retourner l'id du compte et le nom du compte

##### Ensuite vous pouvez créer le personnage
Méthode **PUT** 
```
localhost:8085/character/
{
    "pseudo": "Mulder",
    "classe": {
        "name": "Paladin",
        "description": "Protège et sert ses coéquipiers",
        "skills": [
            {
                "name": "attaque foudroyante",
                "description": "lance un éclair"
            },
            {
                "name": "Bouclier divin",
                "description": "Rend invulnérable pendant 1 tour" 
            }
        ]
    },
    "items": [
        {
            "name": "Excalibur",
            "description": "une bonne épée"
        },
        {
            "name": "Bouclier",
            "description": "un gros bouclier"
        }
    ],
    "pets": [
        {
            "name": "chien"
        }
    ],
    "mounts": [
        {
            "name": "raptor",
            "speed": 20
        }
    ],
    "account": {
        "id": 1,
        "name": "Thomas"
    }
}
```
* Classe ne doit **jamais** être null (le personnage doit avoir une classe pour pouvoir jouer)
* Skills ne doit **jamais** être null (le personnage doit avoir au moins une compétence pour jouer)
* items peut être null
* pets peut être null
* mounts peut être null
* account ne doit **jamais** être null (le personnage doit être associé à un compte) et l'id du compte **doit être correct**

Pour voir tous les comptes avec leurs id, il suffit d'effectuer la requête suivante:

Méthode **GET**
```
localhost:8085/account/
```

## Obtenir les informations
#### Compte
Méthode **GET**
```
localhost:8085/account/
```
#### Personnage
Méthode **GET**
```
localhost:8085/character/
```
#### classe
Méthode **GET**
```
localhost:8085/class/
```
#### Guildes
Méthode **GET**
```
localhost:8085/guild/
```
#### Objets
Méthode **GET**
```
localhost:8085/item/
```
#### Monture
Méthode **GET**
```
localhost:8085/mount/
```
#### Familier
Méthode **GET**
```
localhost:8085/pet/
```
#### Compétences
Méthode **GET**
```
localhost:8085/skills/
```

## Mettre à jour les informations
#### Ajouter un familier
Méthode **PUT**
```
localhost:8085/pet/
{
    "name": "poupée",
    "characterId": "1"
}
```
* name **ne peut pas être null**
* characterId **doit être correct**

#### Ajouter une monture
Méthode **PUT**
```
localhost:8085/mount/
{
    "name": "griffon",
    "speed": 20,
    "characterId": 1
}
```
* name **ne peut pas être null**
* speed **ne peut pas être null**
* characterId **doit être correct**

#### Ajouter un item
Méthode **PUT**
```
localhost:8085/item/
{
    "name": "excalibur2",
    "description": "A great sword",
    "characterId": 1
}
```
* name **ne peut pas être null**
* description **ne peut pas être null**
* characterId **doit être correct**

#### Ajouter une compétence
Méthode **PUT**
```
localhost:8085/skills/
{
    "name": "leap",
    "description": "jump to your opponent and hit him",
    "classId": 1
}
```
* name **ne peut pas être null**
* description **ne peut pas être null**
* classId **doit être correct**

#### Ajouter une guilde
Méthode **PUT**
```
localhost:8085/guild/
{
    "name": "Noob",
    "level":  1,
  	"slogan":"On est les meilleurs"
}
```
* name **ne peut pas être null**
* level **ne peut pas être null**
* slogan **ne peut pas être null**

#### Rejoindre une guilde
Méthode **PUT**
```
localhost:8085/account/joinGuild/
{
    "accountId": 1,
    "guildId": 3
}
```
Permet de lier l'account possédant l'id *accountId* à la guilde possédant l'id *guildId*
* accountId **doit être correct**
* guildId **doit être correct**

## Supprimer des informations
#### Compte
Méthode **DELETE**
```
localhost:8085/account/{account_id}
```
**Attention** si vous supprimez un compte, vous supprimerez les personnages/les montures/les familiers/les objets/les classes/les compétences associés
#### Personnage
Méthode **DELETE**
```
localhost:8085/character/{character_id}
```
**Attention** si vous supprimez un personnage, vous supprimerez les montures/les familiers/les objets/les classes/les compétences associés
#### classe
Méthode **DELETE**
```
localhost:8085/class/{classe_id}
```
**Attention** si vous supprimez une classe, vous supprimerez les compétences associées
#### Guildes
Méthode **DELETE**
```
localhost:8085/guild/{guild_id}
```
**Attention** si vous supprimez une guilde, vous supprimerez les comptes associés à la guilde (ainsi que les personnes etc.)
Si vous ne voulez pas perdre les comptes, vous pouvez changer les compte de guilde en utilisant la méthode ci-dessous puis supprimer la guilde
Méthode **PUT**
```
localhost:8085/account/joinGuild/
{
    "accountId": <id_du_compte_à_déplacer>,
    "guildId": <id_de_la_nouvelle_guilde>
}
```
#### Objets
Méthode **DELETE**
```
localhost:8085/item/{item_id}
```
#### Monture
Méthode **DELETE**
```
localhost:8085/mount/{mount_id}
```
#### Familier
Méthode **DELETE**
```
localhost:8085/pet/{pet_id}
```
#### Compétences
Méthode **DELETE**
```
localhost:8085/skills/{skill_id}
```