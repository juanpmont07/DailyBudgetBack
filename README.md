# DailyBudgetBack

#Crear imagen docker
docker build -t daily-budget-postgres-img .

#Ejecutar el contenedor
docker run --name daily-budget-postgres-cont -p 7171:7171 -d daily-budget-postgres-img

#Ejecutar el contenedor en el puerto 7171
docker run --name daily-budget-postgres-cont -p 7171:7171 -e POSTGRES_PASSWORD=admin_budget -d daily-budget-postgres-img

#Iniciar imagen
docker run daily-budget-postgres-img


ARQUITECTURA

Crear diagramas de secuencia en https://sequencediagram.org/

HEXAGONAL, 
CQS


MONO= 1
FLUX = **