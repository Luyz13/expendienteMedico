# Expediente Medico Personal
Este es el repositorio del proyecto del Talent Lab BEDU - HSBC.

En este encontraras el backend echo en Spring Java, mientras que el front(Angular) del proyecto lo podras ver en el siguiente repositorio:
https://github.com/Luyz13/expedienteFront

## Tablero Kanban
<p>Se uso un tablero Kanban para llevar un control de las tareas, relacionadas a los entregables de los modulos. <br> Dicho tablero lo pueden consultar en:</p>
https://github.com/users/Luyz13/projects/2/


## Descripción:
<p>El propocito del proyecto es registrar la información de las recetas medicas recibidas, esto con la finalidad de tener a la mano los datos relacionados a la receta y asi tener un Expediente Digital.</p>

## Entidades.
<p>Realice un analisis preliminar, en el cual use algunas recetas como ejemplo para indentificar a los <i>Actores</i> principales y asi poder modelarlos como Entidades en un diagrama ER.<br> Dichas entidades identificadas son:</p>
<ul>
 <li>Expediente</li>
 <li>Paciente</li>
 <li>Medico</li>
 <li>Receta</li>
 <li>Medicamento</li>
 <li>Signo</li>
 <li>Indicacion</li>
</ul>

<p>De manera preliminar el diagrama que se obtuvo fue el siguiente:</p>
<img src="" alt="Diagrama ER" width="400" height="400">


## Despliegue:
<p>Para el desbliegue se tienen 2 maneras diferentes, usando Docker:</p>
<ol>
 <li>Docker Compose:</li>
  <p>docker-compose up</p>
 <li>Docker como Provider en Terraform:</li>
  <p>terraform init</p>
  <p>terraform plan</p>
  <p>terraform apply</p>
</ol>





  
  

