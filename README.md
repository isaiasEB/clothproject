# clothproject

Un proyecto donde hago un ordenamiento por pesos en un api rest (petición de un proceso de selección que como no sé si lo puedo decir pues no indicaré para que empresa lo realizo). 

*Quizás con el tiempo añada funcionalidades a este proyecto por gusto*

## Ejecución del proyecto

Desde la raíz del proyecto hace un mvn clean package para generar en target el jar del proyecto

Luego con java -jar target/order-0.0.1-SNAPSHOT.jar se lanza el jar

Una vez arrancado el swagger para probar el api rest se encuentra en http://localhost:8080/swagger-ui/index.html

El proyecto crea en el lugar donde se ejecuta el jar una base de datos H2 que la primera vez la inicializa con unas prendas por defecto para que tenga funcionalidad el único método que inicialmente tiene el proyecto.

*He elegido usar una base de datos en lugar de una simple lista en memoria por si en el futuro me apetece añadir nuevas funcionalidades a este proyecto*