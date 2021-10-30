
AJOUT CV

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "shao", "prenom":"isabelle","email":"sdsdf@dsd", "tel": "0112", "content":"eeeeeeeee", "tags" : ["C", "Haskell"]}'

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "shao", "prenom":"Lucie","email":"sdsdf@dsd", "tel": "0112", "content":"eeeeeeeee", "tags" : ["Python", "Haskell"]}'
curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "Nhaila", "prenom":"Kaoutar","email":"sdsdf@dsd", "tel": "0112", "content":"eeeeeeeee", "tags" : ["OCaml", "Java"]}'

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "Daemi", "prenom":"Maédé","email":"sdsdf@dsd", "tel": "0112", "content":"eeeeeeeee", "tags" : ["Python", "Haskell", "swift"]}'


//RECHERCHE LES cv du Xieme au yieme
curl -sS  'http://127.0.0.1:8080/api/v1/lhom?from=0&to=30

// RECHERCHE par tags
curl http://127.0.0.1:8080/api/v1/lhom?tag=ocaml
curl http://127.0.0.1:8080/api/v1/lhom?tag=swift&tag=ocaml

// par nom, prenom 
curl http://127.0.0.1:8080/api/v1/lhom?nom=shao
curl http://127.0.0.1:8080/api/v1/lhom?prenom=isabelle
curl http://127.0.0.1:8080/api/v1/lhom?nom=shao&prenom=isabelle

//afficher tous les cv : 
curl http://127.0.0.1:8080/api/v1/lhom


