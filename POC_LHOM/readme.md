
AJOUT CV

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "shao", "prenom":"isabelle","email":"sdsdf@dsd", "tel": "0112", "content":"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.", "tags" : ["Java", "Haskell", "Javascript"]}'

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "shao", "prenom":"Lucie","email":"sdsdf@dsd", "tel": "0112", "content":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "tags" : ["Python", "Haskell"]}'
curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "Nhaila", "prenom":"Kaoutar","email":"sdsdf@dsd", "tel": "0112", "content":"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?", "tags" : ["OCaml", "Java"]}'

curl -X POST http://127.0.0.1:8080/api/v1/lhom -H 'Content-Type: application/json' -d '{"nom" : "Daemi", "prenom":"Maédé","email":"sdsdf@dsd", "tel": "0112", "content":"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "tags" : ["Python", "Haskell", "swift"]}'


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


