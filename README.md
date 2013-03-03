Práctica 2ª: “Partida de dominó”
================================

La realización de esta práctica está previsto que ocupe tres sesiones.
Las partes de la asignatura con las que está directamente relacionada son las siguientes: especificación de tipos de datos y diseño orientado a objetos. En particular, el diseño planteado va a necesitar del mecanismo “clase abstracta”.
Se pretenden diseñar en esta práctica las clases a las que pertenecen los diferentes objetos que intervienen en una "partida de dominó", aunque en una versión muy simplificada, evitando lo relativo a estrategias de jugador.
Las clases que se proponen son:
- Ficha
- Mesa
- Jugador
- Partida

Ficha
-----
Como guía, una ficha debe proporcionar métodos para: girar, informar de su valor (suma), mostrarse, informar de si contiene un determinado número, informar de si se trata de una doble, etc.

Mesa
----
Una mesa de dominó consta de dos “montones”, uno con las fichas que no están en posesión de ningún jugador y el otro con las fichas ya colocadas (organizadas correctamente). Tendrá que proporcionar métodos para colocar fichas en ambos montones, extraer aleatoriamente fichas del montón de las que no han entrado en juego, informar de si están o no vacíos esos montones, informar de los extr emos de las colocadas, mostrar las fichas colocadas, etc.

Jugador
-------
Como vamos a permitir jugadores humanos y jugadores gestionados por la máquina, la diseñaremos como clase abstracta. Un jugador posee un conjunto de fichas.
Los métodos abstractos van a limitarse a la forma en la que un jugador elige la ficha a jugar (recibiendo como información un objeto de la clase mesa), y l a forma en la que se gestiona la acción recibir ficha (cada tipo de jugador organiza sus fichas como quiere).
El resto de métodos no son abstractos, proporcionando funcionalidades bás icas como: saber si puede o no jugar (según el estado de la mesa), suma de las fichas, número de fichas, saber si ha finalizado, etc.

Partida
-------
En una partida intervienen una mesa y un conjunto de jugadores. Otro aspecto importante es el turno (qué jugador debe jugar). Al crear la partida se debe conocer el
número de jugadores de cada tipo que van a intervenir en ella. Entre otros, debe proporcionar métodos para: iniciar partida (repartir fichas y generar el turno inicial),
realizar una jugada, informar de la posible finalización, dar el ganador, dar la clasificación, etc. 
