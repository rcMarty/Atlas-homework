# Atlas-homework
Toto je domácí úkol pro Atlas software a.s.

## info

server se spustí příkazem `mvn liberty:run` na adrese `http://localhost:9080/LibertyProject`<br>
RESTful API pro server :    `GET` - `http://localhost:9080/LibertyProject/Api/HelloWorld` - vrací json helloworld
                            `GET` - `http://localhost:9080/LibertyProject/Api/SortByBest` - vrací json hellosortByBest
                            `PUSH` - `http://localhost:9080/LibertyProject/Api/SortByBest` - vstupuje json s content 
```json
{
    "data":[
            {
                "docSsid":"1 soubor",
                "users":[
                            {"uSsid":"1 jmeno","time":4873,"views":13},
                            {"uSsid":"2 jmeno","time":4873,"views":13},
                            {"uSsid":"3 jmeno","time":4873,"views":13}
                        ]
            },
            {
                "docSsid":"2 soubor",
                "users":[
                            {"uSsid":"1 jmeno","time":4873,"views":13},
                            {"uSsid":"2 jmeno","time":4873,"views":13},
                            {"uSsid":"3 jmeno","time":4873,"views":13}
                        ]
            },
            {
                "docSsid":"3 soubor",
                "users":[
                            {"uSsid":"1 jmeno","time":4873,"views":13},
                            {"uSsid":"2 jmeno","time":4873,"views":13},
                            {"uSsid":"3 jmeno","time":4873,"views":13}
                        ]
            }
    ]
}
```
(není "blbuvzdorné") - vrací json se seřazenýma dokumentama a jejich hodnotou cost

`time` = celkový čas v sekundách strávený v dokumentu <br>
`views` = kolikrát jednotlivý uživatel otevřel dokument

otestováno přes [reqbin](https://reqbin.com/)



