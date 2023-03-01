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
<img src="expediente_levm.png" alt="Diagrama ER" width="500" height="500">
<p>Dichas entidades fueron modeladas dentro del paquete <i>Entity</i>, en donde se uso JPA</p>

## BEANS
<p> La apliación que se construyo, sigue un arquitectura en capas. <br> Y en el presente proyecto se tienen 3 capas:</p>
<ul>
 <li>Controller</li>
 <li>Service</li>
 <li>Repository</li>
</ul>
<p>En el proyecto, cada entidad  tiene su clase Controller, Service, etc. Cada clase fue representada como un bean usando la notación correspondiente</p>

## Monitoreo y Logs
<p> Para el proyecto se uso la librería Slf4j, y se configuro para que en cada capa y cada metodo, nos avise que esta pasando mientras la aplicación se ejecuta.</p>

## Lombok
<p> Se indentifico y refactorizo el proyecto para simplificar el código</p>
<p>Las notaciones que se usaron fueron:</p>
<ul>
 <li>@Getter</li>
 <li>@Setter</li>
 <li>@AllArgsConstructor</li>
 <li>@NoArgsConstructor</li>
</ul>

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





  
  

